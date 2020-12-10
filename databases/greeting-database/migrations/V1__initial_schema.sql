CREATE TABLE greeting (
    id      BIGINT(20) NOT NULL AUTO_INCREMENT,
    message VARCHAR(255),

    PRIMARY KEY (id)
)
    ENGINE = innodb
    DEFAULT CHARSET = utf8;

INSERT INTO greeting (message) VALUES ("Hello");
INSERT INTO greeting (message) VALUES ("Bonjour");
INSERT INTO greeting (message) VALUES ("Ni Hao");