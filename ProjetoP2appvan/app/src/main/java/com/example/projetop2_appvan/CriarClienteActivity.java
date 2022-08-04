package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class CriarClienteActivity extends AppCompatActivity {
    private ClienteDbHelper base;
    private EditText nome;
    private EditText cpf;
    private EditText celular;
    private EditText endereco;
    private EditText valor;
    private Spinner lista,lista2,lista3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_cliente);

        base = new ClienteDbHelper(getApplicationContext());
        nome = (EditText) findViewById(R.id.edNomeClienteNovo);
        cpf = (EditText) findViewById(R.id.edCpfClienteNovo);
        celular = (EditText)findViewById(R.id.edTelefoneClienteNovo);
        endereco = (EditText) findViewById(R.id.edEnderecoClienteNovo);
        valor = (EditText) findViewById(R.id.edValorClienteNovo);

        lista = (Spinner) findViewById(R.id.spinnerCidade);
        ClienteDbHelper base = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Cidade> arrayAd = new ArrayAdapter<Cidade>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base.consultarCidades());
        lista.setAdapter(arrayAd);

        lista2 = (Spinner) findViewById(R.id.spinnerPonto);
        ClienteDbHelper base2 = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Ponto> arrayAd2 = new ArrayAdapter<Ponto>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base2.consultarPontos());
        lista2.setAdapter(arrayAd2);

        lista3 = (Spinner) findViewById(R.id.spinnerPeriodo);
        ClienteDbHelper base3 = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Periodo> arrayAd3 = new ArrayAdapter<Periodo>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base3.consultarPeriodos());
        lista3.setAdapter(arrayAd3);
    }

    public void salvarCliente(View view){
        int s_cidade = lista.getSelectedItemPosition();
        int s_ponto = lista2.getSelectedItemPosition();
        int s_periodo = lista3.getSelectedItemPosition();
        Cliente cliente = new Cliente(nome.getText().toString(),cpf.getText().toString(),celular.getText().toString(),endereco.getText().toString(),s_cidade,s_ponto,Float.parseFloat(valor.getText().toString()),s_periodo,"Em dia");
        base.salvarCliente(cliente);

        onBackPressed();
    }
    public void Cancelar(View view){
        onBackPressed();
    }
}