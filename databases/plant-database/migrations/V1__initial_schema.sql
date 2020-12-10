CREATE TABLE plant (
    id      BIGINT(20) NOT NULL AUTO_INCREMENT,
    name VARCHAR(255),
    description VARCHAR(4000),
    height FLOAT,

    PRIMARY KEY (id)
)
    ENGINE = innodb
    DEFAULT CHARSET = utf8;

INSERT INTO plant (name, description, height) VALUES ('Rose', 'A red flower with thorns', 10.4);
INSERT INTO plant (name, description, height) VALUES ('African Violet', 'A purple flower found in Africa', 17.3);
INSERT INTO plant (name, description, height) VALUES ('Lily', 'A yellowish flower without leaves', 5.2);
