package auxiliar;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import Juego.Combate;
import Juego.NoJugable;

public class CombateDAO {
    public static List<Combate> leerCombatesPorMazmorra(int idMazmorra) throws ClassNotFoundException, SQLException {
        List<Combate> combates = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dragonesymazmorras", "root", "Msguez2003");
            String query = "SELECT * FROM combates WHERE mazmorra = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, idMazmorra);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Combate combate = new Combate();

                NoJugable enemigo = NoJugableDAO.leerUnNoJugable(rs.getInt("enemigo"));

                combate.setEnemigo(enemigo);
                combates.add(combate);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer los combates: " + e.getMessage());
        }
        return combates;
    }
}
