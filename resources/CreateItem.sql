--<ScriptOptions statementTerminator=";"/>

CREATE TABLE item (
	idItem INT NOT NULL,
	name VARCHAR(45),
	desciption VARCHAR(100),
	price FLOAT,
	available BIT,
	PRIMARY KEY (idItem)
) ENGINE=InnoDB;

