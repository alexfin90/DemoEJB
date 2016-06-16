--<ScriptOptions statementTerminator=";"/>

CREATE TABLE user (
	iduser INT NOT NULL,
	name VARCHAR(45) NOT NULL,
	surname VARCHAR(45) NOT NULL,
	country VARCHAR(45),
	city VARCHAR(45),
	province VARCHAR(45),
	birthday DATE,
	PRIMARY KEY (iduser)
) ENGINE=InnoDB;

