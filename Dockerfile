FROM openjdk:11
WORKDIR /opt
COPY target/*.jar /opt/SampleSpringRestApp.jar
ENTRYPOINT ["java", "-jar", "SampleSpringRestApp.jar"]
