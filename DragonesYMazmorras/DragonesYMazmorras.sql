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

INSERT INTO Mazmorras (idMazmorra, dificultad, numSalas)
VALUES (3, "Fácil", 2),
		(4, "Medio", 3),
		(5, "Dificil", 6),
		(7, "Pesadilla", 10);

INSERT INTO Combate (idCombate, enemigo, mazmorra)
VALUES(1,3, 3),
(2, 3, 3),
(3, 4, 4),
(4, 4, 4),
(5, 5, 4),
(6, 5, 5),
(7, 5, 5),
(8, 5, 5),
(9, 6, 5),
(10,6, 5),
(11, 6, 7),
(12, 6, 7),
(13, 6, 7),
(14, 6, 7),
(15, 5, 7),
(16, 5, 7),
(17, 5, 7),
(18, 3, 7),
(19, 3, 7),
(20, 3, 7),
(21, 3, 7);
       


       
-- ----------- -----------------------------------

-- Consultas

-- Mostrar el nombre y el rol de todos los personajes jugables, junto con el nombre de su jugador y la cantidad de oro que poseen:

SELECT p.nombre AS nombre_personaje, c.nombre AS rol, j.jugador, j.oro 
FROM Personaje p 
JOIN Jugable j ON p.token = j.idJugable 
JOIN Clases c ON j.clase = c.idClase;

-- Recuperar el nombre y la resistencia de todos los enemigos legendarios:

SELECT NoJugable.idNoJugable, Personaje.nombre, NoJugable.resistencia
FROM NoJugable
JOIN Personaje ON NoJugable.idNoJugable = Personaje.token
WHERE legendario = TRUE;



-- Listar todos los personajes jugables con su nombre, clase y oro disponible
SELECT p.nombre AS Nombre_Personaje, c.nombre AS Clase, j.oro AS Oro_Disponible
FROM Personaje p
JOIN Jugable j ON p.token = j.idJugable
JOIN Clases c ON j.clase = c.idClase;

-- Obtener el nombre y tamaño de todas las armas con un precio superior a 50

SELECT nombre, tamaño
FROM Armas
WHERE precio > 50;


-- Listar todos los personajes jugables y sus clases junto con el nombre de sus jugadores:
SELECT p.nombre AS Nombre_Personaje, c.nombre AS Clase, j.jugador AS Jugador
FROM Personaje p
JOIN Jugable j ON p.token = j.idJugable
JOIN Clases c ON j.clase = c.idClase;


-- Actualizar el nombre de un personaje no jugable y aumentar en 5 su nivel
UPDATE Personaje
SET nombre = CONCAT(nombre, ' el Poderoso'), -- Nuevo nombre
    nivel = nivel + 5 
WHERE token = 10; 


-- Actualizar el nombre de un personaje y su nivel incrementando en 1 el nivel actual
UPDATE Personaje
SET nombre = CONCAT(nombre, ' II'), 
    nivel = nivel + 1 
WHERE token = 4;


-- Eliminar todas las referencias de un personaje no jugable en los combates y luego eliminar el personaje no jugable:
DELETE FROM Combate
WHERE enemigo IN (SELECT idNoJugable FROM NoJugable WHERE idNoJugable = 6);
DELETE FROM NoJugable
WHERE idNoJugable = 6;

-- Vistas
-- Vista para mostrar nombres de personajes y sus razas:

CREATE VIEW VistaPersonajesRazas AS
SELECT 
    Personaje.nombre AS Nombre_Personaje,
    Razas.nombre AS Raza
FROM Personaje 
JOIN Razas ON Personaje.raza = Razas.idRaza;



-- Vista para mostrar nombres de personajes y sus armas

CREATE VIEW VistaPersonajesArmas AS
SELECT 
    Personaje.nombre AS Nombre_Personaje,
    Armas.nombre AS Arma
FROM Personaje 
JOIN Armas ON Personaje.arma = Armas.idArma;





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

/*Trigger para asegurar que el nivel de un personaje nunca se introduzca como negativo:*/

DELIMITER $$

CREATE TRIGGER before_insert_personaje
BEFORE INSERT ON Personaje
FOR EACH ROW
BEGIN
    IF NEW.nivel < 0 THEN
        SET NEW.nivel = 0;
    END IF;
END $$

DELIMITER ;


/*Trigger para actualizar la cantidad de oro de un personaje jugable después de actualizar su nivel en la tabla Personaje*/

DELIMITER $$

CREATE TRIGGER AfterUpdatePersonaje
AFTER UPDATE ON Personaje
FOR EACH ROW
BEGIN
    DECLARE oroIncremento INT;
    IF NEW.nivel > OLD.nivel THEN
        SET oroIncremento = (NEW.nivel - OLD.nivel) * 10;
        UPDATE Jugable
        SET oro = oro + oroIncremento
        WHERE idJugable = NEW.token;
    END IF;
END $$

DELIMITER ;
