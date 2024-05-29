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
        try {
            Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM Jugable LEFT JOIN Personaje ON Jugable.idJugable = Personaje.token";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
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
        try {
            Connection con = DatabaseConnection.getConnection();
            String queryPersonaje = "INSERT INTO Personaje (nombre, nivel, raza, arma, atributos) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement psPersonaje = con.prepareStatement(queryPersonaje, Statement.RETURN_GENERATED_KEYS);
            psPersonaje.setString(1, jugable.getNombre());
            psPersonaje.setInt(2, jugable.getNivel());
            psPersonaje.setInt(3, jugable.getRaza().getId());
            psPersonaje.setInt(4, jugable.getArma().getId());
            psPersonaje.setInt(5, jugable.getAtributo().getId());
            psPersonaje.executeUpdate();

            // Obtener el ID generado para el personaje
            ResultSet rs = psPersonaje.getGeneratedKeys();
            rs.next();
            int personajeId = rs.getInt(1);

            String queryJugable = "INSERT INTO Jugable (idJugable, jugador, clase, oro) VALUES (?, ?, ?, ?)";
            PreparedStatement psJugable = con.prepareStatement(queryJugable);
            psJugable.setInt(1, personajeId);
            psJugable.setString(2, jugable.getJugador());
            psJugable.setInt(3, jugable.getClase().getId());
            psJugable.setInt(4, jugable.getOro());
            psJugable.executeUpdate();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void actualizarJugable(Jugable jugable) throws SQLException, ClassNotFoundException {
        try {
            Connection con = DatabaseConnection.getConnection();

            String queryPersonaje = "UPDATE Personaje SET nombre = ?, nivel = ?, raza = ?, arma = ?, atributos = ? WHERE token = ?";
            PreparedStatement psPersonaje = con.prepareStatement(queryPersonaje);
            psPersonaje.setString(1, jugable.getNombre());
            psPersonaje.setInt(2, jugable.getNivel());
            psPersonaje.setInt(3, jugable.getRaza().getId());
            psPersonaje.setInt(4, jugable.getArma().getId());
            psPersonaje.setInt(5, jugable.getAtributo().getId());
            psPersonaje.setInt(6, jugable.getId());
            psPersonaje.executeUpdate();

            String queryJugable = "UPDATE Jugable SET jugador = ?, clase = ?, oro = ? WHERE idJugable = ?";
            PreparedStatement psJugable = con.prepareStatement(queryJugable);
            psJugable.setString(1, jugable.getJugador());
            psJugable.setInt(2, jugable.getClase().getId());
            psJugable.setInt(3, jugable.getOro());
            psJugable.setInt(4, jugable.getId());
            psJugable.executeUpdate();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void borrarJugable(Jugable jugable) throws SQLException, ClassNotFoundException {
        try {
            Connection con = DatabaseConnection.getConnection();

            String queryJugable = "DELETE FROM Jugable WHERE idJugable = ?";
            PreparedStatement psJugable = con.prepareStatement(queryJugable);
            psJugable.setInt(1, jugable.getId());
            psJugable.executeUpdate();

            String queryPersonaje = "DELETE FROM Personaje WHERE token = ?";
            PreparedStatement psPersonaje = con.prepareStatement(queryPersonaje);
            psPersonaje.setInt(1, jugable.getId());
            psPersonaje.executeUpdate();

            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
