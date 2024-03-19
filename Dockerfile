FROM openjdk:21
ADD target/*.jar app.jar
CMD [ "java", "-jar", "app.jar" ]
