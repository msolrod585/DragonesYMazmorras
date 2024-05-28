package Juego;

public class Armas {
    private String nombre;
    private int peso;
    private int tamanyo;
    private int precio;

    public Armas() {
    }

    public Armas(String nombre, int peso, int tamanyo, int precio) {
        this.nombre = nombre;
        this.peso = peso;
        this.tamanyo = tamanyo;
        this.precio = precio;
    }

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

	@Override
	public String toString() {
		return "Armas [nombre=" + nombre + ", peso=" + peso + ", tamanyo=" + tamanyo + ", precio=" + precio + "]";
	}
    
    

}
