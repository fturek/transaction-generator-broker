# Setting up
1) run `gradle build && gradle shadowJar`
2) run `java -jar build/libs/transaction-generator.jar -customerIds 20:20 -dateRange "2018-03-08T00:00:00.000-0100":"2018-03-08T23:59:59.999-0100" -itemsFile items.csv -itemsCount 5:15 -itemsQuantity 1:30 -eventsCount 10 -outDir ./output --format=xml`


# Docker

docker build --tag generator-transakcji .
docker run --volume ~/Projects/Java/JsonTransactionGenerator/storage/:/storage generator-transakcji