DROP DATABASE IF EXISTS DyD;
CREATE DATABASE DyD CHARACTER SET utf8mb4;
USE DyD;

CREATE TABLE Razas (
 idRaza INT PRIMARY KEY,
 nombre VARCHAR(30),
 edad INT,
 velocidad INT,
 idioma VARCHAR(20),
 visionOscuridad BOOLEAN,
 tamaño VARCHAR(20)
);

CREATE TABLE Clases (
 idClase INT PRIMARY KEY,
 nombre VARCHAR(30),
 rol VARCHAR(20),
 claseMagica BOOLEAN
);

CREATE TABLE Armas (
 idArma INT PRIMARY KEY,
 nombre VARCHAR(30),
 peso INT,
 tamaño VARCHAR(25),
 precio INT
);

CREATE TABLE Suministros (
 idSuministro INT PRIMARY KEY,
 Alimentos VARCHAR(30),
 PocionesCuracion VARCHAR(30),
 MaterialesAlquimia VARCHAR(30)
);

CREATE TABLE Equipamiento (
 idEquipamiento INT PRIMARY KEY,
 Suministros VARCHAR(30),
 CONSTRAINT fk_suministros FOREIGN KEY (Suministros) REFERENCES Suministros(idSuministro)
);

CREATE TABLE Personaje (
 token INT PRIMARY KEY,
 nombre VARCHAR(20),
 nivel INT,
 raza INT,
 clase INT,
 arma INT,
 atributos VARCHAR(20),
 CONSTRAINT fk_raza FOREIGN KEY (raza) REFERENCES Razas(idRaza),
 CONSTRAINT fk_clase FOREIGN KEY (clase) REFERENCES Clases(idClase),
 CONSTRAINT fk_arma FOREIGN KEY (arma) REFERENCES Armas(idArma)
);

CREATE TABLE Jugable (
 idJugable INT PRIMARY KEY,
 jugador VARCHAR(20),
 clase INT,
 equipo INT,
 oro INT,
 CONSTRAINT fk_equipo FOREIGN KEY (equipo) REFERENCES Equipamiento(idEquipamiento),
 CONSTRAINT fk_idJugable FOREIGN KEY (idJugable) REFERENCES Personaje(token)
);

CREATE TABLE NoJugable (
 idNoJugable INT PRIMARY KEY,
 legendario BOOLEAN,
 resistencia VARCHAR(20),
 CONSTRAINT fk_idNoJugable FOREIGN KEY (idNoJugable) REFERENCES Personaje(token)
);

CREATE TABLE Mazmorras (
 idMazmorra INT PRIMARY KEY
);

CREATE TABLE Mazmorra_tiene_salas (
 idMazmorra INT,
 idSala INT,
 dificultad VARCHAR(20),
 PRIMARY KEY (idMazmorra, idSala)
);

CREATE TABLE Salas (
 idSala INT PRIMARY KEY,
 desafioSala INT,
 CONSTRAINT fk_desafioSala FOREIGN KEY (desafioSala) REFERENCES Desafio(idDesafio)
);

CREATE TABLE Desafio (
 idDesafio INT PRIMARY KEY
);

CREATE TABLE Acertijo (
 idAcertijo INT PRIMARY KEY,
 CONSTRAINT fk_acertijo FOREIGN KEY (idAcertijo) REFERENCES Desafio(idDesafio)
);

CREATE TABLE Tesoro (
 idTesoro INT PRIMARY KEY,
 tesoroObtenido VARCHAR(25),
 CONSTRAINT fk_tesoro FOREIGN KEY (idTesoro) REFERENCES Desafio(idDesafio)
);

CREATE TABLE Combate (
 idCombate INT PRIMARY KEY,
 enemigo INT,
 CONSTRAINT fk_combate FOREIGN KEY (enemigo) REFERENCES NoJugable(idNoJugable)
);

CREATE TABLE Dados (
 idDado INT PRIMARY KEY,
 valor INT
);



