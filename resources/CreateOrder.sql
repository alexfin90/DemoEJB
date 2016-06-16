--<ScriptOptions statementTerminator=";"/>

CREATE TABLE order (
	idOrder INT NOT NULL,
	description VARCHAR(100),
	date DATE,
	time TIME,
	stato ENUM,
	fk_user INT,
	fk_item INT,
	PRIMARY KEY (idOrder)
) ENGINE=InnoDB;

CREATE INDEX _idx ON order (fk_user ASC);

CREATE INDEX fk_item_idx ON order (fk_item ASC);

