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
-----------------------------------------------------DONNEES-----------------------------------------------------------
-- ====================================================================================================================



INSERT INTO t_utilisateur(utilisateur_id,utilisateur_nom, utilisateur_prenom, utilisateur_datenaissance,utilisateur_email,utilisateur_password,utilisateur_cotation, utilisateur_profil, adresse_adresse1, adresse_adresse2, adresse_codepostal, adresse_ville, adresse_pays)
VALUES ('1','Parlow', 'Mickaël', '13/04/1981','mickael@parlow-co.com','escalade', '3c', 'admin','5 route d''Ouvrouer', '', '45510', 'Tigy', 'France');
INSERT INTO t_utilisateur(utilisateur_id,utilisateur_nom, utilisateur_prenom, utilisateur_datenaissance,utilisateur_email,utilisateur_password, utilisateur_cotation, utilisateur_profil, adresse_adresse1, adresse_adresse2, adresse_codepostal, adresse_ville, adresse_pays)
VALUES ('2','Parlow', 'Aimée', '28/09/1976','aimee@parlow-co.com','escalade','4b','utilisateur','5 route d''Ouvrouer', '', '45510', 'Tigy', 'France');
INSERT INTO t_utilisateur(utilisateur_id,utilisateur_nom, utilisateur_prenom, utilisateur_datenaissance,utilisateur_email,utilisateur_password, utilisateur_cotation, utilisateur_profil, adresse_adresse1, adresse_adresse2, adresse_codepostal, adresse_ville, adresse_pays)
VALUES ('3','Cloëz', 'Jurgens', '22/08/1983','jurgens@parlow-co.com','escalade','6c','utilisateur','5 route d''Ouvrouer', '', '45510', 'Tigy', 'France');



INSERT INTO t_site(site_id, site_nom, site_description,site_utilisateur_fk_id,site_dateCreation, site_lastUpdate,site_publication, site_image, site_region)
VALUES ('1','Site N°1',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
        '1', '05/01/2018', '07/02/2018', 'false', '../../ressources/images/etiquette1.jpg', 'Corse');
INSERT INTO t_site(site_id, site_nom, site_description,site_utilisateur_fk_id,site_dateCreation, site_lastUpdate,site_publication, site_image, site_region)
VALUES ('2','Site N°2',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
        '2', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette2.jpg', 'Corse');
INSERT INTO t_site(site_id, site_nom, site_description,site_utilisateur_fk_id,site_dateCreation, site_lastUpdate,site_publication, site_image, site_region)
VALUES ('3','Site N°3',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
        '3', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette3.jpg', 'Corse');

INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_description,secteur_utilisateur_fk_id,secteur_dateCreation, secteur_lastUpdate,secteur_publication, secteur_image,secteur_departement)
VALUES ('1','Secteur N°1',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
        '1', '05/01/2018', '07/02/2018', 'false', '../../ressources/images/etiquette1.jpg', 'Loiret');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_description,secteur_utilisateur_fk_id,secteur_dateCreation, secteur_lastUpdate,secteur_publication, secteur_image,secteur_departement)
VALUES ('2','Secteur N°2',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
        '2', '05/01/2018', '07/02/2018', 'false', '../../ressources/images/etiquette2.jpg', 'Loiret');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_description,secteur_utilisateur_fk_id,secteur_dateCreation, secteur_lastUpdate,secteur_publication, secteur_image,secteur_departement)
VALUES ('3','Secteur N°3',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
        '3', '05/01/2018', '07/02/2018', 'false', '../../ressources/images/etiquette3.jpg', 'Loiret');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_description,secteur_utilisateur_fk_id,secteur_dateCreation, secteur_lastUpdate,secteur_publication, secteur_image,secteur_departement)
VALUES ('4','Secteur N°4',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
        '1', '05/01/2018', '07/02/2018', 'false', '../../ressources/images/etiquette1.jpg', 'Loiret');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_description,secteur_utilisateur_fk_id,secteur_dateCreation, secteur_lastUpdate,secteur_publication, secteur_image,secteur_departement)
