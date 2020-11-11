-- Uma function que retorne qual o salário do pesquisador com base nos projetos 	que trabalha e nas horas trabalhada por semana.

CREATE OR REPLACE FUNCTION set_salario(index integer)
RETURNS numeric AS $$
DECLARE
	novo_salario numeric;
	horas_trabalhadas integer;
	salario_hora integer;
	sql varchar;
BEGIN
	sql := 'SELECT projeto_pesquisador.horas_trabalhadas 
			FROM projeto_pesquisador INNER JOIN pesquisador
			ON projeto_pesquisador.id_pesquisador = pesquisador.id
			WHERE pesquisador.id_funcionario = ' || index;
	EXECUTE sql INTO horas_trabalhadas;	
	sql := 'SELECT salario_hora FROM pesquisador 
			WHERE id_funcionario = ' || index;
	EXECUTE sql INTO salario_hora;
	novo_salario := horas_trabalhadas * salario_hora;
	UPDATE funcionario SET salario = novo_salario WHERE id = index;
	RETURN novo_salario;	
END;
$$ LANGUAGE 'plpgsql';

SELECT * FROM set_salario(1);
SELECT * FROM funcionario;
