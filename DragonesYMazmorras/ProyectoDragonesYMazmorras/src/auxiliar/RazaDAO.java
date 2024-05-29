package auxiliar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Juego.Raza;
import basededatos.DatabaseConnection;

public class RazaDAO {
    public static List<Raza> leerRazas() throws SQLException, ClassNotFoundException{
        List<Raza> razas = new ArrayList<>();
        try {
        	Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM razas";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                Raza raza = new Raza();
                raza.setNombre(rs.getString("nombre"));
                raza.setEdad(rs.getInt("edad"));
                raza.setVelocidad(rs.getInt("velocidad"));
                raza.setIdioma(rs.getString("idioma"));
                raza.setVisionOscuridad(rs.getBoolean("visionOscuridad"));
                raza.setTamanio(rs.getString("tamaño"));
                razas.add(raza);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer las razas: " + e.getMessage());
        }
        return razas;
    }


    public static Raza leerUnaRaza(int idRaza) throws SQLException, ClassNotFoundException{
        List<Raza> razas = new ArrayList<>();
        try {
        	Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM razas WHERE idRaza = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idRaza);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Raza raza = new Raza();
                raza.setNombre(rs.getString("nombre"));
                raza.setEdad(rs.getInt("edad"));
                raza.setVelocidad(rs.getInt("velocidad"));
                raza.setIdioma(rs.getString("idioma"));
                raza.setVisionOscuridad(rs.getBoolean("visionOscuridad"));
                raza.setTamanio(rs.getString("tamaño"));
                razas.add(raza);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer las razas: " + e.getMessage());
        }
        return razas.get(0);
    }
}
