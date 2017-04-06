package com.example.tiago.appbank;

/**
 * Created by Tiago on 16/02/2017.
 */
public class Banda {

    private long id;
    private String nome;
    private int ano;


    public Banda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Banda(long id, String nome, int ano) {

        this.id = id;
        this.nome = nome;
        this.ano = ano;
    }
}
