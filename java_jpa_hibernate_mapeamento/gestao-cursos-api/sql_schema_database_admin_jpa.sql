-- TABLE
CREATE TABLE Aluno (aluno_id bigint not null, email varchar(255), matricula varchar(255), nascimento datetime, nomeCompleto varchar(255), primary key (aluno_id));
CREATE TABLE Curso (curso_id bigint not null, nome varchar(255), sigla varchar(255), materialCurso_id bigint, professor_id bigint, primary key (curso_id));
CREATE TABLE Endereco (endereco_id bigint not null, bairro varchar(255), cep integer, cidade varchar(255), endereco varchar(255), estado varchar(255), logradouro varchar(255), numero varchar(255), aluno_id bigint, primary key (endereco_id));
CREATE TABLE Fk_Curso_Aluno (curso_id bigint not null, aluno_id bigint not null);
CREATE TABLE hibernate_sequence (next_val bigint);
CREATE TABLE MaterialCurso (materialCurso_id bigint not null, url varchar(255), curso_id bigint, primary key (materialCurso_id));
CREATE TABLE Professor (professor_id bigint not null, email varchar(255), matricula varchar(255), nomeCompleto varchar(255), primary key (professor_id));
CREATE TABLE Telefone (telefone_id bigint not null, DDD varchar(255), numero varchar(255), aluno_id bigint, primary key (telefone_id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
