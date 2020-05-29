Back-End application
---

The Back-End application is a scala application running APIs. It is located in the `be` folder.

# Quick Start
To start the application as it is, just need a MySQL/MariaDB compatible database and get the application container running.

Database:
```
docker run -d --name jscdb \
        -e MYSQL_ROOT_PASSWORD=root \
        -e MYSQL_DATABASE=jscdb \
        -e MYSQL_USER=jscdb \
        -e MYSQL_PASSWORD=jscdb \
        -p 3306:3306 \
        mariadb
docker exec -i jscdb sh -c 'exec mysql -ujscdb -pjscdb' < ./db/scripts/create.sql
// And optionally
docker exec -i jscdb sh -c 'exec mysql -ujscdb -pjscdb' < ./db/scripts/sample.sql
```
Now the database is up and running, start the application:
```
docker build --build-arg JSCCURRENT="." -t owner/myapp-be .
docker run --name myapp-be -d --rm -p 9001:9001 owner/myapp-be
```
where `owner/myapp-be` is the name you want to tag your docker image.

Then you can open your browser on `http://localhost:9001/hello`.

# Development
The Back-End application is built with the Scala Build Tools (sbt) and supports the following commands:
- `sbt compile`: builds the project.
- `sbt run`: starts the application. It will be available on [http://localhost:9001/hello](http://localhost:9001/hello).
Note if you run the application you'll have to stop the docker instance.

# Database configuration
If you want to customize the database configuration you can change the `MYSQL_` environment variables in the database docker command. You will need to change the application `docker run` command:
```
docker run --name myapp-be -d --rm -p 9001:9001 -v ./conf:/opt/jscbe/conf owner/myapp-be
```
Then update the configuration in `application.conf` to match the database information accordingly. You might need to restart the application (`docker stop ...` and `docker start ...`)
