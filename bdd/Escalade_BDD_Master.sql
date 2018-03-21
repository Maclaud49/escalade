-- ====================================================================================================================
-----------------------------------------------------------------------------------------------------------------------
--
--   Auteur 				: 	Mickael Parlow 
--	 Application			:	MP_Escalade_OC
--   Version application  	: 	01.00
--	 Type BDD 				:	Postgres 
--   Création 				: 	22/02/2018
--   Modification 			: 	
--   Description 			: 	Creation base, tablespace, utilisateurs et role,sequences, tables et contraintes
--  
-----------------------------------------------------------------------------------------------------------------------
-- ====================================================================================================================

-- ====================================================================================================================
------------------------------------------------ CREATION ROLE , DATABASE ---------------------------------------------
-- ====================================================================================================================


CREATE ROLE escalade_admin WITH PASSWORD 'Escalade_2018' LOGIN SUPERUSER CREATEROLE INHERIT;
CREATE ROLE escalade_user WITH PASSWORD 'Escalade_2018' LOGIN;

CREATE DATABASE escalade WITH OWNER = escalade_admin ENCODING = 'UTF8' CONNECTION LIMIT = -1;

CREATE SCHEMA sch_escalade AUTHORIZATION escalade_admin;

-- ====================================================================================================================
------------------------------------------------ CREATION DES TABLES --------------------------------------------------
-- ====================================================================================================================
SET search_path = sch_escalade,pg_catalog;

CREATE TABLE t_topo (
  id SERIAL PRIMARY KEY,
  nom CHARACTER VARYING(15) NOT NULL,
	region INTEGER,
	nbSites INTEGER,
	nbSecteurs INTEGER,
	nbVoies INTEGER,
	disponible BOOLEAN,
	description CHARACTER VARYING(2000) NOT NULL,
	utilisateur_fk_id INTEGER,
	image_fk_id INTEGER
);

CREATE TABLE t_site (
  id SERIAL PRIMARY KEY,
	nom CHARACTER VARYING(20) NOT NULL,
	region_fk_id INTEGER,
	description CHARACTER VARYING(500),
	lastUpdate TIMESTAMP,
	dateCreation TIMESTAMP,
	image_fk_id INTEGER,
	utilisateur_fk_id INTEGER,
	publication boolean
);

CREATE TABLE t_periodeFav (
   id SERIAL PRIMARY KEY,
   periode CHARACTER VARYING(15) NOT NULL
);

CREATE TABLE t_typeRocher (
   id SERIAL PRIMARY KEY,
   typeRocher CHARACTER VARYING(15) NOT NULL
);

CREATE TABLE t_region (
    id INTEGER UNIQUE,
		region CHARACTER VARYING(30) NOT NULL
);

CREATE TABLE t_departement (
	id SERIAL PRIMARY KEY,
	departement CHARACTER VARYING(30) NOT NULL,
	region_fk_id INTEGER
);

CREATE TABLE t_secteur (
	id SERIAL PRIMARY KEY,
	nom CHARACTER VARYING(15) NOT NULL,
	site_fk_id INTEGER,
	utilisateur_fk_id INTEGER,
	publication boolean
);
   
CREATE TABLE t_voie (
  id SERIAL PRIMARY KEY,
	nom CHARACTER VARYING(15) NOT NULL,
	cotation_fk_id INTEGER,
	nbPoints INTEGER,
	equipee BOOLEAN,
	secteur_fk_id INTEGER,
	interet INTEGER,
	utilisateur_fk_id INTEGER
);

CREATE TABLE t_cotation (
   id SERIAL PRIMARY KEY,
   cotation CHARACTER VARYING(5) NOT NULL,
   niveau INTEGER
);

CREATE TABLE t_longueur (
  id SERIAL PRIMARY KEY,
	relai NUMERIC(2),
	voie_fk_id INTEGER,
	cotation_fk_id INTEGER,
	utilisateur_fk_id INTEGER
);

CREATE TABLE t_utilisateur(
	id SERIAL PRIMARY KEY,
	nom CHARACTER VARYING(15) NOT NULL,
	prenom CHARACTER VARYING(15) NOT NULL,
	dateNaissance DATE,
	email CHARACTER VARYING(30) NOT NULL,
	password CHARACTER VARYING(60) NOT NULL,
	cotation_fk_id INTEGER,
	adresse_fk_id INTEGER,
	profil_fk_id INTEGER

);

CREATE TABLE t_location_topo(
	id SERIAL PRIMARY KEY,
	dateDebut TIMESTAMP,
	dateFin TIMESTAMP,
	topoProprioUtilisateur_fk_id INTEGER,
	topoLoueurUtilisateur_fk_id INTEGER,
	topo_fk_id INTEGER
);
---
CREATE TABLE t_adresse(
	id SERIAL PRIMARY KEY,
	adresse1 CHARACTER VARYING(30) NOT NULL,
	adresse2 CHARACTER VARYING(30),
	codePostal CHARACTER VARYING(10),
	ville CHARACTER VARYING(20),
	pays CHARACTER VARYING(20)
);

CREATE TABLE t_commentaire (
	id  SERIAL PRIMARY KEY,
	dateCommentaire TIMESTAMP,
	commentaire CHARACTER VARYING(200),
	utilisateur_fk_id INTEGER,
	table_fk_id INTEGER,
	target_table CHARACTER VARYING(20)
);

