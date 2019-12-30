This is my simple project
I made it to understand how Spring Boot works
To run it you should create database with login and pass like that:
db.driver=com.mysql.jdbc.Driver
db.url=jdbc:mysql://localhost:3306/testdb
db.username=root
db.password=1234567976

To run H2 console you should uncomment spring boot appliation settings in main, because H2 dont works with security(