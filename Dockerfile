FROM amazoncorretto:17.0.11

ARG JAR_FILE=target/*.jar

COPY ${JAR_FILE} reservation_service.jar

ENTRYPOINT ["java", "-jar", "/reservation_service.jar"]

EXPOSE 9502