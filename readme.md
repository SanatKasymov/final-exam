Для запуска проекта требуется создать базу данных MySql с названием "exam";
Далее необходимо вписать логин и пароль от своей базы данных в application.properties
по этому шаблону:
spring.datasource.username=логин
spring.datasource.password=пароль

Возможно понадобится поменять порт базы данных в application.properties,
по дефолту он установлен на 3306
'spring.datasource.url=jdbc:mysql://localhost:3306/exam?serverTimezone=UTC'

Для запуска проекта  через консоль нужно создать jar файл с помощью
комманды maven package далее перейти по пути:
'..\fexam\target>' и ввести комманду 'java -jar fexam-0.0.1.jar'

Проект запускается на порту 8080

