/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import entidades.Cidade;
import entidades.Exame;
import entidades.Pessoa;
import entidades.Telefone;
import entidades.TipoExame;
import java.util.List;

/**
 *
 * @author ARILDOJOSEASSISPINTO
 */
public class Controle {
    private Cadastro cad = new Cadastro();
    /*----------------------------------------*/
    public void salvarCidade(Cidade cidade){
        cad.salvar(cidade);
    }
    public void salvarExame(Exame exame){
        cad.salvar(exame);
    }
    public void salvarPessoa(Pessoa pessoa){
        //cad.salvar(pessoa.getTelefone());
        cad.salvar(pessoa);
    }
    public void salvarTelefone(Telefone telefone){
        cad.salvar(telefone);
    }
    public void salvarTipoExame(TipoExame tipoexame){
        cad.salvar(tipoexame);
    }
    /*----------------------------------------*/
    public List consultarCidades(){
        return cad.consultaTodos(Cidade.class);
    }
    public Cidade consultarCidade(int indexCidade){
        return (Cidade)cad.consultarObjeto(Cidade.class, indexCidade);
    }
    public List consultarExames(){
        return cad.consultaTodos(Exame.class);
    }
    public Exame consultarExame(int indexExame){
        return (Exame)cad.consultarObjeto(Exame.class, indexExame);
    }
    public List consultarPessoa(){
        return cad.consultaTodos(Pessoa.class);
    }
    //public List consultarPessoa(int ini, int qtd){
    //    return cad.consultaTodos(Pessoa.class, ini, qtd);
    //}
    public List consultarTelefone(){
        return cad.consultaTodos(Telefone.class);
    }
    public List consultarTipoExames(){
        return cad.consultaTodos(TipoExame.class);
    }
    public TipoExame consultarTipoExame(int indexTipoExame){
        return (TipoExame)cad.consultarObjeto(TipoExame.class, indexTipoExame);
    }
    /*------------------------------------------*/
    public void deletarCidade(Cidade cidade){
        cad.deletar(cidade);
    }
    
   /*-------------------------------------------*/
    public Pessoa validaPessoa(Pessoa user){
        //Consultar o banco
        Pessoa novo = (Pessoa) cad.consultarDado(Pessoa.class, user.getRg());
        
        if(novo != null && user.getRg().equals(novo.getRg()) && user.getCpf().equals(novo.getCpf())){
            return novo;
        }
        return null;
    }
}
