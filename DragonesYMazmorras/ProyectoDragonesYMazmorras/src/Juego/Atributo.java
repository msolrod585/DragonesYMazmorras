package Juego;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
/*
 * Los atributos muestran las características principales de un personaje
 */

public class Atributo {
	private int id;
	/*
	 * atributo de fuerza
	 */
    private int fuerza;
    /*
	 * atributo de destreza
	 */
    private int destreza;
    /*
	 * atributo de constitucion
	 */
    private int constitucion;
    /*
	 * atributo de inteligencia
	 */
    private int inteligencia;
    /*
	 * Atributo de inteligencia
	 */
    private int sabiduria;
    /*
	 * Atributo de la carisma
	 */
    private int carisma;

    
    /*
	 * Constructor por defecto 
	 */
    public Atributo() {
    	this.fuerza = generarAtributo();
        this.destreza = generarAtributo();
        this.constitucion = generarAtributo();
        this.inteligencia = generarAtributo();
        this.sabiduria = generarAtributo();
        this.carisma=generarAtributo();
    }

    
    /**
     * Constructor para crear un objeto Atributo.
     *
     * @param fuerza para atributo fuerza.
     * @param destreza para atributo destreza.
     * @param constitucion para atributo constitucion.
     * @param inteligencia para atributo inteligencia.´
     * @param sabiduria para atributo sabiduria.
     * @param carisma para atributo carisma.
     */
    public Atributo(int fuerza, int destreza, int constitucion, int inteligencia, int sabiduria, int carisma) {
        this.fuerza = fuerza;
        this.destreza = destreza;
        this.constitucion = constitucion;
        this.inteligencia = inteligencia;
        this.sabiduria = sabiduria;
        this.carisma=carisma;
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
	
	/*
	 * La función Generar Atributo nos retorna el valor de la suma de tres dados de 6 caras sumados
	 */

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
