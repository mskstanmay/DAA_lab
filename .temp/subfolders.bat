:: A little subroutine to create subfolders in each of the folders 
:: located in the parent working directory.

@echo off

:: Step 1: Move one level up from the current ".temp" folder
cd ..

:: Step 2: Loop through every subfolder in the parent directory
for /d %%i in (*) do (
    
    :: Step 3: Skip the ".temp" folder itself
    if /I not "%%i"==".temp" (
        
        :: Step 4: Create the required subfolders inside each subfolder
        mkdir "%%i\MCQs" "%%i\Practice At Home" "%%i\Challenge Yourself" "%%i\Lab Exercise"
    )
)

:: Step 5: Notify user that the script has finished
echo Done!
pause
