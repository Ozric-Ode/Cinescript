@ECHO OFF
ECHO ==================
ECHO Program is compiling.
javac -d . .\Precore.java
javac -d . .\Evaluator.java
javac -d . .\Conditon.java
javac -d . .\PrintInfo.java
javac -d . .\Coreif.java
javac -d . .\Core.java
java Input.java
ECHO ==================
ECHO outputfile created.
PAUSE
