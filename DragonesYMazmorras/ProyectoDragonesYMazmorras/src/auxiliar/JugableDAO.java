package auxiliar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Juego.Jugable;
import Juego.Armas;
import Juego.Atributo;
import Juego.Clase;
import Juego.Raza;
import basededatos.DatabaseConnection;

public class JugableDAO {

    public static List<Jugable> leerJugables() throws ClassNotFoundException, SQLException {
        List<Jugable> jugables = new ArrayList<>();
        String query = "SELECT * FROM Jugable LEFT JOIN Personaje ON Jugable.idJugable = Personaje.token";
        
        try (Connection con = DatabaseConnection.getConnection();
             Statement ps = con.createStatement();
             ResultSet rs = ps.executeQuery(query)) {
             
            while (rs.next()) {
                Armas arma = ArmaDAO.leerUnaArma(rs.getInt("arma"));
                Raza raza = RazaDAO.leerUnaRaza(rs.getInt("raza"));
                Atributo atributo = AtributosDAO.leerAtributos(rs.getInt("atributos"));
                Clase clase = ClaseDAO.leerClases(rs.getInt("clase"));

                Jugable jugable = new Jugable();
                jugable.setId(rs.getInt("idJugable"));
                jugable.setNombre(rs.getString("nombre"));
                jugable.setNivel(rs.getInt("nivel"));
                jugable.setRaza(raza);
                jugable.setArma(arma);
                jugable.setAtributo(atributo);
                jugable.setJugador(rs.getString("jugador"));
                jugable.setClase(clase);
                jugables.add(jugable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return jugables;
    }

    public static void insertarJugable(Jugable jugable) throws SQLException, ClassNotFoundException {
        String queryPersonaje = "INSERT INTO Personaje (nombre, nivel, raza, arma, atributos) VALUES (?, ?, ?, ?, ?)";
        String queryJugable = "INSERT INTO Jugable (idJugable, jugador, clase, oro) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement psPersonaje = con.prepareStatement(queryPersonaje, Statement.RETURN_GENERATED_KEYS);
             PreparedStatement psJugable = con.prepareStatement(queryJugable)) {
            
            int idAtributos = AtributosDAO.insertarAtributos(jugable.getAtributo());

            // Insertar en la tabla Personaje
            psPersonaje.setString(1, jugable.getNombre());
            psPersonaje.setInt(2, jugable.getNivel());
            psPersonaje.setInt(3, jugable.getRaza().getId());
            psPersonaje.setInt(4, jugable.getArma().getId());
            psPersonaje.setInt(5, idAtributos);
            psPersonaje.executeUpdate();

            // Obtener el ID generado para el personaje
            try (ResultSet rs = psPersonaje.getGeneratedKeys()) {
                if (rs.next()) {
                    int personajeId = rs.getInt(1);

                    // Insertar en la tabla Jugable
                    psJugable.setInt(1, personajeId);
                    psJugable.setString(2, jugable.getJugador());
                    psJugable.setInt(3, jugable.getClase().getId());
                    psJugable.setInt(4, jugable.getOro());
                    psJugable.executeUpdate();
                } else {
                    throw new SQLException("Error al obtener el ID generado para el personaje.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    // Método de ayuda para verificar la existencia de un valor en una tabla
    private static boolean existeEnTabla(Connection con, String tabla, String columna, int valor) throws SQLException {
        String query = "SELECT COUNT(*) FROM " + tabla + " WHERE " + columna + " = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, valor);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }


    public static void actualizarJugable(Jugable jugable) throws SQLException, ClassNotFoundException {
        String queryPersonaje = "UPDATE Personaje SET nombre = ?, nivel = ?, raza = ?, arma = ?, atributos = ? WHERE token = ?";
        String queryJugable = "UPDATE Jugable SET jugador = ?, clase = ?, oro = ? WHERE idJugable = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement psPersonaje = con.prepareStatement(queryPersonaje);
             PreparedStatement psJugable = con.prepareStatement(queryJugable)) {

            // Actualizar en la tabla Personaje
            psPersonaje.setString(1, jugable.getNombre());
            psPersonaje.setInt(2, jugable.getNivel());
            psPersonaje.setInt(3, jugable.getRaza().getId());
            psPersonaje.setInt(4, jugable.getArma().getId());
            psPersonaje.setInt(5, jugable.getAtributo().getId());
            psPersonaje.setInt(6, jugable.getId());
            psPersonaje.executeUpdate();

            // Actualizar en la tabla Jugable
            psJugable.setString(1, jugable.getJugador());
            psJugable.setInt(2, jugable.getClase().getId());
            psJugable.setInt(3, jugable.getOro());
            psJugable.setInt(4, jugable.getId());
            psJugable.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public static void borrarJugable(Jugable jugable) throws SQLException, ClassNotFoundException {
        String queryJugable = "DELETE FROM Jugable WHERE idJugable = ?";
        String queryPersonaje = "DELETE FROM Personaje WHERE token = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement psJugable = con.prepareStatement(queryJugable);
             PreparedStatement psPersonaje = con.prepareStatement(queryPersonaje)) {

            // Borrar de la tabla Jugable
            psJugable.setInt(1, jugable.getId());
            psJugable.executeUpdate();

            // Borrar de la tabla Personaje
            psPersonaje.setInt(1, jugable.getId());
            psPersonaje.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
