package auxiliar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Juego.Clase;

public class ClaseDAO {
    public static List<Clase> leerClases() throws SQLException, ClassNotFoundException {
        List<Clase> clases = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dragonesymazmorras", "root", "Msguez2003");
            String query = "SELECT * FROM clases";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setNombre(rs.getString("nombre"));
                clase.setRol(rs.getString("rol"));
                clase.setClaseMagica(rs.getBoolean("claseMagica"));
                clases.add(clase);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer las clases: " + e.getMessage());
        }
        return clases;
    }


    public static Clase leerClases(int idClase) throws SQLException, ClassNotFoundException {
        List<Clase> clases = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("Meter el nombre de la base de datos", "root", "Msguez2003");
            String query = "SELECT * FROM clases WHERE idClase = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idClase);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setNombre(rs.getString("nombre"));
                clase.setRol(rs.getString("rol"));
                clase.setClaseMagica(rs.getBoolean("claseMagica"));
                clases.add(clase);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer las clases: " + e.getMessage());
        }
        return clases.get(0);
    }
}
