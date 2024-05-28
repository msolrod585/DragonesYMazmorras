package Juego;

public class Combate extends Desafio {
    private int idCombate;
    private NoJugable enemigo;

    public Combate() {
    }

    public Combate(int idDesafio, int idCombate, NoJugable enemigo) {
        super(idDesafio);
        this.idCombate = idCombate;
        this.enemigo = enemigo;
    }

    public int getIdCombate() {
        return idCombate;
    }

    public void setIdCombate(int idCombate) {
        this.idCombate = idCombate;
    } 

    public NoJugable getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(NoJugable enemigo) {
        this.enemigo = enemigo;
    }
}
