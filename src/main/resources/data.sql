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
image VARCHAR (100) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE avatar_image (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
image VARCHAR (100) NOT NULL,
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
message VARCHAR(1000) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE education (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
subtitle VARCHAR(30) NOT NULL,
detail VARCHAR(200) NOT NULL,
color VARCHAR(20) NOT NULL,
image VARCHAR (100) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE experience (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
subtitle VARCHAR(30) NOT NULL,
detail VARCHAR(300) NOT NULL,
color VARCHAR(20) NOT NULL,
image VARCHAR (100) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
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

CREATE TABLE project (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
title VARCHAR(30) NOT NULL,
description VARCHAR(200) NOT NULL,
link VARCHAR(100) NOT NULL,
image VARCHAR (100) NOT NULL,
user_id INT NOT NULL,
FOREIGN KEY (user_id) REFERENCES user(id)
)ENGINE= INNODB;

CREATE TABLE portfolio(
user_id INT NOT NULL PRIMARY KEY,
banner_image VARCHAR(100),
avatar_image VARCHAR(100),
network_title VARCHAR(20),
network_icon VARCHAR(50),
network_link VARCHAR(50),
welcome_message VARCHAR(100),
aboutme_message VARCHAR(1000),
education_title VARCHAR(30),
education_subtitle VARCHAR(30),
education_detail VARCHAR(100),
education_color VARCHAR(20),
education_image VARCHAR(100),
experience_title VARCHAR(30),
experience_subtitle VARCHAR(30),
experience_detail VARCHAR(300),
experience_color VARCHAR(20),
experience_image VARCHAR(100),
skill_title VARCHAR(30),
skill_percentaje INT(5),
skill_icon VARCHAR(100),
skill_color VARCHAR(20),
project_title VARCHAR(30),
project_description VARCHAR(200),
project_link VARCHAR(100),
project_image VARCHAR(30),
FOREIGN KEY (user_id) REFERENCES user(id),
FOREIGN KEY (banner_image) REFERENCES banner_image(image),
FOREIGN KEY (avatar_image) REFERENCES avatar_image(image),
FOREIGN KEY (network_title) REFERENCES network(title),
FOREIGN KEY (network_icon) REFERENCES network(icon),
FOREIGN KEY (network_link) REFERENCES network(link),
FOREIGN KEY (welcome_message) REFERENCES welcome(message),
FOREIGN KEY (aboutme_message) REFERENCES aboutme(message),
FOREIGN KEY (education_title ) REFERENCES education(title),
FOREIGN KEY (education_subtitle) REFERENCES education(subtitle),
FOREIGN KEY (education_detail) REFERENCES education(detail),
FOREIGN KEY (education_color) REFERENCES education(color),
FOREIGN KEY (education_image) REFERENCES education(image),
FOREIGN KEY (experience_title) REFERENCES experience(title),
FOREIGN KEY (experience_subtitle) REFERENCES experience(subtitle),
FOREIGN KEY (experience_detail) REFERENCES experience(detail),
FOREIGN KEY (experience_color) REFERENCES experience(color),
FOREIGN KEY (experience_image) REFERENCES experience(image),
FOREIGN KEY (skill_title) REFERENCES skill(title),
FOREIGN KEY (skill_percentaje) REFERENCES skill(percentaje),
FOREIGN KEY (skill_icon) REFERENCES skill(icon),
FOREIGN KEY (skill_color) REFERENCES skill(color),
FOREIGN KEY (project_title) REFERENCES project(title),
FOREIGN KEY (project_description) REFERENCES project(description),
FOREIGN KEY (project_link) REFERENCES project(link),
FOREIGN KEY (project_image) REFERENCES project(image)
)ENGINE= INNODB;

INSERT INTO user(username, password)VALUES('nuccelli', 'Nuccelli2022');
INSERT INTO user(username, password)VALUES('argentina', 'Programa2022');
INSERT INTO network(title, icon, link, user_id)VALUES('Git Hub', 'fa-brands fa-github','http://github.com',1);
INSERT INTO network(title, icon, link, user_id)VALUES('LinkedIn', 'fa-brands fa-linkedin','http://linkedin.com',1);
INSERT INTO network(title, icon, link, user_id)VALUES('Instagram', 'fa-brands fa-instagram','http://instagram.com',1);
INSERT INTO network(title, icon, link, user_id)VALUES('Spotify', 'fa-brands fa-spotify','http://spotify.com',1);
INSERT INTO network(title, icon, link, user_id)VALUES('Oracle', 'fa-brands fa-github','http://google.com',2);
INSERT INTO network(title, icon, link, user_id)VALUES('Argentina Programa', 'fa-brands fa-linkedin','http://reddit.com',2);
INSERT INTO aboutme(message, user_id)VALUES('Desde muy chico siempre estuve en contacto con las computadoras desde
    DOS y luego Windows 3.1. Con el tiempo fui adquiriendo conocimientos en
    varios software de diseño con los cuales realizo trabajos de renders
    para una arquitecta, (AutoCad, SketchUp, Fusion 360, Adobe Suite) y
    producción musical (Ableton Live) debido a que soy musico. Soy
    desarrollador web fullstack manejando, HTML, CSS, Javascript, Bootstrap
    y frameworks como Angular y React. Manejo backend con SpringBoot además
    de manejar su dependecia de seguridad y autenticacion JWT. Tambien
    realice aplicaciones de escritorio con Java y JavaFX. Ultimamente estoy
    desarrollando proyectos de Data Science poniendo en practica los cursos
    de Machine Learning y Deep Learning realizados en Alura Latam. Como
    segundo idioma manejo Ingles con un nivel C1 Advanced segun el EF
    Standard English Test.',1);
    INSERT INTO aboutme(message, user_id)VALUES('Forme parte del primer grupo de Proyecto ONE dictado por Alura Latam +
    Oracle , realizando de manera satisfactoria todas las rutas de
    aprendizaje y logrando tener el reconocimiento de Alura Latam como
    ayudante ONE Helper del Grupo 3. Soy una persona que le gusta aprender
    cosas nuevas sobre todo tecnologías, que sabe trabajar en equipo y a su
    vez me considero emprendedor.',1);
    INSERT INTO avatar_image (image, user_id)VALUES('https://github.com/nnfromthewindow/portafolio/blob/main/assets/img/avatar.jpg?raw=true',1);
    INSERT INTO banner_image (image, user_id)VALUES('https://github.com/nnfromthewindow/portfolio-ap/blob/main/src/assets/img/banner.jpg?raw=true',1);
    INSERT INTO education (title, subtitle, detail, color, image, user_id)VALUES('Alura','Formacion Fullstack', 'Cursos y challenges desarrollados durante todo el 2022 logrando conocimientos web fullstack, Java y Machine Learning', '#c2185b','https://www.aluracursos.com/assets/img/alura-share.1647533644.png',1);
	INSERT INTO education (title, subtitle, detail, color, image, user_id)VALUES('Instituto Fortin Pavon','Bachillerato Comercial', 'Formacion de titulo secundario completo con orientacion a contabilidad y administracion de empresas', '#5632a8','https://acogeauncientifico.com/static/fortin-pavon-ee57eb4156b76e83fb2b3577f7b45ad1.jpg',1);
    INSERT INTO experience (title, subtitle, detail, color, image, user_id)VALUES('Casino Sierra de la Ventana','Croupier', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Iste quibusdam velit hic, at debitis voluptas impedit assumenda recusandae nostrum quidem blanditiis eius rerum, totam natus iusto quasi, accusantium nam atque?', '#FF0066','https://www.noticiastornquist.com.ar/adjuntos/2022-04/casino.jpg',1);
	INSERT INTO experience (title, subtitle, detail, color, image, user_id)VALUES('Hostal del Arroyo','Administracion', 'Lorem ipsum dolor sit amet consectetur adipisicing elit. Iste quibusdam velit hic, at debitis voluptas impedit assumenda recusandae nostrum quidem blanditiis eius rerum, totam natus iusto quasi, accusantium nam atque?', '#ffee00','https://live.staticflickr.com/1429/4609529146_f07d1a4585_z.jpg',1);
	INSERT INTO project (title, description, link, image, user_id)VALUES('Encriptador de Texto', 'Aplicacion para encriptar y desencriptar texto, desarrollado con HTML, CSS y Javascript','https://nnfromthewindow.github.io/challengeencriptador/', 'https://github.com/nnfromthewindow/portafolio/blob/main/assets/img/encriptador.jpeg?raw=true',1);
	INSERT INTO project (title, description, link, image, user_id)VALUES('Juego del Ahorcado', 'Juego clasico del ahorcado, con la posibilidad de agregar palabras nuevas haciendo uso de LocalStorage, desarrollado con HTML, CSS y Javascript','https://nnfromthewindow.github.io/challengeonejuegoahorcado/', 'https://github.com/nnfromthewindow/portafolio/blob/main/assets/img/ahorcado.jpeg?raw=true',1);  
    INSERT INTO skill (title, percentaje, icon, color, user_id)VALUES('HTML', 80, 'fa-brands fa-html5','green',1);
    INSERT INTO skill (title, percentaje, icon, color, user_id)VALUES('Javascript', 90, 'fa-brands fa-square-js','red',1);    
    INSERT INTO welcome (message, user_id)VALUES('Hola! me llamo Nicolás Nuccelli y soy desarrollador de páginas y aplicaciones',1)
    