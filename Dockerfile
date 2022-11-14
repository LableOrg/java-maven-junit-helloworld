FROM maven:3.6.0-jdk-10
COPY . /home/app
RUN mvn -f /home/app clean test
