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


-- ====================================================================================================================
-----------------------------------------------------DONNEES-----------------------------------------------------------
-- ====================================================================================================================



INSERT INTO t_utilisateur(utilisateur_id,utilisateur_nom, utilisateur_prenom, utilisateur_datenaissance,utilisateur_email,utilisateur_password,utilisateur_cotation, utilisateur_profil, adresse_adresse1, adresse_adresse2, adresse_codepostal, adresse_ville, adresse_pays)
VALUES ('1','Parlow', 'Mickaël', '13/04/1981','mickael@parlow-co.com','escalade', '3c', 'admin','5 route d''Ouvrouer', '', '45510', 'Tigy', 'France');
INSERT INTO t_utilisateur(utilisateur_id,utilisateur_nom, utilisateur_prenom, utilisateur_datenaissance,utilisateur_email,utilisateur_password, utilisateur_cotation, utilisateur_profil, adresse_adresse1, adresse_adresse2, adresse_codepostal, adresse_ville, adresse_pays)
VALUES ('2','Parlow', 'Aimée', '28/09/1976','aimee@parlow-co.com','escalade','4b','utilisateur','5 route d''Ouvrouer', '', '45510', 'Tigy', 'France');
INSERT INTO t_utilisateur(utilisateur_id,utilisateur_nom, utilisateur_prenom, utilisateur_datenaissance,utilisateur_email,utilisateur_password, utilisateur_cotation, utilisateur_profil, adresse_adresse1, adresse_adresse2, adresse_codepostal, adresse_ville, adresse_pays)
VALUES ('3','Cloëz', 'Jurgens', '22/08/1983','jurgens@parlow-co.com','escalade','6c','utilisateur','5 route d''Ouvrouer', '', '45510', 'Tigy', 'France');


