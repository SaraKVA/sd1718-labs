This example shows how to use the java.util.Timer class


Instructions using Maven:
------------------------

NOTE: using the exec plugin to run the code uses the same VM as Maven, and 
the code behavior is modified by Maven's own threads and settings.
To test this program properly use the appassembler plugin.

To compile:
  mvn compile

To run using exec plugin:
  mvn exec:java

To generate launch scripts for Windows and Linux:
  (appassembler:assemble is attached to install phase)
  mvn install

To run using appassembler plugin:
  On Windows:
    target\appassembler\bin\timer
  On Linux:
    ./target/appassembler/bin/timer


To configure the Maven project in Eclipse:
-----------------------------------------

'File', 'Import...', 'Maven'-'Existing Maven Projects'
'Select root directory' and 'Browse' to the project base folder.
Check that the desired POM is selected and 'Finish'.


--
Revision date: 2017-03-10
leic-sod@disciplinas.tecnico.ulisboa.pt
