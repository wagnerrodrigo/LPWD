
package br.cesjf.wagnerlpwd.dao;
import br.cesjf.wagnerlpwd.model.TipoQuestao;
import br.cesjf.wagnerlpwd.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class TipoQuestaoDAO implements Serializable{

    public static TipoQuestaoDAO TipoQuestaoDAO;

    public static TipoQuestaoDAO getInstance() {
        if (TipoQuestaoDAO == null) {
            TipoQuestaoDAO = new TipoQuestaoDAO();
        }
        return TipoQuestaoDAO;
    }
    
    public TipoQuestao buscar(int idTipoQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select tq from tipo_questao tq where tq.id_tipo_questao =:idTipoQuestao ");
        query.setParameter("idTipoQuestao", idTipoQuestao);

        List<TipoQuestao> tipoQuestao = query.getResultList();
        
        if (tipoQuestao != null && tipoQuestao.size() > 0) {
            return tipoQuestao.get(0);
        }
        return null;
    }

    public List<TipoQuestao> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from tipo_questao As tq");
        return query.getResultList();
    }

    public List<TipoQuestao> buscarTipoQuestaoInstancia() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select distinct q from tipo_questao q group by q.id_tipo_questao");
        return query.getResultList();
    }
    
    public void remover(TipoQuestao tipoQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tipoQuestao)) {
            tipoQuestao = em.merge(tipoQuestao);
        }
        em.remove(tipoQuestao);
        em.getTransaction().commit();
    }

    public TipoQuestao persistir(TipoQuestao tipoQuestao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tipoQuestao = em.merge(tipoQuestao);
            em.getTransaction().commit();
            System.out.println("Registro tipo_questao gravado com sucesso");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoQuestao;
    }

    public void removeAll() {
       EntityManager em = PersistenceUtil.getEntityManager();
       em.getTransaction().begin();
       Query query = em.createQuery(" delete from TipoQuestao ");
       query.executeUpdate();
       em.getTransaction().commit();
    }

}
