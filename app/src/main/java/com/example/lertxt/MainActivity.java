package com.example.lertxt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    private List<Dados> dados;

    private DadosDAO dao;
    private Dados dado = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.lista_dados);
    }

    public void ler(View view){
        dao = new DadosDAO(this);


        try {
            String f = Environment.getExternalStorageDirectory() + "/" + "Download/teste.txt";
            FileReader reader = new FileReader(f);
            BufferedReader leitor = new BufferedReader(reader);
            String linha;


            while ((linha = leitor.readLine()) != null){

                if ((linha.charAt(1) == 's') && (linha.charAt(2)=='3')){
                    dado = new Dados();

                    int p1 = linha.indexOf(",", 0);
                    int p2 = linha.indexOf(",", (p1+1));
                    String d1 = linha.substring((p1+2), p2);

                    p1 = p2;
                    p2 = linha.indexOf(",", (p1+1));
                    String d2= linha.substring((p1+2), p2);

                    p1 = p2 ;
                    p2 = linha.indexOf("!", 0);
                    String d3 = linha.substring((p1+2),p2);

                    dado.setDado1(d1);
                    dado.setDado2(d2);
                    dado.setDado3(d3);

                    long id = dao.inserir(dado);
                    Toast.makeText(this, "Dado inserido com id: " + id, Toast.LENGTH_SHORT).show();
                }

            }


        } catch (FileNotFoundException e) {
            System.out.println("n achou");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        dados = dao.obterTodos();

        DadosAdapter adaptador = new DadosAdapter(this, dados);
        listView.setAdapter(adaptador);

    }

    public void limpar(View view){
        dao.excluir();
        dados = dao.obterTodos();
        DadosAdapter adaptador = new DadosAdapter(this, dados);
        listView.setAdapter(adaptador);
    }


}