/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.persistencia;

import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Sucursal;
import dominio.Cliente;
import dominio.Cuenta;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edwin
 */
public class CuentaJpaController implements Serializable {

    public CuentaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public CuentaJpaController() {
        emf = Persistence.createEntityManagerFactory("EdwinMendozaAct1Poo20241PU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cuenta cuenta) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal cuentaCreada = cuenta.getCuentaCreada();
            if (cuentaCreada != null) {
                cuentaCreada = em.getReference(cuentaCreada.getClass(), cuentaCreada.getId());
                cuenta.setCuentaCreada(cuentaCreada);
            }
            Cliente clienteDueño = cuenta.getClienteDueño();
            if (clienteDueño != null) {
                clienteDueño = em.getReference(clienteDueño.getClass(), clienteDueño.getId());
                cuenta.setClienteDueño(clienteDueño);
            }
            em.persist(cuenta);
            if (cuentaCreada != null) {
                cuentaCreada.getCuentas().add(cuenta);
                cuentaCreada = em.merge(cuentaCreada);
            }
            if (clienteDueño != null) {
                clienteDueño.getCuentas().add(cuenta);
                clienteDueño = em.merge(clienteDueño);
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cuenta cuenta) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cuenta persistentCuenta = em.find(Cuenta.class, cuenta.getId());
            Sucursal cuentaCreadaOld = persistentCuenta.getCuentaCreada();
            Sucursal cuentaCreadaNew = cuenta.getCuentaCreada();
            Cliente clienteDueñoOld = persistentCuenta.getClienteDueño();
            Cliente clienteDueñoNew = cuenta.getClienteDueño();
            if (cuentaCreadaNew != null) {
                cuentaCreadaNew = em.getReference(cuentaCreadaNew.getClass(), cuentaCreadaNew.getId());
                cuenta.setCuentaCreada(cuentaCreadaNew);
            }
            if (clienteDueñoNew != null) {
                clienteDueñoNew = em.getReference(clienteDueñoNew.getClass(), clienteDueñoNew.getId());
                cuenta.setClienteDueño(clienteDueñoNew);
            }
            cuenta = em.merge(cuenta);
            if (cuentaCreadaOld != null && !cuentaCreadaOld.equals(cuentaCreadaNew)) {
                cuentaCreadaOld.getCuentas().remove(cuenta);
                cuentaCreadaOld = em.merge(cuentaCreadaOld);
            }
            if (cuentaCreadaNew != null && !cuentaCreadaNew.equals(cuentaCreadaOld)) {
                cuentaCreadaNew.getCuentas().add(cuenta);
                cuentaCreadaNew = em.merge(cuentaCreadaNew);
            }
            if (clienteDueñoOld != null && !clienteDueñoOld.equals(clienteDueñoNew)) {
                clienteDueñoOld.getCuentas().remove(cuenta);
                clienteDueñoOld = em.merge(clienteDueñoOld);
            }
            if (clienteDueñoNew != null && !clienteDueñoNew.equals(clienteDueñoOld)) {
                clienteDueñoNew.getCuentas().add(cuenta);
                clienteDueñoNew = em.merge(clienteDueñoNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = cuenta.getId();
                if (findCuenta(id) == null) {
                    throw new NonexistentEntityException("The cuenta with id " + id + " no longer exists.");
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
            Cuenta cuenta;
            try {
                cuenta = em.getReference(Cuenta.class, id);
                cuenta.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cuenta with id " + id + " no longer exists.", enfe);
            }
            Sucursal cuentaCreada = cuenta.getCuentaCreada();
            if (cuentaCreada != null) {
                cuentaCreada.getCuentas().remove(cuenta);
                cuentaCreada = em.merge(cuentaCreada);
            }
            Cliente clienteDueño = cuenta.getClienteDueño();
            if (clienteDueño != null) {
                clienteDueño.getCuentas().remove(cuenta);
                clienteDueño = em.merge(clienteDueño);
            }
            em.remove(cuenta);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cuenta> findCuentaEntities() {
        return findCuentaEntities(true, -1, -1);
    }

    public List<Cuenta> findCuentaEntities(int maxResults, int firstResult) {
        return findCuentaEntities(false, maxResults, firstResult);
    }

    private List<Cuenta> findCuentaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Cuenta.class));
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

    public Cuenta findCuenta(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cuenta.class, id);
        } finally {
            em.close();
        }
    }

    public int getCuentaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Cuenta> rt = cq.from(Cuenta.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
