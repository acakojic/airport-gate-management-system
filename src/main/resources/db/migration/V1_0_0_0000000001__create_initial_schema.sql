-- drop tables
DROP TABLE IF EXISTS GATE;
DROP TABLE IF EXISTS FLIGHT;

-- create tables
CREATE TABLE GATE (
    ID INT NOT NULL AUTO_INCREMENT,
    FLIGHT_ID INT UNIQUE,
    NAME VARCHAR(30) NOT NULL UNIQUE,
    STATUS VARCHAR(20) DEFAULT 'OPENED', -- OPENED, RESERVED, CLOSED
    PRIMARY KEY(id)
);

CREATE TABLE FLIGHT (
    ID INT NOT NULL AUTO_INCREMENT,
    NAME VARCHAR(30) UNIQUE,
    PRIMARY KEY(id)
);

ALTER TABLE GATE ADD CONSTRAINT FKeu2hidjqwaayny863s087jyuk FOREIGN KEY (FLIGHT_ID) REFERENCES FLIGHT;
-- alter table FLIGHT add constraint FLIGHT_GATE_ID_FK foreign key (GATE_ID) references GATE;
