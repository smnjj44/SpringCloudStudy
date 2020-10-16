#基于哪个镜像
FROM java:8

#将本地文件夹挂载到当前容器,持久化目录给多个容器公用
VOLUME /tmp

#复制文件到容器，需要jar包和dockerfile配置文件同一路径
ADD eurake.jar /eurake.jar

#声明暴露端口
EXPOSE 8761

#配置容器启动后执行的命令
ENTRYPOINT ["java","-jar","/eurake.jar"]