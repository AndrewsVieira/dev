PGDMP                     
    x            companhia_exercicio     12.4 (Ubuntu 12.4-1.pgdg20.04+1)     13.0 (Ubuntu 13.0-1.pgdg20.04+1) I    �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    17620    companhia_exercicio    DATABASE     h   CREATE DATABASE companhia_exercicio WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'pt_BR.UTF-8';
 #   DROP DATABASE companhia_exercicio;
                postgres    false            �            1255    17746    codigo_funcionario()    FUNCTION     �   CREATE FUNCTION public.codigo_funcionario() RETURNS SETOF integer
    LANGUAGE plpgsql
    AS $$
DECLARE
	registro record;
BEGIN
	FOR registro IN SELECT * FROM funcionario AS c LOOP
		RETURN NEXT registro.id;
	END LOOP;
	RETURN;
END;
$$;
 +   DROP FUNCTION public.codigo_funcionario();
       public          postgres    false            �            1255    17733    funcionarios(integer)    FUNCTION     D  CREATE FUNCTION public.funcionarios(integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$
DECLARE
	valor integer;
	sql varchar;
BEGIN
	sql := 'SELECT count(*) FROM departamento INNER JOIN funcionario
			ON departamento.id = funcionario.id 
			WHERE funcionario.id = $1';
	EXECUTE sql INTO valor;
	RETURN valor;
END;
$_$;
 ,   DROP FUNCTION public.funcionarios(integer);
       public          postgres    false            �            1255    17728    incrementar(integer)    FUNCTION     �   CREATE FUNCTION public.incrementar(integer) RETURNS integer
    LANGUAGE plpgsql
    AS $_$
DECLARE
	valor integer;
BEGIN
	valor := $1 + 1;
	RETURN valor;
END;
$_$;
 +   DROP FUNCTION public.incrementar(integer);
       public          postgres    false            �            1255    17745    set_salario(integer)    FUNCTION     �  CREATE FUNCTION public.set_salario(index integer) RETURNS numeric
    LANGUAGE plpgsql
    AS $$
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
$$;
 1   DROP FUNCTION public.set_salario(index integer);
       public          postgres    false            �            1255    17729    somar(integer, integer)    FUNCTION     �   CREATE FUNCTION public.somar(num1 integer, num2 integer) RETURNS integer
    LANGUAGE plpgsql
    AS $$
DECLARE
	valor integer;
BEGIN 
	valor := num1 + num2;
	RETURN valor; 
END; 
$$;
 8   DROP FUNCTION public.somar(num1 integer, num2 integer);
       public          postgres    false            �            1255    17747    trg_teste()    FUNCTION     �   CREATE FUNCTION public.trg_teste() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
	RAISE NOTICE 'OPERAÇÃO: %', TG_OP;
	RAISE NOTICE 'NOVO: %', NEW.salario;
	RAISE NOTICE 'ANTIGO: %', OLD.salario;
	RETURN NEW;
END;
$$;
 "   DROP FUNCTION public.trg_teste();
       public          postgres    false            �            1255    17760 *   trg_verificar_salario_supervisor_limpeza()    FUNCTION     �  CREATE FUNCTION public.trg_verificar_salario_supervisor_limpeza() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
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
$$;
 A   DROP FUNCTION public.trg_verificar_salario_supervisor_limpeza();
       public          postgres    false            �            1259    17623    departamento    TABLE     ^   CREATE TABLE public.departamento (
    id integer NOT NULL,
    nome character varying(50)
);
     DROP TABLE public.departamento;
       public         heap    postgres    false            �            1259    17621    departamento_id_seq    SEQUENCE     �   CREATE SEQUENCE public.departamento_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 *   DROP SEQUENCE public.departamento_id_seq;
       public          postgres    false    203            �           0    0    departamento_id_seq    SEQUENCE OWNED BY     K   ALTER SEQUENCE public.departamento_id_seq OWNED BY public.departamento.id;
          public          postgres    false    202            �            1259    17659 
   dependente    TABLE     �   CREATE TABLE public.dependente (
    id integer NOT NULL,
    id_funcionario integer,
    nome character varying(50),
    nasc date,
    grau_parentesco character varying(50)
);
    DROP TABLE public.dependente;
       public         heap    postgres    false            �            1259    17657    dependente_id_seq    SEQUENCE     �   CREATE SEQUENCE public.dependente_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.dependente_id_seq;
       public          postgres    false    209            �           0    0    dependente_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.dependente_id_seq OWNED BY public.dependente.id;
          public          postgres    false    208            �            1259    17644    funcionario    TABLE     �   CREATE TABLE public.funcionario (
    id integer NOT NULL,
    id_departamento integer,
    nome character varying(50),
    nasc date,
    salario numeric(10,2)
);
    DROP TABLE public.funcionario;
       public         heap    postgres    false            �            1259    17642    funcionario_id_seq    SEQUENCE     �   CREATE SEQUENCE public.funcionario_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.funcionario_id_seq;
       public          postgres    false    207            �           0    0    funcionario_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.funcionario_id_seq OWNED BY public.funcionario.id;
          public          postgres    false    206            �            1259    17685    limpeza    TABLE     �   CREATE TABLE public.limpeza (
    id integer NOT NULL,
    id_funcionario integer,
    id_limpeza integer,
    supervisor boolean,
    jornada_de_trabalho integer
);
    DROP TABLE public.limpeza;
       public         heap    postgres    false            �            1259    17683    limpeza_id_seq    SEQUENCE     �   CREATE SEQUENCE public.limpeza_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.limpeza_id_seq;
       public          postgres    false    213            �           0    0    limpeza_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.limpeza_id_seq OWNED BY public.limpeza.id;
          public          postgres    false    212            �            1259    17703    pesquisador    TABLE     s   CREATE TABLE public.pesquisador (
    id integer NOT NULL,
    id_funcionario integer,
    salario_hora integer
);
    DROP TABLE public.pesquisador;
       public         heap    postgres    false            �            1259    17701    pesquisador_id_seq    SEQUENCE     �   CREATE SEQUENCE public.pesquisador_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 )   DROP SEQUENCE public.pesquisador_id_seq;
       public          postgres    false    215            �           0    0    pesquisador_id_seq    SEQUENCE OWNED BY     I   ALTER SEQUENCE public.pesquisador_id_seq OWNED BY public.pesquisador.id;
          public          postgres    false    214            �            1259    17631    projeto    TABLE     �   CREATE TABLE public.projeto (
    id integer NOT NULL,
    id_departamento integer,
    nome character varying(50),
    periodo_desenvolvimento integer
);
    DROP TABLE public.projeto;
       public         heap    postgres    false            �            1259    17629    projeto_id_seq    SEQUENCE     �   CREATE SEQUENCE public.projeto_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 %   DROP SEQUENCE public.projeto_id_seq;
       public          postgres    false    205            �           0    0    projeto_id_seq    SEQUENCE OWNED BY     A   ALTER SEQUENCE public.projeto_id_seq OWNED BY public.projeto.id;
          public          postgres    false    204            �            1259    17714    projeto_pesquisador    TABLE        CREATE TABLE public.projeto_pesquisador (
    id_pesquisador integer,
    id_projeto integer,
    horas_trabalhadas integer
);
 '   DROP TABLE public.projeto_pesquisador;
       public         heap    postgres    false            �            1259    17672 
   secretaria    TABLE     �   CREATE TABLE public.secretaria (
    id integer NOT NULL,
    id_funcionario integer,
    grau_escolaridade character varying(30)
);
    DROP TABLE public.secretaria;
       public         heap    postgres    false            �            1259    17670    secretaria_id_seq    SEQUENCE     �   CREATE SEQUENCE public.secretaria_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 (   DROP SEQUENCE public.secretaria_id_seq;
       public          postgres    false    211            �           0    0    secretaria_id_seq    SEQUENCE OWNED BY     G   ALTER SEQUENCE public.secretaria_id_seq OWNED BY public.secretaria.id;
          public          postgres    false    210            A           2604    17626    departamento id    DEFAULT     r   ALTER TABLE ONLY public.departamento ALTER COLUMN id SET DEFAULT nextval('public.departamento_id_seq'::regclass);
 >   ALTER TABLE public.departamento ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    202    203    203            D           2604    17662    dependente id    DEFAULT     n   ALTER TABLE ONLY public.dependente ALTER COLUMN id SET DEFAULT nextval('public.dependente_id_seq'::regclass);
 <   ALTER TABLE public.dependente ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    209    208    209            C           2604    17647    funcionario id    DEFAULT     p   ALTER TABLE ONLY public.funcionario ALTER COLUMN id SET DEFAULT nextval('public.funcionario_id_seq'::regclass);
 =   ALTER TABLE public.funcionario ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207            F           2604    17688 
   limpeza id    DEFAULT     h   ALTER TABLE ONLY public.limpeza ALTER COLUMN id SET DEFAULT nextval('public.limpeza_id_seq'::regclass);
 9   ALTER TABLE public.limpeza ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    212    213    213            G           2604    17706    pesquisador id    DEFAULT     p   ALTER TABLE ONLY public.pesquisador ALTER COLUMN id SET DEFAULT nextval('public.pesquisador_id_seq'::regclass);
 =   ALTER TABLE public.pesquisador ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    214    215    215            B           2604    17634 
   projeto id    DEFAULT     h   ALTER TABLE ONLY public.projeto ALTER COLUMN id SET DEFAULT nextval('public.projeto_id_seq'::regclass);
 9   ALTER TABLE public.projeto ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    204    205    205            E           2604    17675    secretaria id    DEFAULT     n   ALTER TABLE ONLY public.secretaria ALTER COLUMN id SET DEFAULT nextval('public.secretaria_id_seq'::regclass);
 <   ALTER TABLE public.secretaria ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    210    211    211            �          0    17623    departamento 
   TABLE DATA           0   COPY public.departamento (id, nome) FROM stdin;
    public          postgres    false    203   \       �          0    17659 
   dependente 
   TABLE DATA           U   COPY public.dependente (id, id_funcionario, nome, nasc, grau_parentesco) FROM stdin;
    public          postgres    false    209   @\       �          0    17644    funcionario 
   TABLE DATA           O   COPY public.funcionario (id, id_departamento, nome, nasc, salario) FROM stdin;
    public          postgres    false    207   �\       �          0    17685    limpeza 
   TABLE DATA           b   COPY public.limpeza (id, id_funcionario, id_limpeza, supervisor, jornada_de_trabalho) FROM stdin;
    public          postgres    false    213    ]       �          0    17703    pesquisador 
   TABLE DATA           G   COPY public.pesquisador (id, id_funcionario, salario_hora) FROM stdin;
    public          postgres    false    215   2]       �          0    17631    projeto 
   TABLE DATA           U   COPY public.projeto (id, id_departamento, nome, periodo_desenvolvimento) FROM stdin;
    public          postgres    false    205   V]       �          0    17714    projeto_pesquisador 
   TABLE DATA           \   COPY public.projeto_pesquisador (id_pesquisador, id_projeto, horas_trabalhadas) FROM stdin;
    public          postgres    false    216   �]       �          0    17672 
   secretaria 
   TABLE DATA           K   COPY public.secretaria (id, id_funcionario, grau_escolaridade) FROM stdin;
    public          postgres    false    211   �]       �           0    0    departamento_id_seq    SEQUENCE SET     A   SELECT pg_catalog.setval('public.departamento_id_seq', 1, true);
          public          postgres    false    202            �           0    0    dependente_id_seq    SEQUENCE SET     ?   SELECT pg_catalog.setval('public.dependente_id_seq', 1, true);
          public          postgres    false    208            �           0    0    funcionario_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.funcionario_id_seq', 4, true);
          public          postgres    false    206            �           0    0    limpeza_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.limpeza_id_seq', 2, true);
          public          postgres    false    212            �           0    0    pesquisador_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.pesquisador_id_seq', 1, true);
          public          postgres    false    214                        0    0    projeto_id_seq    SEQUENCE SET     <   SELECT pg_catalog.setval('public.projeto_id_seq', 1, true);
          public          postgres    false    204                       0    0    secretaria_id_seq    SEQUENCE SET     @   SELECT pg_catalog.setval('public.secretaria_id_seq', 1, false);
          public          postgres    false    210            I           2606    17628    departamento departamento_pkey 
   CONSTRAINT     \   ALTER TABLE ONLY public.departamento
    ADD CONSTRAINT departamento_pkey PRIMARY KEY (id);
 H   ALTER TABLE ONLY public.departamento DROP CONSTRAINT departamento_pkey;
       public            postgres    false    203            O           2606    17664    dependente dependente_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.dependente
    ADD CONSTRAINT dependente_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.dependente DROP CONSTRAINT dependente_pkey;
       public            postgres    false    209            M           2606    17649    funcionario funcionario_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_pkey;
       public            postgres    false    207            S           2606    17690    limpeza limpeza_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.limpeza
    ADD CONSTRAINT limpeza_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.limpeza DROP CONSTRAINT limpeza_pkey;
       public            postgres    false    213            U           2606    17708    pesquisador pesquisador_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.pesquisador
    ADD CONSTRAINT pesquisador_pkey PRIMARY KEY (id);
 F   ALTER TABLE ONLY public.pesquisador DROP CONSTRAINT pesquisador_pkey;
       public            postgres    false    215            K           2606    17636    projeto projeto_pkey 
   CONSTRAINT     R   ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT projeto_pkey PRIMARY KEY (id);
 >   ALTER TABLE ONLY public.projeto DROP CONSTRAINT projeto_pkey;
       public            postgres    false    205            Q           2606    17677    secretaria secretaria_pkey 
   CONSTRAINT     X   ALTER TABLE ONLY public.secretaria
    ADD CONSTRAINT secretaria_pkey PRIMARY KEY (id);
 D   ALTER TABLE ONLY public.secretaria DROP CONSTRAINT secretaria_pkey;
       public            postgres    false    211            _           2620    17748    funcionario tr_teste    TRIGGER     �   CREATE TRIGGER tr_teste BEFORE INSERT OR DELETE OR UPDATE ON public.funcionario FOR EACH ROW EXECUTE FUNCTION public.trg_teste();
 -   DROP TRIGGER tr_teste ON public.funcionario;
       public          postgres    false    207    235            `           2620    17761 0   funcionario verificar_salario_supervisor_limpeza    TRIGGER     �   CREATE TRIGGER verificar_salario_supervisor_limpeza BEFORE INSERT OR UPDATE ON public.funcionario FOR EACH ROW EXECUTE FUNCTION public.trg_verificar_salario_supervisor_limpeza();
 I   DROP TRIGGER verificar_salario_supervisor_limpeza ON public.funcionario;
       public          postgres    false    234    207            X           2606    17665 )   dependente dependente_id_funcionario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.dependente
    ADD CONSTRAINT dependente_id_funcionario_fkey FOREIGN KEY (id_funcionario) REFERENCES public.funcionario(id);
 S   ALTER TABLE ONLY public.dependente DROP CONSTRAINT dependente_id_funcionario_fkey;
       public          postgres    false    2893    209    207            W           2606    17650 ,   funcionario funcionario_id_departamento_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.funcionario
    ADD CONSTRAINT funcionario_id_departamento_fkey FOREIGN KEY (id_departamento) REFERENCES public.departamento(id);
 V   ALTER TABLE ONLY public.funcionario DROP CONSTRAINT funcionario_id_departamento_fkey;
       public          postgres    false    2889    203    207            Z           2606    17691 #   limpeza limpeza_id_funcionario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.limpeza
    ADD CONSTRAINT limpeza_id_funcionario_fkey FOREIGN KEY (id_funcionario) REFERENCES public.funcionario(id);
 M   ALTER TABLE ONLY public.limpeza DROP CONSTRAINT limpeza_id_funcionario_fkey;
       public          postgres    false    2893    207    213            [           2606    17696    limpeza limpeza_id_limpeza_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.limpeza
    ADD CONSTRAINT limpeza_id_limpeza_fkey FOREIGN KEY (id_limpeza) REFERENCES public.limpeza(id);
 I   ALTER TABLE ONLY public.limpeza DROP CONSTRAINT limpeza_id_limpeza_fkey;
       public          postgres    false    213    213    2899            \           2606    17709 +   pesquisador pesquisador_id_funcionario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.pesquisador
    ADD CONSTRAINT pesquisador_id_funcionario_fkey FOREIGN KEY (id_funcionario) REFERENCES public.funcionario(id);
 U   ALTER TABLE ONLY public.pesquisador DROP CONSTRAINT pesquisador_id_funcionario_fkey;
       public          postgres    false    215    2893    207            V           2606    17637 $   projeto projeto_id_departamento_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.projeto
    ADD CONSTRAINT projeto_id_departamento_fkey FOREIGN KEY (id_departamento) REFERENCES public.departamento(id);
 N   ALTER TABLE ONLY public.projeto DROP CONSTRAINT projeto_id_departamento_fkey;
       public          postgres    false    203    2889    205            ]           2606    17717 ;   projeto_pesquisador projeto_pesquisador_id_pesquisador_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.projeto_pesquisador
    ADD CONSTRAINT projeto_pesquisador_id_pesquisador_fkey FOREIGN KEY (id_pesquisador) REFERENCES public.pesquisador(id);
 e   ALTER TABLE ONLY public.projeto_pesquisador DROP CONSTRAINT projeto_pesquisador_id_pesquisador_fkey;
       public          postgres    false    216    215    2901            ^           2606    17722 7   projeto_pesquisador projeto_pesquisador_id_projeto_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.projeto_pesquisador
    ADD CONSTRAINT projeto_pesquisador_id_projeto_fkey FOREIGN KEY (id_projeto) REFERENCES public.projeto(id);
 a   ALTER TABLE ONLY public.projeto_pesquisador DROP CONSTRAINT projeto_pesquisador_id_projeto_fkey;
       public          postgres    false    2891    216    205            Y           2606    17678 )   secretaria secretaria_id_funcionario_fkey    FK CONSTRAINT     �   ALTER TABLE ONLY public.secretaria
    ADD CONSTRAINT secretaria_id_funcionario_fkey FOREIGN KEY (id_funcionario) REFERENCES public.funcionario(id);
 S   ALTER TABLE ONLY public.secretaria DROP CONSTRAINT secretaria_id_funcionario_fkey;
       public          postgres    false    2893    207    211            �      x�3�t�sw��p�t����� '��      �   1   x�3�4��	uvVpqT��	s�4204�54�54�t��������� �TK      �   o   x�-��	�0 ��i 2�F��@��F���Ɠu�1����`��O�e��l!
��F��u��*"�����'�e��#�]�B6�O���`��~w�tN���~�R�<�      �   "   x�3�4���,\F�&���i�&&\1z\\\ H�      �      x�3�4�45������ 
��      �   +   x�3�4�t>����������id`����� ��`      �      x�3�4�42������ 
��      �      x������ � �     