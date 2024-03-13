#build
docker build -t pguide_competition_manage:latest .

#start
docker run \
  -p 9000:9000 \
  --name pguide_competition_manage \
  -d pguide_competition_manage


