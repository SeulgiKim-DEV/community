CREATE DATABASE community;

CREATE TABLE member (
  id BIGINT AUTO_INCREMENT NOT NULL,
   login_id VARCHAR(20) NOT NULL,
   user_name VARCHAR(15) NOT NULL,
   password VARCHAR(30) NOT NULL,
   email VARCHAR(50) NOT NULL,
   phone_number VARCHAR(11) NOT NULL,
   level INT NOT NULL,
   point INT NULL,
   grade VARCHAR(10) NULL,
   status VARCHAR(10) NOT NULL,
   resign BIT(1) NULL,
   created_at datetime NULL,
   updated_at datetime NULL,
   CONSTRAINT pk_member PRIMARY KEY (id)
);

CREATE TABLE member_access_history (
  id BIGINT AUTO_INCREMENT NOT NULL,
   member_id BIGINT NULL,
   access_time datetime NULL,
   CONSTRAINT pk_member_access_history PRIMARY KEY (id)
);

ALTER TABLE member_access_history ADD CONSTRAINT FK_MEMBER_ACCESS_HISTORY_ON_MEMBER FOREIGN KEY (member_id) REFERENCES member (id);
