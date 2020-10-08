SELECT * FROM empregado WHERE salario < 2000;

SELECT * FROM empregado WHERE salario > 2000 AND idade < 45;

SELECT nome, idade FROM empregado;

SELECT nome, salario FROM empregado WHERE idade > 40;

SELECT * FROM empregado WHERE idade < 30;

SELECT cod_emp FROM projeto_empregado WHERE cod_proj = 4;

SELECT nome, salario FROM empregado WHERE cod_dep = 7;

SELECT cod_proj, cod_emp FROM projeto_empregado
	WHERE 	(pe.data_fim > '2008-12-31' AND pe.data_ini < '2010-01-01')
				OR (pe.data_fim < '2010-01-01' OR pe.data_ini > '2008-12-31') 
*****POSSO TER DUVIDA*******

SELECT e.nome, p.descricao  FROM projeto_empregado as pe 
	INNER JOIN projeto as p ON p.cod_proj = pe.cod_proj 
	INNER JOIN empregado as e ON e.cod_emp = pe.cod_emp 
		WHERE 	(pe.data_fim > '2008-12-31' AND pe.data_ini < '2010-01-01')
				OR (pe.data_fim < '2010-01-01' OR pe.data_ini > '2008-12-31') 




