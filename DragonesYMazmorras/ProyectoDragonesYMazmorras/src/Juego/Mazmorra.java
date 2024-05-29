package Juego;

import java.util.List;

public class Mazmorra {
    private int numSalas;
    private final static String[] dificutades = {"Facil", "Medio", "Dificil", "Pesadilla"};
    private String dificultad;
    private List <Combate> combates;


    public Mazmorra() {
    }

    public Mazmorra(int numSalas, String dificultad,List<Combate> combates) {
        this.numSalas = numSalas;
        this.dificultad = dificultad;
        this.combates=combates;
    }


    public int getNumSalas() {
        return numSalas;
    }

    public void setNumSalas(int numSalas) {
        this.numSalas = numSalas;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }


    public List<Combate> getCombates() {
        return combates;
    }
    
    public void setCombates(List<Combate> combates) {
        this.combates = combates;
    }
}