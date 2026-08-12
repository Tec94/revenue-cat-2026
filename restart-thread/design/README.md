# Restart Thread design package

Start with the project-root [`DESIGN.md`](../DESIGN.md). It is the implementation-facing source
of truth extracted from the locked Forward Thread prototype and reconciled with
the accepted Run 8 and Run 12 decisions.

```text
design/
├── README.md
├── assets/
│   └── logos/
│       ├── README.md
│       ├── logo-sheet.svg
│       ├── mark-01-open-thread.svg
│       ├── mark-02-corner-thread.svg
│       ├── mark-03-split-boundary.svg
│       ├── mark-04-compact-forward.svg
│       ├── lockup-horizontal-editable.svg
│       └── wordmark-stacked-editable.svg
├── reference/
│   ├── README.md
│   └── forward-thread-prototype.png
└── tokens/
    └── design-tokens.json
```

The four symbol files are reconstructions of the four Logo Lab cells. The
prototype establishes their shared grammar but does not record a final choice,
so they remain candidates. The editable wordmark and lockup retain live SVG
text because the exact serif was not supplied; outline a licensed final face
before treating either as immutable production art.

The token file is platform-neutral. Android implementation should map semantic
roles into Compose theme values rather than importing raw colors throughout the
UI.
