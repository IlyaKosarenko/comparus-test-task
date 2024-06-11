Test task for comparus:

Swagger URL: http://localhost:8080/swagger-ui/index.html

Application Properties:

Application supports only PostgreSQL.

Add this to application.yaml to add new database for reading:

task:
  datasources:
    -   name: "db"
        password: password
        url: jdbc:postgresql://localhost:5432/db
        username: admin
        table: users
        schema: public
        mapping:
          id: user_id
          username: login
          name: first_name
          surname: last_name

Necessarily specify 'schema' for database.



