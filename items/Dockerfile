FROM openjdk:17-jdk-alpine
COPY "./build/libs/items-0.0.1-SNAPSHOT.jar" "ligero.jar"
EXPOSE 8002
ENTRYPOINT ["java","-jar","ligero.jar"]