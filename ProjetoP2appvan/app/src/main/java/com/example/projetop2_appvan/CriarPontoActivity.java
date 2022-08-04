package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.view.View;

public class CriarPontoActivity extends AppCompatActivity {
    private ClienteDbHelper base;
    private EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_ponto);

        base = new ClienteDbHelper(getApplicationContext());
        nome = (EditText) findViewById(R.id.edNomePontoNovo);
    }

    public void salvarPonto(View view){
        Ponto ponto = new Ponto(nome.getText().toString());
        base.salvarPonto(ponto);
        nome.setText("");

        onBackPressed();
    }
    public void Cancelar(View view){
        onBackPressed();
    }
}