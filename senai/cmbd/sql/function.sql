CREATE OR REPLACE FUNCTION getClientes()
RETURNS SETOF cliente AS $$  -- SETOF retorna um conjunto de valores --
BEGIN
	RETURN QUERY SELECT * FROM cliente
	RETURN;
END;

$$ LANGUAGE 'plpgsql';

-- SELECT --
SELECT * FROM getCliente(); -- que nesse caso é igual a -- 
SELECT * FROM cliente;


--------------------------------------------
CREATE OR REPLACE FUNCTION codigo_cliente()
RETURNS SETOF integer AS $$
DECLARE
	registro record;	-- record é um tipo de armazenamento em conjuntos --
				-- quando eu preciso trabalhar com tabelas eu uso o record --
BEGIN
	FOR registro IN SELECT * FROM cliente LOOP
		RETURN NEXT registro.codigo;
	END LOOP;
	RETURN;
END;
$$ LANGUAGE 'plpgsql'
--------------------------------------------
-- criar um tipo de registro --
CREATE TYPE venda_cliente  AS (venda INT, valor NUMERIC, cliente VARCHAR, produto VARCHAR);

CREATE OR REPLACE FUNCTION getVendas()
RETURN SETOF venda_cliente AS $$
DECLARE
	linha _venda venda_cliente%ROWTYPE; -- variável e tipo e o ROWTYPE é pra especificar que essa variável é apenas UMA linha do conjunto de linhas que queremos
	r_vendas record;	
BEGIN
	FOR r_vendas IN SELECT * v.codigo as c_venda,
				v.valor as c_valor,
				c.nome as c_cliente,
				p.nome as c_produto
		FROM venda as v INNER JOIN cliente as c ON c.codigo = cliente 
				INNER JOIN produto as p ON Pp.codigo = v.codigo LOOP
		linha_venda.venda := r_vendas.c_venda;
		linha_venda.valor := r_vendas.c_valor;
		linha_venda.cliente := r_vendas.c_cliente;
		linha_venda.produto := r_vendas.c_produto;
		RETURN NEXT linha_venda;
	END LOOP;
	RETURN;
END;
$$ LANGUAGE 'plpgsql'



SELECT * FROM getVendas();

--------------------------------------------


CREATE OR REPLACE FUNCTION getVenda()
RETURN SETOF venda_cliente AS $$
DECLARE
        linha _venda venda_cliente%ROWTYPE; -- variável e tipo e o ROWTYPE é pra especificar que essa variável é apenas UMA linha do conjunto de linhas que queremos
        r_vendas record;
BEGIN
	SELECT * v.codigo as venda,
                 v.valor as valor,
                 c.nome as cliente,
                 p.nome as produto
        	INTO linha_venda FROM venda as v INNER JOIN cliente as c ON c.codigo = cliente
                				INNER JOIN produto as p ON Pp.codigo = v.codigo
			WHERE v.codigo = $1;
        RETURN NEXT linha_venda;
        
        RETURN;
END;
$$ LANGUAGE 'plpgsql'


--------------------------------------------









