package com.example.lertxt;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class DadosDAO {
    private Conexao conexao;
    private SQLiteDatabase banco;


    public DadosDAO (Context context){
        conexao = new Conexao(context);
        banco = conexao.getWritableDatabase();
    }

    public long inserir (Dados d){
        ContentValues values = new ContentValues();
        values.put("dado1", d.getDado1());
        values.put("dado2", d.getDado2());
        values.put("dado3", d.getDado3());
        return banco.insert("aluno", null, values);
    }
    public List<Dados> obterTodos(){
        List<Dados> dados = new ArrayList<>();
        Cursor cursor = banco.query("aluno", new String[]{"id", "dado1", "dado2", "dado3"}, null, null, null, null, null);

        while(cursor.moveToNext()){
            Dados a = new Dados();
            a.setId(cursor.getInt(0));
            a.setDado1(cursor.getString(1));
            a.setDado2(cursor.getString(2));
            a.setDado3(cursor.getString(3));
            dados.add(a);
        }
        return dados;
    }

    public void excluir(){
        banco.delete("aluno", null, null);



    }


}
