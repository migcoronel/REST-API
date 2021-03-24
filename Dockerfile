#set the jdk image
FROM openjdk:15-jdk-alpine
#set user and usergroup running this app
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
# set Jar
ARG JAR_FILE=target/firstAPI-0.0.1-SNAPSHOT.jar
# cd to opt/app
WORKDIR /opt/app
# cp JAR_FILE to /opt/app/app.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","app.jar"]