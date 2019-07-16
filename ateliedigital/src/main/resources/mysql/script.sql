create database ateliedigital;
use ateliedigital;
create table cliente(
    id integer auto_increment not null primary key ,
    nome varchar(50)not null,
    email varchar(30) not null unique,
    cep integer not null,
    numero integer not null,
    senha varchar(255) not null
);
drop table cliente;
drop table fornecedor;
create table fornecedor(
    id integer auto_increment not null primary key ,
    nome varchar(50)not null,
    email varchar(30) not null unique,
    cpf integer not null unique ,
    cep integer not null,
    numero integer not null,
    senha varchar(255) not null,
    id_plano integer not null
);
alter table fornecedor
add constraint fk_fornecedor_plano foreign key (id_plano)
references  planos(id);

create table planos(
    id integer auto_increment not null primary key ,
    nome  varchar(30)not null,
    duracao DATE not null,
    valor decimal(5,2) not null
);

SELECT * FROM cliente;

