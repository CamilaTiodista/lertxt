package com.example.lertxt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Conexao extends SQLiteOpenHelper {
    private static final String name = "banco.db";
    private static final int version = 1;

    public Conexao(@Nullable Context context) {
        super(context, name, null, version);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        //Cria uma tabela SQL
        db.execSQL("create table aluno(id integer primary key, " + "dado1 varchar(50), dado2 varchar(50), dado3 varchar(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }







}
