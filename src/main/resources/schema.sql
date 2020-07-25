drop table if exists person
create table person (id bigint not null auto_increment, address varchar(255), age integer, name varchar(4), primary key (id)) engine=InnoDB