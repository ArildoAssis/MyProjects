package com.example.projetop2_appvan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class EditarClienteActivity extends AppCompatActivity {
    private ClienteDbHelper base;
    private EditText nome;
    private EditText cpf;
    private EditText telefone;
    private EditText endereco;
    private EditText valor;
    private EditText situacao;
    private Spinner lista,lista2,lista3;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_cliente);
    }

    @Override
    protected void onResume() {
        super.onResume();

        base = new ClienteDbHelper(getApplicationContext());
        Intent intent = getIntent();
        position = intent.getIntExtra("position",0);

        lista = (Spinner) findViewById(R.id.spinnerCidade);
        ClienteDbHelper base = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Cidade> arrayAd = new ArrayAdapter<Cidade>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base.consultarCidades());
        lista.setAdapter(arrayAd);
        lista.setSelection(Integer.parseInt(base.consultarNomeCliente((position+1),5)));

        lista2 = (Spinner) findViewById(R.id.spinnerPonto);
        ClienteDbHelper base2 = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Ponto> arrayAd2 = new ArrayAdapter<Ponto>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base2.consultarPontos());
        lista2.setAdapter(arrayAd2);
        lista2.setSelection(Integer.parseInt(base.consultarNomeCliente((position+1),6)));

        lista3 = (Spinner) findViewById(R.id.spinnerPeriodo);
        ClienteDbHelper base3 = new ClienteDbHelper(getApplicationContext());
        final ArrayAdapter<Periodo> arrayAd3 = new ArrayAdapter<Periodo>(getApplicationContext(),
                android.R.layout.simple_list_item_1, base3.consultarPeriodos());
        lista3.setAdapter(arrayAd3);
        lista3.setSelection(Integer.parseInt(base.consultarNomeCliente((position+1),8)));

        nome = (EditText) findViewById(R.id.edNomeCliente);
        nome.setText(base.consultarNomeCliente((position+1),1));

        cpf = (EditText) findViewById(R.id.edCpfCliente);
        cpf.setText(base.consultarNomeCliente((position+1),2));

        telefone = (EditText) findViewById(R.id.edTelefoneCliente);
        telefone.setText(base.consultarNomeCliente((position+1),3));

        endereco = (EditText) findViewById(R.id.edTelefoneCliente);
        endereco.setText(base.consultarNomeCliente((position+1),4));

        valor = (EditText) findViewById(R.id.edValorCliente);
        valor.setText(base.consultarNomeCliente((position+1),7));

        situacao = (EditText) findViewById(R.id.edSituacaoCliente);
        situacao.setText(base.consultarNomeCliente((position+1),9));
    }

    public void Atualizar(View view) {
        String name = nome.getText().toString();
        String cpfA = cpf.getText().toString();
        String telefoneA = telefone.getText().toString();
        String enderecoA = endereco.getText().toString();
        String valorA = valor.getText().toString();
        String situacaoA = situacao.getText().toString();
        int s_cidade = lista.getSelectedItemPosition();
        int s_ponto = lista2.getSelectedItemPosition();
        int s_periodo = lista3.getSelectedItemPosition();
        base.atualizarNomeCliente(position+1, name,cpfA,telefoneA,enderecoA,s_cidade,s_ponto,Float.valueOf(valorA),s_periodo,situacaoA);

        onBackPressed();
    }

    public void Cancelar(View view){
        onBackPressed();
    }
}