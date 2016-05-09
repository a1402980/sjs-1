CREATE TABLE pizza(
pizza_id int NOT NULL AUTO_INCREMENT,
p_nimi varchar(50) UNIQUE NOT NULL,
p_hinta decimal(4,2) NOT NULL,
p_saatavuus enum('true', 'false') NOT NULL,
PRIMARY KEY (pizza_id)
)Engine="InnoDB";

CREATE TABLE tayte(
tayte_id int NOT NULL AUTO_INCREMENT,
t_nimi varchar(30) UNIQUE NOT NULL,
t_hinta decimal(4,2) NOT NULL,
PRIMARY KEY(tayte_id)
)Engine="InnoDB";

CREATE TABLE pizzatayte(
pizza_id int NOT NULL,
tayte_id int NOT NULL,
PRIMARY KEY (pizza_id, tayte_id),
FOREIGN KEY (pizza_id) REFERENCES pizza(pizza_id),
FOREIGN KEY (tayte_id) REFERENCES tayte(tayte_id)
)Engine="InnoDB";


CREATE TABLE kayttaja(
kayttaja_id int NOT NULL AUTO_INCREMENT,
username varchar(50) UNIQUE NOT NULL,
password varchar(50) NOT NULL,
userrole varchar(15) NOT NULL,
PRIMARY KEY (kayttaja_id)
)Engine="InnoDB";


CREATE TABLE asiakas(
asiakas_id int NOT NULL,
etunimi varchar(30) NOT NULL,
sukunimi varchar(30) NOT NULL,
puh varchar(15) NOT NULL,
osoite varchar(30) NOT NULL,
posti_nro char(5) NOT NULL,
posti_tmp varchar(15) NOT NULL,
s_posti varchar(15),
kayttaja_id int NOT NULL,
PRIMARY KEY (asiakas_id),
FOREIGN KEY (kayttaja_id) REFERENCES kayttaja(kayttaja_id)
)Engine="InnoDB";


CREATE TABLE tilaus(
tilaus_id int NOT NULL AUTO_INCREMENT,
asiakas_id int NOT NULL,
etunimi varchar(30) NOT NULL,
sukunimi varchar(30) NOT NULL,
puh varchar(15) NOT NULL,
osoite varchar(30) NOT NULL,
posti_nro char(5) NOT NULL,
posti_tmp varchar(15) NOT NULL,
status varchar(15) NOT NULL default 'Odottaa',
til_ajankohta timestamp NOT NULL default CURRENT_TIMESTAMP(), 
oregano enum('true', 'false') NOT NULL,
valkosipuli enum('true', 'false') NOT NULL,
PRIMARY KEY (tilaus_id),
FOREIGN KEY (asiakas_id) REFERENCES asiakas(asiakas_id)
)Engine="InnoDB";




CREATE TABLE pizzatilaus(
tilaus_id int NOT NULL,
pizza_id int NOT NULL,
lkm int NOT NULL,
PRIMARY KEY (tilaus_id, pizza_id),
FOREIGN KEY (tilaus_id) REFERENCES tilaus(tilaus_id),
FOREIGN KEY (pizza_id) REFERENCES pizza(pizza_id)
)Engine="InnoDB";

CREATE VIEW v_tilausnakyma AS SELECT t.tilaus_id, status, til_ajankohta, pt.pizza_id, lkm, p_nimi, p_hinta*lkm
FROM tilaus t JOIN pizzatilaus pt ON t.tilaus_id = pt.tilaus_id JOIN pizza p ON pt.pizza_id = p.pizza_id;


