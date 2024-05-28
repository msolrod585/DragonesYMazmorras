package Juego;

import java.util.List;

public class Mazmorra {
    private int numSalas;
    private final static String[] dificutades = {"Facil", "Medio", "Dificil", "Pesadilla"};
    private String dificultad;
    private List <Desafio> desafios;
    private int nivelMinimo;

    public Mazmorra() {
    }

    public Mazmorra(int numSalas, String dificultad,List<Desafio> desafios, int nivelMinimo) {
        this.numSalas = numSalas;
        this.dificultad = dificultad;
        this.desafios=desafios;
        this.nivelMinimo = nivelMinimo;
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

    public int getNivelMinimo() {
        return nivelMinimo;
    }

    public void setNivelMinimo(int nivelMinimo) {
        this.nivelMinimo = nivelMinimo;
    }

}
