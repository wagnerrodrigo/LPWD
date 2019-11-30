/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.dao;

import br.cesjf.wagnerlpwd.model.Resposta;
import br.cesjf.wagnerlpwd.util.PersistenceUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author wagner
 */
public class RespostaDAO {

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
