# Booking-a-flight-test

Greetings!

The following instructions assuming the user is using Intellij IDEA:

- Clone the project.
- Open project using Intellji IDEA.
- Add Maven plugin to project through these steps: 
   - Right click project root directory
   - In the Project tool window, right-click your project and select Add Framework Support
   - In the dialog that opens, select Maven from the options on the left and click OK.
   https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html.
- Right click project root directory -> Maven -> Reimport.
- Download FirFox Browser
- Download FirFox driver from https://github.com/mozilla/geckodriver/releases 
- Go to java class BrowserDriver in "bookAFlight" package and change the driverPath variable to your driver path.

To run Robot files double click ctrl to open run anything and run "mvn robotframework:run"
