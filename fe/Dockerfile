FROM node:latest AS build-env
WORKDIR /build

## Install dependencies packages
RUN set -ex; apt-get -qq update && apt-get -qq upgrade
RUN set -ex; apt-get install -qqy --no-install-recommends \
        ca-certificates apt-transport-https \
        software-properties-common dirmngr python

# Build application
COPY . .
RUN yarn install
RUN yarn build

# Deploy
FROM nginx:latest
WORKDIR /build

COPY --from=build-env /build/dist /usr/share/nginx/html/
EXPOSE 80 443

