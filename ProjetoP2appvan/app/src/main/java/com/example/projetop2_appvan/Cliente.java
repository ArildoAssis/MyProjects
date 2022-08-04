package com.example.projetop2_appvan;

import android.content.Intent;

import java.io.Serializable;

public class Cliente implements Serializable {
    private long id;
    private String nome;
    private String cpf;
    private String celular;
    private String endereco;
    private Integer cidade;
    private Integer ponto;
    private Float valor;
    private Integer periodo;
    private String situacao;

    public Cliente(long id, String nome, String cpf, String celular, String endereco, Integer cidade, Integer ponto, Float valor, Integer periodo, String situacao){
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.endereco = endereco;
        this.cidade = cidade;
        this.ponto = ponto;
        this.valor = valor;
        this.periodo = periodo;
        this.situacao = situacao;
    }
    public Cliente(String nome, String cpf, String celular, String endereco, Integer cidade, Integer ponto, Float valor, Integer periodo, String situacao){
        this.nome = nome;
        this.nome = nome;
        this.cpf = cpf;
        this.celular = celular;
        this.endereco = endereco;
        this.cidade = cidade;
        this.ponto = ponto;
        this.valor = valor;
        this.periodo = periodo;
        this.situacao = situacao;
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

    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf;
    }

    public String getCelular(){
        return celular;
    }
    public void setCelular(String celular){
        this.celular = celular;
    }

    public String getEndereco(){
        return endereco;
    }
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

    public Integer getCidade(){
        return cidade;
    }
    public void setCidade(Integer cidade){
        this.cidade = cidade;
    }

    public Integer getPonto(){
        return ponto;
    }
    public void setPonto(Integer ponto){
        this.ponto = ponto;
    }

    public Float getValor(){
        return valor;
    }
    public void setValor(Float valor){
        this.valor = valor;
    }

    public Integer getPeriodo(){
        return periodo;
    }
    public void setPeriodo(Integer periodo){
        this.periodo = periodo;
    }

    public String getSituacao(){
        return situacao;
    }
    public void setPeriodo(String situacao){
        this.situacao = situacao;
    }
    @Override
    public String toString(){
        return id + " - " + nome + " - " + celular;
    }
}