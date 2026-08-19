#!/usr/bin/env python3
"""Validate Apple app-icon catalogs without third-party dependencies."""

from __future__ import annotations

import json
import plistlib
import struct
import sys
from pathlib import Path


APPLE_ROOT = Path(__file__).resolve().parents[1]
PNG_SIGNATURE = b"\x89PNG\r\n\x1a\n"


def png_metadata(path: Path) -> tuple[int, int, int]:
    try:
        header = path.read_bytes()[:33]
    except OSError as error:
        raise AssertionError(f"could not read {path}: {error}") from error
    if len(header) < 33 or header[:8] != PNG_SIGNATURE or header[12:16] != b"IHDR":
        raise AssertionError(f"not a valid PNG with an IHDR header: {path}")
    width, height, _, color_type, _, _, _ = struct.unpack(">IIBBBBB", header[16:29])
    return width, height, color_type


def expected_pixels(image: dict[str, str]) -> int:
    size = image.get("size", "").split("x", maxsplit=1)[0]
    scale = image.get("scale", "").removesuffix("x")
    try:
        pixels = float(size) * int(scale)
    except ValueError as error:
        raise AssertionError(f"invalid size or scale declaration: {image}") from error
    if not pixels.is_integer():
        raise AssertionError(f"non-integral icon dimensions: {image}")
    return int(pixels)


def verify_catalog(catalog: Path) -> int:
    contents_path = catalog / "Contents.json"
    try:
        contents = json.loads(contents_path.read_text(encoding="utf-8"))
    except (OSError, json.JSONDecodeError) as error:
        raise AssertionError(f"invalid asset catalog {contents_path}: {error}") from error

    referenced: set[str] = set()
    for image in contents.get("images", []):
        filename = image.get("filename")
        if not filename:
            raise AssertionError(f"icon slot has no filename in {contents_path}: {image}")
        referenced.add(filename)
        path = catalog / filename
        width, height, color_type = png_metadata(path)
        expected = expected_pixels(image)
        if width != expected or height != expected:
            raise AssertionError(
                f"wrong dimensions for {path}: {width}x{height}, expected {expected}x{expected}"
            )
        if color_type not in {0, 2}:
            raise AssertionError(f"app icon must not contain alpha or indexed transparency: {path}")

    present = {path.name for path in catalog.glob("*.png")}
    if referenced != present:
        raise AssertionError(
            f"catalog file mismatch in {catalog}; unreferenced={sorted(present - referenced)}, "
            f"missing={sorted(referenced - present)}"
        )
    print(f"verified {catalog.relative_to(APPLE_ROOT)}: {len(referenced)} opaque PNG files")
    return len(referenced)


def verify() -> None:
    catalogs = [
        APPLE_ROOT / "Resources" / "iOS" / "Assets.xcassets" / "AppIcon.appiconset",
        APPLE_ROOT / "Resources" / "macOS" / "Assets.xcassets" / "AppIcon.appiconset",
    ]
    total = sum(verify_catalog(catalog) for catalog in catalogs)
    print(f"verified Apple app icons: {total} files")

    privacy_path = APPLE_ROOT / "Resources" / "Shared" / "PrivacyInfo.xcprivacy"
    try:
        privacy = plistlib.loads(privacy_path.read_bytes())
    except (OSError, plistlib.InvalidFileException) as error:
        raise AssertionError(f"invalid privacy manifest {privacy_path}: {error}") from error
    if privacy.get("NSPrivacyTracking") is not False:
        raise AssertionError("privacy manifest must declare tracking as disabled")
    accessed = {
        item.get("NSPrivacyAccessedAPIType"): set(item.get("NSPrivacyAccessedAPITypeReasons", []))
        for item in privacy.get("NSPrivacyAccessedAPITypes", [])
    }
    expected_defaults_reasons = {"CA92.1", "1C8F.1"}
    actual_defaults_reasons = accessed.get("NSPrivacyAccessedAPICategoryUserDefaults", set())
    if actual_defaults_reasons != expected_defaults_reasons:
        raise AssertionError(
            "privacy manifest UserDefaults reasons mismatch; "
            f"expected={sorted(expected_defaults_reasons)}, "
            f"actual={sorted(actual_defaults_reasons)}"
        )
    print("verified PrivacyInfo.xcprivacy: tracking disabled and UserDefaults reasons declared")


if __name__ == "__main__":
    try:
        verify()
    except AssertionError as error:
        print(f"Apple asset verification failed: {error}", file=sys.stderr)
        raise SystemExit(1) from error
