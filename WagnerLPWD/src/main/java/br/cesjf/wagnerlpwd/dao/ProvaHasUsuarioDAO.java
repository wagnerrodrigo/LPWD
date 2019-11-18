/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.dao;

import br.cesjf.wagnerlpwd.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
/**
 *
 * @author alunoces
 */
public class ProvaHasUsuarioDAO implements Serializable{

    public static ProvaHasUsuarioDAO provaHasUsuarioDao;

    public static ProvaHasUsuarioDAO getInstance() {
        if (provaHasUsuarioDao == null) provaHasUsuarioDao = new ProvaHasUsuarioDAO();
       
        return provaHasUsuarioDao;
    }
   
    public void persistir(int provaId,int usuarioId) {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery("insert into provaHasUsuario values(provaId,usuarioId)");
       query.executeUpdate();
       em.getTransaction().commit();
    }
}
