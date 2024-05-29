DROP DATABASE IF EXISTS DyD;
CREATE DATABASE DyD CHARACTER SET utf8mb4;
USE DyD;

CREATE TABLE Razas (
 idRaza INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(30),
 edad INT,
 velocidad INT,
 idioma VARCHAR(20),
 visionOscuridad BOOLEAN,
 tamaño VARCHAR(20)
);

CREATE TABLE Clases (
 idClase INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(30),
 rol VARCHAR(20),
 claseMagica BOOLEAN
);

CREATE TABLE Atributos (
 idSetAtributos INT PRIMARY KEY AUTO_INCREMENT,
 fuerza INT default 10,
 destreza INT default 10,
 constitucion INT default 10,
 inteligencia INT  default 10,
 sabiduria INT default 10,
 carisma INT default 10
);

CREATE TABLE Armas (
 idArma INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(30),
 peso INT,
 tamaño VARCHAR(25),
 precio INT
);

CREATE TABLE Personaje (
 token INT PRIMARY KEY AUTO_INCREMENT,
 nombre VARCHAR(20),
 nivel INT,
 raza INT,
 arma INT,
 atributos int,
 CONSTRAINT fk_raza FOREIGN KEY (raza) REFERENCES Razas(idRaza),
 CONSTRAINT fk_arma FOREIGN KEY (arma) REFERENCES Armas(idArma),
 CONSTRAINT fk_atributos FOREIGN KEY (atributos) REFERENCES Atributos(idSetAtributos)
);

CREATE TABLE Jugable (
 idJugable INT PRIMARY KEY AUTO_INCREMENT,
 jugador VARCHAR(20),
 clase INT,
 oro INT,
 CONSTRAINT fk_clase FOREIGN KEY (clase) REFERENCES Clases(idClase),
 CONSTRAINT fk_idJugable FOREIGN KEY (idJugable) REFERENCES Personaje(token)
);

CREATE TABLE NoJugable (
 idNoJugable INT PRIMARY KEY AUTO_INCREMENT,
 legendario BOOLEAN,
 resistencia VARCHAR(20),
 CONSTRAINT fk_idNoJugable FOREIGN KEY (idNoJugable) REFERENCES Personaje(token)
);

CREATE TABLE Mazmorras (
 idMazmorra INT PRIMARY KEY AUTO_INCREMENT,
 numSalas INT,
 dificultad VARCHAR(20)
);


CREATE TABLE Combate (
 idCombate INT PRIMARY KEY,
 enemigo INT,
 mazmorra INT,
 CONSTRAINT fk_combate FOREIGN KEY (enemigo) REFERENCES NoJugable(idNoJugable)
);


INSERT INTO Razas (idRaza, nombre, edad, velocidad, idioma, visionOscuridad, tamaño)
VALUES (1, 'Elfo', 100, 30, 'Élfico', TRUE, 'Mediano'),
(2, 'Enano', 150, 20, 'Enánico', FALSE, 'Pequeño'),
(3, 'Humano', 80, 40, 'Común', FALSE, 'Mediano'),
(4, 'Orco', 60, 35, 'Orco', FALSE, 'Grande'),
(5, 'Hada', 200, 25, 'Feérico', TRUE, 'Pequeño'),
(6, 'Gnomo', 120, 20, 'Gnómico', FALSE, 'Pequeño'),
(7, 'Troll', 40, 25, 'Trol', FALSE, 'Grande'),
(8, 'Dragón', 1000, 50, 'Dragónico', TRUE, 'Enorme'),
(9, 'Naga', 300, 40, 'Nagático', TRUE, 'Grande'),
(10, 'Elfo Oscuro', 120, 35, 'Élfico Oscuro', TRUE, 'Mediano');


INSERT INTO Clases (idClase, nombre, rol, claseMagica)
VALUES (1, 'Guerrero', 'Tanque', FALSE),
       (2, 'Mago', 'DPS', TRUE);

