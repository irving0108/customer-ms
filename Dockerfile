FROM adoptopenjdk/openjdk11:alpine-jre
ADD target/*.jar customer-ms.jar
EXPOSE 9091
ENTRYPOINT ["java","-jar", "customer-ms.jar"]