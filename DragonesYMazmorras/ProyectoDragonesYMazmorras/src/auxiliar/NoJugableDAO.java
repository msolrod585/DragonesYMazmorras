package auxiliar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Juego.Armas;
import Juego.Atributo;
import Juego.NoJugable;
import Juego.Raza;
import basededatos.DatabaseConnection;


public class NoJugableDAO {
    public static List<NoJugable> leerNoJugables() throws ClassNotFoundException, SQLException{
        List<NoJugable> noJugables = new ArrayList<NoJugable>();
        try {
        	Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM NoJugable LEFT JOIN Personaje ON NoJugable.idNoJugable = Personaje.token";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
            	Armas arma = ArmaDAO.leerUnaArma(rs.getInt("arma"));
                Raza raza = RazaDAO.leerUnaRaza(rs.getInt("raza"));
                Atributo atributo = AtributosDAO.leerAtributos(rs.getInt("atributos"));

                NoJugable noJugable = new NoJugable();
                noJugable.setNombre(rs.getString("nombre"));
                noJugable.setNivel(rs.getInt("nivel"));
                noJugable.setRaza(raza);
                noJugable.setArma(arma);
                noJugable.setAtributo(atributo);
                noJugable.setLegendario(rs.getBoolean("legendario"));
                noJugable.setResistencia(rs.getString("resistencia"));
                noJugables.add(noJugable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noJugables;
    }

    public static NoJugable leerUnNoJugable(int idNoJugable) throws ClassNotFoundException, SQLException{
        List<NoJugable> noJugables = new ArrayList<NoJugable>();
        try {
        	Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM NoJugable LEFT JOIN Personaje ON NoJugable.idNoJugable = Personaje.token WHERE NoJugable.idNoJugable = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idNoJugable);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Armas arma = ArmaDAO.leerUnaArma(rs.getInt("arma"));
                Raza raza = RazaDAO.leerUnaRaza(rs.getInt("raza"));
                Atributo atributo = AtributosDAO.leerAtributos(rs.getInt("atributos"));

                NoJugable noJugable = new NoJugable();
                noJugable.setNombre(rs.getString("nombre"));
                noJugable.setNivel(rs.getInt("nivel"));
                noJugable.setRaza(raza);
                noJugable.setArma(arma);
                noJugable.setAtributo(atributo);
                noJugable.setLegendario(rs.getBoolean("legendario"));
                noJugable.setResistencia(rs.getString("resistencia"));
                noJugables.add(noJugable);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return noJugables.get(0);
    }
}
