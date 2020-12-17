#-f :指定要使用的Dockerfile路径
# -t XXX 构建tag为xxx 镜像
docker build -f Dockerfile -t liuyuqing1212/liuyq-springboot-test:dev .
#docker push liuyuqing1212/liuyq-springboot-test:dev