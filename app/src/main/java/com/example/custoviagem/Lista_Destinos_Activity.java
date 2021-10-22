package com.example.custoviagem;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.custoviagem.database.dao.CustoViagemDAO;
import com.example.custoviagem.database.model.CustoViagemModel;

import java.util.List;

public class Lista_Destinos_Activity extends AppCompatActivity {

    private ListView listaDestinos;
    private Button novoCalculo;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_destinos);

        listaDestinos = (ListView) findViewById(R.id.lista_destinos);

        novoCalculo = (Button) findViewById(R.id.novo_calculo);
        novoCalculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentNovoCalculo = new Intent(Lista_Destinos_Activity.this, CustosActivity.class);
                startActivity(intentNovoCalculo);
            }
        });

        registerForContextMenu(listaDestinos);
    }

    @Override
    protected void onResume() {
        super.onResume();
        carregaLista();
    }


    private void carregaLista() {
        CustoViagemDAO dao = new CustoViagemDAO(this);
        List<CustoViagemModel> custos = dao.Select();
        //dao.close();

        ArrayAdapter<CustoViagemModel> adapter = new ArrayAdapter<CustoViagemModel>(this, android.R.layout.simple_list_item_1, custos);
        listaDestinos.setAdapter(adapter);
    }

}