@ECHO OFF
ECHO =================================================================
ECHO Enter c to compile and run all files or r to run the Input [c/r]!
set /p choice=""
if %choice%==c (
ECHO Program is being compiled.
javac -d . *.java
java filehandling.Input)
if %choice%==r (
java filehandling.Input)
ECHO =================================================================
ECHO OutputFile.txt is generated successfully ;) .
PAUSE
