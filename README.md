# TestNG Data Driven Login Testing - SauceDemo

## Project Overview
Automated login testing on SauceDemo website using 
TestNG and Apache POI to read test data from Excel file.

## What This Project Does
- Reads usernames, passwords and expected results from Excel
- Logs in with each user one by one automatically
- Validates pass and fail scenarios
- Prints results in console for each user
- Opens browser in Incognito mode to avoid popups

## Tools & Technologies
- Java
- Selenium WebDriver
- TestNG
- Apache POI (Excel reading)
- ChromeOptions (Incognito mode)
- Eclipse IDE

## Test Data (Excel)
| Username | Password | Expected |
|----------|----------|----------|
| standard_user | secret_sauce | Pass |
| locked_out_user | secret_sauce | Fail |
| problem_user | secret_sauce | Pass |
| invalid_user | wrongpassword | Fail |

## Test Results
standard_user -> PASSED ✅
locked_out_user -> FAILED as expected ✅
problem_user -> PASSED ✅
invalid_user -> FAILED as expected ✅

## Challenges I Solved
**Chrome Password Popup**
After login Chrome showed a password manager popup.
Selenium cannot handle browser level popups.
Solved by launching Chrome in Incognito mode
using ChromeOptions.

## What I Learned
Data driven testing allows running same test
with multiple sets of data without changing code.
Reading test data from Excel makes tests
more maintainable and scalable.
