FROM openjdk:11
ADD target/achat-1.0-*.jar achat-1.0.jar
EXPOSE 8080

CMD java -jar achat-1.0-*.jar
