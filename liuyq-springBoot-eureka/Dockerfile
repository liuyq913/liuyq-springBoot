FROM justrydeng/jdk8
MAINTAINER liuyuqing<2273852279@qq.com>
RUN mkdir -p /java/
WORKDIR /java/jar
ADD ./target/liuyq-springBoot-eureka-1.0-SNAPSHOT.jar /java/jar
EXPOSE 8092
# 构建镜像之后运行
CMD ["java","-jar","liuyq-springBoot-eureka-1.0-SNAPSHOT.jar"]