package Juego;
/*
 * La clase armas representa el objetos más importante que un aventurero puede llevar
 */
public class Armas {
	 private int id;
	/*
	 * atributo del nombre
	 */
    private String nombre;
    /*
	 * atributo de peso
	 */
    private int peso;
    /*
	 * atributo de tamaño
	 */
    private int tamanyo;
    /*
	 * atributo de precio
	 */
    private int precio;

    /*
	 * COnstructor por defecto
	 */
    public Armas() {
    }
    
    /**
     * Constructor para crear un objeto Arma.
     *
     * @param nombre Nombre del arma.
     * @param peso Peso del arma.
     * @param tamanyo Tamaño del arma.
     * @param precio Precio del arma.
     */
    public Armas(String nombre, int peso, int tamanyo, int precio) {
        this.nombre = nombre;
        this.peso = peso;
        this.tamanyo = tamanyo;
        this.precio = precio;
    }
    
    public Armas(int id, String nombre, int peso, int tamanyo, int precio) {
        this.id = id;
        this.nombre = nombre;
        this.peso = peso;
        this.tamanyo = tamanyo;
        this.precio = precio;
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
   
    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getTamanyo() {
        return tamanyo;
    }

    public void setTamanyo(int tamanyo) {
        this.tamanyo = tamanyo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    /*
	 * To string de la clase arma
	 */
	@Override
	public String toString() {
		return "Armas [nombre=" + nombre + ", peso=" + peso + ", tamanyo=" + tamanyo + ", precio=" + precio + "]";
	}
    
    

}
