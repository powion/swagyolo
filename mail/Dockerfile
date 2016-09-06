FROM openjdk:8
ADD target/mail-1.0-SNAPSHOT.jar /data/mail-1.0-SNAPSHOT.jar
ADD config.yml /data/config.yml
RUN java -jar /data/mail-1.0-SNAPSHOT.jar db migrate /data/config.yml
CMD java -jar /data/mail-1.0-SNAPSHOT.jar server /data/config.yml
EXPOSE 8080
