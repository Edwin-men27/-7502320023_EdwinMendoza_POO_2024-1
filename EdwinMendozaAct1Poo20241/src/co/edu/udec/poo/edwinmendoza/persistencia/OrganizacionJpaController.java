/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.persistencia;

import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.Cliente;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Cuenta;
import dominio.Organizacion;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edwin
 */
public class OrganizacionJpaController implements Serializable {

    public OrganizacionJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public OrganizacionJpaController() {
        emf = Persistence.createEntityManagerFactory("EdwinMendozaAct1Poo20241PU");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Organizacion organizacion) {
        if (organizacion.getCuentas() == null) {
            organizacion.setCuentas(new LinkedList<Cuenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LinkedList<Cuenta> attachedCuentas = new LinkedList<Cuenta>();
            for (Cuenta cuentasCuentaToAttach : organizacion.getCuentas()) {
                cuentasCuentaToAttach = em.getReference(cuentasCuentaToAttach.getClass(), cuentasCuentaToAttach.getId());
                attachedCuentas.add(cuentasCuentaToAttach);
            }
            organizacion.setCuentas(attachedCuentas);
            em.persist(organizacion);
            for (Cuenta cuentasCuenta : organizacion.getCuentas()) {
                dominio.Cliente oldClienteDueñoOfCuentasCuenta = cuentasCuenta.getClienteDueño();
                cuentasCuenta.setClienteDueño(organizacion);
                cuentasCuenta = em.merge(cuentasCuenta);
                if (oldClienteDueñoOfCuentasCuenta != null) {
                    oldClienteDueñoOfCuentasCuenta.getCuentas().remove(cuentasCuenta);
                    oldClienteDueñoOfCuentasCuenta = em.merge(oldClienteDueñoOfCuentasCuenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Organizacion organizacion) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Organizacion persistentOrganizacion = em.find(Organizacion.class, organizacion.getId());
            LinkedList<Cuenta> cuentasOld = persistentOrganizacion.getCuentas();
            LinkedList<Cuenta> cuentasNew = organizacion.getCuentas();
            LinkedList<Cuenta> attachedCuentasNew = new LinkedList<Cuenta>();
            for (Cuenta cuentasNewCuentaToAttach : cuentasNew) {
                cuentasNewCuentaToAttach = em.getReference(cuentasNewCuentaToAttach.getClass(), cuentasNewCuentaToAttach.getId());
                attachedCuentasNew.add(cuentasNewCuentaToAttach);
            }
            cuentasNew = attachedCuentasNew;
            organizacion.setCuentas(cuentasNew);
            organizacion = em.merge(organizacion);
            for (Cuenta cuentasOldCuenta : cuentasOld) {
                if (!cuentasNew.contains(cuentasOldCuenta)) {
                    cuentasOldCuenta.setClienteDueño(null);
                    cuentasOldCuenta = em.merge(cuentasOldCuenta);
                }
            }
            for (Cuenta cuentasNewCuenta : cuentasNew) {
                if (!cuentasOld.contains(cuentasNewCuenta)) {
                    Cliente oldClienteDueñoOfCuentasNewCuenta = cuentasNewCuenta.getClienteDueño();
                    cuentasNewCuenta.setClienteDueño(organizacion);
                    cuentasNewCuenta = em.merge(cuentasNewCuenta);
                    if (oldClienteDueñoOfCuentasNewCuenta != null && !oldClienteDueñoOfCuentasNewCuenta.equals(organizacion)) {
                        oldClienteDueñoOfCuentasNewCuenta.getCuentas().remove(cuentasNewCuenta);
                        oldClienteDueñoOfCuentasNewCuenta = em.merge(oldClienteDueñoOfCuentasNewCuenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = organizacion.getId();
                if (findOrganizacion(id) == null) {
                    throw new NonexistentEntityException("The organizacion with id " + id + " no longer exists.");
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
            Organizacion organizacion;
            try {
                organizacion = em.getReference(Organizacion.class, id);
                organizacion.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The organizacion with id " + id + " no longer exists.", enfe);
            }
            LinkedList<Cuenta> cuentas = organizacion.getCuentas();
            for (Cuenta cuentasCuenta : cuentas) {
                cuentasCuenta.setClienteDueño(null);
                cuentasCuenta = em.merge(cuentasCuenta);
            }
            em.remove(organizacion);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Organizacion> findOrganizacionEntities() {
        return findOrganizacionEntities(true, -1, -1);
    }

    public List<Organizacion> findOrganizacionEntities(int maxResults, int firstResult) {
        return findOrganizacionEntities(false, maxResults, firstResult);
    }

    private List<Organizacion> findOrganizacionEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Organizacion.class));
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

    public Organizacion findOrganizacion(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Organizacion.class, id);
        } finally {
            em.close();
        }
    }

    public int getOrganizacionCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Organizacion> rt = cq.from(Organizacion.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
