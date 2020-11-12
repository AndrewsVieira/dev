-- exercício 1

-- preparação para o exercício 1

insert into departamento (nome) values ('engenharia de software');
select * from departamento;
insert into funcionario (id_departamento, nome, nasc, salario) values (2, 'João Silva', '28/09/1995', 1000.00);
select * from funcionario;
insert into pesquisador (id_funcionario, salario_hora) values (1, 50.00);
select * from pesquisador;
insert into projeto (id_departamento, nome) values (2, 'Sistemas de Depuração'); 
select * from projeto;
insert into projeto (id_departamento, nome) values (2, 'Processamento de Dados'); 
select * from projeto;
insert into projeto (id_departamento, nome) values (2, 'Software de Sistema Jurídico'); 
select * from projeto;
insert into projeto_pesquisador (id_pesquisador, id_projeto, horas_trabalhadas) values (1, 1, 50);
select * from projeto_pesquisador;
insert into projeto_pesquisador (id_pesquisador, id_projeto, horas_trabalhadas) values (1, 2, 30);
select * from projeto_pesquisador;
insert into projeto_pesquisador (id_pesquisador, id_projeto, horas_trabalhadas) values (1, 3, 60);
select * from projeto_pesquisador;



--- Criar uma function que retorne qual o salário do pesquisador com base nos projetos que trabalha e nas horas trabalhada por semana.

-- view para facilitar a criação da função
create or replace view relacao_funcionario_projeto as
	select 	f.id,
			f.nome, 
			p.salario_hora, 
			pp.horas_trabalhadas, 
			p2.nome as projeto 
			
		from 	funcionario as f 
				inner join pesquisador as p on f.id = p.id_funcionario 
				inner join projeto_pesquisador as pp on p.id = pp.id_pesquisador 
				inner join projeto as p2 on pp.id_projeto = p2.id;

select * from relacao_funcionario_projeto;

-- função

create or replace function calcular_salario_pesquisador(int)
returns float as $$
declare
	r record;
	salario float;
	horas_trabalhadas int;
	salario_hora float;
	salario_acumulado float;
begin
	salario_acumulado := 0;
	for r in select * from relacao_funcionario_projeto as rfp where rfp.id = $1 loop
		salario_hora := r.salario_hora;
		horas_trabalhadas := r.horas_trabalhadas;
		salario = salario_hora * horas_trabalhadas;
		raise notice '% ganhou % por trabalhar % hora(s) no projeto %.', r.nome, salario, r.horas_trabalhadas, r.projeto;
		salario_acumulado := salario_acumulado + salario;
	end loop;

	raise notice 'Salário acumulado de %: %', r.nome, salario_acumulado;
	update funcionario set salario = salario_acumulado where id = $1;
	
	return salario_acumulado;
	
end;
$$ language plpgsql;

 -- chamar a funcão e verificar se alterou o salário na tabela funcionario
 
select calcular_salario_pesquisador(1);
select * from funcionario;

select 	nome, calcular_salario_pesquisador(1) as salario from funcionario where id = 1;




