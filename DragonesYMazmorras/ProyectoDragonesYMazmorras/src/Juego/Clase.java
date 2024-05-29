package Juego;

/*
 * La clase es el "oficio" o especialidad de nuestro personaje
 */
public class Clase {
	private int id;
	/*
	 * Atributo de nombre
	 */
    private String nombre;
    /*
	 * Atributo de rol
	 */
    private String rol;
    /*
	 * Atributo que indica si la clase es magica o no
	 */
    private boolean claseMagica;

    /*
	 * Constructo de Clase por defecto
	 */
    public Clase() {
    }

    /**
     * Constructor para crear un objeto clase.
     *
     * @param nombre Nombre de la clase.
     * @param rol Rol de la clase.
     * @param claseMagica indiqca si es una clase con magia.
     * 
     */
    
    public Clase(String nombre, String rol, boolean claseMagica) {
        this.nombre = nombre;
        this.rol = rol;
        this.claseMagica = claseMagica;
    }
    
    public Clase(int id, String nombre, String rol, boolean claseMagica) {
        this.id = id;
        this.nombre = nombre;
        this.rol = rol;
        this.claseMagica = claseMagica;
    } 

  
    /*
	 * Getters y Setters
	 */
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public boolean isClaseMagica() {
        return claseMagica;
    }

    public void setClaseMagica(boolean claseMagica) {
        this.claseMagica = claseMagica;
    }

    /*
	 * To string de clase
	 */
	@Override
	public String toString() {
		return "Clase [ nombre=" + nombre + ", rol=" + rol + ", claseMagica=" + claseMagica
				+ "]";
	}
    
    

}
