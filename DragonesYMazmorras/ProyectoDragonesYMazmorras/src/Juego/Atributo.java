package Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Atributo {
    private int fuerza;
    private int destreza;
    private int constitucion;
    private int inteligencia;
    private int sabiduria;
    private int carisma;

    public Atributo() {
    	this.fuerza = generarAtributo();
        this.destreza = generarAtributo();
        this.constitucion = generarAtributo();
        this.inteligencia = generarAtributo();
        this.sabiduria = generarAtributo();
        this.carisma=generarAtributo();
    }

    public Atributo(int fuerza, int destreza, int constitucion, int inteligencia, int sabiduria, int carisma) {
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.sabiduria = sabiduria;
        this.carisma=carisma;
    }


    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getConstitucion() {
        return constitucion;
    }

    public void setConstitucion(int constitucion) {
        this.constitucion = constitucion;
    }

    public int getInteligencia() {
        return inteligencia;
    }

    public void setInteligencia(int inteligencia) {
        this.inteligencia = inteligencia;
    }

    public int getSabiduria() {
        return sabiduria;
    }

    public void setSabiduria(int sabiduria) {
        this.sabiduria = sabiduria;
    }

    public int getCarisma() {
		return carisma;
	}

	public void setCarisma(int carisma) {
		this.carisma = carisma;
	}

	private int generarAtributo() {
        Random random = new Random();
        ArrayList<Integer> dados = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            dados.add(random.nextInt(6) + 1);
        }
        Collections.sort(dados);
        return dados.get(1) + dados.get(2) + dados.get(3); 
    }
}
