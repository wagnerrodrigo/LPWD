/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cesjf.wagnerlpwd.dao;

import br.cesjf.wagnerlpwd.model.Usuario;
import br.cesjf.wagnerlpwd.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author wagner
 */
public class UsuarioDAO implements Serializable{
     public static UsuarioDAO usuarioDAO;

    public static UsuarioDAO getInstance() {
        if (usuarioDAO == null) {
            usuarioDAO = new UsuarioDAO();
        }
        return usuarioDAO;
    }
    
    public Usuario buscar(String nmUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select a from Usuario a where a.nmUsuario =:nmUsuario ");
        query.setParameter("nmUsuario", nmUsuario);

        List<Usuario> usuario = query.getResultList();
        if (usuario != null && usuario.size() > 0) {
            return usuario.get(0);
        }

        return null;
    }

    public List<Usuario> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Usuario As a");
        return query.getResultList();
    }

    public List<Usuario> buscarUsuarioInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct a from Usuario a group by a.nmUsuario");
        return query.getResultList();
    }
    
    public void remover(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(usuario)) {
            usuario = em.merge(usuario);
        }
        em.remove(usuario);
        em.getTransaction().commit();
    }
    
    public Usuario getLogin(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery(
            "select u from Usuario u where u.cpf =:cpf "
            + "and u.senha = :senha");
        query.setParameter("cpf", usuario.getCpf());
        query.setParameter("senha", usuario.getSenha());
       
        List<Usuario> usuariosRetornados = query.getResultList();
        if (usuariosRetornados != null && usuariosRetornados.size() > 0) {
            return usuariosRetornados.get(0);
        }
        return null;
    }


    public Usuario persistir(Usuario usuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            usuario = em.merge(usuario);
            em.getTransaction().commit();
            System.out.println("Registro Usuario gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from Usuario ");
       query.executeUpdate();
       em.getTransaction().commit();
    }
 
}
