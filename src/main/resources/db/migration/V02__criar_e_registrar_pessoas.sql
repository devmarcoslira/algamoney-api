CREATE TABLE pessoa (
	codigo		BIGINT(20) 	PRIMARY KEY AUTO_INCREMENT,
	nome 		VARCHAR(50) 	NOT NULL,
	ativo 		BOOLEAN 	NOT NULL,
	logradouro  	VARCHAR(60),
	numero		VARCHAR(10),
	complemento	VARCHAR(50),
	bairro		VARCHAR(50),
	cep		VARCHAR(10),
	cidade		VARCHAR(50),
	estado		VARCHAR(2)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
	   VALUES ('Geralt de Rívea', true, 'The Wichter', '03', null, 'Nilfgard','72000-000','Gameopolis','XO');
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
	   VALUES ('Sqall Leonart', true, 'Balam Gardem', '01', null, 'FFVIII','72000-000','Final Fantasy','FF');
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
	   VALUES ('Cloud Strife', true, 'Gaia', '01', null, 'Centro','72000-000','Final Fantasy','FF');
INSERT INTO pessoa (nome,ativo,logradouro,numero,complemento,bairro,cep,cidade,estado) 
	   VALUES ('Marcus Michael Fenix', true, ',Manhattan', '01', null, 'Nova York','72000-000','Nova York','NY');
