
package br.cesjf.wagnerlpwd.dao;
import br.cesjf.wagnerlpwd.model.TipoUsuario;
import br.cesjf.wagnerlpwd.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TipoUsuarioDAO implements Serializable{

    public static TipoUsuarioDAO TipoUsuarioDAO;

    public static TipoUsuarioDAO getInstance() {
        if (TipoUsuarioDAO == null) {
            TipoUsuarioDAO = new TipoUsuarioDAO();
        }
        return TipoUsuarioDAO;
    }
    
    public TipoUsuario buscar(int idTipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select tu from tipo_usuario tu where tq.id_tipo_usuario =:idTipoUsuario ");
        query.setParameter("idTipoUsuario", idTipoUsuario);

        List<TipoUsuario> tipoUsuario = query.getResultList();
        
        if (tipoUsuario != null && tipoUsuario.size() > 0) {
            return tipoUsuario.get(0);
        }
        return null;
    }

    public List<TipoUsuario> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from tipo_usuario As tu");
        return query.getResultList();
    }

    public List<TipoUsuario> buscarTipoUsuarioInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct q from tipo_usuario q group by q.id_tipo_usuario");
        return query.getResultList();
    }
    
    public void remover(TipoUsuario tipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tipoUsuario)) {
            tipoUsuario = em.merge(tipoUsuario);
        }
        em.remove(tipoUsuario);
        em.getTransaction().commit();
    }

    public TipoUsuario persistir(TipoUsuario tipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tipoUsuario = em.merge(tipoUsuario);
            em.getTransaction().commit();
            System.out.println("Registro tipo_usuario gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoUsuario;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from TipoUsuario ");
       query.executeUpdate();
       em.getTransaction().commit();
    }

}
