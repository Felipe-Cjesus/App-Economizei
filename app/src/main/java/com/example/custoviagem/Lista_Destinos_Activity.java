package com.example.custoviagem;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

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

        /**
         *
         */
        listaDestinos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                CustoViagemModel custo = (CustoViagemModel) listaDestinos.getItemAtPosition(position);
                AlertDialog dialog = new AlertDialog.Builder(Lista_Destinos_Activity.this)
                        .setTitle("Custo de viagem")
                        .setMessage("ID: " +" \t " +custo.getId()+
                                "\nNumero de Viajante: "+ " \t "+custo.getTotalViajante()+
                                "\nDuração: "+ " \t " + custo.getDuracaoViagem()+
                                "\nValor total: "+ " \t " + custo.getCustoTotalViagem()+
                                "\nValor Por Pessoa: "+ " \t " + custo.getCustoTotalPessoa()+
                                "\nOrigem: "+ " \t " + custo.getOrigem()+
                                "\nDestino: "+ " \t " + custo.getDestino())
                        .setNeutralButton("Sair", null)
                        .show();

                //add opcao editar com as ultimas informções salvas no shared preferences
            }
        });

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

    /**
     * função para criar um menu contexto, é ativado assim que for presionado a opção na lista
     *
     * @param menu
     * @param v
     * @param menuInfo
     */
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        MenuItem detalhe = menu.add("Editar");
        detalhe.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {


                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                CustoViagemModel custo = (CustoViagemModel) listaDestinos.getItemAtPosition(info.position);

                Intent intentNovoCalculo = new Intent(Lista_Destinos_Activity.this, CustosActivity.class);
                startActivity(intentNovoCalculo);

//                AlertDialog dialog = new AlertDialog.Builder(Lista_Destinos_Activity.this)
//                        .setTitle(R.string.app_name)
//                        .setMessage("ID: " +" \t " +custo.getId()+
//                                "\nNumero de Viajante: "+ " \t "+custo.getTotalViajante()+
//                                "\nDuração: "+ " \t " + custo.getDuracaoViagem()+
//                                "\nValor total: "+ " \t " + custo.getCustoTotalViagem()+
//                                "\nValor Por Pessoa: "+ " \t " + custo.getCustoTotalPessoa()+
//                                "\nOrigem: "+ " \t " + custo.getOrigem()+
//                                "\nDestino: "+ " \t " + custo.getDestino())
////                        .setNeutralButton("Sair", null)
//                        .setNeutralButton("Editar", new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialogInterface, int i) {
//                                Intent intentNovoCalculo = new Intent(Lista_Destinos_Activity.this, CustosActivity.class);
//                                startActivity(intentNovoCalculo);
//                            }
//                        })
//                        .show();
//
//                dialog.getButton(AlertDialog.THEME_HOLO_DARK);
//                Intent intentDetalhe = new Intent(Lista_Destinos_Activity.this, DetalheActivity.class);
//                startActivity(intentDetalhe);

                carregaLista();
                return false;
            }
        });
    }

    private void carregaLista() {
        CustoViagemDAO dao = new CustoViagemDAO(this);
        List<CustoViagemModel> custos = dao.Select();
        //dao.close();

        ArrayAdapter<CustoViagemModel> adapter = new ArrayAdapter<CustoViagemModel>(this, android.R.layout.simple_list_item_1, custos);
        listaDestinos.setAdapter(adapter);
    }

}