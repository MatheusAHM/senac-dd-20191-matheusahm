create database DBPESSOAS;

use DBPESSOAS;

create table nivel (
	idnivel int primary key not null,
    descricao varchar(120)
);

create table pessoa (
	idpessoa int primary key not null auto_increment,
	nome varchar(120),
    email varchar(120),
    senha varchar(45),
    idnivel int,
    foreign key (idnivel) 
		references nivel(idnivel)
);
