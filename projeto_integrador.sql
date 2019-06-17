create database loja_virtual;

use loja_virtual;

create table planos(
id_plano int primary key auto_increment unique not null,
nome varchar(30),
valor decimal(2),
periodo int
);



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
id int primary key auto_increment unique not null,
valor decimal(2),
id_cliente int,
id_fornecedor int,
id_empresa int,
descricao text
);

create table produto(
id int primary key auto_increment unique not null,
tipo varchar(30),
descricao text,
tamanho enum('pp','p','m','g','gg','eg','34','36','38', '40','42','44','46','48','50','52'),
quantidade tinyint,
imagem varchar(100),
valor decimal(2),
id_cliente int,
id_fornecedor int,
id_empresa int
);

create table empresa(
id int primary key auto_increment unique not null,
razao_social varchar(50),
nome_fantasia varchar(50) not null unique,
email varchar(30) unique,
telefone varchar(15),
cnpj varchar(14) unique,
cep varchar(8),
assinatura int,
pontuacao decimal(2)
);

alter table empresa
ADD CONSTRAINT empresa_plano  foreign key (assinatura) references planos(id_plano);


describe fornecedor;
-- ALTER TABLE objeto ADD CONSTRAINT fk_pessoa FOREIGN KEY(id) REFERENCES pessoa (id);
