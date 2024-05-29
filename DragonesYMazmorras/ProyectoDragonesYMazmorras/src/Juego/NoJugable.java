package Juego;
/*
 * Los personajes no jugables o enemigos son aquellos que no controlamos y luchamos en su contra,
 * y se hereda de la clase personaje
 */
public class NoJugable extends Personaje {
	/*
	 * Indica si es un jefe legendario
	 */
    private boolean legendario;
    /*
	 * Indica la resistencia al daño de cada enemigo
	 */
    private String resistencia;

    /*
	 * Constructor por defecto
	 */
    public NoJugable() {

    }

    /**
	 * Constructor para crear un objeto NoJugable.
	 *
	 * @param nombre Nombre del personaje.
	 * @param nivel Nivel del personaje.
	 * @param raza Raza del personaje.
	 * @param arma Arma del personaje.
	 * @param atributo Atributos del personaje.
	 * @param legendario comprueba si es legendario.
	 * @param Resistencia resistencia del personaje.
	 */
    public NoJugable(String nombre, int nivel, Raza raza, Armas arma, Atributo atributo, boolean legendario, String resistencia) {
		super(nombre, nivel, raza, arma, atributo);
		this.legendario = legendario;
        this.resistencia = resistencia;
	}

    /*
	 * Getters y Setters
	 */
    
	public boolean isLegendario() {
        return legendario;
    }

    public void setLegendario(boolean legendario) {
        this.legendario = legendario;
    }

    public String getResistencia() {
        return resistencia;
    }

    public void setResistencia(String resistencia) {
        this.resistencia = resistencia;
    }
    
    
    /*
	 * String de la clase
	 */

	@Override
	public String toString() {
		return "NoJugable [legendario=" + legendario + ", resistencia=" + resistencia + ", Nombre=" + getNombre()
				+ ", Nivel()=" + getNivel() + ", Raza=" + getRaza() + ", getArma()=" + getArma()
				+ ", getAtributo=" + getAtributo()  + ", Clase=" + getClass() + "]";
	}

	
	
    
    
}
