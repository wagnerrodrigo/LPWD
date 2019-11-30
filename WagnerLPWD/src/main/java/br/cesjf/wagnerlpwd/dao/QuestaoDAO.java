/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.dao;
import br.cesjf.wagnerlpwd.model.Questao;
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
public class QuestaoDAO {
    public static QuestaoDAO questaoDao;
    
    public static QuestaoDAO getInstace(){
        if(questaoDao == null){
            questaoDao = new QuestaoDAO();
        }
        return questaoDao;
    }
    
     public List<Questao> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("SELECT q FROM Questao q");
        return query.getResultList();
    }
     
     
 public Questao persistir(Questao questaoP) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            questaoP = em.merge(questaoP);
            em.getTransaction().commit();
            System.out.println("Registro TbAssunto gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questaoP;
    }
 
 
    public String remover(Questao quest){
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            em.getTransaction().begin();
            quest = em.merge(quest);
            em.remove(quest);
            em.getTransaction().commit();
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO,"Prova Removidos com sucesso!!!");
            return "Prova" + quest.getQuestaoPK()+ "Removido com Sucesso";
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING,"Não foi possivel remover a prova", e.getMessage());
            return "Desculpe não foi possivel remover a prova! entre em contato com o suporte" + quest.getQuestaoPK()+"";
        }
    }
    
    
     public Questao busca(int id){
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT q FROM Questao q WHERE q.questaoPK.provaIdProva = :provaIdProva");
            query.setParameter("idProva", id);
            Questao questao = (Questao) query.getSingleResult();
            if(questao != null && questao.getIdRespostaFk() > 0){
                return questao;
            }else{
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO,"Não foi encotrado o id da prova");
                return null;
            }
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING,"Erro do id prova");
            return null;
        }
    }

}
