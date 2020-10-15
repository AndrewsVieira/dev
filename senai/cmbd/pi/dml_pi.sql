--USERS
--INSERT

INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Jair', 'Schwan', 'ADMIN', false, '123');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Antonio', 'Oliveira', 'STUDENT', false, '456');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Alisson', 'Vieira', 'TEACHER', false, '789');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Andrews', 'Vieira', 'STUDENT', false, '012');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Victor', 'Georges', 'TEACHER', false, '345');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('José', 'Borges', 'STUDENT', false, '325');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Alexandre', 'Ramos', 'STUDENT', false, '147');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Vanessa', 'Georges', 'TEACHER', false, '171');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Willian', 'Schwan', 'TEACHER', false, '159');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Miguel', 'Schimit', 'ADMIN', false, '135');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Bruno', 'Schwan', 'TEACHER', false, '175');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Carol', 'Reis', 'STUDENT', false, '132');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Zulmar', 'Vieira', 'TEACHER', false, '789');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Goretti', 'Assunção', 'TEACHER', false, '765');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Alisson', 'Vieira', 'ADMIN', false, '534');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Liara', 'Zanella', 'TEACHER', false, '345');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Caio', 'Bruno', 'TEACHER', false, '002');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Brenda', 'Santos', 'STUDENT', false, '300');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Thiago', 'Puim', 'ADMIN', true, '374');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Paulo', 'Pelicano', 'STUDENT', false, '345');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Vinícius', 'Souza', 'TEACHER', false, '695');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Joao', 'Carlos', 'ADMIM', false, '555');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Lucas', 'Pereira', 'STUDENT', false, '565');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Carlos', 'Vieira', 'TEACHER', false, '645');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Victor', 'Santiago', 'ADMIN', false, '375');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Antonior', 'Costa', 'STUDENT', false, '845');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Bruna', 'Silva', 'TEACHER', false, '825');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Maria', 'Silveira', 'ADMIN', false, '885');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Marilia', 'Vladmir', 'ADMIN', false, '835');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Joao', 'Schwan', 'STUDENT', false, '245');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Joana', 'da Silva', 'ADMIN', false, '885');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Jobson', 'Carvalho', 'ADMIN', false, '835');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Maicon', 'Santos', 'ADMIN', false, '245');

--SELECT

SELECT name, last_name, deleted,type FROM users WHERE type = 'STUDENT'  OR type = 'TEACHER';

--UPDATE

UPDATE users SET password= '789' WHERE id=3;
UPDATE users SET deleted = true WHERE id=1;
UPDATE users SET last_name= 'Silveira' WHERE id=20;
UPDATE users SET name= 'Jair' WHERE id=33;

--DELETE

DELETE FROM users WHERE id = 1;
DELETE FROM users WHERE id = 2;
DELETE FROM users WHERE id = 3;
DELETE FROM users WHERE id = 4;

--TEACHER
--INSERT
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (3,'1996-10-19','14526378410');
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (5,'1994-4-25','45752314864');

INSERT INTO teacher (id_user,date_birth,cpf) VALUES (21,'1984-12-17','45752314124');
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (9,'1982-12-10','45752313464');
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (14,'1985-4-13','43723454864');
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (13,'1990-4-04','13752244864');
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (16,'1991-8-10','98752123864');
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (17,'1990-6-25','69742312348');
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (27,'1986-3-20','05732311254');
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (24,'1973-9-02','79751312314');

--UPDATE

UPDATE teacher SET date_birth='1980-01-10' WHERE id_user = 2;
UPDATE teacher SET date_birth='1974-01-10' WHERE id_user = 1;
UPDATE teacher SET date_birth='1969-01-10' WHERE id_user = 3;
UPDATE teacher SET date_birth='1987-01-10' WHERE id_user = 9;

--DELETE

DELETE FROM teacher WHERE id = 1;
DELETE FROM teacher WHERE id = 2;
DELETE FROM teacher WHERE id = 3;
DELETE FROM teacher WHERE id = 4;

--STUDENTS
--INSERT

INSERT INTO student (id_user,school_year) VALUES (2,1);
INSERT INTO student (id_user,school_year) VALUES (4,2);

INSERT INTO student (id_user,school_year) VALUES (6,2);
INSERT INTO student (id_user,school_year) VALUES (7,3);
INSERT INTO student (id_user,school_year) VALUES (12,3);
INSERT INTO student (id_user,school_year) VALUES (18,3);
INSERT INTO student (id_user,school_year) VALUES (20,4);
INSERT INTO student (id_user,school_year) VALUES (23,4);
INSERT INTO student (id_user,school_year) VALUES (26,5);
INSERT INTO student (id_user,school_year) VALUES (30,5);

--SELECT

