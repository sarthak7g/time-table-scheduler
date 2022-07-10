# Time-Table

## Swagger (for api documentation)
- To open swagger http://localhost:8081/swagger-ui.html

## Local Setup
[using docker]
 - ./mvnw clean install
 - docker run --name=mysqldb -e MYSQL_ROOT_PASSWORD=123456 -e  MYSQL_DATABASE=java_demo -dp 6603:3306 mysql:8
 - docker image build -t time-table:v1 .
 - docker run --add-host host.docker.internal:host-gateway --rm -itp 8081:8080 --name timetable time-table:v1

### Note: Docker compose is not running at the moment.

### Check out my github: https://github.com/sarthak7g