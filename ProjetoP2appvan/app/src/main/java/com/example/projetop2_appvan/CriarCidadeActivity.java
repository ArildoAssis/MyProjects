package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CriarCidadeActivity extends AppCompatActivity {
    private ClienteDbHelper base;
    private EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_cidade);

        base = new ClienteDbHelper(getApplicationContext());
        nome = (EditText) findViewById(R.id.edNomeCidadeNovo);
    }

    public void salvarCidade(View view){
        Cidade cidade = new Cidade(nome.getText().toString());
        base.salvarCidade(cidade);
        nome.setText("");

        onBackPressed();
    }
    public void Cancelar(View view){
        onBackPressed();
    }
}