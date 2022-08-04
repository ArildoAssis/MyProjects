package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CriarPeriodoActivity extends AppCompatActivity {
    private ClienteDbHelper base;
    private EditText nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_periodo);

        base = new ClienteDbHelper(getApplicationContext());
        nome = (EditText) findViewById(R.id.edNomePeriodoNovo);
    }

    public void salvarPeriodo(View view) {
        Periodo periodo = new Periodo(nome.getText().toString());
        base.salvarPeriodo(periodo);
        nome.setText("");

        onBackPressed();
    }

    public void Cancelar(View view) {
        onBackPressed();
    }
}