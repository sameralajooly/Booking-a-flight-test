*** Settings ***
Library  bookAFlight.Booking
Library  OperatingSystem
*** Variables ***
${valid}  Valid
*** Testcases ***

Book flight
    [Documentation]     Test booking a flight
    ${result} =   book A Flight
    Should Be Equal  ${result}  ${valid}

Validate flight finder page
    [Documentation]     Check data in flight page
    ${result} =   flight Finder
    Should Be Equal  ${result}  ${valid}

Verify flight data
    [Documentation]     Match data selected and flight data
     ${result} =   verifyFlightData
     Should Be Equal  ${result}  ${valid}
