-- TABLE
CREATE TABLE hibernate_sequence (next_val bigint);
CREATE TABLE Pessoa (id integer not null, cpf varchar(255), dataNascimento datetime, email varchar(255), idade integer not null, nome varchar(255), primary key (id));
CREATE TABLE Produto (id integer not null, nome varchar(255), preco double precision not null, quantidade integer not null, status boolean not null, primary key (id));
 
-- INDEX
 
-- TRIGGER
 
-- VIEW
 
