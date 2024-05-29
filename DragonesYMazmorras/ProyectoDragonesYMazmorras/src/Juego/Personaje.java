package Juego;

/*
 * La clase personaje generaliza todos los seres de este programa
 */
public abstract class Personaje {
	/*
	 * atributo de nombre
	 */
    private String nombre;
    /*
	 * atributo de nivel
	 */
    private int nivel;
    /*
	 * atributo de raza
	 */
    private Raza raza;
    /*
	 * atributo de arma
	 */
    private Armas arma;
    /*
	 * atributo de arma
	 */
    private Atributo atributo;

    /*
	 * Constructor por defecto
	 */
    public Personaje() {
    }

    /*
	 * Constructor con todos los atributos de la clase padre
	 */
    public Personaje(String nombre, int nivel, Raza raza, Armas arma, Atributo atributo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.raza = raza;
        this.arma = arma;
        this.atributo = atributo;
    }
    
    /*
	 * Getters y Setters
	 */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Armas getArma() {
        return arma;
    }

    public void setArma(Armas arma) {
        this.arma = arma;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }

    /*
	 * To string de Personaje
	 */
	@Override
	public String toString() {
		return "Personaje [nombre=" + nombre + ", nivel=" + nivel + ", raza=" + raza + ", arma=" + arma + ", atributo="
				+ atributo + "]";
	}
    
    
}
