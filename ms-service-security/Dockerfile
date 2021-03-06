FROM openjdk:11
EXPOSE 8080
ADD ./target/ms-service-security-0.0.1-SNAPSHOT.jar   micro-security.jar
ENTRYPOINT ["java","-jar","/micro-security.jar"]