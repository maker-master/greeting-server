CREATE TABLE greeting (
    id      BIGINT(20) NOT NULL AUTO_INCREMENT,
    message VARCHAR(255),

    PRIMARY KEY (id)
)
    ENGINE = innodb
    DEFAULT CHARSET = utf8;