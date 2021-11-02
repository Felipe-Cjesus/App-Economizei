package com.example.custoviagem.adapter;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.custoviagem.R;
import com.example.custoviagem.database.model.CustoViagemModel;

import java.util.List;

public class DestinoAdapter extends BaseAdapter {

    private Activity activity;
    private List<CustoViagemModel> lista;

    public DestinoAdapter(final Activity activity,final List<CustoViagemModel> listaDestino) {
        this.activity = activity;
        this.lista = listaDestino;
    }

    public int getCount(){
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            convertView = activity.getLayoutInflater().inflate(R.layout.view_lista, parent,false);
        }

        TextView titulo = convertView.findViewById(R.id.txtTitulo);
        titulo.setText(lista.get(position).getDestino());

        TextView valor = convertView.findViewById(R.id.txtValorTotal);
        valor.setText("Valor da viagem  R$ "+lista.get(position).getCustoTotalViagem());

        return convertView;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
