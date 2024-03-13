#build
docker build -t pguide_auth:latest .

#start
docker run \
  -p 888:888 \
  --name pguide_auth \
  -d pguide_auth


