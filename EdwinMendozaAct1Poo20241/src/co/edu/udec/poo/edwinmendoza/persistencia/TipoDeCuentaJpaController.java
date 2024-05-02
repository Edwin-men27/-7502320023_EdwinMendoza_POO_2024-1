/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.persistencia;

import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.TipoDeCuenta;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

/**
 *
 * @author Edwin
 */
public class TipoDeCuentaJpaController implements Serializable {

    public TipoDeCuentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public TipoDeCuentaJpaController() {
        emf = Persistence.createEntityManagerFactory("EdwinMendozaAct1Poo20241PU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(TipoDeCuenta tipoDeCuenta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(tipoDeCuenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(TipoDeCuenta tipoDeCuenta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            tipoDeCuenta = em.merge(tipoDeCuenta);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = tipoDeCuenta.getId();
                if (findTipoDeCuenta(id) == null) {
                    throw new NonexistentEntityException("The tipoDeCuenta with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(int id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            TipoDeCuenta tipoDeCuenta;
            try {
                tipoDeCuenta = em.getReference(TipoDeCuenta.class, id);
                tipoDeCuenta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The tipoDeCuenta with id " + id + " no longer exists.", enfe);
            }
            em.remove(tipoDeCuenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<TipoDeCuenta> findTipoDeCuentaEntities() {
        return findTipoDeCuentaEntities(true, -1, -1);
    }

    public List<TipoDeCuenta> findTipoDeCuentaEntities(int maxResults, int firstResult) {
        return findTipoDeCuentaEntities(false, maxResults, firstResult);
    }

    private List<TipoDeCuenta> findTipoDeCuentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(TipoDeCuenta.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public TipoDeCuenta findTipoDeCuenta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(TipoDeCuenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getTipoDeCuentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<TipoDeCuenta> rt = cq.from(TipoDeCuenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
