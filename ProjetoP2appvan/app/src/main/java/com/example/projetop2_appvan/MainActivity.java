package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void verPontos(View view){
        Intent intent = new Intent(getApplicationContext(), VisualizarPontosActivity.class);
        startActivity(intent);
    }

    public void verCidades(View view){
        Intent intent = new Intent(getApplicationContext(), VisualizarCidadesActivity.class);
        startActivity(intent);
    }

    public void verPeriodos(View view){
        Intent intent = new Intent(getApplicationContext(), VisualizarPeriodosActivity.class);
        startActivity(intent);
    }

    public void verClientes(View view){
        Intent intent = new Intent(getApplicationContext(), VisualizarClientesActivity.class);
        startActivity(intent);
    }
}