INSERT INTO Atributos (idSetAtributos, fuerza, destreza, constitucion, inteligencia, sabiduria, carisma) VALUES 
(1,12, 14, 10, 8, 10, 16),
(2,10, 12, 14, 16, 10, 10),
(3,15, 10, 10, 12, 14, 8),
(4,8, 10, 12, 14, 16, 10),
(5,10, 10, 10, 10, 10, 10),
(6,12, 14, 10, 8, 10, 16),
(7,10, 12, 14, 16, 10, 10),
(8,15, 10, 10, 12, 14, 8),
(9,8, 10, 12, 14, 16, 10),
(10,10, 10, 10, 10, 10, 10),
(11,10, 12, 14, 16, 10, 10),
(12,15, 10, 10, 12, 14, 8);

INSERT INTO Armas (idArma, nombre, peso, tamaño, precio)
VALUES (1, 'Espada', 10, 100, 50),
(2, 'Arco', 5, 80, 30),
(3, 'Daga', 3, 50, 20),
(4, 'Hacha', 12, 120, 60),
(5, 'Martillo', 15, 150, 70),
(6, 'Maza', 14, 140, 65),
(7, 'Ballesta', 8, 90, 40),
(8, 'Espada Larga', 18, 180, 80),
(9, 'Lanza', 10, 100, 55),
(10, 'Báculo', 6, 70, 25),
(11, 'Bastón', 7, 75, 35),
(12, 'Espadón', 20, 200, 90);


INSERT INTO Personaje (token, nombre, nivel, raza, arma, atributos)
VALUES 
(1, 'Alduin', 20, 1, 1, 1),
(2, 'Gandalf', 20, 2, 2, 4),
(3, 'Legolas', 20, 1, 3, 2),
(4, 'Aragorn', 20, 3, 4, 3),
(5, 'Frodo', 15, 4, 5, 5),
(6, 'Gimli', 20, 2, 6, 6),
(7, 'Thranduil', 20, 1, 7, 7),
(8, 'Boromir', 18, 3, 8, 8),
(9, 'Saruman', 20, 5, 9, 9),
(10, 'Sauron', 20, 6, 10, 10),
(11, 'Galadriel', 20, 1, 11, 11),
(12, 'Elrond', 20, 1, 12, 12);

INSERT INTO Jugable (idJugable, jugador, clase, oro)
VALUES 
(1, 'Player1', 1, 100),
(2, 'Player2', 2, 200);


INSERT INTO NoJugable (idNoJugable, legendario, resistencia)
VALUES 
(3, TRUE, 'Alta'),
(4, FALSE, 'Media'),
(5,FALSE,'Fuego'),
(6,TRUE,'Hielo');

INSERT INTO Mazmorras (idMazmorra)
VALUES (1),
       (2);

INSERT INTO Combate (idCombate, enemigo, mazmorra)
VALUES (1,3, 3),
       (2,4, 4);
       


       
-- ----------- -----------------------------------

-- Sentencias multitabla 

/* Esta consulta selecciona el nombre y nivel de los personajes cuyo nivel es mayor que el nivel promedio de todos los personajes. */
SELECT nombre, nivel
FROM Personaje
WHERE nivel > (SELECT AVG(nivel) FROM Personaje);

/* Esta consulta selecciona el nombre de los personajes y su raza para los personajes con el nivel*/
SELECT Personaje.nombre, Razas.nombre AS Raza
FROM Personaje
JOIN Razas ON Personaje.raza = Razas.idRaza
WHERE Personaje.nivel = (SELECT MAX(nivel) FROM Personaje);


/* Esta consulta cuenta el número de personajes en cada clase y agrupa los resultados por nombre de la clase. */

/* Esta consulta obtiene el nombre y la clase de los personajes que pertenecen a la raza "Elfo".*/

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



-- Vistas

/*Vista para personajes con sus clases y equipamientos*/



/*Esta vista muestra los desafíos y las salas correspondientes en las que se encuentran, junto con la información de la mazmorra a la que pertenecen.
*/



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
