# set base image for build with java version runtime
FROM openjdk:17-jdk-slim
# set maintainer - who make this image
MAINTAINER vutth
# copy jar file from build to image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar
# excute the jar file
ENTRYPOINT ["java","-jar","/accounts-0.0.1-SNAPSHOT.jar"]

#1 After created this docker file, run this command to build image
#docker build . -t timovuton8499/accounts:s4

#2 Run this command to run container
#docker run -p 8080:8080 timovuton8499/accounts:s4

#3 Run this command to run container without logs in background
#docker run -d -p 8080:8080 timovuton8499/accounts:s4

#4 Run this command to check running container
#docker ps
