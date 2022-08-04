package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

public class EditarPontoActivity extends AppCompatActivity {
    private ClienteDbHelper base;
    private EditText nome;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_ponto);
    }

    @Override
    protected void onResume() {
        super.onResume();

        base = new ClienteDbHelper(getApplicationContext());
        Intent intent = getIntent();
        position = intent.getIntExtra("position",0);

        nome = (EditText) findViewById(R.id.edNomePonto);
        nome.setText(base.consultarNomePonto((position+1)));
    }

    public void Atualizar(View view) {
        String name = nome.getText().toString();
        base.atualizarNomePonto(position+1, name);

        //voltar a activity de visualização
        onBackPressed();
    }

    public void Cancelar(View view){
        onBackPressed();
    }
}