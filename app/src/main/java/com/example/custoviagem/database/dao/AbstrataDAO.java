package com.example.custoviagem.database.dao;

import android.database.sqlite.SQLiteDatabase;

import com.example.custoviagem.database.DBOpenHelper;

public abstract class AbstrataDAO {

    protected SQLiteDatabase db;
    protected DBOpenHelper helper;

    protected final void Open(){
        db = helper.getWritableDatabase();
    }

    protected final void Close(){
        helper.close();
    }

}
