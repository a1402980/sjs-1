INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
 VALUES ('Margharita', 7.90, 'true');

INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
 VALUES ('Vegetara', 8.90, 'true');

INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
VALUES ('Frutti di Mare', 9.90, 'false');

INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
VALUES ('Capricciosa', 9.90, 'true');

INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
VALUES ('Vesuvio', 9.90, 'true');

INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
VALUES ('Quatro Stagioni', 10.90, 'true');

INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
VALUES ('Della Casa', 10.90, 'true');

INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
VALUES ('Fantasia 2', 8.90, 'true');

INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
VALUES ('Fantasia 3', 9.90, 'true');

INSERT INTO pizza(p_nimi, p_hinta, p_saatavuus)
VALUES ('Fantasia 4', 10.90, 'true');



/*T�YTTEET*/

INSERT INTO tayte(t_nimi)
VALUES ('tomaattikastike');

INSERT INTO tayte(t_nimi)
VALUES ('juusto');

INSERT INTO tayte(t_nimi)
VALUES ('herkkusieni');

INSERT INTO tayte(t_nimi)
VALUES ('sipuli');

INSERT INTO tayte(t_nimi)
VALUES ('oliivi');

INSERT INTO tayte(t_nimi)
VALUES ('pinaatti');

INSERT INTO tayte(t_nimi)
VALUES ('tonnikala');

INSERT INTO tayte(t_nimi)
VALUES ('katkarapu');

INSERT INTO tayte(t_nimi)
VALUES ('simpukka');

INSERT INTO tayte(t_nimi)
VALUES ('kinkku');



/*YKSITT�ISEN PIZZAN T�YTTEET*/

INSERT INTO pizzatayte(pizza_id, tayte_id)
VALUES(1,1);

INSERT INTO pizzatayte(pizza_id, tayte_id)
VALUES(1,2);

INSERT INTO pizzatayte(pizza_id, tayte_id)
VALUES(2,1);

INSERT INTO pizzatayte(pizza_id, tayte_id)
VALUES(2,2);

INSERT INTO pizzatayte(pizza_id, tayte_id)
VALUES(2,3);

INSERT INTO pizzatayte(pizza_id, tayte_id)
VALUES(2,4);

INSERT INTO pizzatayte(pizza_id, tayte_id)
VALUES(2,5);

INSERT INTO pizzatayte(pizza_id, tayte_id)
VALUES(2,6);

/*K�YTT�J�RYHM�T*/

INSERT INTO kayttaja(kayttaja_id, username, password, userrole)
VALUES(1, 'admin', 'admin', 'omistaja');

INSERT INTO kayttaja(kayttaja_id, username, password, userrole)
VALUES(1, 'admin', 'admin', 'omistaja');



/*POISTA PIZZA*/
DELETE FROM pizza WHERE pizza_id= "+pizzaId+"; DELETE FROM pizzatayte WHERE pizza_id="+pizzaId+";

/*YHDIST� PIZZA JA SEN T�YTTEET */
SELECT p.pizza_id, p_nimi, p_hinta, p_saatavuus, t.tayte_id, t_nimi, t_hinta FROM pizza p INNER JOIN pizzatayte pt ON p.pizza_id = pt.pizza_id INNER JOIN tayte t ON t.tayte_id = pt.tayte_id;

/*tilaus ja pizzatilaus*/

INSERT INTO asiakas(etunimi, sukunimi, puh, osoite, posti_nro, posti_tmp, s_posti, kayttaja_id) VALUES ('Matti', 'Virtanen', '040-1234568', 'Kujakatu 2', 01232, 'Hattula', 'etu.suku@net.com', 5);

INSERT INTO tilaus(a_etunimi, a_sukunimi, a_puh, a_osoite, a_posti_nro, a_posti_tmp) VALUES ('assi', 'asiakas', '123456789', 'Kujakatu 1', 12345, 'Kunta');

INSERT INTO pizzatilaus(tilaus_id, pizza_id) VALUES (1,157);

/*lisää tilauksiin juomat*/
alter table tilaus add sprite enum('true', 'false') default 'false';
alter table tilaus add cola enum('true', 'false') default 'false';
alter table tilaus add fanta enum('true', 'false') default 'false';

alter table tilaus modify cola enum('true', 'false') NOT NULL default'false';

