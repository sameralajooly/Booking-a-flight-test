*** Settings ***
Library  bookAFlight.Login
Library  OperatingSystem
*** Variables ***
${valid}  Valid
*** Testcases ***

Valid login
    [Documentation]     Test valid login
    ${result} =   validLogin
    Should Be Equal  ${result}  ${valid}

Invalid login
    [Documentation]     Test invalid login
    ${result} =   invalidLogin
    Should Be Equal  ${result}  ${valid}