package Juego;

public class Tesoro extends Desafio {
    private int idTesoro;
    private String tesoroObtenido;

    public Tesoro() {
    }

    public Tesoro(int idDesafio, int idTesoro, String tesoroObtenido) {
        super(idDesafio);
        this.idTesoro = idTesoro;
        this.tesoroObtenido = tesoroObtenido;
    }

    public int getIdTesoro() {
        return idTesoro;
    }

    public void setIdTesoro(int idTesoro) {
        this.idTesoro = idTesoro;
    }  

    public String getTesoroObtenido() {
        return tesoroObtenido;
    }

    public void setTesoroObtenido(String tesoroObtenido) {
        this.tesoroObtenido = tesoroObtenido;
    }

    
}