INSERT INTO Razas (idRaza, nombre, edad, velocidad, idioma, visionOscuridad, tamaño)
VALUES (1, 'Elfo', 750, 30, 'Élfico', TRUE, 'Mediano'),
       (2, 'Enano', 350, 25, 'Enano', TRUE, 'Pequeño');


INSERT INTO Clases (idClase, nombre, rol, claseMagica)
VALUES (1, 'Guerrero', 'Tanque', FALSE),
       (2, 'Mago', 'DPS', TRUE);


INSERT INTO Armas (idArma, nombre, peso, tamaño, precio)
VALUES (1, 'Espada Larga', 3, 'Grande', 50),
       (2, 'Varita', 1, 'Pequeño', 30);


INSERT INTO Suministros (idSuministro, Alimentos, PocionesCuracion, MaterialesAlquimia)
VALUES (1, 'Pan', 'Poción Menor', 'Hierbas Mágicas'),
       (2, 'Carne', 'Poción Mayor', 'Cristales Alquímicos');

INSERT INTO Equipamiento (idEquipamiento, Suministros)
VALUES (1, '1'),
       (2, '2');

INSERT INTO Personaje (token, nombre, nivel, raza, clase, arma, atributos)
VALUES (1, 'Alduin', 20, 1, 1, 1, 'Fuerza, Agilidad'),
       (2, 'Gandalf', 30, 2, 2, 2, 'Inteligencia, Sabiduría');

INSERT INTO Jugable (idJugable, jugador, clase, equipo, oro)
VALUES (1, 'Player1', 1, 1, 100),
       (2, 'Player2', 2, 2, 200);

INSERT INTO NoJugable (idNoJugable, legendario, resistencia)
VALUES (3, TRUE, 'Alta'),
       (4, FALSE, 'Media');

INSERT INTO Mazmorras (idMazmorra)
VALUES (1),
       (2);

INSERT INTO Mazmorra_tiene_salas (idMazmorra, idSala, dificultad)
VALUES (1, 1, 'Difícil'),
       (2, 2, 'Media');

INSERT INTO Salas (idSala, desafioSala)
VALUES (1, 1),
       (2, 2);

INSERT INTO Desafio (idDesafio)
VALUES (1),
       (2);

INSERT INTO Acertijo (idAcertijo)
VALUES (1);

INSERT INTO Tesoro (idTesoro, tesoroObtenido)
VALUES (1, 'Espada Legendaria'),
       (2, 'Bolsa de Oro'),
       (3, 'Escudo de metal');

INSERT INTO Combate (idCombate, enemigo)
VALUES (1, 3),
       (2, 4);

INSERT INTO Dados (idDado, valor)
VALUES (1, 20),
	   (2, 100),
	   (3, 10),
	   (4, 12),
	   (5, 8),
       (6, 6),
       (7, 4);
       
       
-- ----------- -----------------------------------

-- Sentencias multitabla 

/* Esta consulta selecciona el nombre y nivel de los personajes cuyo nivel es mayor que el nivel promedio de todos los personajes. */
SELECT nombre, nivel
FROM Personaje
WHERE nivel > (SELECT AVG(nivel) FROM Personaje);

/* Esta consulta selecciona el nombre de los personajes y su raza para los personajes con el nivel*/
SELECT Personaje.nombre, Raza.nombre AS Raza
FROM Personaje
JOIN Razas ON Personaje.raza = Raza.idRaza
WHERE Personaje.nivel = (SELECT MAX(nivel) FROM Personaje);


/* Esta consulta cuenta el número de personajes en cada clase y agrupa los resultados por nombre de la clase. */
SELECT Clase.nombre AS Clase, COUNT(Personaje.token) AS NumeroPersonajes
FROM Personaje 
JOIN Clases ON Personaje.clase = Clase.idClase
GROUP BY Clase.nombre;

