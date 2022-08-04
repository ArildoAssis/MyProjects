package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class VisualizarClientesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_clientes);
    }
    @Override
    protected void onResume() {
        super.onResume();

        ListView lista = (ListView) findViewById(R.id.listViewCliente);
        ClienteDbHelper base = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Cliente> arrayAd = new ArrayAdapter<Cliente>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base.consultarClientes());
        lista.setAdapter(arrayAd);

        ((ListView) findViewById(R.id.listViewCliente)).setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arrayAd, View view, int position, long id) {
                Intent intent = new Intent(getApplicationContext(), EditarClienteActivity.class);
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }

    public void criarCliente (View view){
        Intent intent = new Intent(getApplicationContext(), CriarClienteActivity.class);
        startActivity(intent);
    }
}