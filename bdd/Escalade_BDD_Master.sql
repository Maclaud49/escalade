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

CREATE DATABASE escalade WITH OWNER = escalade_admin ENCODING = 'UTF8' LC_COLLATE = 'C' LC_CTYPE = 'C' CONNECTION LIMIT = -1;

CREATE SCHEMA sch_escalade AUTHORIZATION escalade_admin;

-- ====================================================================================================================
------------------------------------------------ CREATION DES TABLES --------------------------------------------------
-- ====================================================================================================================
SET search_path = sch_escalade,pg_catalog;

CREATE TABLE t_topo (
  id SERIAL PRIMARY KEY,
  nom CHARACTER VARYING(15) NOT NULL,
	region CHARACTER VARYING(20),
	disponible BOOLEAN,
	site_fk_id INTEGER
);

CREATE TABLE t_site (
  id SERIAL PRIMARY KEY,
	nom CHARACTER VARYING(20) NOT NULL,
	secteur_fk_id INTEGER,
	region_fk_id INTEGER,
	description CHARACTER VARYING(500),
	periodeFav_fk_id INTEGER, 
	lastUpdate TIMESTAMP, 
	typeRocher_fk_id INTEGER,
	dateCreation TIMESTAMP
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
    id INTEGER,
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
	voie_fk_id INTEGER,
	site_fk_id INTEGER
);
   
CREATE TABLE t_voie (
    id SERIAL PRIMARY KEY,
	nom CHARACTER VARYING(15) NOT NULL,
	longueur_fk_id INTEGER,
	cotation_fk_id INTEGER,
	nbPoints INTEGER,
	equipee BOOLEAN,
	secteur_fk_id INTEGER,
	interet INTEGER
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
	cotation_fk_id INTEGER
);

CREATE TABLE t_user(
	id SERIAL PRIMARY KEY,
	nom CHARACTER VARYING(15) NOT NULL,
	prenom CHARACTER VARYING(15) NOT NULL,
	dateNaissance DATE,
	profil INTEGER,
	email CHARACTER VARYING(30) NOT NULL,
	password CHARACTER VARYING(60) NOT NULL,
	cotation_fk_id INTEGER,
	topo_fk_id INTEGER
);

CREATE TABLE t_location_topo(
	id SERIAL PRIMARY KEY,
	dateDebut DATE,
	dateFin DATE,
	topoProprioUser_fk_id INTEGER,
	topoLoueurUser_fk_id INTEGER,
	topo_fk_id INTEGER
);


-- ====================================================================================================================
--------------------------------------------------------- CONTRAINTES -------------------------------------------------
-- ====================================================================================================================

ALTER TABLE t_topo ADD CONSTRAINT t_topo_site_fk FOREIGN KEY (site_fk_id) REFERENCES t_site ON DELETE SET NULL;	
ALTER TABLE t_site ADD CONSTRAINT t_site_secteur_fk FOREIGN KEY (secteur_fk_id) REFERENCES t_secteur ON DELETE SET NULL;	
ALTER TABLE t_site ADD CONSTRAINT t_site_region_fk FOREIGN KEY (region_fk_id) REFERENCES t_region ON DELETE SET NULL;	
ALTER TABLE t_site ADD CONSTRAINT t_site_periodeFav_fk FOREIGN KEY (periodeFav_fk_id) REFERENCES t_periodeFav ON DELETE SET NULL;	
ALTER TABLE t_site ADD CONSTRAINT t_site_typeRocher_fk FOREIGN KEY (typeRocher_fk_id) REFERENCES t_typeRocher ON DELETE SET NULL;	
ALTER TABLE t_secteur ADD CONSTRAINT t_secteur_voie_fk FOREIGN KEY (voie_fk_id) REFERENCES t_voie ON DELETE SET NULL;	
ALTER TABLE t_secteur ADD CONSTRAINT t_secteur_site_fk FOREIGN KEY (site_fk_id) REFERENCES t_site ON DELETE SET NULL;
ALTER TABLE t_voie ADD CONSTRAINT t_voie_longueur_fk FOREIGN KEY (longueur_fk_id) REFERENCES t_longueur ON DELETE CASCADE;	
ALTER TABLE t_voie ADD CONSTRAINT t_voie_cotation_fk FOREIGN KEY (cotation_fk_id) REFERENCES t_cotation ON DELETE SET NULL;	
ALTER TABLE t_voie ADD CONSTRAINT t_voie_secteur_fk FOREIGN KEY (secteur_fk_id) REFERENCES t_secteur ON DELETE SET NULL;	
ALTER TABLE t_longueur ADD CONSTRAINT t_longueur_voie_fk FOREIGN KEY (voie_fk_id) REFERENCES t_voie ON DELETE SET NULL;	
ALTER TABLE t_longueur ADD CONSTRAINT t_longueur_cotation_fk FOREIGN KEY (cotation_fk_id) REFERENCES t_cotation ON DELETE SET NULL;
ALTER TABLE t_user ADD CONSTRAINT t_user_cotation_fk FOREIGN KEY (cotation_fk_id) REFERENCES t_cotation ON DELETE SET NULL;	
ALTER TABLE t_user ADD CONSTRAINT t_user_topo_fk FOREIGN KEY (topo_fk_id) REFERENCES t_topo ON DELETE RESTRICT;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_user_fk FOREIGN KEY (topoProprioUSer_fk_id) REFERENCES t_user ON DELETE SET NULL;	
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_user_fk2 FOREIGN KEY (topoLoueurUser_fk_id) REFERENCES t_user ON DELETE RESTRICT;
ALTER TABLE t_location_topo ADD CONSTRAINT t_location_topo_fk FOREIGN KEY (topo_fk_id) REFERENCES t_topo ON DELETE RESTRICT;
ALTER TABLE t_departement ADD CONSTRAINT t_departement_region_fk FOREIGN KEY (region_fk_id) REFERENCES t_region ON DELETE SET NULL;

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
ALTER TABLE t_user OWNER TO escalade_admin;
ALTER TABLE t_location_topo OWNER TO escalade_admin;

GRANT ALL ON SCHEMA sch_escalade TO escalade_admin;
GRANT USAGE ON SCHEMA sch_escalade TO escalade_user;

GRANT SELECT ON ALL TABLES IN SCHEMA sch_escalade TO escalade_user;
GRANT UPDATE ON ALL TABLES IN SCHEMA sch_escalade TO escalade_user;
GRANT INSERT ON ALL TABLES IN SCHEMA sch_escalade TO escalade_user;
GRANT DELETE ON ALL TABLES IN SCHEMA sch_escalade TO escalade_user;

GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA sch_escalade TO escalade_user;

