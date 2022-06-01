FROM node:18.2.0-slim AS development
ENV NODE_ENV development

WORKDIR /app

COPY package.json .
RUN yarn install

COPY . .

EXPOSE 3000

CMD [ "yarn", "start" ]

FROM node:18.2.0-slim AS builder
ENV NODE_ENV production

WORKDIR /app

COPY package.json .
RUN yarn install --production

COPY . .

RUN yarn build

FROM nginx:1.22-alpine as production

COPY --from=builder /app/build /usr/share/nginx/html

COPY nginx/nginx.conf /etc/nginx/conf.d/default.conf
EXPOSE 80

CMD ["sh", "-c", "nginx -g 'daemon off;'"]
