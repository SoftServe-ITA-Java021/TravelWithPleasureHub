create table if not exists users
(
	id serial not null
		constraint "User_pkey"
			primary key,
	username varchar(40) not null,
	password varchar(40) not null,
	first_name varchar(40),
	second_name varchar(40),
	email varchar(255) not null,
	location varchar(255),
	additional_info text,
	phone_number varchar(20),
	path_to_photo text,
	status text NOT NULL,
	role text
);

alter table users owner to postgres;

create table if not exists property_type
(
	id serial not null
		constraint "Property_type_pkey"
			primary key,
	title varchar(255) not null
);

alter table property_type owner to postgres;

create table if not exists user_review
(
	id serial not null
		constraint "User_review_pkey"
			primary key,
	made_by_user_id integer not null,
	review_text text not null,
	rate integer not null,
	user_id integer not null
		constraint user_id
			references users
);

alter table user_review owner to postgres;

create table if not exists property
(
	id serial not null
		constraint property_pkey
			primary key,
	title varchar(255) not null,
	description text not null,
	locality varchar(255) not null,
	address varchar(255) not null,
	user_id integer not null
		constraint user_id
			references users,
	property_type_id integer not null
		constraint property_type_id
			references property_type,
	price integer not null,
	path_to_photo text
);

alter table property owner to postgres;

create index if not exists fki_user_id
	on property (user_id);

create table if not exists property_review
(
	id serial not null
		constraint "Property_review_pkey"
			primary key,
	review_text text not null,
	rate integer not null,
	user_id integer not null
		constraint user_id
			references users,
	property_id integer not null
		constraint property_id
			references property
);

alter table property_review owner to postgres;

create table if not exists application
(
	id serial not null
		constraint "Application_pkey"
			primary key,
	rent_since date not null,
	rent_until date not null,
	application_text text,
	is_approved boolean,
	property_id integer not null
		constraint property_id
			references property,
	user_id integer not null
		constraint user_id
			references users
);

alter table application owner to postgres;

create index if not exists fki_property_id
	on application (property_id);

create table if not exists property_availability
(
	id serial not null
		constraint "Availability_of_property_pkey"
			primary key,
	booked_since date not null,
	booked_until date not null,
	property_id integer not null
		constraint property_id
			references property
);

alter table property_availability owner to postgres;


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


CREATE TABLE many_users_has_many_meeting
(
  user_id_users integer NOT NULL,
  meeting_id_meeting integer NOT NULL,
  CONSTRAINT many_users_has_many_meeting_pk PRIMARY KEY (user_id_users, meeting_id_meeting),
  CONSTRAINT meeting_fk FOREIGN KEY (meeting_id_meeting)
      REFERENCES meeting (meeting_id) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT,
  CONSTRAINT users_fk FOREIGN KEY (user_id_users)
      REFERENCES users (id) MATCH FULL
      ON UPDATE CASCADE ON DELETE RESTRICT
)
WITH (
  OIDS=FALSE
);
ALTER TABLE many_users_has_many_meeting
  OWNER TO postgres;


CREATE TABLE meeting_feedback
(

  m_feedback_id serial NOT NULL,

  text text NOT NULL,

  rate smallint NOT NULL,

  meeting_id_meeting integer,

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

  meeting_held_id serial NOT NULL,

  organized_by_user integer NOT NULL,

  meeting_id_meeting integer,

  user_id_users integer,

  CONSTRAINT meeting_held_pk PRIMARY KEY (meeting_held_id),

  CONSTRAINT meeting_fk FOREIGN KEY (meeting_id_meeting)

      REFERENCES meeting (meeting_id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL,

  CONSTRAINT users_fk FOREIGN KEY (user_id_users)

      REFERENCES users (id) MATCH FULL

      ON UPDATE CASCADE ON DELETE SET NULL,

  CONSTRAINT meeting_held_uq UNIQUE (meeting_id_meeting)

)

WITH (
  OIDS=FALSE
);

ALTER TABLE meeting_held
  
OWNER TO postgres;
