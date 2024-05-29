package auxiliar;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

import Juego.Combate;
import Juego.Mazmorra;

public class MazmorraDAO {
    public List<Mazmorra> leerMazmorras() throws ClassNotFoundException, SQLException {
        List<Mazmorra> mazmorras = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/dragonesymazmorras", "root", "Msguez2003");
            String query = "SELECT * FROM mazmorras";
            Statement ps = con.createStatement();
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()) {
                Mazmorra mazmorra = new Mazmorra();

                List<Combate> combates = CombateDAO.leerCombatesPorMazmorra(rs.getInt("idMazmorra"));

                mazmorra.setNumSalas(rs.getInt("numSalas"));
                mazmorra.setDificultad(rs.getString("dificultad"));
                mazmorra.setNivelMinimo(rs.getInt("nivelMinimo"));
                mazmorra.setCombates(combates);
                mazmorras.add(mazmorra);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al leer las mazmorras: " + e.getMessage());
        }
        return mazmorras;
    }
}
