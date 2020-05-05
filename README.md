# Docker Front-End And Back-End
[![CircleCI](https://circleci.com/gh/jscoobyced/jsc-fe-be.svg?style=svg)](https://circleci.com/gh/jscoobyced/jsc-fe-be)  
[![codecov](https://codecov.io/gh/jscoobyced/jsc-fe-be/branch/master/graph/badge.svg)](https://codecov.io/gh/jscoobyced/jsc-fe-be)

This project is a skeleton to create a full-stack web-application.


This is a full-stack application built from the [jsc-fe-be](https://github.com/jscoobyced/jsc-fe-be) github template.

## Front-End

![Docker Cloud Build Status](https://img.shields.io/docker/cloud/build/jscdroiddev/jscfe)

The Front-End consists of a TypeScript and ReactJS application that runs in a nginx docker container.

More details in Front-End [readme](./fe/README.md) file.

## Back-End

![Docker Cloud Build Status](https://img.shields.io/docker/cloud/build/jscdroiddev/narokio-be)

The Back-End consists of an akka Scala API that runs in a docker container.

More details in Front-End [readme](./be/README.md) file.


---
This is still work in progress and only Front-End is currently implemented, without calling a back-end service.