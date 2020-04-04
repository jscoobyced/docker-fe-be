FROM node:latest AS build-env
WORKDIR /build

# Build application
COPY . .

# Deploy
FROM nginx:latest
WORKDIR /build

RUN mkdir /opt/jscbe

COPY --from=build-env /build/dist /opt/jscbe/
EXPOSE 8080
