package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VisualizarPontosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_pontos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        ListView lista = (ListView) findViewById(R.id.listViewPonto);
        ClienteDbHelper base = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Ponto> arrayAd = new ArrayAdapter<Ponto>(getApplicationContext(),
                android.R.layout.simple_list_item_1,base.consultarPontos());
        lista.setAdapter(arrayAd);

        ((ListView)findViewById(R.id.listViewPonto)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arrayAd, View view,int position, long id) {
                Intent intent = new Intent(getApplicationContext(),EditarPontoActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public void criarPontos(View view){
        Intent intent = new Intent(getApplicationContext(),CriarPontoActivity.class);
        startActivity(intent);
    }

}