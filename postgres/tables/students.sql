BEGIN TRANSACTION;
create table students (
  id serial primary key,
  name varchar(100),
  email text unique not null,
  dob timestamp not null,
  age bigint default 0
);

COMMIT;