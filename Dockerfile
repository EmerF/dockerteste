FROM openjdk:11.0.4-jre-slim-buster
WORKDIR /
ADD target/ImprimirListas-0.0.1-SNAPSHOT.jar ImprimirListas.jar
COPY target/lib /lib
EXPOSE 8080
CMD java -jar ImprimirListas.jar
