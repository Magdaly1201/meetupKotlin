###API - Meetups

#Readme

- Api para crear meetup o charlas de TI, donde se podra visualizar todas las meets y tambien la cantidad de participantes que asistiran.

###Tecnologias
- kotlin V
- Spring Boot V2.6.6
- Spring doc open api ui V1.6.8
- MySql V8.0.24
- Flyway V5.2.4
- JPA

# url Swagger

http://localhost:8080/swagger-ui/index.html#/

## Docker composer DB
    version: '3.1'
    services:
      db:
        image: mysql
        restart: always
        environment:
          MYSQL_ROOT_PASSWORD:
          MYSQL_DATABASE: db_meetup

        ports:
          - "3307:3306"


###End