CREATE TABLE t_image(
	id  SERIAL PRIMARY KEY,
	chemin CHARACTER VARYING(100)
);

CREATE TABLE t_profil(
	id  SERIAL PRIMARY KEY,
	profil CHARACTER VARYING(15)
);





-- ====================================================================================================================
--------------------------------------------------------- CONTRAINTES -------------------------------------------------
-- ====================================================================================================================

ALTER TABLE t_topo ADD CONSTRAINT t_topo_utilisateur_fk FOREIGN KEY (utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_topo ADD CONSTRAINT t_topo_image_fk FOREIGN KEY (image_fk_id) REFERENCES t_image ON DELETE SET NULL;
ALTER TABLE t_site ADD CONSTRAINT t_site_region_fk FOREIGN KEY (region_fk_id) REFERENCES t_region(id) ON DELETE SET NULL;
ALTER TABLE t_site ADD CONSTRAINT t_site_image_fk FOREIGN KEY (image_fk_id) REFERENCES t_image ON DELETE SET NULL;
ALTER TABLE t_site ADD CONSTRAINT t_site_utilisateur_fk FOREIGN KEY (utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_secteur ADD CONSTRAINT t_secteur_site_fk FOREIGN KEY (site_fk_id) REFERENCES t_site ON DELETE SET NULL;
ALTER TABLE t_secteur ADD CONSTRAINT t_secteur_utilisateur_fk FOREIGN KEY (utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_voie ADD CONSTRAINT t_voie_cotation_fk FOREIGN KEY (cotation_fk_id) REFERENCES t_cotation ON DELETE SET NULL;	
ALTER TABLE t_voie ADD CONSTRAINT t_voie_secteur_fk FOREIGN KEY (secteur_fk_id) REFERENCES t_secteur ON DELETE SET NULL;
ALTER TABLE t_voie ADD CONSTRAINT t_voie_utilisateur_fk FOREIGN KEY (utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_longueur ADD CONSTRAINT t_longueur_voie_fk FOREIGN KEY (voie_fk_id) REFERENCES t_voie ON DELETE SET NULL;	
ALTER TABLE t_longueur ADD CONSTRAINT t_longueur_cotation_fk FOREIGN KEY (cotation_fk_id) REFERENCES t_cotation ON DELETE SET NULL;
ALTER TABLE t_longueur ADD CONSTRAINT t_longueur_utilisateur_fk FOREIGN KEY (utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;
ALTER TABLE t_utilisateur ADD CONSTRAINT t_utilisateur_cotation_fk FOREIGN KEY (cotation_fk_id) REFERENCES t_cotation ON DELETE SET NULL;
ALTER TABLE t_utilisateur ADD CONSTRAINT t_utilisateur_profil_fk FOREIGN KEY (profil_fk_id) REFERENCES t_profil ON DELETE SET NULL;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_utilisateur_fk FOREIGN KEY (topoProprioUtilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;	
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_utilisateur_fk2 FOREIGN KEY (topoLoueurUtilisateur_fk_id) REFERENCES t_utilisateur ON DELETE RESTRICT;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_topo_fk FOREIGN KEY (topo_fk_id) REFERENCES t_topo ON DELETE RESTRICT;
ALTER TABLE t_departement ADD CONSTRAINT t_departement_region_fk FOREIGN KEY (region_fk_id) REFERENCES t_region(id) ON DELETE SET NULL;
ALTER TABLE t_utilisateur ADD CONSTRAINT t_utilisateur_adresse_fk FOREIGN KEY (adresse_fk_id) REFERENCES t_adresse ON DELETE SET NULL;
ALTER TABLE t_commentaire ADD CONSTRAINT t_commentaire_utilisateur_fk FOREIGN KEY (utilisateur_fk_id) REFERENCES t_utilisateur ON DELETE SET NULL;





-- ====================================================================================================================
---------------------------------------------------- DROITS SUR TABLES ------------------------------------------------
-- ====================================================================================================================

ALTER TABLE t_topo OWNER TO escalade_admin;
ALTER TABLE t_site OWNER TO escalade_admin;
ALTER TABLE t_periodeFav OWNER TO escalade_admin;
ALTER TABLE t_typeRocher OWNER TO escalade_admin;
ALTER TABLE t_region OWNER TO escalade_admin;
ALTER TABLE t_departement OWNER TO escalade_admin;
ALTER TABLE t_secteur OWNER TO escalade_admin;
ALTER TABLE t_voie OWNER TO escalade_admin;
ALTER TABLE t_cotation OWNER TO escalade_admin;
ALTER TABLE t_longueur OWNER TO escalade_admin;
ALTER TABLE t_utilisateur OWNER TO escalade_admin;
ALTER TABLE t_location_topo OWNER TO escalade_admin;


GRANT ALL ON SCHEMA sch_escalade TO escalade_admin;
GRANT USAGE ON SCHEMA sch_escalade TO escalade_user;

GRANT SELECT ON ALL TABLES IN SCHEMA sch_escalade TO escalade_user;
GRANT UPDATE ON ALL TABLES IN SCHEMA sch_escalade TO escalade_user;
GRANT INSERT ON ALL TABLES IN SCHEMA sch_escalade TO escalade_user;
GRANT DELETE ON ALL TABLES IN SCHEMA sch_escalade TO escalade_user;

GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA sch_escalade TO escalade_user;

