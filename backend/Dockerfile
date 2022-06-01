FROM maven:3.8.5-jdk-11-slim AS builder
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

FROM openjdk:11-jre-slim AS development
COPY --from=builder /home/app/target/CA1-0.0.1-SNAPSHOT.war /usr/local/lib/ie-back.jar
EXPOSE 8080
CMD ["java","-jar","/usr/local/lib/ie-back.jar"]
