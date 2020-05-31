*** Settings ***
Library  bookAFlight.LoginTest
Library  OperatingSystem
*** Variables ***
${valid}  Valid
*** Testcases ***

Book flight
    [Documentation]     Test booking a flight
    ${result} =   book A Flight
    Should Be Equal  ${result}  ${valid}

Invalid login
    [Documentation]     Test invalid login
    ${result} =   invalid Login
    Should Be Equal  ${result}  ${valid}