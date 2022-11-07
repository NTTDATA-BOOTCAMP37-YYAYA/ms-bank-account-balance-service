FROM openjdk:11
EXPOSE 8102
ADD target/ms-bank-account-0.0.1-SNAPSHOT.jar ms-bank-account.jar
ENTRYPOINT ["java","-jar","/ms-bank-account.jar"]