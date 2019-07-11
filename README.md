# book-recommendation
App built using JSF and MongoDB in embedded Tomcat server

Before executing this app make sure you have the MongoDB server installed and configured on port 27017.

Run MongoDB server: mongod.exe

To execute the app in debug mode run the maven goal: clean install tomcat7:run

To create a executable jar file run the maven goal: clean install tomcat7:exec-war-only

After the executable jar file creation go to target folder and run the following command to execute it: java -jar executable.jar

The main urls:
http://localhost:8080/bookrecommendation/book_list.xhtml
http://localhost:8080/bookrecommendation/add_book_form.xhtml
