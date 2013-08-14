-- Sequence: dealer_id_seq

--DROP SEQUENCE dealer_id_seq;

CREATE SEQUENCE tictactoe_seq
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE tictactoe_seq
  OWNER TO tictactoe_user;
-- Table: history

--DROP TABLE history;

CREATE TABLE history
(
  id bigint primary key NOT NULL default nextval('tictactoe_seq'),
  first_player "char",
  winner "char",
  steps text,
  time_stamp bigint
)
WITH (
  OIDS=FALSE
);
ALTER TABLE history
  OWNER TO tictactoe_user;
