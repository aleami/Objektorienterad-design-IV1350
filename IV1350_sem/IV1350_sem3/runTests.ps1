Get-ChildItem -Recurse -Filter *.java src | Select-Object -ExpandProperty FullName | Out-File -Encoding ascii sources.txt
Get-ChildItem -Recurse -Filter *.java test | Select-Object -ExpandProperty FullName | Out-File -Encoding ascii test-sources.txt
javac -cp "out;lib/junit-platform-console-standalone-1.10.0.jar" -d out `@sources.txt
javac -cp "out;lib/junit-platform-console-standalone-1.10.0.jar" -d out-test `@test-sources.txt
java -jar lib/junit-platform-console-standalone-1.10.0.jar --class-path "out;out-test" --scan-class-path