param()

$ErrorActionPreference = "Stop"

$backendDirectory = Split-Path -Parent $PSScriptRoot
$environmentPath = Join-Path $backendDirectory ".env"

if (Test-Path -LiteralPath $environmentPath) {
    $configured = Get-Content -LiteralPath $environmentPath | Where-Object {
        $_ -match '^INSTALLATION_TOKEN_SECRET=.{32,}$'
    }
    if ($configured) {
        Write-Output "Existing backend/.env secret retained."
        exit 0
    }
}

$bytes = New-Object byte[] 32
$generator = [System.Security.Cryptography.RandomNumberGenerator]::Create()
try {
    $generator.GetBytes($bytes)
} finally {
    $generator.Dispose()
}

$secret = [Convert]::ToBase64String($bytes).TrimEnd('=').Replace('+', '-').Replace('/', '_')
$content = @(
    "# Local Cloudflare Worker secrets. Never commit this file."
    "INSTALLATION_TOKEN_SECRET=$secret"
)

$utf8NoBom = New-Object System.Text.UTF8Encoding($false)
[System.IO.File]::WriteAllLines($environmentPath, $content, $utf8NoBom)
Write-Output "Created backend/.env with a generated installation-token secret."
