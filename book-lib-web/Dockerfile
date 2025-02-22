# FROM node:18-alpine as build
# WORKDIR /app
# COPY package.json ./
# RUN npm install
# COPY . .
# RUN npm run build

FROM nginx:1.23-alpine
COPY ./dist /usr/share/nginx/html
# COPY --from=build /app/dist /usr/share/nginx/html
EXPOSE 8088
CMD ["nginx", "-g", "daemon off;"]
