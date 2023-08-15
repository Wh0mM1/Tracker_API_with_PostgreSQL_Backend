FROM openjdk:17

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} trackerservice.jar

ENTRYPOINT ["java","-jar","/trackerservice.jar"]

EXPOSE 8080