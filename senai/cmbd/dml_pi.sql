--INSERT

--USERS

INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Jair', 'Schwan', 'ADMIN', false, '123');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Antonio', 'Oliveira', 'STUDENT', false, '456');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Alisson', 'Vieira', 'TEACHER', false, '789');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Andrews', 'Vieira', 'STUDENT', false, '012');
INSERT INTO users (name, last_name, type, deleted, password) VALUES ('Victor', 'Georges', 'TEACHER', false, '345');

--TEACHER

INSERT INTO teacher (id_user,date_birth,cpf) VALUES (3,'1996-10-19','14526378410');
INSERT INTO teacher (id_user,date_birth,cpf) VALUES (5,'1994-4-25','45752314864');

--STUDENTS

INSERT INTO student (id_user,school_year) VALUES (2,1);
INSERT INTO student (id_user,school_year) VALUES (4,2);

--ADMIN

INSERT INTO admin (id_user) VALUES (1);

--QUESTION

INSERT INTO question (id_teacher,quest,deleted) VALUES (4,'Quanto é 2+2?',false);
INSERT INTO question (id_teacher,quest,deleted) VALUES (5,'Quanto é 4+1?',false);

--ALTERNATIVES

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (3,'2',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (3,'3',false,false);
INSERT INTO alternatives(id_question,alternative,aceppted,deleted) VALUES (3,'4',true,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (3,'5',false,false);

INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (4,'2',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (4,'3',false,false);
INSERT INTO alternatives(id_question,alternative,aceppted,deleted) VALUES (4,'4',false,false);
INSERT INTO alternatives (id_question,alternative,aceppted,deleted) VALUES (4,'5',true,false);

--DUELO

INSERT INTO duel (id_user1,id_user2,deleted) VALUES (2,4,false);

--STUDENT_QUESTION

INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (3,3,1,'6');
INSERT INTO student_question (id_question,id_student,id_duel,answer) VALUES (3,4,1,'2');

--UPDATE

SELECT * FROM student;
UPDATE student SET school_year = 2 WHERE id = 3
	RETURNING school_year;

UPDATE student_question SET answer = '4' WHERE answer = '6'
	RETURNING answer;

--DELETE

--INSERT INTO question (id_teacher,quest,deleted) VALUES (5,'Quanto é 4+1?',false);
DELETE FROM alternatives WHERE id_question = 4
DELETE FROM question WHERE id_teacher = 5;

--SELECT
--alunos que estão fazendo um duelo
SELECT users.name, student.school_year, question.quest, sq.answer 
	FROM users 	INNER JOIN student ON users.id = student.id_user
				INNER JOIN student_question AS sq ON student.id = sq.id_student
				INNER JOIN question ON sq.id_question = question.id
				INNER JOIN duel ON sq.id_duel = duel.id
		WHERE sq.id_duel = duel.id

--Aluno que acertou a resposta
SELECT users.name, question.quest, sq.answer, alternatives.aceppted
	FROM users 	INNER JOIN student ON users.id = student.id_user
				INNER JOIN student_question AS sq ON student.id = sq.id_student
				INNER JOIN question ON sq.id_question = question.id
				INNER JOIN alternatives ON question.id = alternatives.id_question
		WHERE sq.answer = alternatives.alternative AND alternatives.aceppted = true;


--Professor que fez a pergunta
SELECT users.name, question.quest
	FROM users 	INNER JOIN teacher ON users.id = teacher.id_user
				INNER JOIN question ON teacher.id = question.id_teacher


--Questão e alternativa correta

SELECT question.quest, alternatives.alternative
	FROM question INNER JOIN alternatives ON question.id = alternatives.id_question
		WHERE alternatives.aceppted = true
	
	
	
	
	
	
	

