CREATE TABLE users
(

  user_id numeric NOT NULL,

  name text NOT NULL,

  surname text NOT NULL,

  phone text,

  status text NOT NULL,

  password text NOT NULL,

  photo text NOT NULL,

  role text,

  CONSTRAINT users_pk PRIMARY KEY (user_id)

)

WITH (
  OIDS=FALSE
);

ALTER TABLE users

  OWNER TO postgres;


  CREATE TABLE user_feedback
(
  u_feedback_id integer NOT NULL,
  text text NOT NULL,
  rate smallint NOT NULL,
  user_id_users numeric,
  CONSTRAINT user_feedback_pk PRIMARY KEY (u_feedback_id),
  CONSTRAINT users_fk FOREIGN KEY (user_id_users)
      REFERENCES users (user_id) MATCH FULL
      ON UPDATE CASCADE ON DELETE SET NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE user_feedback
  OWNER TO postgres;
  
  
CREATE TABLE property_type
(

  type_id integer NOT NULL,

  title text NOT NULL,

  CONSTRAINT property_type_pk PRIMARY KEY (type_id)

)

WITH (
  OIDS=FALSE
);

ALTER TABLE property_type

  OWNER TO postgres;

CREATE TABLE property
(
  property_id numeric NOT NULL,
  title text NOT NULL,
  description text NOT NULL,
  locality text NOT NULL,
  address text NOT NULL,
  user_id_users numeric,
  type_id_property_type integer,
  CONSTRAINT property_pk PRIMARY KEY (property_id),
  CONSTRAINT property_type_fk FOREIGN KEY (type_id_property_type)
      REFERENCES property_type (type_id) MATCH FULL
      ON UPDATE CASCADE ON DELETE SET NULL,
  CONSTRAINT users_fk FOREIGN KEY (user_id_users)
      REFERENCES users (user_id) MATCH FULL
      ON UPDATE CASCADE ON DELETE SET NULL
)
WITH (
  OIDS=FALSE
);
ALTER TABLE property
  OWNER TO postgres;

CREATE TABLE property_availability
(

  availability_id integer NOT NULL,

  booked_since date NOT NULL,

  booked_to date NOT NULL,

  property_id_property numeric,

  CONSTRAINT property_availability_pk PRIMARY KEY (availability_id),

  CONSTRAINT property_fk FOREIGN KEY (property_id_property)

      REFERENCES property (property_id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL,

  CONSTRAINT property_availability_uq
 UNIQUE (property_id_property)

)

WITH (
  OIDS=FALSE
);

ALTER TABLE property_availability

  OWNER TO postgres;


CREATE TABLE property_feedback
(

  p_feedback_id integer NOT NULL,

  text text NOT NULL,

  rate smallint NOT NULL,

  property_id_property numeric,

  user_id_users numeric,

  CONSTRAINT property_feedback_pk PRIMARY KEY (p_feedback_id),
  CONSTRAINT property_fk FOREIGN KEY (property_id_property)

      REFERENCES property (property_id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL,

  CONSTRAINT users_fk FOREIGN KEY (user_id_users)

      REFERENCES users (user_id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL
)

WITH (
  OIDS=FALSE
);

ALTER TABLE property_feedback

  OWNER TO postgres;


CREATE TABLE application
(

  application_id numeric NOT NULL,

  rent_since date NOT NULL,

  rent_until date NOT NULL,

  application_text text NOT NULL,

  is_approved boolean NOT NULL,

  user_id_users numeric,

  property_id_property numeric,

  CONSTRAINT application_pk PRIMARY KEY (application_id),

  CONSTRAINT property_fk FOREIGN KEY (property_id_property)

      REFERENCES property (property_id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL,

  CONSTRAINT users_fk FOREIGN KEY (user_id_users)

      REFERENCES users (user_id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL,

  CONSTRAINT application_uq UNIQUE (property_id_property)

)

WITH (
  OIDS=FALSE
);

ALTER TABLE application

  OWNER TO postgres;


  CREATE TABLE link
(
  
type_id integer NOT NULL,
  
links text NOT NULL,
  
CONSTRAINT new_table_pk 
PRIMARY KEY (type_id, links)

)

WITH (
  OIDS=FALSE
);

ALTER TABLE link
  
OWNER TO postgres;


CREATE TABLE meeting
(

  meeting_id numeric NOT NULL,

  header text NOT NULL,

  content text NOT NULL,

  location text NOT NULL,

  date date NOT NULL,

  type_id_new_table integer,

  links_new_table text,

  owner_id integer references users(user_id),

  CONSTRAINT meeting_pk PRIMARY KEY (meeting_id),

  CONSTRAINT new_table_fk FOREIGN KEY (type_id_new_table, links_new_table)

      REFERENCES link (type_id, links) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL,

  CONSTRAINT meeting_uq
 UNIQUE (type_id_new_table, links_new_table)

)

WITH (
  OIDS=FALSE
);

ALTER TABLE meeting
  
OWNER TO postgres;


CREATE TABLE confirmed_users
(
  user_id_users numeric NOT NULL,
  meeting_id_meeting numeric NOT NULL,
  CONSTRAINT confirmed_users_pk PRIMARY KEY (user_id_users, meeting_id_meeting),
  CONSTRAINT confirmed_users_fk FOREIGN KEY (meeting_id_meeting)
      REFERENCES meeting (meeting_id) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT users_fk FOREIGN KEY (user_id_users)
      REFERENCES users (user_id) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE confirmed_users
  OWNER TO postgres;


CREATE TABLE wishing_users
(
  user_id_users numeric NOT NULL,
  meeting_id_meeting numeric NOT NULL,
  CONSTRAINT wishing_users_pk PRIMARY KEY (user_id_users, meeting_id_meeting),
  CONSTRAINT wishing_users_fk FOREIGN KEY (meeting_id_meeting)
      REFERENCES meeting (meeting_id) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT users_fk FOREIGN KEY (user_id_users)
      REFERENCES users (user_id) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE wishing_users
  OWNER TO postgres;



CREATE TABLE meeting_feedback
(

  m_feedback_id integer NOT NULL,

  text text NOT NULL,

  rate smallint NOT NULL,

  meeting_id_meeting numeric,

  CONSTRAINT meeting_fk FOREIGN KEY (meeting_id_meeting)

      REFERENCES meeting (meeting_id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL

)

WITH (
  OIDS=FALSE
);

ALTER TABLE meeting_feedback
  
OWNER TO postgres;

CREATE TABLE meeting_held
(

  meeting_held_id integer NOT NULL,

  organized_by_user numeric NOT NULL,

  meeting_id_meeting numeric,

  user_id_users numeric,

  CONSTRAINT meeting_held_pk PRIMARY KEY (meeting_held_id),

  CONSTRAINT meeting_fk FOREIGN KEY (meeting_id_meeting)

      REFERENCES meeting (meeting_id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL,

  CONSTRAINT users_fk FOREIGN KEY (user_id_users)

      REFERENCES users (user_id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL,

  CONSTRAINT meeting_held_uq UNIQUE (meeting_id_meeting)

)

WITH (
  OIDS=FALSE
);

ALTER TABLE meeting_held
  
OWNER TO postgres;
