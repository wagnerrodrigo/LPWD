/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.dao;

import br.cesjf.wagnerlpwd.model.Curso;
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
public class CursoDAO {
    public static CursoDAO cursoDAo;
    
    public static CursoDAO getInstance(){
        if(cursoDAo == null){
            cursoDAo = new CursoDAO();
        }
        return cursoDAo;
    }
    
    public Curso buscar(int id){
        try{
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT c FROM Curso c WHERE c.id = :id");
            query.setParameter("id",id);
            Curso curso = (Curso) query.getSingleResult();
            if(curso != null && curso.getIdCurso() > 0){
                return curso;
            }else{
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO," Nao encontrado o curso");
                return null;
            }
            } catch (Exception e){
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING," erro");
                return null;        
        }     
    }
    
    public Curso buscar(Curso c){
        try {
            EntityManager em = PersistenceUtil.getEntityManager();
            Query query = em.createQuery("SELECT c FROM Curso c WHERE c.id = :id");
            query.setParameter("id",c.getIdCurso());
            Curso curso = (Curso) query.getSingleResult();
            if(curso != null && curso.getIdCurso() > 0){
                return curso;
            }else{
                Logger.getLogger(PersistenceUtil.class.getName()).log(Level.INFO," Nao encontrado o curso");
                return null;
            }
        } catch (Exception e) {
             Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING," erro");
                return null; 
        }
    }
    
    public List<Curso> buscaTodos(){
        try {
           EntityManager em = PersistenceUtil.getEntityManager();
           Query query = em.createQuery("SELECT c FROM Curso c");
           return query.getResultList();
        } catch (Exception e) {
            Logger.getLogger(PersistenceUtil.class.getName()).log(Level.WARNING,"Desculpe nao foi possivel retonar todos os curso");
            return new ArrayList<>();
        }
    }
    
      public Curso remover(Curso c){
         try {
             EntityManager em = PersistenceUtil.getEntityManager();
             em.getTransaction();
            Query query = em.createQuery("DELETE c FROM Curso c WHERE c.id = :id");
            query.setParameter("id",c.getIdCurso());
            Curso curso = (Curso) query.executeUpdate();
        } catch (Exception e) {
        }
    }
    
}
