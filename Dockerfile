FROM openjdk:8-jdk-alpine

COPY target/nagp-devops-assignment-0.0.1-SNAPSHOT.jar nagp-devops-assignment.jar

ENTRYPOINT ["java","-jar","/nagp-devops-assignment.jar"]