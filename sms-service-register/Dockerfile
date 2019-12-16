FROM openjdk:8
COPY target/sms-service-register.jar /root/
COPY src/main/resources/configuration.xml /root/
CMD ["mkdir", "/root/libs"]
COPY target/libs/*.jar /root/libs/
ENTRYPOINT ["java", "-jar", "/root/sms-service-register.jar"]