FROM justrydeng/jdk8
MAINTAINER liuyuqing<2273852279@qq.com>
RUN mkdir -p /java/
WORKDIR /java/jar
ADD ./target/liuyq-springBoot-test-1.0-SNAPSHOT.jar /java/jar
EXPOSE 8080
# 构建镜像之后运行
CMD ["java","-Djava.security.egd=file:/dev/./urandom -Dsentry.dsn=http://6f06eb4bb0904e27ba5538b4eaf98071@10.104.70.81:9000/2","-jar","liuyq-springBoot-test-1.0-SNAPSHOT.jar"]