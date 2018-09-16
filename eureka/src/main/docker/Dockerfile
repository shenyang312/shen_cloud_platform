# 基于哪个镜像
FROM java
# 将本地文件挂载到当前容器
VOLUME /tmp
#
#VOLUME /Data/logs
# 复制文件到容器，也可以直接写成
ADD eureka-0.0.1-SNAPSHOT.jar /app.jar
RUN bash -c 'touch /app.jar'
# Expose ports.
EXPOSE 18761
# Define default command.
ENTRYPOINT ["java","Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]