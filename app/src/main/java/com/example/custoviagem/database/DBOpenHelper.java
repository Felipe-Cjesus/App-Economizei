package com.example.custoviagem.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.custoviagem.database.model.CustoViagemModel;
import com.example.custoviagem.database.model.UsuarioModel;

public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String
    DATABASE_NOME = "bancoCustoViagem.db";
    public static final int
    DATABASE_VERSAO = 2;

    public DBOpenHelper(final Context context){
        super(context, DATABASE_NOME, null, DATABASE_VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(UsuarioModel.CREATE_TABLE);
        db.execSQL(CustoViagemModel.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(UsuarioModel.DROP_TABLE);
        db.execSQL(UsuarioModel.CREATE_TABLE);
        db.execSQL(CustoViagemModel.DROP_TABLE);
        db.execSQL(CustoViagemModel.CREATE_TABLE);
    }
}
