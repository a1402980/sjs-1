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
asiakas_id int NOT NULL AUTO_INCREMENT,
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
tilaus_id int (11) NOT NULL AUTO_INCREMENT,
status varchar(15) NOT NULL default 'Odottaa',
til_ajankohta timestamp NOT NULL default CURRENT_TIMESTAMP(),
a_etunimi varchar(30) NOT NULL,
a_sukunimi varchar(30) NOT NULL,
a_puh varchar(15) NOT NULL,
a_osoite varchar(30) NOT NULL,
a_posti_nro char(5) NOT NULL,
a_posti_tmp varchar(15) NOT NULL, 
cola enum('true', 'false') NOT NULL default'false',
fanta enum('true', 'false') NOT NULL default'false',
sprite enum('true', 'false') NOT NULL default'false', 
yht_hinta decimal(4,2) NOT NULL,
PRIMARY KEY (tilaus_id)
)Engine="InnoDB";




CREATE TABLE pizzatilaus(
pizzatil_id int NOT NULL AUTO_INCREMENT,
tilaus_id int NOT NULL,
pizza_id int NOT NULL,
oregano enum('true', 'false') NOT NULL default'false',
valkosipuli enum('true', 'false') NOT NULL default 'false',
PRIMARY KEY (pizzatil_id),
FOREIGN KEY (tilaus_id) REFERENCES tilaus(tilaus_id),
FOREIGN KEY (pizza_id) REFERENCES pizza(pizza_id)
)Engine="InnoDB";

