#build
docker build -t pguide_search:latest .

#start
docker run \
  -p 11001:11001 \
  --name pguide_search \
  -d pguide_search



