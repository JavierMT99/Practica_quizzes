package com.example.practica_quizzes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.practica_quizzes.databinding.ActivityDetailBinding;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityDetailBinding binding = ActivityDetailBinding.inflate(getLayoutInflater());
        //setContentView(R.layout.activity_main);
        setContentView(binding.getRoot());

        Bundle extras = getIntent().getExtras();

        if(extras.getBoolean("correcta") == true){
            binding.texto.setText(R.string.respuestaCorrecta);
        }else{
            binding.texto.setText(R.string.respuestaFallada);
        }

        if(extras.getInt("numeroPregunta") < 2){
            binding.boton.setText(R.string.irSiguientePregunta);
        }else{
            binding.boton.setText(R.string.volverEmpezar);
        }

        binding.boton.setOnClickListener(v ->{
            Volver(extras);
        });
    }

    private void Volver(Bundle extras){
        Intent irPregunta = new Intent(this, MainActivity.class);

        if(extras.getInt("numeroPregunta") > 1){
            irPregunta.putExtra("numeroPregunta", 0);
        }else{
            irPregunta.putExtra("numeroPregunta", extras.getInt("numeroPregunta") + 1);
        }

        startActivity(irPregunta);
    }
}