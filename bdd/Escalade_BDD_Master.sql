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


-- ====================================================================================================================
------------------------------------------------ CREATION DES TABLES --------------------------------------------------
-- ====================================================================================================================


CREATE TABLE t_topo (
  topo_id SERIAL PRIMARY KEY,
  topo_nom CHARACTER VARYING(15) NOT NULL,
	topo_region CHARACTER VARYING(30),
	topo_nbSites INTEGER,
	topo_nbSecteurs INTEGER,
	topo_nbVoies INTEGER,
	topo_disponible BOOLEAN,
	topo_description CHARACTER VARYING(2000) NOT NULL,
	topo_utilisateur_fk_id INTEGER,
	topo_image CHARACTER VARYING(100)
);

CREATE TABLE t_site (
  site_id SERIAL PRIMARY KEY,
	site_nom CHARACTER VARYING(20) NOT NULL,
	site_region CHARACTER VARYING(30),
	site_description CHARACTER VARYING(500),
	site_lastUpdate TIMESTAMP,
	site_dateCreation TIMESTAMP,
	site_image CHARACTER VARYING(100),
	site_utilisateur_fk_id INTEGER,
	site_publication boolean
);

CREATE TABLE t_departement (
	departement_id SERIAL PRIMARY KEY,
	departement_departement CHARACTER VARYING(30) NOT NULL,
	departement_region CHARACTER VARYING(30)
);

CREATE TABLE t_secteur (
	secteur_id SERIAL PRIMARY KEY,
	secteur_nom CHARACTER VARYING(15) NOT NULL,
	secteur_site_fk_id INTEGER,
	secteur_utilisateur_fk_id INTEGER,
	secteur_publication boolean,
	secteur_lastUpdate TIMESTAMP,
	secteur_dateCreation TIMESTAMP,
	secteur_description CHARACTER VARYING(500)
);
   
CREATE TABLE t_voie (
	voie_id SERIAL PRIMARY KEY,
	voie_nom CHARACTER VARYING(15) NOT NULL,
	voie_cotation CHARACTER VARYING(15),
	voie_nbPoints INTEGER,
	voie_equipee BOOLEAN,
	voie_secteur_fk_id INTEGER,
	voie_interet INTEGER,
	voie_utilisateur_fk_id INTEGER,
	voie_lastUpdate TIMESTAMP,
	voie_dateCreation TIMESTAMP,
	voie_description CHARACTER VARYING(500),
	voie_publication boolean
);

CREATE TABLE t_longueur (
	longueur_id SERIAL PRIMARY KEY,
	longueur_relai NUMERIC(2),
	longueur_voie_fk_id INTEGER,
	longueur_cotation CHARACTER VARYING(15),
	longueur_utilisateur_fk_id INTEGER
);

CREATE TABLE t_utilisateur(
	utilisateur_id SERIAL PRIMARY KEY,
	utilisateur_nom CHARACTER VARYING(15) NOT NULL,
	utilisateur_prenom CHARACTER VARYING(15) NOT NULL,
	utilisateur_dateNaissance DATE,
	utilisateur_email CHARACTER VARYING(30) NOT NULL,
	utilisateur_password CHARACTER VARYING(60) NOT NULL,
	utilisateur_cotation CHARACTER VARYING(15),
	utilisateur_profil CHARACTER VARYING(15) NOT NULL,
	adresse_adresse1 CHARACTER VARYING(30),
	adresse_adresse2 CHARACTER VARYING(30),
	adresse_codePostal CHARACTER VARYING(10),
	adresse_ville CHARACTER VARYING(20),
	adresse_pays CHARACTER VARYING(20)
);

CREATE TABLE t_location_topo(
	loc_id SERIAL PRIMARY KEY,
	loc_dateDebut TIMESTAMP,
	loc_dateFin TIMESTAMP,
	loc_topoProprioUser_fk_id INTEGER,
	loc_topoLoueurUser_fk_id INTEGER,
	loc_topo_fk_id INTEGER
);

CREATE TABLE t_commentaire (
	com_id  SERIAL PRIMARY KEY,
	com_dateCommentaire TIMESTAMP,
	com_commentaire CHARACTER VARYING(200),
	com_utilisateur_fk_id INTEGER,
	com_table_fk_id INTEGER,
	com_target_table CHARACTER VARYING(20)
);








-- ====================================================================================================================
---------------------------------------------------- DROITS SUR TABLES ------------------------------------------------
-- ====================================================================================================================

ALTER TABLE t_topo OWNER TO escalade_admin;
ALTER TABLE t_site OWNER TO escalade_admin;
ALTER TABLE t_secteur OWNER TO escalade_admin;
ALTER TABLE t_voie OWNER TO escalade_admin;
ALTER TABLE t_longueur OWNER TO escalade_admin;
ALTER TABLE t_utilisateur OWNER TO escalade_admin;
ALTER TABLE t_location_topo OWNER TO escalade_admin;
ALTER TABLE t_commentaire OWNER TO escalade_admin;


GRANT ALL ON SCHEMA public TO escalade_admin;
GRANT USAGE ON SCHEMA public TO escalade_user;

GRANT SELECT ON ALL TABLES IN SCHEMA public TO escalade_user;
GRANT UPDATE ON ALL TABLES IN SCHEMA public TO escalade_user;
GRANT INSERT ON ALL TABLES IN SCHEMA public TO escalade_user;
GRANT DELETE ON ALL TABLES IN SCHEMA public TO escalade_user;

GRANT USAGE, SELECT ON ALL SEQUENCES IN SCHEMA public TO escalade_user;

