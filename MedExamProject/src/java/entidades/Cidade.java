package entidades;
// Generated 22/10/2020 03:51:54 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Cidade generated by hbm2java
 */
public class Cidade  implements java.io.Serializable {


     private int idCidade;
     private String nomeCidade;
     private String cep;
     private Set pessoas = new HashSet(0);
     
    @Override
    public String toString(){
        return nomeCidade;
    }
    public Cidade() {
    }

	
    public Cidade(int idCidade) {
        this.idCidade = idCidade;
    }
    public Cidade(int idCidade, String nomeCidade, String cep, Set pessoas) {
       this.idCidade = idCidade;
       this.nomeCidade = nomeCidade;
       this.cep = cep;
       this.pessoas = pessoas;
    }
   
    public int getIdCidade() {
        return this.idCidade;
    }
    
    public void setIdCidade(int idCidade) {
        this.idCidade = idCidade;
    }
    public String getNomeCidade() {
        return this.nomeCidade;
    }
    
    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }
    public String getCep() {
        return this.cep;
    }
    
    public void setCep(String cep) {
        this.cep = cep;
    }
    public Set getPessoas() {
        return this.pessoas;
    }
    
    public void setPessoas(Set pessoas) {
        this.pessoas = pessoas;
    }




}


