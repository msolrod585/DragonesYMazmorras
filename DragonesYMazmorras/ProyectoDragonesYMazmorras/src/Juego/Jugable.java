package Juego;

/*
 * Clase Jugable, que extiende de Personaje
 */
public class Jugable extends Personaje {
	  private int id;
	/*
	 * Constructor con nombre del jugador
	 */
	private String jugador;
	/*
	 * COnstructor con la clase
	 */
	private Clase clase;
	/*
	 * COnstructor que indica el oro
	 */
	private int oro;

	/*
	 * Constructor por defecto
	 */
	public Jugable() {

	}

	/**
	 * Constructor para crear un objeto Jugable.
	 *
	 * @param nombre Nombre del personaje.
	 * @param nivel Nivel del personaje.
	 * @param raza Raza del personaje.
	 * @param arma Arma del personaje.
	 * @param atributo Atributos del personaje.
	 * @param jugador propietario del personaje.
	 * @param clase clase del personaje.
	 */
	public Jugable(String nombre, int nivel, Raza raza, Armas arma, Atributo atributo, String jugador, Clase clase,
			int oro) {
		super(nombre, nivel, raza, arma, atributo);
		this.jugador = jugador;
		this.clase = clase;
		this.oro = oro;
	}
	
	 public Jugable(int id, String nombre, int nivel, Raza raza, Armas arma, Atributo atributo, String jugador, Clase clase, int oro) {
	        super(nombre, nivel, raza, arma, atributo);
	        this.id = id;
	        this.jugador = jugador;
	        this.clase = clase;
	        this.oro = oro;
	    }

	   

	/*
	 * Getters y setters
	 */
	 
	 public int getId() {
	        return id;
	    }

	    public void setId(int id) {
	        this.id = id;
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

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}

	/*
	 * To string de Jugable
	 */
	@Override
	public String toString() {
		return "Jugable [jugador=" + jugador + ", clase=" + clase + ",oro=" + oro + ", nombre=" + getNombre()
				+ ", nivel=" + getNivel() + ", raza=" + getRaza() + ", arma=" + getArma() + "]";
	}

}
