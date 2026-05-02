Get-ChildItem -Recurse -Filter *.java src | Select-Object -ExpandProperty FullName | Out-File -Encoding ascii sources.txt
javac -d out `@sources.txt
java -cp out se.kth.iv1350.repairelectricbike.startup.Main
# kör i terminalen: .\run.ps1