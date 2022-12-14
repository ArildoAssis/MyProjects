package entidades;
// Generated 22/10/2020 03:51:54 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Telefone generated by hbm2java
 */
public class Telefone  implements java.io.Serializable {

    @Override
    public String toString(){
        return numTelefone;
    }
     private int idTelefone;
     private String numTelefone;
     private Pessoa pessoa;

    public Telefone() {
    }

	
    public Telefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }
    public Telefone(int idTelefone, String numTelefone, Set pessoas) {
       this.idTelefone = idTelefone;
       this.numTelefone = numTelefone;
    }
   
    public int getIdTelefone() {
        return this.idTelefone;
    }
    
    public void setIdTelefone(int idTelefone) {
        this.idTelefone = idTelefone;
    }
    public String getNumTelefone() {
        return this.numTelefone;
    }
    
    public void setNumTelefone(String numTelefone) {
        this.numTelefone = numTelefone;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    




}


