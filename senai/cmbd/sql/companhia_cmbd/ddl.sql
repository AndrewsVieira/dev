-- criação de ddl para os exercícios de cmbd

create table departamento (
	id serial not null primary key,
	nome varchar(50)
);
create table funcionario (
	id serial not null primary key,
	id_departamento int references departamento(id),
	nome varchar(50),
	nasc date,
	salario float
);
create table projeto (
	id serial not null primary key,
	id_departamento int references departamento(id),
	nome varchar(50)
);
create table limpeza (
	id serial not null primary key,
	id_funcionario int references funcionario(id),
	id_supervisor int references limpeza(id),
	supervisor boolean
);
create table pesquisador (
	id serial not null primary key,
	id_funcionario int references funcionario(id),
	salario_hora float
);
create table projeto_pesquisador(
	id_pesquisador int references pesquisador(id),
	id_projeto int references projeto(id),
	horas_trabalhadas int
);

