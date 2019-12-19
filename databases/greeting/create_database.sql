DROP DATABASE IF EXISTS greeting;

CREATE DATABASE greeting;

CREATE USER IF NOT EXISTS 'greeting'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON greeting.* TO 'greeting'@'localhost';
