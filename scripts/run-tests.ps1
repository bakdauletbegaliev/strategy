$ErrorActionPreference = "Stop"
$root = (Resolve-Path (Join-Path $PSScriptRoot "..")).Path
Set-Location $root
New-Item -ItemType Directory -Force -Path out | Out-Null
$files = @(Get-ChildItem -Recurse src/main/java,src/test/java -Filter *.java | ForEach-Object { $_.FullName })
javac --release 17 -encoding UTF-8 -d out $files
if ($LASTEXITCODE -ne 0) { exit $LASTEXITCODE }
java -cp out kz.aitu.strategy.StrategyTest
exit $LASTEXITCODE
