#-f :指定要使用的Dockerfile路径
# -t XXX 构建tag为xxx 镜像
docker build -f Dockerfile -t dockerhub.ergengtech.com/genghuo/genghuo-trade:dev .
#docker push dockerhub.ergengtech.com/genghuo/genghuo-trade:dev
#docker push liuyuqing1212/eureka:dev