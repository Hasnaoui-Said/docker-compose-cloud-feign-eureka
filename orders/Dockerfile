FROM openjdk:11.0.2-jdk-oracle

WORKDIR /orders

COPY target/demo-0.0.1-SNAPSHOT.jar orders/

EXPOSE 9090

CMD ["java","-jar","orders/demo-0.0.1-SNAPSHOT.jar"]