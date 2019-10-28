/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.dao;

import br.cesjf.wagnerlpwd.model.Prova;
import static br.cesjf.wagnerlpwd.model.Questao_.prova;
import br.cesjf.wagnerlpwd.util.PersistenceUtil;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author alunoces
 */
public class ProvaDao {
    
    public static ProvaDao provaDao;
    
    public static ProvaDao getInstance(){
        if(provaDao == null){
            provaDao = new ProvaDao();
        }
        return provaDao;
    }
    
    public Prova busca(int id){
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT p FROM prova p WHERE p.idProva =:id");
            query.setParameter("idProva", id);
            Prova prova = (Prova) query.getSingleResult();
            if(prova != null && prova.getIdProva() > 0){
                return prova;
            }else{
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO,"Não foi encotrado o id da prova");
                return null;
            }
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING,"Erro do id prova");
            return null;
        }
    }
    
    public Prova buscaProvaAno(Date ano){
            try {
                EntityManager em = PersistenceUtil.getEntiyManager();
                Query query = em.createQuery("SELECT an FROM ano an WHERE an.ano =:ano");
                query.setParameter("ano",ano);
                Prova prova = (Prova) query.getSingleResult();
                if(prova !=null && prova.getAno() > 0){
                    return prova;
                }else{
                    Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO,"Não foi encontrado o ano da prova");
                }
            } catch (Exception e) {
            }
    }
    
}