VALUES ('5','Secteur N°5',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
        '2', '05/01/2018', '07/02/2018', 'false', '../../ressources/images/etiquette2.jpg', 'Loiret');
INSERT INTO t_secteur(secteur_id, secteur_nom, secteur_description,secteur_utilisateur_fk_id,secteur_dateCreation, secteur_lastUpdate,secteur_publication, secteur_image,secteur_departement)
VALUES ('6','Secteur N°6',
        'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
        '3', '05/01/2018', '07/02/2018', 'false', '../../ressources/images/etiquette3.jpg', 'Loiret');


INSERT INTO t_voie(voie_id, voie_nom, voie_description,voie_utilisateur_fk_id,voie_dateCreation, voie_lastUpdate,voie_publication, voie_image,voie_hauteurVoie,voie_cotation,voie_nbPoints,voie_equipee)
VALUES ('1','Voie N°1',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '1', '05/01/2018', '07/02/2018', 'false', '../../ressources/images/etiquette1.jpg', '5,2','5b','3','true');
INSERT INTO t_voie(voie_id, voie_nom, voie_description,voie_utilisateur_fk_id,voie_dateCreation, voie_lastUpdate,voie_publication, voie_image,voie_hauteurVoie,voie_cotation,voie_nbPoints,voie_equipee)
VALUES ('2','Voie N°2',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '2', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette2.jpg', '5,2','5b','3','true');
INSERT INTO t_voie(voie_id, voie_nom, voie_description,voie_utilisateur_fk_id,voie_dateCreation, voie_lastUpdate,voie_publication, voie_image,voie_hauteurVoie,voie_cotation,voie_nbPoints,voie_equipee)
VALUES ('3','Voie N°3',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '3', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette3.jpg', '5,2','5b','3','true');
INSERT INTO t_voie(voie_id, voie_nom, voie_description,voie_utilisateur_fk_id,voie_dateCreation, voie_lastUpdate,voie_publication, voie_image,voie_hauteurVoie,voie_cotation,voie_nbPoints,voie_equipee)
VALUES ('4','Voie N°4',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '1', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette1.jpg', '5,2','5b','3','true');
INSERT INTO t_voie(voie_id, voie_nom, voie_description,voie_utilisateur_fk_id,voie_dateCreation, voie_lastUpdate,voie_publication, voie_image,voie_hauteurVoie,voie_cotation,voie_nbPoints,voie_equipee)
VALUES ('5','Voie N°5',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '2', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette2.jpg', '5,2','5b','3','true');
INSERT INTO t_voie(voie_id, voie_nom, voie_description,voie_utilisateur_fk_id,voie_dateCreation, voie_lastUpdate,voie_publication, voie_image,voie_hauteurVoie,voie_cotation,voie_nbPoints,voie_equipee)
VALUES ('6','Voie N°6',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '3', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette3.jpg', '5,2','5b','3','true');


INSERT INTO t_longueur(longueur_id, longueur_nom, longueur_description,longueur_utilisateur_fk_id,longueur_dateCreation, longueur_lastUpdate,longueur_publication, longueur_image,longueur_relai,longueur_voie_fk_id,longueur_cotation)
VALUES ('1','Longueur N°1',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '1', '05/01/2018', '07/02/2018', 'false', '../../ressources/images/etiquette1.jpg', '3,1','1','3c');
INSERT INTO t_longueur(longueur_id, longueur_nom, longueur_description,longueur_utilisateur_fk_id,longueur_dateCreation, longueur_lastUpdate,longueur_publication, longueur_image,longueur_relai,longueur_voie_fk_id,longueur_cotation)
VALUES ('2','Longueur N°2',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '2', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette1.jpg', '3,1','1','3c');
INSERT INTO t_longueur(longueur_id, longueur_nom, longueur_description,longueur_utilisateur_fk_id,longueur_dateCreation, longueur_lastUpdate,longueur_publication, longueur_image,longueur_relai,longueur_voie_fk_id,longueur_cotation)
VALUES ('3','Longueur N°3',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '3', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette1.jpg', '3,1','2','3c');
INSERT INTO t_longueur(longueur_id, longueur_nom, longueur_description,longueur_utilisateur_fk_id,longueur_dateCreation, longueur_lastUpdate,longueur_publication, longueur_image,longueur_relai,longueur_voie_fk_id,longueur_cotation)
VALUES ('4','Longueur N°4',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '1', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette1.jpg', '3,1','2','3c');
INSERT INTO t_longueur(longueur_id, longueur_nom, longueur_description,longueur_utilisateur_fk_id,longueur_dateCreation, longueur_lastUpdate,longueur_publication, longueur_image,longueur_relai,longueur_voie_fk_id,longueur_cotation)
VALUES ('5','Longueur N°5',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '2', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette1.jpg', '3,1','3','3c');
INSERT INTO t_longueur(longueur_id, longueur_nom, longueur_description,longueur_utilisateur_fk_id,longueur_dateCreation, longueur_lastUpdate,longueur_publication, longueur_image,longueur_relai,longueur_voie_fk_id,longueur_cotation)
VALUES ('6','Longueur N°6',
            'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam. Dicta expedita corporis animi vero voluptate voluptatibus possimus, veniam magni quis!',
            '3', '05/01/2018', '07/02/2018', 'true', '../../ressources/images/etiquette1.jpg', '3,1','3','3c');

-- ====================================================================================================================
--------------------------------------------------------- CONTRAINTES -------------------------------------------------
-- ====================================================================================================================

ALTER TABLE t_topo ADD CONSTRAINT t_topo_utilisateur_fk FOREIGN KEY (topo_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_site ADD CONSTRAINT t_site_utilisateur_fk FOREIGN KEY (site_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_secteur ADD CONSTRAINT t_secteur_utilisateur_fk FOREIGN KEY (secteur_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_voie ADD CONSTRAINT t_voie_utilisateur_fk FOREIGN KEY (voie_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_longueur ADD CONSTRAINT t_longueur_voie_fk FOREIGN KEY (longueur_voie_fk_id) REFERENCES t_voie ON DELETE SET NULL;
ALTER TABLE t_longueur ADD CONSTRAINT t_longueur_utilisateur_fk FOREIGN KEY (longueur_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_utilisateur_fk FOREIGN KEY (loc_topoProprioUser_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_utilisateur_fk2 FOREIGN KEY (loc_topoLoueurUser_fk_id) REFERENCES t_utilisateur ON DELETE RESTRICT;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_topo_fk FOREIGN KEY (loc_topo_fk_id) REFERENCES t_topo ON DELETE RESTRICT;
ALTER TABLE t_commentaire ADD CONSTRAINT t_commentaire_utilisateur_fk FOREIGN KEY (com_utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_site_secteur_asso ADD CONSTRAINT t_site_secteur_asso_site_fk FOREIGN KEY (site_fk_id) REFERENCES t_site ON DELETE CASCADE;
ALTER TABLE t_site_secteur_asso ADD CONSTRAINT t_site_secteur_asso_secteur_fk FOREIGN KEY (secteur_fk_id) REFERENCES t_secteur ON DELETE CASCADE;
ALTER TABLE t_secteur_voie_asso ADD CONSTRAINT t_secteur_voie_asso_secteur_fk FOREIGN KEY (secteur_fk_id) REFERENCES t_secteur ON DELETE CASCADE;
ALTER TABLE t_secteur_voie_asso ADD CONSTRAINT t_secteur_voie_asso_voie_fk FOREIGN KEY (voie_fk_id) REFERENCES t_voie ON DELETE CASCADE;









