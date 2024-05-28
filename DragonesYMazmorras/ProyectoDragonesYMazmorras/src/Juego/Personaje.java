package Juego;

public abstract class Personaje {
    private String nombre;
    private int nivel;
    private Raza raza;
    private Armas arma;
    private Atributo atributo;


    public Personaje() {
    }

    public Personaje(String nombre, int nivel, Raza raza, Armas arma, Atributo atributo) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.raza = raza;
        this.arma = arma;
        this.atributo = atributo;
    }
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Raza getRaza() {
        return raza;
    }

    public void setRaza(Raza raza) {
        this.raza = raza;
    }

    public Armas getArma() {
        return arma;
    }

    public void setArma(Armas arma) {
        this.arma = arma;
    }

    public Atributo getAtributo() {
        return atributo;
    }

    public void setAtributo(Atributo atributo) {
        this.atributo = atributo;
    }
}
