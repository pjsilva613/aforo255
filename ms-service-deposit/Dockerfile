FROM openjdk:13
EXPOSE 8006
ADD ./target/ms-service-deposit-0.0.1-SNAPSHOT.jar   micro-deposit.jar
ENTRYPOINT ["java","-jar","/micro-deposit.jar"]