package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VisualizarCidadesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_cidades);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView lista = (ListView) findViewById(R.id.listViewCidade);
        ClienteDbHelper base = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Cidade> arrayAd = new ArrayAdapter<Cidade>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base.consultarCidades());
        lista.setAdapter(arrayAd);

        ((ListView) findViewById(R.id.listViewCidade)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arrayAd, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EditarCidadeActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public void criarCidade (View view){
        Intent intent = new Intent(getApplicationContext(), CriarCidadeActivity.class);
        startActivity(intent);
    }
}