package com.example.custoviagem.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.example.custoviagem.database.DBOpenHelper;
import com.example.custoviagem.database.model.UsuarioModel;

import java.util.List;

public class UsuarioDAO extends AbstrataDAO{

    private final String[]
    colunas = {
        UsuarioModel.COLUNA_ID,
        UsuarioModel.COLUNA_USUARIO,
        UsuarioModel.COLUNA_SENHA,
    };

    public UsuarioDAO(final Context contexto){
        helper = new DBOpenHelper(contexto);
    }

    /**
     * Faz o Insert no banco de dados.
     * @param model
     * @return
     */

    public long Insert(UsuarioModel model){
        long linhasAfetadas;

        try {
            Open();

            //Criado um hashMap com os values para ser inserido no db.insert
            ContentValues values = new ContentValues();
            values.put(UsuarioModel.COLUNA_USUARIO, model.getUsuario());
            values.put(UsuarioModel.COLUNA_SENHA, model.getSenha());

            linhasAfetadas = db.insert(UsuarioModel.TABELA_NOME, null, values);
        }finally {
            Close();
        }
        return linhasAfetadas;
    }


    /**
     * Executa o SELECT buscando pelo usuario e senha.
     * @param usuario
     * @param senha
     * @return
     */
    public UsuarioModel Select(final String usuario, final String senha) {

        UsuarioModel model = null;

        try {
            Open();

            Cursor cursor = db.query
                    (
                            UsuarioModel.TABELA_NOME,
                            colunas,
                            UsuarioModel.COLUNA_USUARIO + " = ? and "+UsuarioModel.COLUNA_SENHA+" = ?",
                            new String[]{usuario, senha},
                            null,
                            null,
                            null);
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                model = CursorToStructure(cursor);
                break;
            }
        }
        finally {
            Close();
        }

        return model;
    }

    /**
     * Executa o SELECT no banco de dados trazendo todos os usuários.
     * @return
     */

    public List<UsuarioModel> Select(){



        return null;
    }

    /**
     * Transforma o cursor em UsuarioModel.
     * @param cursor
     * @return
     */

    public final UsuarioModel CursorToStructure(Cursor cursor) {
        UsuarioModel model = new UsuarioModel();
        model.setId(cursor.getLong(0));
        model.setUsuario(cursor.getString(1));
        model.setSenha(cursor.getString(2));
        return model;
    }

}
