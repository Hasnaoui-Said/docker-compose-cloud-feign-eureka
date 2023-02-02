FROM openjdk:11.0.2-jdk-oracle

WORKDIR /stock

COPY target/gp-0.0.1-SNAPSHOT.jar stock/

EXPOSE 9091

CMD ["java","-jar","stock/gp-0.0.1-SNAPSHOT.jar"]