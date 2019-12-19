DROP DATABASE IF EXISTS greeting;

CREATE DATABASE greeting;

CREATE USER IF NOT EXISTS 'greeting'@'localhost' IDENTIFIED WITH mysql_native_password BY '';
GRANT ALL PRIVILEGES ON greeting.* TO 'greeting'@'localhost';
