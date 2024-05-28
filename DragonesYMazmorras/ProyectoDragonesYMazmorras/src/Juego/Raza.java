package Juego;

public class Raza {
    private String nombre;
    private int edad;
    private int velocidad;
    private String idioma;
    private boolean visionOscuridad;
    final private static String[] tamanios = {"Pequenio", "Mediano", "Grande"};
    private String tamanio;
    
    public Raza() {
    }

    public Raza(String nombre, int edad, int velocidad, String idioma, boolean visionOscuridad, String tamanio) {
        this.nombre = nombre;
        this.edad = edad;
        this.velocidad = velocidad;
        this.idioma = idioma;
        this.visionOscuridad = visionOscuridad;
        this.tamanio = tamanio;
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

    

}