/* Esta consulta obtiene el nombre y la clase de los personajes que pertenecen a la raza "Elfo".*/
SELECT Personaje.nombre, Clases.nombre AS Clase
FROM Personaje 
JOIN Clases ON Personaje.clase = Clases.idClase
WHERE Personaje.raza = (SELECT idRaza FROM Razas WHERE nombre = 'Elfo');

/*Esta consulta cuenta el número de personajes por raza, agrupando los resultados por nombre de la raza.*/
SELECT Razas.nombre AS Raza, COUNT(Personaje.token) AS NumeroPersonajes
FROM Personaje 
JOIN Razas ON Personaje.raza = Razas.idRaza
GROUP BY Razas.nombre;


/*Esta actualización sube de nivel a los personajes cuyo oro sea superior a 150*/
UPDATE Personaje
SET nivel = nivel + 1
WHERE token IN (SELECT idJugable FROM Jugable WHERE oro > 150);


/*Esta actualización aumenta el nivel en 10 a los personaje No Jugables Legendarios*/
UPDATE Personaje 
JOIN NoJugable ON Personaje.token = NoJugable.idNoJugable
SET Personaje.nivel = Personaje.nivel + 10
WHERE NoJugable.legendario = TRUE;


/*Esta actualización borra los personajes de clase Guerrero*/

DELETE FROM Personaje
WHERE token IN (SELECT idJugable FROM Jugable WHERE clase = (SELECT idClase FROM Clases WHERE nombre = 'Guerrero'));



-- Vistas

/*Vista para personajes con sus clases y equipamientos*/

CREATE VIEW VistaPersonajesEquipados AS
SELECT Personaje.nombre AS Personaje, Clases.nombre AS Clase, Equipamiento.Suministros AS Equipamiento
FROM Personaje 
JOIN Clases ON Personaje.clase = Clases.idClase
JOIN Jugable ON Personaje.token = Jugable.idJugable
JOIN Equipamiento e ON Jugable.equipo = Equipamiento.idEquipamiento;


/*Esta vista muestra los desafíos y las salas correspondientes en las que se encuentran, junto con la información de la mazmorra a la que pertenecen.
*/

CREATE VIEW VistaDesafiosSalas AS SELECT DEsafio.idDesafio, Desafiop.nombre AS Desafio, Salas.idSala, Salas.desafioSala AS DesafioEnSala, Mazmorras.idMazmorra, Mazmorras.dificultad
FROM Desafio 
JOIN Salas ON Desafio.idDesafio = Salas.desafioSala
JOIN Mazmorras ON Salas.idMazmorra = Mazmorras.idMazmorra;


-- Funciones/Procedimientos

/*Procedimiento que actualiza un equipo*/

DELIMITER $$
CREATE PROCEDURE ActualizarEquipoJugador (IN NuevoIdJugable INT,IN nuevoEquipo INT)
BEGIN
    UPDATE Jugable
    SET equipo = nuevoEquipo
    WHERE idJugable = NuevoIdJugable;
END $$
DELIMITER ;


/*Procedimiento que borra a un jugador y sus personajes*/
DELIMITER $$
CREATE PROCEDURE EliminarJugador (IN jugadorNombre VARCHAR(20))
BEGIN
    DELETE FROM Jugable WHERE jugador = jugador_nombre;
    DELETE FROM Personaje WHERE token NOT IN (SELECT idJugable FROM Jugable);
END $$
DELIMITER ;


/*Esta función calcula el valor del equipo de un personaje*/
DELIMITER $$
CREATE FUNCTION ValorEquipamientoJugador(jugadorNombre VARCHAR(20)) RETURNS INT
BEGIN
    DECLARE totalvalor INT;
    SELECT SUM(Armas.precio)
    INTO totalValor
    FROM Jugable 
    JOIN Personaje ON Jugable.idJugable = Personaje.token
    JOIN Armas ON Personaje.arma = Armas.idArma
    WHERE Jugable.jugador = jugadorNombre;
    RETURN totalValor;
END $$
DELIMITER ;

/**/

/**/
