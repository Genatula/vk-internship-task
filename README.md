# Профильное задание на позицию бэкенд-разработчика
## Сборка
Для сборки проекта требуется JDK 17 
## Запуск
Измените файл `application.properties.public` согласно инструкции в начале этого файла

Для сборки используется Maven. Чтобы локально запустить проект, можно собрать jar-файл и запустить его из командной строки:
```shell
git clone https://github.com/Genatula/vk-internship-task.git
cd vk-internship-task
./mvnw package
java -jar target/*.jar
```
После этого процесс будет запущен локально на 8080 порту (или любом другом, указанном в `server.port` в файле `application.properties`)
## Тестирование
Для тестирования работы можно воспользоваться Swagger UI по адресу [http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html) (здесь указан порт по умолчанию) 