SELECT id_user,school_year FROM student ORDER BY school_year ASC;
SELECT id_user,school_year FROM  student ORDER BY id_user DESC; 

--UPDATE

UPDATE student SET school_year=1 WHERE id_user = 1;
UPDATE student SET school_year=2 WHERE id_user = 2;
UPDATE student SET school_year=4 WHERE id_user = 8;
UPDATE student SET school_year=3 WHERE id_user = 7;

--DELETE

DELETE FROM students WHERE id = 1;
DELETE FROM students WHERE id = 2;
DELETE FROM students WHERE id = 3;
DELETE FROM students WHERE id = 4;
DELETE FROM students WHERE id = 5;


--ADMIN
--INSERT

INSERT INTO admin (id_user) VALUES (1);
INSERT INTO admin (id_user) VALUES (10);
INSERT INTO admin (id_user) VALUES (15);
INSERT INTO admin (id_user) VALUES (19);
INSERT INTO admin (id_user) VALUES (25);
INSERT INTO admin (id_user) VALUES (28);
INSERT INTO admin (id_user) VALUES (29);
INSERT INTO admin (id_user) VALUES (31);
INSERT INTO admin (id_user) VALUES (32);
INSERT INTO admin (id_user) VALUES (33);

--SELECT
SELECT count(*) FROM admin;

--UPDATE
-- ADMIN NÃO TEM UPDATE PORQUÊ SO TEM CAMPO ID.

--DELETE

DELETE FROM admin WHERE id_user = 1;
DELETE FROM admin WHERE id_user = 10;
DELETE FROM admin WHERE id_user = 15;
DELETE FROM admin WHERE id_user = 29;

--QUESTION
--INSERT

INSERT INTO question (id_teacher,quest,deleted) VALUES (4,'Quanto é 2+2?',false);
INSERT INTO question (id_teacher,quest,deleted) VALUES (5,'Quanto é 4+1?',false);

