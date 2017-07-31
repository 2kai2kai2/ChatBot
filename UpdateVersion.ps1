Read-Host -Prompt "Press Enter if you are sure you want to continue"
./gradlew cleanCache
./gradlew setupDecompWorkspace --refresh-dependencies
./gradlew eclipse
Read-Host -Prompt "Press Enter to close"