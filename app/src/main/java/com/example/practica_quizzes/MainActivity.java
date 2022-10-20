package com.example.practica_quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.practica_quizzes.databinding.ActivityMainBinding;
import com.example.practica_quizzes.models.Quizz;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private int numeroPregunta = 0;
    private Quizz quizzes[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        binding.enviar.setOnClickListener(v -> {
            if(!binding.respuesta2.isChecked() && !binding.respuesta1.isChecked()){
                Toast.makeText(this,getString(R.string.sinRespuesta), Toast.LENGTH_LONG).show();

            }else{

                if(quizzes[numeroPregunta].getRespuestaCorrecta() == 1 && binding.respuesta1.isChecked()){
                    BotonEnviar(numeroPregunta, true);

                }else if(quizzes[numeroPregunta].getRespuestaCorrecta() == 2 && binding.respuesta1.isChecked()){
                    BotonEnviar(numeroPregunta, false);
                }else if(quizzes[numeroPregunta].getRespuestaCorrecta() == 1 && binding.respuesta2.isChecked()){
                    BotonEnviar(numeroPregunta, false);
                }else{
                    BotonEnviar(numeroPregunta, true);
                }


            }
        });

        Bundle extras;

        try{
            extras = getIntent().getExtras();
        } catch (Exception e) {
            extras = null;
        }

        if(extras != null){
            numeroPregunta = extras.getInt("numeroPregunta");
        }

        quizzes = CrearPreguntas();
        CargarPregunta(quizzes[numeroPregunta]);

    }

    private Quizz[] CrearPreguntas(){

        Quizz quizzes[];
        quizzes = new Quizz[3];

        Quizz pregunta1 = new Quizz(getString(R.string.pregunta1), getString(R.string.respuesta1pregunta1), getString(R.string.pregunta1respuesta2), 1);
        quizzes[0] = pregunta1;

        Quizz pregunta2 = new Quizz(getString(R.string.pregunta2),getString(R.string.pregunta2respuesta1), getString(R.string.pregunta2respuesta2),  1);
        quizzes[1] = pregunta2;

        Quizz pregunta3 = new Quizz(getString(R.string.pregunta3), getString(R.string.pregunta3respuesta1), getString(R.string.pregunta3respuesta2),  2);
        quizzes[2] = pregunta3;

        return quizzes;
    }

    private void CargarPregunta(Quizz pregunta){
        binding.pregunta.setText(pregunta.getPregunta());
        binding.respuesta1.setText(pregunta.getRespuesta1());
        binding.respuesta2.setText(pregunta.getRespuesta2());
        binding.numeroPregunta.setText(numeroPregunta + 1 + "/3");
    }

    private void BotonEnviar(int numeroPregunta, boolean correcta){

        Intent irRespuesta = new Intent(this, DetailActivity.class);
        irRespuesta.putExtra("numeroPregunta", numeroPregunta);
        irRespuesta.putExtra("correcta", correcta);

        startActivity(irRespuesta);
    }
}