package Juego;
/*
 * La raza del personaje proporciona ciertos rasgos utiles tanto como para el rol como para el combate
 */
public class Raza {
	 private int id;

    private String nombre;

    private int edad;
   
    private int velocidad;
    
    private String idioma;
    
    private boolean visionOscuridad;
    
    final private static String[] tamanios = {"Pequenio", "Mediano", "Grande"};
    
    private String tamanio;
    
    
    /*
	 * Constructor por defecto
	 */
    public Raza() {
    }

    /**
     * Constructor para crear un objeto Raza.
     *
     * @param nombre Nombre de la raza.
     * @param edad Edad de la raza.
     * @param velocidad Velocidad de la raza.
     * @param idioma Idioma de la raza.
     * @param visionOscuridad Si la raza tiene visión en la oscuridad.
     * @param tamanyo Tamaño de la raza.
     */
    public Raza(String nombre, int edad, int velocidad, String idioma, boolean visionOscuridad, String tamanio) {
        this.nombre = nombre;
        this.edad = edad;
        this.velocidad = velocidad;
        this.idioma = idioma;
        this.visionOscuridad = visionOscuridad;
        this.tamanio = tamanio;
    }   

    public Raza(int id, String nombre, int edad, int velocidad, String idioma, boolean visionOscuridad,
            String tamanio) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.velocidad = velocidad;
        this.idioma = idioma;
        this.visionOscuridad = visionOscuridad;
        this.tamanio = tamanio;
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

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public String getIdioma() {
        return idioma;
    }   

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }   

    public boolean isVisionOscuridad() {
        return visionOscuridad;
    }

    public void setVisionOscuridad(boolean visionOscuridad) {
        this.visionOscuridad = visionOscuridad;
    }

    public String getTamanio() {
        return tamanio;
    }

    public void setTamanio(String tamanio) {
        this.tamanio = tamanio;
    }
    
    public static String[] getTamanios() {
        return tamanios;
    }

    /*
	 * To string de la raza
	 */
	@Override
	public String toString() {
		return "Raza [nombre=" + nombre + ", edad=" + edad + ", velocidad=" + velocidad + ", idioma=" + idioma
				+ ", visionOscuridad=" + visionOscuridad + ", tamanio=" + tamanio + "]";
	}

    

}
