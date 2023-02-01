FROM openjdk:11.0.2-jdk-oracle

WORKDIR /yb-back-end

COPY ./target/demo-0.0.1-SNAPSHOT.jar /demo-0.0.1-SNAPSHOT.jar

EXPOSE 9090

CMD ["java","-jar","/demo-0.0.1-SNAPSHOT.jar"]