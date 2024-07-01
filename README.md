# Lawyer system

### A course project at the university on a system for lawyers. The project implements a server-based rendering architecture.


## Prerequisites
- Java Development Kit (JDK) version 17.
- Apache Maven version 4.0.
- MySQL DB version 8.X.XX

## Tools Used
- Spring Framework version 6.X.X or higher
- Spring Boot version 3.2.X
- Hibernate ORM version 6.1.X.
- Apache Tomcat version 10


## Local Development

### Build

To build the project, execute the following command:

```bash
./mvnw --batch-mode clean package 
```

### Testing

To run tests, execute the following command:

```bash
./mvnw --batch-mode test
```


### Running

Environment variables

    MYSQL_DRIVER=com.mysql.cj.jdbc.Driver
    MYSQL_URL=jdbc:mysql://<host>:<port>/<database>
    MYSQL_USER=<username>
    MYSQL_PASSWORD=<password>
