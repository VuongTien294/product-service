FROM openjdk:8

COPY target/*.jar product-service.jar
EXPOSE 8283
ENTRYPOINT ["java","-jar","/product-service.jar"]