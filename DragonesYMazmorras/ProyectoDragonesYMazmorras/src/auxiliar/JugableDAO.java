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
    public static List<Jugable> leerJugables() throws ClassNotFoundException, SQLException{
        List<Jugable> jugables = new ArrayList<>();
        try {
        	Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM no_jugables";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                Armas arma = ArmaDAO.leerUnaArma(rs.getInt("arma"));
                Raza raza = RazaDAO.leerUnaRaza(rs.getInt("raza"));
                Atributo atributo = AtributosDAO.leerAtributos(rs.getInt("atributos"));
                Clase clase = ClaseDAO.leerClases(rs.getInt("clase"));

                Jugable jugable = new Jugable();
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
            String query = "INSERT INTO jugables (nombre, nivel, raza, arma, atributos, jugador, clase, oro) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, jugable.getNombre());
            ps.setInt(2, jugable.getNivel());
            ps.setInt(3, jugable.getRaza().getId());
            ps.setInt(4, jugable.getArma().getId());
            ps.setInt(5, jugable.getAtributo().getId());
            ps.setString(6, jugable.getJugador());
            ps.setInt(7, jugable.getClase().getId());
            ps.setInt(8, jugable.getOro());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void borrarJugable(Jugable jugable) throws SQLException, ClassNotFoundException {
        try {
        	Connection con = DatabaseConnection.getConnection();
            String query = "DELETE FROM jugables WHERE idJugable = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, jugable.getId());
            ps.executeUpdate();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
