@ECHO OFF
ECHO =================================================================
ECHO Enter c to compile and run all files or r to run the Input [c/r]!
set /p choice=""
if %choice%==c (
ECHO Program is being compiled.
javac -d . .\Precore.java
javac -d . .\Evaluator.java
javac -d . .\Conditon.java
javac -d . .\PrintInfo.java
javac -d . .\Coreif.java
javac -d . .\Core.java
javac -d . .\Input.java
java filehandling.Input)
if %choice%==r (
java filehandling.Input)
ECHO =================================================================
ECHO OutputFile.txt is generated successfully ;) .
PAUSE
