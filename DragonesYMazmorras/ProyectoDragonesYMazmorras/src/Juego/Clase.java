package Juego;

public class Clase {

    private String nombre;
    private String rol;
    private boolean claseMagica;

    public Clase() {
    }

    public Clase(String nombre, String rol, boolean claseMagica) {
        this.nombre = nombre;
        this.rol = rol;
        this.claseMagica = claseMagica;
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

	@Override
	public String toString() {
		return "Clase [ nombre=" + nombre + ", rol=" + rol + ", claseMagica=" + claseMagica
				+ "]";
	}
    
    

}
