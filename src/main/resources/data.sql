CREATE SCHEMA portfolio CHARACTER SET utf8;
USE portfolio;

CREATE TABLE user (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
username VARCHAR(20) NOT NULL,
password VARCHAR(20)
)ENGINE= INNODB;

CREATE TABLE network (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(20) NOT NULL,
icon VARCHAR(50) NOT NULL,
link VARCHAR(50) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE banner_image (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT ,
name VARCHAR(50) NOT NULL,
type VARCHAR(100) NOT NULL,
data BLOB,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE avatar_image (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
type VARCHAR(100) NOT NULL,
data BLOB,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE welcome(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
message VARCHAR(100) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE aboutme(
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
message VARCHAR(100) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE education_image (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
type VARCHAR(100) NOT NULL,
data BLOB,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE education (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
subtitle VARCHAR(30) NOT NULL,
detail VARCHAR(100) NOT NULL,
color VARCHAR(20) NOT NULL,
image_id INT NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (image_id) REFERENCES education_image(id)
)ENGINE= INNODB;

CREATE TABLE experience_image (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
type VARCHAR(100) NOT NULL,
data BLOB,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;


CREATE TABLE experience (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
subtitle VARCHAR(30) NOT NULL,
detail VARCHAR(100) NOT NULL,
color VARCHAR(20) NOT NULL,
image_id INT NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (image_id) REFERENCES experience_image(id)
)ENGINE= INNODB;

CREATE TABLE skill (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
percentaje INT(5) NOT NULL,
icon VARCHAR(100) NOT NULL,
color VARCHAR(20) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE project_image (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(50) NOT NULL,
type VARCHAR(100) NOT NULL,
data BLOB,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE project (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
description VARCHAR(200) NOT NULL,
link VARCHAR(100) NOT NULL,
image_id INT NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (image_id) REFERENCES project_image(id)
)ENGINE= INNODB;


INSERT INTO user(username, password)VALUES('nuccelli', 'Nuccelli2022');
INSERT INTO user(username, password)VALUES('argentina', 'Programa2022');
INSERT INTO network(title, icon, link, user_id)VALUES('Git Hub', 'fa-brands fa-github','http://github.com',1);
INSERT INTO network(title, icon, link, user_id)VALUES('LinkedIn', 'fa-brands fa-linkedin','http://linkedin.com',1);
INSERT INTO network(title, icon, link, user_id)VALUES('Instagram', 'fa-brands fa-instagram','http://instagram.com',1);
INSERT INTO network(title, icon, link, user_id)VALUES('Spotify', 'fa-brands fa-spotify','http://spotify.com',1);
INSERT INTO network(title, icon, link, user_id)VALUES('Oracle', 'fa-brands fa-github','http://google.com',2);
INSERT INTO network(title, icon, link, user_id)VALUES('Argentina Programa', 'fa-brands fa-linkedin','http://reddit.com',2);
