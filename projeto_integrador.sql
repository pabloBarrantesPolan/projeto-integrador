create database loja_virtual;
create table planos(
id_plano int primary key auto_increment unique not null,
nome varchar(30),
valor decimal(2),
periodo int
);

use loja_virtual;

create table fornecedor(
id int primary key auto_increment unique not null,
nome varchar(50),
email varchar(30) unique,
telefone varchar(15),
cpf varchar(11) unique,
cep varchar(8),
assinatura int,
pontuacao decimal(2)
);
drop table cliente;
create table cliente(
id int primary key auto_increment unique not null,
nome varchar(50),
email varchar(30) unique,
telefone varchar(15),
cpf varchar(11) unique,
cep varchar(8),
pontuacao decimal(2)
);

create table servico(
valor decimal(2),
id_cliente int,
id_fonecedor int,
id_empresa int,
descricao text
);

create table produto(
id int primary key auto_increment unique not null,
tipo varchar(30),
tamanho enum('pp','p','m','g','gg','eg','34','36','38', '40','42','44','46','48','50','52'),
valor decimal(2),
);