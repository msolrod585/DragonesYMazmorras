package auxiliar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Juego.Armas;

public class ArmaDAO {
    public static List<Armas> leerArmas() throws SQLException, ClassNotFoundException{
        List<Armas> armas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dragonesymazmorras" , "root", "Msguez2003");
            String query = "SELECT * FROM armas";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                Armas arma = new Armas();
                arma.setNombre(rs.getString("nombre"));
                arma.setPeso(rs.getInt("peso"));
                arma.setTamanyo(rs.getInt("tamaño"));
                arma.setPrecio(rs.getInt("precio"));
                armas.add(arma);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer las armas: " + e.getMessage());
        }
        return armas;
    }


    public static Armas leerUnaArma(int idRaza) throws SQLException, ClassNotFoundException{
        List<Armas> armas = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("Meter el nombre de la base de datos" , "root", "Msguez2003");
            String query = "SELECT * FROM armas WHERE idRaza = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idRaza);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Armas arma = new Armas();
                arma.setNombre(rs.getString("nombre"));
                arma.setPeso(rs.getInt("peso"));
                arma.setTamanyo(rs.getInt("tamaño"));
                arma.setPrecio(rs.getInt("precio"));
                armas.add(arma);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer las armas: " + e.getMessage());
        }
        return armas.get(0);
    } 
        
}
