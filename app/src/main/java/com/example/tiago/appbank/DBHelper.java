package com.example.tiago.appbank;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by Tiago on 16/02/2017.
 */

public class DBHelper extends SQLiteOpenHelper {



    public static final String NOME_DATABASE ="dbmusica.db";
    public static final int VERSAO_DB =1;

    //inner class
    public static class EntradaBanda implements BaseColumns {
        public static final String COLUNA_NOME = "nome";
        public static final String COLUNA_ANO = "ano";
        public static final String NOME_TABELA ="banda";

        private static final String CRIAR_TABELA =
            "CREATE TABLE " + NOME_TABELA + "("+
                    _ID + " integer primary key,"+
                    COLUNA_NOME + " text," +
                    COLUNA_ANO + " integer)";

        private static final String REMOVER_TABELA =
                "DROP TABLE IF EXISTS " + NOME_TABELA;

    }


    public DBHelper(Context context){
        super(context,NOME_DATABASE,null,VERSAO_DB);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(EntradaBanda.CRIAR_TABELA);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(EntradaBanda.REMOVER_TABELA);
        onCreate(db);

    }
}
