package com.example.lertxt;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class DadosAdapter extends BaseAdapter {
    private List<Dados> dados;
    private Activity activity;

    public DadosAdapter(Activity activity, List<Dados> dados){
        this.activity = activity;
        this.dados = dados;
    }
    @Override
    public int getCount() {
        return dados.size();
    }

    @Override
    public Object getItem(int position) {
        return dados.get(position);
    }

    @Override
    public long getItemId(int position) {
        return dados.get(position).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = activity.getLayoutInflater().inflate(R.layout.item, viewGroup, false);
        TextView d1 = v.findViewById(R.id.txt_dado1);
        TextView d2 = v.findViewById(R.id.txt_dado2);
        TextView d3 = v.findViewById(R.id.txt_dado3);
        Dados a = dados.get(i);
        d1.setText(a.getDado1());
        d2.setText(a.getDado2());
        d3.setText(a.getDado3());
        return v;
    }
}
