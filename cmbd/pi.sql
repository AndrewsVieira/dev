CREATE TABLE users(
	id SERIAL PRIMARY KEY NOT NULL,
	name VARCHAR (50) NOT NULL,
	last_name VARCHAR (50) NOT NULL,
	type VARCHAR (10) NOT NULL,
	deleted BOOLEAN NOT NULL,
	password VARCHAR (8)
);

CREATE TABLE duel(
	id SERIAL PRIMARY KEY NOT NULL,
	id_user1 INTEGER NOT NULL REFERENCES users(id),
	id_user2 INTEGER NOT NULL REFERENCES users(id),
	deleted BOOLEAN NOT NULL	
);

CREATE TABLE teacher (
	id SERIAL PRIMARY KEY NOT NULL,
	id_user INTEGER NOT NULL REFERENCES users (id) ,
	date_birth DATE NOT NULL,
	cpf VARCHAR (11) NOT NULL
);

CREATE TABLE student(
	id SERIAL PRIMARY KEY NOT NULL,
	id_user INTEGER NOT NULL REFERENCES users(id) ,
	school_year INTEGER NOT NULL
);

CREATE TABLE question(
	id SERIAL PRIMARY KEY NOT NULL,
	id_teacher INTEGER NOT NULL REFERENCES teacher(id) ,
	quest VARCHAR(250)NOT NULL,
	deleted BOOLEAN NOT NULL
);

CREATE TABLE student_question(
	id_question INTEGER NOT NULL REFERENCES question(id) ,
	id_student INTEGER NOT NULL REFERENCES student(id),
	id_duel INTEGER NOT NULL REFERENCES duel(id) ,
	answer1 VARCHAR(20) NOT NULL,
	answer2 VARCHAR(20) NOT NULL,
	CONSTRAINT id_student_question PRIMARY KEY (id_question, id_student)
);

CREATE TABLE alternatives(
	id SERIAL PRIMARY KEY NOT NULL,
	id_question INTEGER NOT NULL REFERENCES question(id) ,
	alternative VARCHAR(20) NOT NULL,
	aceppted BOOLEAN NOT NULL,
	deleted BOOLEAN NOT NULL
);


CREATE TABLE admin(
	id_admin SERIAL PRIMARY KEY NOT NULL,
	id_user INTEGER NOT NULL REFERENCES users(id)
);