#!/bin/bash
psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" --dbname "$POSTGRES_DB" <<-EOSQL
	
	CREATE TABLE todo(
		id serial PRIMARY KEY,
		name varchar(100) NOT NULL,
		description varchar(255) NOT NULL,
		status varchar(10) NOT NULL,
		image_path varchar(255)
	);

	INSERT INTO todo (name, description, status) VALUES('Cortar pasto', 'Cortar el paso en casa', 'pending'),
  	('Limpiar habitacion', 'Limpiar la habitacion. Limpiar polvo}', 'pending'),
  	('Leer Clean Code', 'Leer y tomar nota sobre el libro de Clean Code de uncle Bob', 'done'),
  	('Estudiar ingles', 'Estudiar ingles para dar el FCE', 'done');