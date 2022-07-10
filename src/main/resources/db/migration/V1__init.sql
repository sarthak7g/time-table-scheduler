DROP TABLE IF EXISTS `user`;

create table `user`(
id bigint primary key,
first_name varchar(100),
last_name varchar(100),
email varchar(100) not null,
contact_number varchar(15),
age int,
is_active boolean not null,
record_version_number integer not null,
created_by varchar(100),
last_updated_by varchar(100),
created_timestamp varchar(100),
last_updated_timestamp varchar(100)
);