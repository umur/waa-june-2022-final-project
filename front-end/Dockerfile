FROM node:alpine
WORKDIR '/app'

COPY package.json .
RUN npm install --legacy-peer-deps
COPY . .
CMD ["npm", "start"]

# docker build . -t subo8/front-end  
# docker run --name=front-end -p 3000:3000 front-end