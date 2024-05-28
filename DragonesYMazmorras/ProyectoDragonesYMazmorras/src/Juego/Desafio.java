package Juego;

public abstract class Desafio {
    private int idDesafio;

    public Desafio() {
    }

    public Desafio(int idDesafio) {
        this.idDesafio = idDesafio;
    }

    public int getIdDesafio() {
        return idDesafio;
    }

    public void setIdDesafio(int idDesafio) {
        this.idDesafio = idDesafio;
    }
}
