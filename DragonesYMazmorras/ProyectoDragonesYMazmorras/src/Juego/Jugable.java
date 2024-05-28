package Juego;

public class Jugable extends Personaje {
    private String jugador;
    private Clase clase;
    private Equipamiento equipo;
    private int oro;


    public Jugable() {

    }

    public Jugable(String nombre, int nivel, Raza raza, Armas arma, Atributo atributo, String jugador, Clase clase, Equipamiento equipo, int oro) {
		super(nombre, nivel, raza, arma, atributo);
		 this.jugador = jugador;
	     this.clase = clase;
	     this.equipo = equipo;
	     this.oro = oro;
	}

	public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public Equipamiento getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipamiento equipo) {
        this.equipo = equipo;
    }

    public int getOro() {
        return oro;
    }

    public void setOro(int oro) {
        this.oro = oro;
    }

	@Override
	public String toString() {
		return "Jugable [jugador=" + jugador + ", clase=" + clase + ", equipo=" + equipo + ", oro=" + oro
				+ ", getNombre()=" + getNombre() + ", getNivel()=" + getNivel() + ", getRaza()=" + getRaza()
				+ ", getArma()=" + getArma() + ", getAtributo()=" + getAtributo() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
    
    

}
