DROP TABLE IF EXISTS cis CASCADE;
DROP TABLE IF EXISTS Cis_cip CASCADE;
DROP TABLE IF EXISTS Cis_compo CASCADE;

CREATE TABLE cis (
  cis_id serial PRIMARY KEY,
  name varchar[100],
  pharma_form varchar[100],
  admin_routes varchar[100],
  admin_status varchar[100],
  procedure varchar[100],
  comm_status varchar[100],
  auth_date date,
  status varchar[100],
  eu_id varchar[100],
  bool boolean
);

CREATE TABLE cis_cip (
  cis_id serial PRIMARY KEY,
  cip7_id varchar[100],
  pres_label varchar[100],
  admin_status varchar[100],
  comm_status varchar[100],
  comm_date varchar[100],
  cip13_id date,
  collec_agree varchar[100],
  reimbursement varchar[100],
  price varchar[100],
  official_text varchar[100]
);

CREATE TABLE cis_compo (
  cis_id int PRIMARY KEY,
  label varchar[100],
  sub_id varchar[100],
  sub_name varchar[100],
  dosage varchar[100],
  comp_nature varchar[100],
  saft varchar[100]
);
