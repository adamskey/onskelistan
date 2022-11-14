CREATE TABLE PRODUCT(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  TITLE VARCHAR(64) NOT NULL,
  AUTHOR VARCHAR(64) NOT NULL,
  PRICE BIGINT NOT NULL
);

CREATE TABLE USER(
  ID BIGINT AUTO_INCREMENT PRIMARY KEY,
  FIRST_NAME VARCHAR(64),
  LAST_NAME VARCHAR(64),
  EMAIL_ADDRESS VARCHAR(64),
  PASSWORD VARCHAR(64)
);
