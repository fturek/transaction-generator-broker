FROM openjdk:8-jdk-alpine

COPY ./build/libs/transaction-generator.jar ./generator-transakcji.jar

CMD java -jar ./generator-transakcji.jar docker