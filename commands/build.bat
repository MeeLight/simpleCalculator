@echo off

:: cd ./.. & if not exist "build" then md "build" & cd ./build & kotlinc ./../src/main/kotlin/Main.kt -include-runtime -d simpleCalculator.jar & cd ./..
cd ./..

if not exist "build" (
  md "build"
)

cd ./build & kotlinc ./../src/main/kotlin/com/github/meelight/Main.kt -include-runtime -d simpleCalculator.jar & cd ./..
