
-- cadastrar dois supervisores
select * from departamento;
insert into funcionario(id_departamento, nome, nasc, salario) values (2, 'Fábio Martins', '1979-02-12', 3000.00);
select * from funcionario;
insert into limpeza (id_funcionario, supervisor) values (2, true);
select * from limpeza;

select * from departamento;
insert into funcionario(id_departamento, nome, nasc, salario) values (2, 'Paulo Costa', '1979-02-12', 3500.00);
select * from funcionario;
insert into limpeza (id_funcionario, supervisor) values (4, true);
select * from limpeza;

-- cadastrar quatro funcionarios e limpeza
insert into funcionario(id_departamento, nome, nasc, salario) values (2, 'Adriana Fasolo', '1985-05-24', 1500.00);
select * from funcionario;
insert into limpeza (id_funcionario, id_supervisor , supervisor) values (10, 1, false);
select * from limpeza;

insert into funcionario(id_departamento, nome, nasc, salario) values (2, 'Fabiana Severino', '1985-05-24', 1500.00);
select * from funcionario;
insert into limpeza (id_funcionario, id_supervisor , supervisor) values (11, 3, false);
select * from limpeza;

insert into funcionario(id_departamento, nome, nasc, salario) values (2, 'Sandra Rute', '1985-05-24', 1500.00);
select * from funcionario;
insert into limpeza (id_funcionario, id_supervisor , supervisor) values (12, 1, false);
select * from limpeza;

insert into funcionario(id_departamento, nome, nasc, salario) values (2, 'Louise Vieira', '1985-05-24', 1500.00);
select * from funcionario;
insert into limpeza (id_funcionario, id_supervisor , supervisor) values (13, 3, false);
select * from limpeza;

-- Uma trigger que deverá executar uma função quando um cadastro de funcionário for executado, seja inserção ou alteração. 
-- A função dela é garantir que um funcionário da limpeza não possa ganhar mais que o seu supervisor.

-- criar a trigger


create or replace function trg_function_ajustar_salario_limpeza()
returns trigger as $$
declare
	id_funcionario_supervisor	int;

	salario_supervisor			float;
	salario_funcionario			float;

begin
	
	raise notice 'id de limpeza: %', new.id;

	-- colhe o id do supervisor
	select id_funcionario into id_funcionario_supervisor from limpeza where id = new.id_supervisor;
	raise notice 'id do funcionario: %', new.id_funcionario;
	raise notice 'id do supervisor: %', id_funcionario_supervisor;
	
	select salario into salario_supervisor from funcionario where id = id_funcionario_supervisor;
	raise notice 'salario do supervisor: %', salario_supervisor;

	select salario into salario_funcionario from funcionario where id = new.id_funcionario;
	raise notice 'salario do funcionario: %', salario_funcionario;

	if salario_funcionario >= salario_supervisor then
		raise exception 'O salário de um funcionario tem que ser menor que o salário do seu supervisor - salário do supervisor: %', salario_supervisor;
	else 
		return new;
	end if;

end;
$$ language plpgsql;

create trigger trg_ajustar_salario_limpeza
before insert or update on limpeza
for each row 
execute procedure trg_function_ajustar_salario_limpeza();





