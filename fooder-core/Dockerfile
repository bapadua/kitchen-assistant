FROM maven:3.8.5-openjdk-17-slim AS builder
ENV HOME=/opt/app
RUN mkdir -p $HOME
WORKDIR $HOME
ADD . $HOME
RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-alpine
COPY --from=builder /opt/app/target/fooder-core-1.0.jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","/opt/app/app.jar"]