INSERT INTO t_site(site_id,site_nom, site_region, site_description, site_lastupdate, site_datecreation, site_image, site_utilisateur_fk_id, site_publication)
VALUES ('1','Site N°1', 'Corse', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!', '05/01/2018', '07/02/2018', '../../ressources/images/etiquette1.jpg', '1', 'false');
INSERT INTO t_site(site_id, site_nom, site_region, site_description, site_lastupdate, site_datecreation, site_image, site_utilisateur_fk_id, site_publication)
VALUES ('2','Site N°2', 'Bretagne', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!', '13/07/2017', '22/02/2018', '../../ressources/images/etiquette2.jpg', '2', 'true');
INSERT INTO t_site(site_id, site_nom, site_region, site_description, site_lastupdate, site_datecreation, site_image, site_utilisateur_fk_id, site_publication)
VALUES ('3','Site N°3', 'Centre-Val de Loire', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!', '18/09/2017', '15/03/2018', '../../ressources/images/etiquette3.jpg', '3', 'true');

INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_site_fk_id, secteur_utilisateur_fk_id, secteur_publication, secteur_lastupdate, secteur_datecreation, secteur_description)
VALUES ('1','secteur N°1','1','3', 'true', '25/03/2018', '17/01/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_site_fk_id, secteur_utilisateur_fk_id, secteur_publication, secteur_lastupdate, secteur_datecreation, secteur_description)
VALUES ('2','secteur N°2','1','3', 'true', '25/03/2018', '17/01/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_site_fk_id, secteur_utilisateur_fk_id, secteur_publication, secteur_lastupdate, secteur_datecreation, secteur_description)
VALUES ('3','secteur N°3','1','3', 'true', '25/03/2018', '17/01/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_site_fk_id, secteur_utilisateur_fk_id, secteur_publication, secteur_lastupdate, secteur_datecreation, secteur_description)
VALUES ('4','secteur N°4','2','3', 'true', '25/03/2018', '17/01/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_site_fk_id, secteur_utilisateur_fk_id, secteur_publication, secteur_lastupdate, secteur_datecreation, secteur_description)
VALUES ('5','secteur N°5','2','3', 'true', '25/03/2018', '17/01/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_site_fk_id, secteur_utilisateur_fk_id, secteur_publication, secteur_lastupdate, secteur_datecreation, secteur_description)
VALUES ('6','secteur N°6','2','3', 'true', '25/03/2018', '17/01/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_site_fk_id, secteur_utilisateur_fk_id, secteur_publication, secteur_lastupdate, secteur_datecreation, secteur_description)
VALUES ('7','secteur N°7','3','3', 'true', '25/03/2018', '17/01/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_site_fk_id, secteur_utilisateur_fk_id, secteur_publication, secteur_lastupdate, secteur_datecreation, secteur_description)
VALUES ('8','secteur N°8','3','3', 'true', '25/03/2018', '17/01/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_site_fk_id, secteur_utilisateur_fk_id, secteur_publication, secteur_lastupdate, secteur_datecreation, secteur_description)
VALUES ('9','secteur N°9','3','3', 'true', '25/03/2018', '17/01/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.');

INSERT INTO t_voie(voie_id, voie_nom, voie_cotation, voie_nbpoints, voie_equipee, voie_secteur_fk_id, voie_interet, voie_utilisateur_fk_id, voie_lastupdate, voie_datecreation, voie_description, voie_publication)
VALUES ('1', 'Voie N°1', '3c', '2', 'true', '2', '5', '1', '02/03/2018', '01/02/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.', 'true');
INSERT INTO t_voie(voie_id, voie_nom, voie_cotation, voie_nbpoints, voie_equipee, voie_secteur_fk_id, voie_interet, voie_utilisateur_fk_id, voie_lastupdate, voie_datecreation, voie_description, voie_publication)
VALUES ('2', 'Voie N°2', '5a', '1', 'true', '2', '5', '1', '02/03/2018', '01/02/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.', 'true');
INSERT INTO t_voie(voie_id, voie_nom, voie_cotation, voie_nbpoints, voie_equipee, voie_secteur_fk_id, voie_interet, voie_utilisateur_fk_id, voie_lastupdate, voie_datecreation, voie_description, voie_publication)
VALUES ('3', 'Voie N°3', '6b', '3', 'true', '2', '5', '2', '02/03/2018', '01/02/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.', 'true');
INSERT INTO t_voie(voie_id, voie_nom, voie_cotation, voie_nbpoints, voie_equipee, voie_secteur_fk_id, voie_interet, voie_utilisateur_fk_id, voie_lastupdate, voie_datecreation, voie_description, voie_publication)
VALUES ('4', 'Voie N°4', '4a', '2', 'true', '2', '5', '3', '02/03/2018', '01/02/2018', 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.', 'true');


-- ====================================================================================================================
--------------------------------------------------------- CONTRAINTES -------------------------------------------------
-- ====================================================================================================================

ALTER TABLE t_topo ADD CONSTRAINT t_topo_utilisateur_fk FOREIGN KEY (topo_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_site ADD CONSTRAINT t_site_utilisateur_fk FOREIGN KEY (site_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_secteur ADD CONSTRAINT t_secteur_site_fk FOREIGN KEY (secteur_site_fk_id) REFERENCES t_site ON DELETE SET NULL;
ALTER TABLE t_secteur ADD CONSTRAINT t_secteur_utilisateur_fk FOREIGN KEY (secteur_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_voie ADD CONSTRAINT t_voie_secteur_fk FOREIGN KEY (voie_secteur_fk_id) REFERENCES t_secteur ON DELETE SET NULL;
ALTER TABLE t_voie ADD CONSTRAINT t_voie_utilisateur_fk FOREIGN KEY (voie_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_longueur ADD CONSTRAINT t_longueur_voie_fk FOREIGN KEY (longueur_voie_fk_id) REFERENCES t_voie ON DELETE SET NULL;
ALTER TABLE t_longueur ADD CONSTRAINT t_longueur_utilisateur_fk FOREIGN KEY (longueur_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_utilisateur_fk FOREIGN KEY (loc_topoProprioUser_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_utilisateur_fk2 FOREIGN KEY (loc_topoLoueurUser_fk_id) REFERENCES t_utilisateur ON DELETE RESTRICT;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_topo_fk FOREIGN KEY (loc_topo_fk_id) REFERENCES t_topo ON DELETE RESTRICT;
ALTER TABLE t_commentaire ADD CONSTRAINT t_commentaire_utilisateur_fk FOREIGN KEY (com_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;




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



INSERT INTO t_image(chemin) VALUES ('../../ressources/images/750x300.png');





