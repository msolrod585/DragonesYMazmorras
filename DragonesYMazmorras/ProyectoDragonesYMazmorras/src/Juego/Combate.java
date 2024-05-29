package Juego;

/*
 * El combate es una extension de desafio, en el cual nos enfrentamos a un enemigo
 */
public class Combate {
    private NoJugable enemigo;

    public Combate() {
    }

    
    /**
     * Constructor para crear un objeto Combate.
     *
     * @param enemigo para seleccionar un enemigo.
     */
    public Combate( NoJugable enemigo) {
        this.enemigo = enemigo;
    }

    public NoJugable getEnemigo() {
        return enemigo;
    }

    public void setEnemigo(NoJugable enemigo) {
        this.enemigo = enemigo;
    }
}