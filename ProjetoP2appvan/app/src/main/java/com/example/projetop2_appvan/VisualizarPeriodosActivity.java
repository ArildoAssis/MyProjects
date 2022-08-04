package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VisualizarPeriodosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_periodos);
    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView lista = (ListView) findViewById(R.id.listViewPeriodo);
        ClienteDbHelper base = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Periodo> arrayAd = new ArrayAdapter<Periodo>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base.consultarPeriodos());
        lista.setAdapter(arrayAd);

        ((ListView) findViewById(R.id.listViewPeriodo)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arrayAd, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EditarPeriodoActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public void criarPeriodo (View view){
        Intent intent = new Intent(getApplicationContext(), CriarPeriodoActivity.class);
        startActivity(intent);
    }
}