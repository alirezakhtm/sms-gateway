FROM openjdk:8
CMD ["mkdir", "/root/sms-gateway"]
CMD ["mkdir", "/root/sms-gateway/libs"]
COPY target/sms-gateway.jar /root/sms-gateway/
COPY src/main/resources/hibernate.cfg.xml /root/
COPY src/main/resources/application.xml /root/
COPY target/libs/*.jar /root/sms-gateway/libs/
ENTRYPOINT ["java", "-jar", "/root/sms-gateway/sms-gateway.jar"]