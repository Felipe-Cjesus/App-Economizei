package com.example.custoviagem;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.custoviagem.database.dao.CustoViagemDAO;
import com.example.custoviagem.database.model.CustoViagemModel;

import java.util.List;

public class ResultadoActivity extends AppCompatActivity {

    private TextView txt_result_totalViajante, txt_result_duracaoViagem, txt_result_custoTotalViagem, txt_result_custoTotalPessoa, txt_result_origem, txt_result_destino;
    private Button mostrar;
    private CustoViagemDAO ResultCustoDAO;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        // Instancia o banco de dados.
        ResultCustoDAO = new CustoViagemDAO(ResultadoActivity.this);

        txt_result_totalViajante = (TextView) findViewById(R.id.txt_result_totalViajante);
        txt_result_duracaoViagem = (TextView) findViewById(R.id.txt_result_duracaoViagem);
        txt_result_custoTotalViagem = (TextView) findViewById(R.id.txt_result_custoTotalViagem);
        txt_result_custoTotalPessoa = (TextView) findViewById(R.id.txt_result_custoTotalPessoa);
        txt_result_origem = (TextView) findViewById(R.id.txt_result_origem);
        txt_result_destino = (TextView) findViewById(R.id.txt_result_destino);

        mostrar = (Button) findViewById(R.id.mostrar);

        //CustoViagemModel model = new CustoViagemModel();


        mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<CustoViagemModel> model = ResultCustoDAO.Select();
                for (CustoViagemModel custo : model) {
                    System.out.println("/n/n/n/n");
                    System.out.println("************************ >>>>>>>>>>>>> "+custo.getOrigem());
                    System.out.println("************************ >>>>>>>>>>>>> "+custo.getDestino());
                    System.out.println("************************ >>>>>>>>>>>>> "+custo.getTotalViajante());
                    System.out.println("************************ >>>>>>>>>>>>> "+custo.getDuracaoViagem());
                    System.out.println("************************ >>>>>>>>>>>>> "+custo.getCustoTotalViagem());
                    System.out.println("************************ >>>>>>>>>>>>> "+custo.getCustoTotalPessoa());
                    System.out.println("/n/n/n/n");

                }
            }
        });



    }
}