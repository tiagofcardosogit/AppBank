package com.example.tiago.appbank;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastroActivity extends Activity {

    EditText editNome;
    EditText editAno;
    BandaDAO bandaDAO;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        editNome = (EditText) findViewById(R.id.editNome);
        editAno = (EditText) findViewById(R.id.editAno);
        bandaDAO = new BandaDAO(getApplicationContext());
    }

    public void gravar(View v) {
        Banda banda = new Banda();
        banda.setNome(editNome.getText().toString());
        banda.setAno(Integer.parseInt(editAno.getText().toString()));

        long newID = bandaDAO.inserir(banda);

        if (newID != -1) {
            String mensagem = "Banda Cadastrada com o ID " + newID;
            Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Falha ao Cadastar", Toast.LENGTH_SHORT).show();
        }
        finish();
    }
}
