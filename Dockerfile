FROM openjdk:17-slim

WORKDIR /app

COPY pom.xml .
RUN apt-get update && apt-get install -y maven
RUN mvn clean package -DskipTests

COPY target/*.jar .

EXPOSE 9090

CMD ["java", "-jar", "autocomplete.jar"]