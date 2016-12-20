# CSCI-8700-CoursePlanner
This repository contains source code along with documentation for the project Course Planner

Required software to run the project
  1. Java 1.7 or higher
  2. Eclipse IDE (neon)
  3. Apache TomcatServer V8.5
  4. MAMP server for database
  5. MySql connector
  
Steps to import the project
  1. clone the repo or download the zip file and unzip the folder
  2. open Eclipse IDE and from the menu bar select "Open project from file system" and browse for the cloned project
  3. Make sure to point to the CoursePlanner folder since it contains all the project env.
  4. add server to eclipse follow the steps in http://www.eclipse.org/webtools/jst/components/ws/1.5/tutorials/InstallTomcat/InstallTomcat.html
  5. configur build path of java by adding the external jar library of mysql connector to the project library by selecting properties -> java build path -> add external jar -> browse for the MySql connector and add it
  6. add the MySql connctor in the lib folder of WEB-INF
  7. configure targeted runttime by selecting properites of the project -> targeted runtimes -> select the installed server and apply the settings.
  
  Steps to run the project
   1. right click on the project and select run as -> run on server
   
  
