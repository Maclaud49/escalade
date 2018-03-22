-- ====================================================================================================================
-----------------------------------------------------------------------------------------------------------------------
--
--   Auteur 				: 	Mickael Parlow (SOFYNE)
--	 Application			:	MP_Escalade_OC
--   Version application  	: 	01.00
--	 Type BDD 				:	Postgres 
--   Création 				: 	22/02/2018
--   Modification 			: 	
--   Description 			: 	Donnees pour application
--  
-----------------------------------------------------------------------------------------------------------------------
-- ====================================================================================================================



-- ====================================================================================================================
---------------------------------------------------ENVIRONNEMENT-------------------------------------------------------
-- ====================================================================================================================
SET search_path = sch_escalade,pg_catalog;

-- ====================================================================================================================
-----------------------------------------------------DONNEES-----------------------------------------------------------
-- ====================================================================================================================

INSERT INTO t_utilisateur(
  nom, prenom, datenaissance,email,password, profil, adresse_fk_id)
VALUES ('Parlow', 'Mickaël', '13/04/2018','mickael@parlow-co.com','escalade2018','admin','1');

INSERT INTO sch_escalade.t_adresse( adresse1, adresse2, codepostal, ville, pays) VALUES ('5 route d''Ouvrouer', '', '45510', 'Tigy', 'France');

INSERT INTO t_region(id,region) VALUES('1','Grand-Est');
INSERT INTO t_region(id,region) VALUES('2','Nouvelle-Aquitaine');
INSERT INTO t_region(id,region) VALUES('3','Auvergne-Rhône-Alpes');
INSERT INTO t_region(id,region) VALUES('4','Bourgogne-Franche-Comté');
INSERT INTO t_region(id,region) VALUES('5','Bretagne');
INSERT INTO t_region(id,region) VALUES('6','Centre-Val de Loire');
INSERT INTO t_region(id,region) VALUES('7','Corse');
INSERT INTO t_region(id,region) VALUES('8','Île-de-France');
INSERT INTO t_region(id,region) VALUES('9','Occitanie');
INSERT INTO t_region(id,region) VALUES('10','Hauts-de-France');
INSERT INTO t_region(id,region) VALUES('11','Normandie');
INSERT INTO t_region(id,region) VALUES('12','Pays de la Loire');
INSERT INTO t_region(id,region) VALUES('13','Provence-Alpes-Côte d''Azur');

INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Ardennes');
INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Aube');
INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Marne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Haute-Marne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Meurthe-et-Moselle');
INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Meuse');
INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Moselle');
INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Bas-Rhin');
INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Haut-Rhin');
INSERT INTO t_departement(region_fk_id,departement) VALUES('1','Vosges');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Charente');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Charente-Maritime');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Corrèze');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Creuse');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Deux-Sèvres');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Dordogne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Gironde');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Landes');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Lot-et-Garonne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Pyrénées-Atlantiques');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Haute-Vienne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('2','Vienne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Ain');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Allier');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Ardèche');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Cantal');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Drôme');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Haute-Loire');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Isère');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Loire');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Puy-de-Dôme');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Rhône');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Savois');
INSERT INTO t_departement(region_fk_id,departement) VALUES('3','Haute-Savoie');
INSERT INTO t_departement(region_fk_id,departement) VALUES('4','Côte-d''Or');
INSERT INTO t_departement(region_fk_id,departement) VALUES('4','Doubs');
INSERT INTO t_departement(region_fk_id,departement) VALUES('4','Jura');
INSERT INTO t_departement(region_fk_id,departement) VALUES('4','Nièvre');
INSERT INTO t_departement(region_fk_id,departement) VALUES('4','Saône-et-Loire');
INSERT INTO t_departement(region_fk_id,departement) VALUES('4','Haute-Saône');
INSERT INTO t_departement(region_fk_id,departement) VALUES('4','Territoire de Belfort');
INSERT INTO t_departement(region_fk_id,departement) VALUES('4','Yonne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('5','Côtes-d''Armor');
INSERT INTO t_departement(region_fk_id,departement) VALUES('5','Finistère');
INSERT INTO t_departement(region_fk_id,departement) VALUES('5','Ille-et-Vilaine');
INSERT INTO t_departement(region_fk_id,departement) VALUES('5','Morbihan');
INSERT INTO t_departement(region_fk_id,departement) VALUES('6','Cher');
INSERT INTO t_departement(region_fk_id,departement) VALUES('6','Eure-et-Loir');
INSERT INTO t_departement(region_fk_id,departement) VALUES('6','Indre');
INSERT INTO t_departement(region_fk_id,departement) VALUES('6','Indre-et-Loire');
INSERT INTO t_departement(region_fk_id,departement) VALUES('6','Loir-et-Cher');
INSERT INTO t_departement(region_fk_id,departement) VALUES('6','Loiret');
INSERT INTO t_departement(region_fk_id,departement) VALUES('7','Corse-du-Sud');
INSERT INTO t_departement(region_fk_id,departement) VALUES('7','Haute-Corse');
INSERT INTO t_departement(region_fk_id,departement) VALUES('8','Essonne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('8','Hauts-de-Seine');
INSERT INTO t_departement(region_fk_id,departement) VALUES('8','Paris');
INSERT INTO t_departement(region_fk_id,departement) VALUES('8','Seine-Saint-Denis');
INSERT INTO t_departement(region_fk_id,departement) VALUES('8','Seine-et-Marne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('8','Val-de-Marne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('8','Val-d''Oise');
INSERT INTO t_departement(region_fk_id,departement) VALUES('8','Yvelines');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Ariège');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Aude');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Aveyron');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Gard');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Haute-Garonne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Gers');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Lot');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Hautes-Pyrénées');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Hérault');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Lozère');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Pyrénées-Orientales');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Tarn');
INSERT INTO t_departement(region_fk_id,departement) VALUES('9','Tarn-et-Garonne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('10','Aisne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('10','Nord');
INSERT INTO t_departement(region_fk_id,departement) VALUES('10','Oise');
INSERT INTO t_departement(region_fk_id,departement) VALUES('10','Pas-de-Calais');
INSERT INTO t_departement(region_fk_id,departement) VALUES('10','Somme');
INSERT INTO t_departement(region_fk_id,departement) VALUES('11','Calvados');
INSERT INTO t_departement(region_fk_id,departement) VALUES('11','Eure');
INSERT INTO t_departement(region_fk_id,departement) VALUES('11','Manche');
INSERT INTO t_departement(region_fk_id,departement) VALUES('11','Orne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('11','Seine-Maritime');
INSERT INTO t_departement(region_fk_id,departement) VALUES('12','Loire-Atlantique');
INSERT INTO t_departement(region_fk_id,departement) VALUES('12','Maine-et-Loire');
INSERT INTO t_departement(region_fk_id,departement) VALUES('12','Mayenne');
INSERT INTO t_departement(region_fk_id,departement) VALUES('12','Sarthe');
INSERT INTO t_departement(region_fk_id,departement) VALUES('12','Vendée');
INSERT INTO t_departement(region_fk_id,departement) VALUES('13','Alpes-de-Haute-Provence');
INSERT INTO t_departement(region_fk_id,departement) VALUES('13','Hautes-Alpes');
INSERT INTO t_departement(region_fk_id,departement) VALUES('13','Alpes-Maritimes');
INSERT INTO t_departement(region_fk_id,departement) VALUES('13','Bouches-du-Rhône');
INSERT INTO t_departement(region_fk_id,departement) VALUES('13','Var');
INSERT INTO t_departement(region_fk_id,departement) VALUES('13','Vaucluse');

INSERT INTO t_cotation(cotation, niveau)VALUES (3, 1);
INSERT INTO t_cotation(cotation, niveau)VALUES ('3a', 2);
INSERT INTO t_cotation(cotation, niveau)VALUES ('3b', 3);
INSERT INTO t_cotation(cotation, niveau)VALUES ('3c', 4);
INSERT INTO t_cotation(cotation, niveau)VALUES (4, 1);
INSERT INTO t_cotation(cotation, niveau)VALUES ('4a', 5);
INSERT INTO t_cotation(cotation, niveau)VALUES ('4b', 6);
INSERT INTO t_cotation(cotation, niveau)VALUES ('4c', 7);
INSERT INTO t_cotation(cotation, niveau)VALUES (5, 8);
INSERT INTO t_cotation(cotation, niveau)VALUES ('5a', 9);
INSERT INTO t_cotation(cotation, niveau)VALUES ('5b', 10);
INSERT INTO t_cotation(cotation, niveau)VALUES ('5c', 11);
INSERT INTO t_cotation(cotation, niveau)VALUES (6, 12);
INSERT INTO t_cotation(cotation, niveau)VALUES ('6a', 13);
INSERT INTO t_cotation(cotation, niveau)VALUES ('6b', 14);
INSERT INTO t_cotation(cotation, niveau)VALUES ('6c', 15);
INSERT INTO t_cotation(cotation, niveau)VALUES (7, 16);
INSERT INTO t_cotation(cotation, niveau)VALUES ('7a', 17);
INSERT INTO t_cotation(cotation, niveau)VALUES ('7b', 18);
INSERT INTO t_cotation(cotation, niveau)VALUES ('7c', 19);
INSERT INTO t_cotation(cotation, niveau)VALUES (8, 20);
INSERT INTO t_cotation(cotation, niveau)VALUES ('8a', 21);
INSERT INTO t_cotation(cotation, niveau)VALUES ('8b', 22);
INSERT INTO t_cotation(cotation, niveau)VALUES ('8c', 23);
INSERT INTO t_cotation(cotation, niveau)VALUES (9, 24);
INSERT INTO t_cotation(cotation, niveau)VALUES ('9a', 25);
INSERT INTO t_cotation(cotation, niveau)VALUES ('9b', 26);
INSERT INTO t_cotation(cotation, niveau)VALUES ('9c', 27);

INSERT INTO t_profil(profil) VALUES ('Editor');
INSERT INTO t_profil(profil) VALUES ('Admin');

INSERT INTO t_image(chemin) VALUES ('../../ressources/images/750x300.png');





