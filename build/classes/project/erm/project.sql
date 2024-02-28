SET SESSION FOREIGN_KEY_CHECKS=0;

/* Drop Tables */

DROP TABLE IF EXISTS boardAdvice;
DROP TABLE IF EXISTS BoardAuction;
DROP TABLE IF EXISTS equipment;
DROP TABLE IF EXISTS users;




/* Create Tables */

CREATE TABLE boardAdvice
(
	bid int NOT NULL AUTO_INCREMENT,
	uid varchar(12) NOT NULL,
	title varchar(256) NOT NULL,
	content varchar(4000),
	modTime datetime DEFAULT CURRENT_TIMESTAMP,
	isDeleted int DEFAULT 0,
	viewCount int DEFAULT 0,
	replyCount int DEFAULT 0,
	PRIMARY KEY (bid)
);


CREATE TABLE BoardAuction
(
	bid int NOT NULL AUTO_INCREMENT,
	uid varchar(12) NOT NULL,
	applTime datetime NOT NULL,
	nickName varchar(16),
	processTitle varchar(64),
	processContent varchar(256),
	avgPrice int,
	numOfCompany int,
	process int,
	isDeleted int,
	PRIMARY KEY (bid)
);


CREATE TABLE equipment
(
	inum int NOT NULL AUTO_INCREMENT,
	eImg varchar(256) NOT NULL,
	ename varchar(64) NOT NULL,
	eContent varchar(256) NOT NULL,
	price int NOT NULL,
	PRIMARY KEY (inum)
);


CREATE TABLE users
(
	uid varchar(12) NOT NULL,
	pwd char(60) NOT NULL,
	uname varchar(16) NOT NULL,
	email varchar(32),
	nickName varchar(16),
	regDate date DEFAULT (CURRENT_DATE),
	isDeleted int DEFAULT 0,
	PRIMARY KEY (uid)
);



/* Create Foreign Keys */

ALTER TABLE boardAdvice
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;


ALTER TABLE BoardAuction
	ADD FOREIGN KEY (uid)
	REFERENCES users (uid)
	ON UPDATE RESTRICT
	ON DELETE RESTRICT
;



