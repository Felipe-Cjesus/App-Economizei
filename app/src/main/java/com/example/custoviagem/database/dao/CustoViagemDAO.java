package com.example.custoviagem.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.custoviagem.database.DBOpenHelper;
import com.example.custoviagem.database.model.CustoViagemModel;
import com.example.custoviagem.database.model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class CustoViagemDAO extends AbstrataDAO{

    private final String[]
    colunas = {
            CustoViagemModel.COLUNA_ID,
            CustoViagemModel.COLUNA_TOTAL_VIAJANTE,
            CustoViagemModel.COLUNA_DURACAO,
            CustoViagemModel.COLUNA_VLRTOTAL,
            CustoViagemModel.COLUNA_VLRPESSOA,
            CustoViagemModel.COLUNA_ORIGEM,
            CustoViagemModel.COLUNA_DESTINO
    };

    public CustoViagemDAO(final Context contexto) {
        helper = new DBOpenHelper(contexto);
    }

    /**
     * Faz o Insert no banco de dados.
     * @param model
     * @return
     */

    public long Insert(CustoViagemModel model){

        long linhasAfetadas;
        try{
            Open();

            //Criado um hashMap com os values para ser inserido no db.insert
            ContentValues values = new ContentValues();
            values.put(CustoViagemModel.COLUNA_TOTAL_VIAJANTE, model.getTotalViajante());
            values.put(CustoViagemModel.COLUNA_DURACAO, model.getDuracaoViagem());
            values.put(CustoViagemModel.COLUNA_VLRTOTAL, model.getCustoTotalViagem());
            values.put(CustoViagemModel.COLUNA_VLRPESSOA, model.getCustoTotalPessoa());
            values.put(CustoViagemModel.COLUNA_ORIGEM, model.getOrigem());
            values.put(CustoViagemModel.COLUNA_DESTINO, model.getDestino());

            linhasAfetadas = db.insert(CustoViagemModel.TABELA_NOME, null, values);

        } finally {
            Close();
        }

        return linhasAfetadas;
    }

    /**
     * Executa o SELECT no banco de dados trazendo todos os usuários.
     * @return
     */

    public List<CustoViagemModel> Select() {

        List<CustoViagemModel> lista = new ArrayList<CustoViagemModel>();

        try {
            Open();
            Cursor cursor = db.query(CustoViagemModel.TABELA_NOME, colunas, null, null, null, null, null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                lista.add(CursorToStructure(cursor));
                cursor.moveToNext();
            }
        }
        finally {
            Close();
        }
        return lista;
    }


    /**
     * Transforma o cursor em CustoViagemModel.
     * @param cursor
     * @return
     */

    public final CustoViagemModel CursorToStructure(Cursor cursor) {
        CustoViagemModel model = new CustoViagemModel();
        model.setId(cursor.getLong(0));
        model.setTotalViajante(cursor.getString(1));
        model.setDuracaoViagem(cursor.getString(2));
        model.setCustoTotalViagem(cursor.getString(3));
        model.setCustoTotalPessoa(cursor.getString(4));
        model.setOrigem(cursor.getString(5));
        model.setDestino(cursor.getString(6));
        return model;
    }





}
