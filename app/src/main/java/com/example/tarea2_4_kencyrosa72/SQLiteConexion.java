package com.example.tarea2_4_kencyrosa72;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.tarea2_4_kencyrosa72.Transacciones.Operaciones;

public class SQLiteConexion extends SQLiteOpenHelper  {

    public SQLiteConexion(Context context, String bddname, SQLiteDatabase.CursorFactory factory, int version){
        super(context, bddname, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Operaciones.CreateTableFirmas);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Operaciones.DropTableFirmas);
        onCreate(db);
    }
}
