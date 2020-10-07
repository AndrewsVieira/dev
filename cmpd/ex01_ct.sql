CREATE TABLE departamento (
	cod_dep SERIAL NOT NULL PRIMARY KEY,
	descricao TEXT
);

CREATE TABLE empregado (
	cod_emp SERIAL NOT NULL PRIMARY KEY,
	cod_dep INTEGER NOT NULL REFERENCES departamento(cod_dep),
	nome VARCHAR(20),
	salario NUMERIC,
	idade INTEGER
);

CREATE TABLE projeto (
	cod_proj SERIAL NOT NULL PRIMARY KEY,
	cod_dep INTEGER NOT NULL REFERENCES departamento(cod_dep),
	descricao TEXT
);

CREATE TABLE projeto_empregado (
	cod_proj INTEGER NOT NULL REFERENCES projeto(cod_proj),
	cod_emp INTEGER NOT NULL REFERENCES empregado(cod_emp),
	data_ini DATE,
	data_fim DATE,
	
	CONSTRAINT cod_proj_emp_pk PRIMARY KEY (cod_proj, cod_emp)
);
