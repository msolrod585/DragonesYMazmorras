package tests;

import java.sql.SQLException;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Juego.Armas;
import auxiliar.ArmaDAO;

public class ArmaDAOTest {

    @Test
    public void testLeerArmas() {
        try {
            List<Armas> armas = ArmaDAO.leerArmas();
            Assertions.assertNotNull(armas);
            Assertions.assertFalse(armas.isEmpty()); 
        } catch (SQLException | ClassNotFoundException e) {
            Assertions.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Test
    public void testLeerUnaArma() {
        int idRaza = 1;
        try {
            Armas arma = ArmaDAO.leerUnaArma(idRaza);
            Assertions.assertNotNull(arma);
        } catch (SQLException | ClassNotFoundException e) {
            Assertions.fail("Exception occurred: " + e.getMessage());
        }
    }
}
