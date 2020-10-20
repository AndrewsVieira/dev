SELECT * FROM vw_projetos_abertos_em_2009;

CREATE OR REPLACE VIEW vw_empregado_salario_menor_2000 AS SELECT * FROM empregado WHERE salario < 2000;

CREATE OR REPLACE VIEW vw_empregado AS SELECT * FROM empregado WHERE salario > 2000 AND idade < 45;

CREATE OR REPLACE VIEW vw_empregado_nome_idade AS SELECT nome, idade FROM empregado;

CREATE OR REPLACE VIEW vw_empregado_nome_salario AS SELECT nome, salario FROM empregado WHERE idade > 40;

CREATE OR REPLACE VIEW vw_empregado_idade_menor_30 AS SELECT * FROM empregado WHERE idade < 30;

CREATE OR REPLACE VIEW vw_empregados_projeto_AATOM 
	AS SELECT e.nome, p.descricao  FROM projeto_empregado as pe
        INNER JOIN projeto as p ON p.cod_proj = pe.cod_proj
        INNER JOIN empregado as e ON e.cod_emp = pe.cod_emp
			WHERE pe.cod_proj = 4;

CREATE OR REPLACE VIEW vw_empregado_departamento_pesquisa 
	AS SELECT nome, salario FROM empregado WHERE cod_dep = 7;

CREATE OR REPLACE VIEW vw_projeto_empregado
AS SELECT cod_proj, cod_emp FROM projeto_empregado as pe
        WHERE   (pe.data_fim > '2008-12-31' 
				 AND pe.data_ini < '2010-01-01')
                 OR (pe.data_fim < '2010-01-01' 
				 OR pe.data_ini > '2008-12-31');

CREATE OR REPLACE VIEW vw_projetos_abertos_em_2009
AS SELECT e.nome, p.descricao  FROM projeto_empregado as pe
        INNER JOIN projeto as p ON p.cod_proj = pe.cod_proj
        INNER JOIN empregado as e ON e.cod_emp = pe.cod_emp
                WHERE   (pe.data_fim > '2008-12-31' 
						 AND pe.data_ini < '2010-01-01')
                         OR (pe.data_fim < '2010-01-01' 
						 OR pe.data_ini > '2008-12-31');
