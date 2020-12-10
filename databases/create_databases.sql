DROP DATABASE IF EXISTS greeter_greeting_dev;
DROP DATABASE IF EXISTS greeter_plant_dev;

CREATE DATABASE greeter_greeting_dev;
CREATE DATABASE greeter_plant_dev;

CREATE USER IF NOT EXISTS 'greeter'@'localhost' IDENTIFIED BY '';
GRANT ALL PRIVILEGES ON *.* TO 'greeter'@'localhost';




