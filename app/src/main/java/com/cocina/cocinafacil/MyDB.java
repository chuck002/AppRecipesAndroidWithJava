package com.cocina.cocinafacil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cocina.cocinafacil.utilidades.Utilidades;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

public class MyDB extends SQLiteAssetHelper {

    public MyDB(Context context) {
        super(context, Utilidades.DB_NAME, null, Utilidades.DB_VERSION);
    }
}