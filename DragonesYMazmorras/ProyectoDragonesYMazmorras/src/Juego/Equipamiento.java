package Juego;

public class Equipamiento {
	private String nombre;
	private int peso;
	private Suministro suministros;
	
	
	public Equipamiento() {
		
	}
	
	public Equipamiento(String nombre, int peso, Suministro suministros) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.suministros = suministros;
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

	public Suministro getSuministros() {
		return suministros;
	}

	public void setSuministros(Suministro suministros) {
		this.suministros = suministros;
	}

	@Override
	public String toString() {
		return "Equipamiento [nombre=" + nombre + ", peso=" + peso + ", suministros=" + suministros + "]";
	}

	
	
	
	
}
