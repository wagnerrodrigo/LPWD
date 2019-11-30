/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.dao;

import br.cesjf.wagnerlpwd.model.Prova;
import br.cesjf.wagnerlpwd.util.PersistenceUtil;
import java.util.ArrayList;
import java.util.List;
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
    
//    public Prova buscaProvaAno(Date ano){
//            try {
//            EntityManager em = PersistenceUtil.getEntityManager();
//                Query query = em.createQuery("SELECT an FROM ano an WHERE an.ano =:ano");
//                query.setParameter("ano",ano);
//                Prova prova = (Prova) query.getSingleResult();
//                if(prova !=null && prova.getAno() > 0){
//                    return prova;
//                }else{
//                    Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO,"Não foi encontrado o ano da prova");
//                }
//            } catch (Exception e) {
//            }
//    }
    public List<Prova> buscarTodasProva(){
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT p FROM idProva p");
            return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING,"Desculpe nao foi possivel retonar todas as provas, Por favor entre em contato com o suporte");
            return new ArrayList<>();
        }
    }
    
    public String remover(Prova prova){
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            prova = em.merge(prova);
            em.remove(prova);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO,"Prova Removidos com sucesso!!!");
            return "Prova" + prova.getIdProva() + "Removido com Sucesso";
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING,"Não foi possivel remover a prova", e.getMessage());
            return "Desculpe não foi possivel remover a prova! entre em contato com o suporte" + prova.getIdProva() +"";
        }
    }
    
    
    public String persistir(Prova prova){
        EntityManager em = PersistenceUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            prova = em.merge(prova);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO,"Prova salvo com sucesso!!!");
            return "Prova" + prova.getIdProva() + "Salvo com sucesso";
        } catch (Exception e) {
            em.getTransaction().rollback();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING,"Não foi possível salvar a prova",e.getMessage());
            if(e.getMessage().contains("ConstraintViolationExeption")){
                return "Não foi possível salvar a prova" + prova.getIdProva() +", pois a prova deve ser única";
            }
            return "Não foi possivel salvar a prova" + prova.getIdProva() + "!!!";
        }
    }
    
    public String removelTudo(){
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            Query query = em.createQuery("DELETE FROM idProva");
            query.executeUpdate();
            em.getTransaction();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO,"Todas as prova foram deletados!!!");
            return "Todas as Provas foram Deletadas!!!";
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING,"Não foi possível remover todas as provas"
            + "Por favor entre em contato com o suporte", e.getMessage());
            return "Não foi possível deletar todas as Provas!!!";
        }
    }
      
    
    
}
