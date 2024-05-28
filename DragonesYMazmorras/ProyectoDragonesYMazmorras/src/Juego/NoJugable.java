package Juego;

public class NoJugable extends Personaje {
    private boolean legendario;
    private String resistencia;


    public NoJugable() {

    }

    public NoJugable(String nombre, int nivel, Raza raza, Armas arma, Atributo atributo, int idNoJugable, boolean legendario, String resistencia) {
		super(nombre, nivel, raza, arma, atributo);
		this.legendario = legendario;
        this.resistencia = resistencia;
	}

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
}
