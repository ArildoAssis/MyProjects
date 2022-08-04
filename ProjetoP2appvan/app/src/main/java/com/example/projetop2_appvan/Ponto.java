package com.example.projetop2_appvan;

import java.io.Serializable;

public class Ponto implements Serializable {
    private long id;
    private String nome;

    public Ponto(long id, String nome){
        this.id = id;
        this.nome = nome;
    }
    public Ponto(String nome){
        this.nome = nome;
    }
    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    @Override
    public String toString(){
        return id + " - " + nome;
    }
}
