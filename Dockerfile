FROM docker.4pd.io/base-image-openjdk8:1.0.1

ADD ./target/java-exporter-1.0-SNAPSHOT.jar .


EXPOSE 1234

ENTRYPOINT bash -x java -jar java-exporter-1.0-SNAPSHOT.jar
