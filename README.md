# book-recommendation
App built using JSF in embedded Tomcat server

To execute in debug mode run the maven goal: clean install tomcat7:run

To create a executable jar file run the maven goal: clean install tomcat7:exec-war-only

After the executable jar file creation go to target folder and run the following command to execute it: java -jar executable.jar

http://localhost:8080/bookrecommendation/book_list.xhtml
http://localhost:8080/bookrecommendation/add_book_form.xhtml