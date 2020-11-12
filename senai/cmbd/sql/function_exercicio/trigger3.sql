-- Uma trigger que deverá executar uma função quando um cadastro de dependente for executado. 
-- Quando isso ocorrer e a idade do dependente for menor de 18 anos o salário deverá ser aumentado em 10%. 
-- Caso seja um funcionário da limpeza deverá antes ser realizada uma verificação se o seu supervisor 
-- ganhará menos após a atualização. Nesse caso o salário do supervisor também deverá ser aumentado em 5%.

CREATE OR REPLACE FUNCTION trg_aumentar_salario_de_quem_tem_dependente_menor_de_idade()
RETURNS TRIGGER AS $$
DECLARE
	idade_dependente INTEGER;
	ano_nasc DOUBLE;
	ano_atual DOUBLE;
	
	salario NUMERIC;
	sql VARCHAR;
BEGIN
	sql := 'SELECT EXTRACT(YEAR FROM nasc) FROM dependente';
	sql INTO ano_nasc;
	sql := 'SELECT EXTRACT(YEAR FROM NOW())';
	sql INTO ano_atual;
	
	idade_dependente = ano_atual - ano_nasc;
	
	sql := 'SELECT funcionario.salario FROM funcionario 
	INNER JOIN dependente ON funcionario.id = dependente.id_funcionario';
	sql INTO salario;
	
	IF idade_dependente < 18 THEN
		RETURN salario * 1.10;
	END IF;
	RETURN
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER aumentar_salario_de_quem_tem_dependente_menor_de_idade
BEFORE INSERT ON dependente
FOR EACH ROW 
EXECUTE PROCEDURE trg_aumentar_salario_de_quem_tem_dependente_menor_de_idade();

select * from dependente;
select * from funcionario;

insert into dependente	(id_funcionario, nome, nasc, grau_parentesco)
			values		(1, 'LUCAS DA SILVA', '2010-11-14', 'FILHO');

