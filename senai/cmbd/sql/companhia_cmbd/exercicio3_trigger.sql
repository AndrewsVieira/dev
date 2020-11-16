CREATE TABLE dependente (
	id serial not null primary key,
	id_funcionario int references funcionario(id),
	nome varchar(50),
	nasc date,
	grau_parentesco varchar(50)
);



-- Uma trigger que deverá executar uma função quando um cadastro de dependente for executado. 
-- Quando isso ocorrer e a idade do dependente for menor de 18 anos o salário deverá ser aumentado em 10%. 
-- Caso seja um funcionário da limpeza deverá antes ser realizada uma verificação se o seu supervisor ganhará 
-- menos após a atualização. Nesse caso o salário do supervisor também deverá ser aumentado em 5%.

create or replace function trg_function_verificar_dependete_menores()
returns trigger as $$
declare
	idade int;
	id_supervisor_responsavel int;
	id_funcionario_responsavel int;
	salario_responsavel float;
	salario_supervisor float;
begin
	
	idade := extract('year' from now()) - extract('year' from new.nasc);
	raise notice 'idade: %', idade;
	
	if idade < 18 then
		
		select salario into salario_responsavel from funcionario where id = new.id_funcionario;
		salario_responsavel := salario_responsavel * 1.10;
		update funcionario set salario = salario_responsavel where id = new.id_funcionario;
	
		select id_supervisor into id_supervisor_responsavel from limpeza where id_funcionario = new.id_funcionario;
		raise notice '%', id_supervisor_responsavel;
		
		if id_supervisor_responsavel != 0 then
			raise notice 'entrou no if';
			select id_funcionario into id_funcionario_responsavel from limpeza where id = id_supervisor_responsavel;
			select salario into salario_supervisor from funcionario where id = id_funcionario_responsavel;
		
			if salario_responsavel > salario_supervisor then
				salario_supervisor := salario_supervisor * 1.05;
				update funcionario set salario = salario_supervisor where id = id_funcionario_responsavel;
			end if;
		end if;
	
	end if;

	return new;
	
end;
$$ language plpgsql;

create trigger trg_verificar_dependete_menores
before insert or update on dependente
for each row 
execute procedure trg_function_verificar_dependete_menores();

select * from limpeza ;

insert into dependente (id_funcionario, nome, nasc, grau_parentesco) values (20, 'Jair Jr', '2012-09-04', 'Filho');


