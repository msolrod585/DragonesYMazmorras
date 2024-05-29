package auxiliar;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Juego.Armas;
import basededatos.DatabaseConnection;

public class ArmaDAO {
    public static List<Armas> leerArmas() throws SQLException, ClassNotFoundException{
        List<Armas> armas = new ArrayList<>();
        try {
        	Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM armas";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                Armas arma = new Armas();
                arma.setId(rs.getInt("idArma"));
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
        	Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM armas WHERE idArma = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idRaza);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Armas arma = new Armas();
                arma.setId(rs.getInt("idArma"));
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
