# 网络创建
sudo docker network create gateway

#build
docker build -t pguide_gateway:latest .

#可以build的时候加入，也可以后面再加
sudo docker network connect gateway pguide_gateway

#start
docker run \
  -p 666:666 \
  --name pguide_gateway \
  -d pguide_gateway


