-- Uma trigger que deverá executar uma função quando um cadastro de funcionário
-- for executado, seja inserção ou alteração. A função dela é garantir que um 
-- funcionário da limpeza não possa ganhar mais que o seu supervisor.

CREATE OR REPLACE FUNCTION trg_verificar_salario_supervisor_limpeza()
RETURNS TRIGGER AS $$
DECLARE
	salario_supervisor NUMERIC;
	salario_funcionario NUMERIC;
	id_supervisor INTEGER;
BEGIN
	salario_funcionario := NEW.salario;
	
	SELECT limpeza.id_limpeza INTO id_supervisor
	FROM funcionario INNER JOIN limpeza ON funcionario.id = limpeza.id;
	
	SELECT funcionario.salario INTO salario_supervisor
	FROM funcionario INNER JOIN limpeza ON funcionario.id = limpeza.id
	WHERE id_supervisor = limpeza.id_limpeza;
	
	IF salario_funcionario >= salario_supervisor THEN
		RAISE EXCEPTION 'Salário maior do que seu supervisor - insira um salário menor.';
		RETURN OLD;
	ELSE
		RETURN NEW;
	END IF;
END;
$$ LANGUAGE 'plpgsql';

CREATE TRIGGER verificar_salario_supervisor_limpeza
BEFORE INSERT OR UPDATE ON funcionario
FOR EACH ROW
EXECUTE PROCEDURE trg_verificar_salario_supervisor_limpeza();


SELECT * FROM limpeza;

select * from funcionario;

insert into funcionario(id_departamento, nome, nasc, salario)
values 					(1, 'JOSÉ DE ARIMATEIA', '23/08/1985', 5000.00); -- id 3

insert into limpeza(id_funcionario, supervisor)
values				(3, true); -- id 1

insert into funcionario(id_departamento, nome, nasc, salario)
values 					(1, 'SIDNEY MAGALHÃES', '23/08/1996', 6000.00); -- ID 4

update funcionario set salario = 1500.00 where id = 4;

insert into limpeza(id_funcionario, id_limpeza, supervisor, jornada_de_trabalho)
values				(4, 1, false, 44);

ALTER TABLE limpeza ALTER COLUMN supervisor TYPE boolean
USING CAST (supervisor AS boolean);



