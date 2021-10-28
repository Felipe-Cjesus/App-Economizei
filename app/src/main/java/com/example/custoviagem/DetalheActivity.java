package com.example.custoviagem;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.custoviagem.database.model.CustoViagemModel;

public class DetalheActivity extends AppCompatActivity {

    private TextView id, total_viajante, duracacao, valorTotal, valorPessoa, destino, origem;
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes);

        CustoViagemModel custo = new CustoViagemModel();

        id = findViewById(R.id.id);
        id.setText(getText((int) custo.getId()));
        total_viajante = findViewById(R.id.total_viajante);
        duracacao = findViewById(R.id.duracao);

    }
}
