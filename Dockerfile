FROM openjdk:8-jdk-alpine

ARG JAR_FILE
COPY ${JAR_FILE} nagp-devops-assignment.jar

ENTRYPOINT ["java","-jar","/nagp-devops-assignment.jar"]