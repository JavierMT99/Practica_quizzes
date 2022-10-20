package com.example.practica_quizzes.models;

public class Quizz {

    private String pregunta;
    private String respuesta1;
    private String respuesta2;
    private int respuestaCorrecta;


    public Quizz(String pregunta, String respuesta1, String respuesta2, int respuestaCorrecta) {
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getRespuesta1() {
        return respuesta1;
    }

    public String getRespuesta2() {
        return respuesta2;
    }

    public int getRespuestaCorrecta() {
        return respuestaCorrecta;
    }
}
