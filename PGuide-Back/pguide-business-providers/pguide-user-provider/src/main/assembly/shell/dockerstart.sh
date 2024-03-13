#build
docker build -t pguide_user:latest .

#start
docker run \
  -p 777:777 \
  --name pguide_user \
  -d pguide_user


