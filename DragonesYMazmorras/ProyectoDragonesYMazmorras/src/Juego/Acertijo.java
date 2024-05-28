package Juego;

public class Acertijo extends Desafio{
    private String pregunta;
    private String respuesta;

    public Acertijo() {
    }

    public Acertijo(int idDesafio, int idAcertijo, String pregunta, String respuesta) {
        super(idDesafio);
        this.pregunta = pregunta;
        this.respuesta = respuesta;
    }

    

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

}
