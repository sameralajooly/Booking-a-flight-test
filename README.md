# Booking-a-flight-test

Greetings!

The following instructions assuming the user is using Intellij IDEA:

1. Clone the project.
2. Open project using Intellji IDEA.
3. Add Maven plugin to project through these steps: 
   A. Right click project root directory
   B. In the Project tool window, right-click your project and select Add Framework Support
   C. In the dialog that opens, select Maven from the options on the left and click OK.
   https://www.jetbrains.com/help/idea/convert-a-regular-project-into-a-maven-project.html.
4. Right click project root directory -> Maven -> Reimport.
5. Download FirFox Browser
6. Download FirFox driver from https://github.com/mozilla/geckodriver/releases 
7. Go to java class BrowserDriver in "bookAFlight" package and change the driverPath variable to your driver path.

To run Robot files double click ctrl to open run anything and run "mvn robotframework:run"
