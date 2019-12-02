/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.dao;

import br.cesjf.wagnerlpwd.model.Resposta;
import br.cesjf.wagnerlpwd.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author wagner
 */
public class RespostaDAO {

     public static RespostaDAO RespostaDAO;

    public static RespostaDAO getInstance() {
        if (RespostaDAO == null) {
            RespostaDAO = new RespostaDAO();
        }
        return RespostaDAO;
    }
    
    public Resposta buscar(int respostaId) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select q from Resposta q where q.id_resposta =:respostaId ");
        query.setParameter("respostaId", respostaId);

        List<Resposta> resposta = query.getResultList();
        
        if (resposta != null && resposta.size() > 0) {
            return resposta.get(0);
        }
        return null;
    }

    public List<Resposta> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Resposta As q");
        return query.getResultList();
    }

    public List<Resposta> buscarRespostaInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct q from Resposta q group by q.id_resposta");
        return query.getResultList();
    }
    
    public void remover(Resposta resposta) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(resposta)) {
            resposta = em.merge(resposta);
        }
        em.remove(resposta);
        em.getTransaction().commit();
    }
    
    
    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from Resposta ");
       query.executeUpdate();
       em.getTransaction().commit();
    }
    
    public Resposta persistir(Resposta respostaP) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            respostaP = em.merge(respostaP);
            em.getTransaction().commit();
            System.out.println("Registro TbAssunto gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return respostaP;
    }
    
}
