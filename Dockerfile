FROM node:alpine AS build-env
WORKDIR /dist

# Build application
COPY app app
RUN yarn --cwd app install
RUN yarn --cwd app build

# Setup system
FROM nginx:latest
WORKDIR /dist

COPY --from=build-env /dist/app/dist /usr/share/nginx/html/
EXPOSE 80 443

