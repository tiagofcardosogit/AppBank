package com.example.tiago.appbank;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.icu.text.UnicodeSet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tiago on 16/02/2017.
 */

public class BandaDAO {

    private DBHelper dbHelper;

    public BandaDAO(Context context){
        dbHelper = new DBHelper(context);
    }

    public long inserir(Banda banda){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBHelper.EntradaBanda.COLUNA_NOME,banda.getNome());
        values.put(DBHelper.EntradaBanda.COLUNA_ANO,banda.getAno());

        return db.insert(DBHelper.EntradaBanda.NOME_TABELA,null,values);
    }

    public List<Banda> findAll(){
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String[] colunas = {DBHelper.EntradaBanda._ID,
                DBHelper.EntradaBanda.COLUNA_NOME,
                DBHelper.EntradaBanda.COLUNA_ANO};

        Cursor cursor = db.query(DBHelper.EntradaBanda.NOME_TABELA,
                colunas,null,null,null,null,null);

        List<Banda> bandas = new ArrayList<>();

        if (cursor.moveToFirst()){ //força o cursor a ir para o primeiro registro do vetor
            do {
                Banda banda = new Banda();
                banda.setId(cursor.getLong(cursor.getColumnIndex(DBHelper.EntradaBanda._ID)));
                banda.setNome(cursor.getString(cursor.getColumnIndex(DBHelper.EntradaBanda.COLUNA_NOME)));
                banda.setAno(cursor.getInt(cursor.getColumnIndex(DBHelper.EntradaBanda.COLUNA_ANO)));

                bandas.add(banda);
            }while(cursor.moveToNext());

        }

        return bandas;
    }

    public boolean alterar(Banda banda){
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(DBHelper.EntradaBanda.COLUNA_NOME,banda.getNome());
        values.put(DBHelper.EntradaBanda.COLUNA_ANO,banda.getNome());

        String condicao = DBHelper.EntradaBanda._ID + " = ? ";
        String[] condicaoArg = {String.valueOf(banda.getId())};

        int rows = db.update(DBHelper.EntradaBanda.NOME_TABELA,values,condicao,condicaoArg);

        return rows > 0 ? true : false; //if ternario

    }

    public boolean remover(long id){
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String condicao = DBHelper.EntradaBanda._ID + "= ? ";
        String[] condicaoArg = {String.valueOf(id)};

        int rows = db.delete(DBHelper.EntradaBanda.NOME_TABELA,condicao,condicaoArg);

        return rows > 0 ? true : false; //if ternario

    }
}
