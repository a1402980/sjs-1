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


CREATE TABLE omistaja(
omistaja_id int NOT NULL AUTO_INCREMENT,
o_username varchar(50) UNIQUE NOT NULL,
o_password varchar(50) NOT NULL,
PRIMARY KEY (omistaja_id)
)Engine="InnoDB";

CREATE TABLE asiakas(
asiakas_id int NOT NULL AUTO_INCREMENT,
a_username varchar(50) UNIQUE NOT NULL,
a_password varchar(50) NOT NULL,
PRIMARY KEY (asiakas_id)
)Engine="InnoDB";
