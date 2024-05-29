package auxiliar;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import Juego.Atributo;
import basededatos.DatabaseConnection;

public class AtributosDAO {
    public static Atributo leerAtributos(int idSetAtributos) throws SQLException, ClassNotFoundException {
        List<Atributo> atributos = new ArrayList<>();
        try {
        	Connection con = DatabaseConnection.getConnection();
            String query = "SELECT * FROM atributos WHERE idSetAtributos = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idSetAtributos);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Atributo atributo = new Atributo();
                atributo.setId(rs.getInt("idSetAtributos"));
                atributo.setFuerza(rs.getInt("fuerza"));
                atributo.setDestreza(rs.getInt("destreza"));
                atributo.setConstitucion(rs.getInt("constitucion"));
                atributo.setInteligencia(rs.getInt("inteligencia"));
                atributo.setSabiduria(rs.getInt("sabiduria"));
                atributo.setCarisma(rs.getInt("carisma"));
                atributos.add(atributo);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer los atributos: " + e.getMessage());
        }
        return atributos.get(0);
    }
    
    
}
