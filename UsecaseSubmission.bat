pushd "%CD%"
CD /D "%~dp0"
git config --global user.email %computername%"@dnapass.com"
git config --global user.name %computername%
  
git add .
git commit -m "Use Case Submitted"
git push --set-upstream origin Development
@echo off
echo. 
echo "Congratulations!!! Your code is successfully pushed to GIT Repository"
echo "Please visit the DnA Pass Portal for the Assessment Report"
echo.
echo.
TIMEOUT /T 10 /NOBREAK >nul
exit >nul