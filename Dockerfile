FROM openjdk:11
EXPOSE 8080
ADD target/achat-*.jar achat-*.jar
CMD java -jar achat-*.jar
