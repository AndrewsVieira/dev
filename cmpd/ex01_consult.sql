SELECT * FROM empregado WHERE salario < 2000;

SELECT * FROM empregado WHERE salario > 2000 AND idade < 45;

SELECT nome, idade FROM empregado;

SELECT nome, salario FROM empregado WHERE idade > 40;

SELECT * FROM empregado WHERE idade < 30;

SELECT cod_emp FROM projeto_empregado WHERE cod_proj = 4;

SELECT nome, salario FROM empregado WHERE cod_dep = 7;

SELECT cod_proj, cod_emp FROM projeto_empregado
	WHERE data_ini <= '2009-01-01'
	OR data_fim >= '2009-12-31';
*****POSSO TER DUVIDA*******


