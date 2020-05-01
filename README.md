# Docker Front-End And Back-End

This project is a skeleton to create a full-stack web-application.

This is a full-stack application built from the [jsc-fe-be](https://github.com/jscoobyced/jsc-fe-be) github template.

The Front-End consists of a TypeScript and ReactJS application that runs in a nginx docker container.

More details in Front-End [readme](./fe/README.md) file.

The Back-End consists of an akka Scala API that runs in a docker container.

More details in Front-End [readme](./be/README.md) file.

# Ports in use

If you want to change the ports, you can edit the [docker-compose](docker-compose.yml)
```
  jscfe:
    ...
    ports:
      - "80:80"
  jscbe:
    ...
    ports:
      - "8080:8080"
```
and modify the left side the "portA:portB" settings. If you change the Back-End API port binding, you must also update the Front-End application configuration to use this port in [fe/src/services/config/config.json](fe/src/services/config/config.json):
```
{
    "api": {
        "port": 8080
    }
    ...
}
```

---
This is still work in progress and only Front-End is currently implemented, without calling a back-end service.