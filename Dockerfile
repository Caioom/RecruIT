FROM maven:3.6.3-openjdk-11
COPY * /tmp/application/
RUN cd /tmp/application/ && mvn clean package