Command for creating a postgres docker container:

docker run --name some-postgres -e POSTGRES_PASSWORD=jpademo -e POSTGRES_USER=jpademo -p 5432:5432 -d postgres

Create table person:

CREATE TABLE person(
  id int,
  name varchar,
  PRIMARY KEY(id)
);

Inserting rows into table person:

insert into person values (1, 'Paul');
insert into person values (2, 'John');
insert into person values (3, 'George');
insert into person values (4, 'Ringo');

Create table person with auto increment of id:

CREATE SEQUENCE person_id_seq;
CREATE TABLE person(
  id int NOT NULL DEFAULT nextval('person_id_seq'),
  name varchar,
  PRIMARY KEY(id)
);