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
    
    public static int insertarAtributos(Atributo atributo) throws SQLException, ClassNotFoundException {
        String query = "INSERT INTO Atributos (fuerza, destreza, constitucion, inteligencia, sabiduria, carisma) VALUES (?, ?, ?, ?, ?, ?)";
        int idGenerado = 0;
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, atributo.getFuerza());
            ps.setInt(2, atributo.getDestreza());
            ps.setInt(3, atributo.getConstitucion());
            ps.setInt(4, atributo.getInteligencia());
            ps.setInt(5, atributo.getSabiduria());
            ps.setInt(6, atributo.getCarisma());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    idGenerado = rs.getInt(1);
                    atributo.setId(idGenerado);
                }
            }

            System.out.println("Atributos insertados correctamente con ID: " + atributo.getId());

        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return idGenerado;
    }

    
    
}