INSERT INTO question (id_teacher,quest,deleted) VALUES (1,'Quanto é 4/2?',false);
INSERT INTO question (id_teacher,quest,deleted) VALUES (2,'Quanto é 8+2?',false);
INSERT INTO question (id_teacher,quest,deleted) VALUES (3,'Quanto é 7/7?',false);
INSERT INTO question (id_teacher,quest,deleted) VALUES (2,'Quanto é 5+5?',false);
INSERT INTO question (id_teacher,quest,deleted) VALUES (10,'Quanto é 4+4?',false);
INSERT INTO question (id_teacher,quest,deleted) VALUES (9,'Quanto é 6+2?',false);
INSERT INTO question (id_teacher,quest,deleted) VALUES (7,'Quanto
é 8*9?',false);
INSERT INTO question (id_teacher,quest,deleted) VALUES (6,'Quanto é 16/8?',false);

--UPDATE

UPDATE question SET quest = 'Quanto é 36/6 ?' WHERE id = 10;
UPDATE question SET quest = 'Quanto é 2*2 ?' WHERE id = 8;
UPDATE question SET quest = 'Quanto é 5+4 ?' WHERE id = 7;
UPDATE question SET quest = 'Quanto é 6*2 ?' WHERE id = 6;

--DELETE

DELETE FROM question WHERE id = 6;
DELETE FROM question WHERE id = 7;
DELETE FROM question WHERE id = 8;
DELETE FROM question WHERE id = 9;
DELETE FROM question WHERE id_teacher = 5;


--ALTERNATIVES
--INSERT

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (1,'2',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (1,'3',false,false);
INSERT INTO alternatives(id_question,alternative,aceppted,deleted) VALUES (1,'4',true,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (1,'5',false,false);

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (2,'2',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (2,'3',false,false);
INSERT INTO alternatives(id_question,alternative,aceppted,deleted) VALUES (2,'4',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (2,'5',true,false);


INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (3,'2',true,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (3,'4',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (3,'6',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (3,'8',false,false);

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (4,'11',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (4,'8',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (4,'9',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (4,'10',true,false);

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (5,'2',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (5,'1',true,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (5,'3',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (5,'4',false,false);

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (6,'10',true,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (6,'11',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (6,'12',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (6,'13',false,false);

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (7,'8',true,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (7,'9',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (7,'5',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (7,'7',false,false);

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (8,'2',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (8,'8',true,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (8,'6',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (8,'4',false,false);

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (9,'72',true,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (9,'78',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (9,'76',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (9,'75',false,false);

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (10,'2',true,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (10,'4',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (10,'6',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (10,'8',false,false);

--UPDATE

UPDATE alternatives SET aceppted = true WHERE id_question = 8 AND alternative = '12';
UPDATE alternatives SET aceppted = false WHERE id_question = 8 AND alternative = '10';

UPDATE alternatives SET aceppted = true WHERE id_question = 8 AND alternative = '9';
UPDATE alternatives SET aceppted = false WHERE id_question = 8 AND alternative = '8';

UPDATE alternatives SET aceppted = true WHERE id_question = 8 AND alternative = '4';
UPDATE alternatives SET aceppted = false WHERE id_question = 8 AND alternative = '8';

UPDATE alternatives SET aceppted = true WHERE id_question = 10 AND alternative = '6';
UPDATE alternatives SET aceppted = false WHERE id_question = 10 AND alternative = '2';

--DELETE

DELETE FROM alternatives WHERE id_question = 6;
DELETE FROM alternatives WHERE id_question = 7;
DELETE FROM alternatives WHERE id_question = 8;
DELETE FROM alternatives WHERE id_question = 9;
DELETE FROM alternatives WHERE id_question = 4


--DUELO
--INSERT

INSERT INTO duel (id_user1,id_user2,deleted) VALUES (2,4,false);
INSERT INTO duel (id_user1,id_user2,deleted) VALUES (18,4,false);
INSERT INTO duel (id_user1,id_user2,deleted) VALUES (4,6,false);
INSERT INTO duel (id_user1,id_user2,deleted) VALUES (20,2,false);
INSERT INTO duel (id_user1,id_user2,deleted) VALUES (20,4,false);
INSERT INTO duel (id_user1,id_user2,deleted) VALUES (12,7,false);
INSERT INTO duel (id_user1,id_user2,deleted) VALUES (30,4,false);
INSERT INTO duel (id_user1,id_user2,deleted) VALUES (18,6,false);
INSERT INTO duel (id_user1,id_user2,deleted) VALUES (12,4,false);
INSERT INTO duel (id_user1,id_user2,deleted) VALUES (30,12,false);

--SELECT

SELECT count(*) FROM duel;

--UPDATE
UPDATE duel SET deleted= true WHERE id=1;
UPDATE duel SET deleted= true WHERE id=4;
UPDATE duel SET deleted= true WHERE id=5;
UPDATE duel SET deleted= true WHERE id=2;

--DELETE

DELETE FROM duel WHERE id = 3;
DELETE FROM duel WHERE id = 2;
DELETE FROM duel WHERE id = 5;
DELETE FROM duel WHERE id = 4;
DELETE FROM duel WHERE id = 1;


--STUDENT_QUESTION
--INSERT

INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (3,3,1,'6');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (3,4,1,'2');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (5,6,7,'1');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (3,5,8,'4');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (1,10,3,'3');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (4,9,4,'2');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (9,2,10,'1');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (6,1,7,'3');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (10,6,6,'1');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (7,6,5,'2');

--UPDATE

UPDATE student SET school_year = 2 WHERE id = 3
	RETURNING school_year;

UPDATE student_question SET answer = '4' WHERE answer = '6'
	RETURNING answer;

UPDATE student_question SET answer = '5' WHERE id = 1;
UPDATE student_question SET answer = '5' WHERE id = 2;
UPDATE student_question SET answer = '5' WHERE id = 3;
UPDATE student_question SET answer = '5' WHERE id = 4;

--DELETE

DELETE FROM student_question WHERE id = 1;
DELETE FROM student_question WHERE id = 2;
DELETE FROM student_question WHERE id = 3;
DELETE FROM student_question WHERE id = 4;


-- SELECT AVANÇADOS

--Busca os alunos e suas pergutnas e respostas e seu ano escolar
SELECT users.name, student.school_year, question.quest, sq.answer 
	FROM users 	INNER JOIN student ON users.id = student.id_user
				INNER JOIN student_question AS sq ON student.id = sq.id_student
				INNER JOIN question ON sq.id_question = question.id
				INNER JOIN duel ON sq.id_duel = duel.id
		WHERE sq.id_duel = duel.id;

--Aluno que acertou a resposta
SELECT users.name, question.quest, sq.answer, alternatives.aceppted
	FROM users 	INNER JOIN student ON users.id = student.id_user
				INNER JOIN student_question AS sq ON student.id = sq.id_student
				INNER JOIN question ON sq.id_question = question.id
				INNER JOIN alternatives ON question.id = alternatives.id_question
		WHERE sq.answer = alternatives.alternative AND alternatives.aceppted = true;


--Professor que fez a pergunta
SELECT users.name, question.quest
	FROM users INNER JOIN teacher ON users.id = teacher.id_user
				INNER JOIN question ON teacher.id = question.id_teacher;

--Questão e alternativa correta
SELECT question.quest, alternatives.alternative
	FROM question INNER JOIN alternatives ON question.id = alternatives.id_question
		WHERE alternatives.aceppted = true;

	
	
	
	
	
	

