package com.example.lertxt;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class ListarDadosActivity extends AppCompatActivity {
    private ListView listView;
    private DadosDAO dao;
    private List<Dados> dados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_dados);

        listView = findViewById(R.id.lista_dados);
        dao = new DadosDAO(this);
        dados = dao.obterTodos();

        DadosAdapter adaptador = new DadosAdapter(this, dados);
        listView.setAdapter(adaptador);
    }



}
