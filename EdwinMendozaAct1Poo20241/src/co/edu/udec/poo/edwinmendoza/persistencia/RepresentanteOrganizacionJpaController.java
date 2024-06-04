/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.persistencia;

import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.RepresentanteOrganizacion;
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
public class RepresentanteOrganizacionJpaController implements Serializable {

    public RepresentanteOrganizacionJpaController() {
        emf = Persistence.createEntityManagerFactory("EdwinMendozaAct1Poo20241PU");
    }

    public RepresentanteOrganizacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(RepresentanteOrganizacion representanteOrganizacion) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(representanteOrganizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(RepresentanteOrganizacion representanteOrganizacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            representanteOrganizacion = em.merge(representanteOrganizacion);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = representanteOrganizacion.getId();
                if (findRepresentanteOrganizacion(id) == null) {
                    throw new NonexistentEntityException("The representanteOrganizacion with id " + id + " no longer exists.");
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
            RepresentanteOrganizacion representanteOrganizacion;
            try {
                representanteOrganizacion = em.getReference(RepresentanteOrganizacion.class, id);
                representanteOrganizacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The representanteOrganizacion with id " + id + " no longer exists.", enfe);
            }
            em.remove(representanteOrganizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<RepresentanteOrganizacion> findRepresentanteOrganizacionEntities() {
        return findRepresentanteOrganizacionEntities(true, -1, -1);
    }

    public List<RepresentanteOrganizacion> findRepresentanteOrganizacionEntities(int maxResults, int firstResult) {
        return findRepresentanteOrganizacionEntities(false, maxResults, firstResult);
    }

    private List<RepresentanteOrganizacion> findRepresentanteOrganizacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(RepresentanteOrganizacion.class));
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

    public RepresentanteOrganizacion findRepresentanteOrganizacion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(RepresentanteOrganizacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getRepresentanteOrganizacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<RepresentanteOrganizacion> rt = cq.from(RepresentanteOrganizacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
