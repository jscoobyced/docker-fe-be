## Docker Front-End And Back-End
---

This project is a skeleton to create a full-stack web-application.

The Front-End consists of a TypeScript and ReactJS application that runs in a nginx docker container.

The Back-End consists of an akka Scala API that runs in a docker container.

The [docker-compose](docker-compose.yml) file allows to start the whole stack:
```
docker-compose up -d
```

This is still work in progress and only Front-End is currently implemented, without calling a back-end service.