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
java Input.java)
if %choice%==r (
java Input.java)
ECHO =================================================================
ECHO OutputFile.txt is generated successfully ;) .
PAUSE
