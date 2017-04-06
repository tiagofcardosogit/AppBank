package com.example.tiago.appbank;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class MainActivity extends Activity {

    List<Banda> bandas;
    BandaDAO bandaDAO;
    ListView listaBandas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listaBandas = (ListView) findViewById(R.id.listBanda);
        bandaDAO = new BandaDAO(getApplicationContext());

        getBandas();
    }

    protected  void onRestart(){
        super.onRestart();
        getBandas();

    }

    private void getBandas() {
        bandas = bandaDAO.findAll();
        BandaAdapter bandaAdapter = new BandaAdapter(getApplicationContext(),bandas);
        listaBandas.setAdapter(bandaAdapter);
    }

    public void cadastrar(View v){
        Intent cadastrar = new Intent(getApplicationContext(),CadastroActivity.class);
        startActivity(cadastrar);
    }
}
