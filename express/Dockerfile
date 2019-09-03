FROM alpine
RUN apk add --update nodejs && node -v
#Alternatively (larger image size):
#FROM node:12-alpine
COPY dist/index.js index.js
COPY public/index.html public/index.html
CMD [ "node", "index.js" ]