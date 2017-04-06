package com.example.tiago.appbank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tiago on 17/02/2017.
 */
public class BandaAdapter extends ArrayAdapter<Banda> {

    List<Banda> bandas;

    public BandaAdapter(Context context, List<Banda> bandas) {
        super(context, R.layout.banda_item, bandas);
        this.bandas = bandas;
    }

    @Override
    public View getView(int position, View contentView, ViewGroup parent) {

        View local = contentView;

        if (local == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            local = inflater.inflate(R.layout.banda_item, null);
        }
        Banda banda = bandas.get(position);

        if (banda != null) {
            TextView textID = (TextView) local.findViewById(R.id.textID);
            TextView textNome = (TextView) local.findViewById(R.id.textNome);
            TextView textAno = (TextView) local.findViewById(R.id.textAno);

            if (textID != null) {
                textID.setText(String.valueOf(banda.getId()));
            }

            if (textNome != null) {
                textID.setText(String.valueOf(banda.getNome()));
            }

            if (textAno != null) {
                textID.setText(String.valueOf(banda.getAno()));
            }
        }

        return local;
    }
}