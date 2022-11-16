FROM openjdk:11
VOLUME /tmp
ENV IMG_PATH=/img
EXPOSE 8080
RUN sh -c 'touch /asignacion-0.0.1-SNAPSHOT.jar'
ADD ./target/asignacion-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT [ "java", "-jar", "/app.jar"]
