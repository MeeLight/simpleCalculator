@echo off

cd ./..

if not exist "build" (
  md "build"
)

cd ./build & kotlinc ./../src/main/kotlin/com/github/meelight/Main.kt -include-runtime -d simpleCalculator.jar & cd ./..
