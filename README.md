# restwiki

1. Download the code/Clone the repository
2. Import the project into eclipse
3. install tomcat [ https://tomcat.apache.org/download-90.cgi ]
4. Add tomcat into [ eclipse https://www.eclipse.org/webtools/jst/components/ws/1.0/tutorials/InstallTomcat/InstallTomcat.html ]
5. create a file in local directory.
Ex :
     Linux / Mac : touch /tmp/details.txt
     Windows : cd <some location>
               copy con details.txt
               ctrl + z
6. Update src/com/mbrass/rest/Wiki.java, with the location of the file created in the previous step
	
	<< static String path = "E:\\tmp\\details.txt"; >>
  
 7. Deploy the project into tomcat
 8. To access the wiki, open this url http://127.0.0.1:8080/R1/rest/wiki
 9. To update the wiki, Run the following using POSTMAN [ https://www.postman.com/ ]
      POST http://127.0.0.1:8080/R1/rest/wiki
      { "key" : "server 1",
         "value : " www.github.com" }
	