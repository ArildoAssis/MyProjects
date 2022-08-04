package com.example.projetop2_appvan;

import java.io.Serializable;

public class Periodo implements Serializable {
    private long id;
    private String nome;

    public Periodo(long id, String nome){
        this.id = id;
        this.nome = nome;
    }
    public Periodo(String nome){
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