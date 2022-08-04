/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author ARILDOJOSEASSISPINTO
 */
public class Cadastro {
    static private Session ses = HibernateUtil.getSessionFactory().openSession();
    
    public List consultaTodos(Class classe){
        return ses.createCriteria(classe).list();
    }
    
    public Object consultarObjeto(Class classe, int index){
        return ses.createCriteria(classe).add(Restrictions.idEq(index)).uniqueResult();
    }
    
    public Object consultarDado(Class classe, String dado){
        return ses.createCriteria(classe).add(Restrictions.ilike("rg",dado,MatchMode.EXACT)).uniqueResult();
    }
    
    public List consultaTodos(Class classe, int ini, int qtd){
        return ses.createCriteria(classe).setFirstResult(ini).setMaxResults(qtd).list();
    }
    
    public void salvar(Object obj){
        Transaction tr = ses.beginTransaction();
        ses.saveOrUpdate(obj);
        tr.commit();
        ses.clear();
    }
    
    public void deletar(Object obj){
        Transaction tr = ses.beginTransaction();
        ses.delete(obj);
        tr.commit();
    }
}
