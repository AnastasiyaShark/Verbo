#//каждая команда добавляет слой в image
#родительский image на основе которого будет собираться мой image (образ) для app. образ my JDK. from DockerHub
FROM openjdk:17-ea-jdk-alpine
#копирует файлы и папки в контейнер. app.jar - name of image
ADD target/App-0.0.1.jar /backend_app.jar
#jar-файл запускается, собирается команда java -jar app.jar из заданной рабочей директории
ENTRYPOINT ["java","-jar","/backend_app.jar"]

EXPOSE 8080

