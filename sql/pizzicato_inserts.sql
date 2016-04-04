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



/*TÄYTTEET*/

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



/*YKSITTÄISEN PIZZAN TÄYTTEET*/

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

/*KÄYTTÄJÄRYHMÄT*/

INSERT INTO kayttaja(kayttaja_id, username, password, userrole)
VALUES(1, 'admin', 'admin', 'omistaja')



