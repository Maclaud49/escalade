BEGIN TRANSACTION;

SET search_path = sch_escalade;

--- ===== Purge des tables
DELETE FROM t_topo;
DELETE FROM t_site;
DELETE FROM t_periodeFav;
DELETE FROM t_typeRocher;
DELETE FROM t_region;
DELETE FROM t_secteur;
DELETE FROM t_voie;
DELETE FROM t_cotation;
DELETE FROM t_longueur;
DELETE FROM t_user;
DELETE FROM t_location_topo;


COMMIT;