FROM openjdk:8-alpine
ADD /target/time-table-docker.jar time-table-docker.jar
#CMD java -Dspring.profiles.active=staging -jar time-table-docker.jar
CMD java -jar time-table-docker.jar
