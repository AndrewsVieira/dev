INSERT INTO departamento(descricao) VALUES ('Pesquisa');
INSERT INTO departamento(descricao) VALUES ('Desenvolvimento');

INSERT INTO empregado(nome, salario, idade, cod_dep) VALUES ('Pedro', 3000, 45, 7);
INSERT INTO empregado(nome, salario, idade, cod_dep) VALUES ('Paulo', 2200, 43, 7);
INSERT INTO empregado(nome, salario, idade, cod_dep) VALUES ('Maria', 2500, 38, 7);
INSERT INTO empregado(nome, salario, idade, cod_dep) VALUES ('Ana', 1800, 25, 8);

INSERT INTO projeto(descricao, cod_dep) VALUES ('AATOM', 7);
INSERT INTO projeto(descricao, cod_dep) VALUES ('DW espaço-temporal', 8);

INSERT INTO projeto_empregado(cod_proj, cod_emp, data_ini, data_fim) VALUES (4, 9, '2007-01-01', '2020-10-05');
INSERT INTO projeto_empregado(cod_proj, cod_emp, data_ini, data_fim) VALUES (4, 10, '2007-01-01', '2020-10-05');
INSERT INTO projeto_empregado(cod_proj, cod_emp, data_ini, data_fim) VALUES (4, 11, '2006-02-01', '2010-02-18');
INSERT INTO projeto_empregado(cod_proj, cod_emp, data_ini, data_fim) VALUES (5, 12, '2008-02-15', '2010-02-15');
