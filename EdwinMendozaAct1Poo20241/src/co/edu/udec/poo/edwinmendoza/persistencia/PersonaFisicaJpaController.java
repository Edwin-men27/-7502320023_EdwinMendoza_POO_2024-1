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
import dominio.PersonaFisica;
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
public class PersonaFisicaJpaController implements Serializable {

    public PersonaFisicaJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public PersonaFisicaJpaController() {
        emf = Persistence.createEntityManagerFactory("EdwinMendozaAct1Poo20241PU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(PersonaFisica personaFisica) {
        if (personaFisica.getCuentas() == null) {
            personaFisica.setCuentas(new LinkedList<Cuenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LinkedList<Cuenta> attachedCuentas = new LinkedList<Cuenta>();
            for (Cuenta cuentasCuentaToAttach : personaFisica.getCuentas()) {
                cuentasCuentaToAttach = em.getReference(cuentasCuentaToAttach.getClass(), cuentasCuentaToAttach.getId());
                attachedCuentas.add(cuentasCuentaToAttach);
            }
            personaFisica.setCuentas(attachedCuentas);
            em.persist(personaFisica);
            for (Cuenta cuentasCuenta : personaFisica.getCuentas()) {
                dominio.Cliente oldClienteDueñoOfCuentasCuenta = cuentasCuenta.getClienteDueño();
                cuentasCuenta.setClienteDueño(personaFisica);
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

    public void edit(PersonaFisica personaFisica) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            PersonaFisica persistentPersonaFisica = em.find(PersonaFisica.class, personaFisica.getId());
            LinkedList<Cuenta> cuentasOld = persistentPersonaFisica.getCuentas();
            LinkedList<Cuenta> cuentasNew = personaFisica.getCuentas();
            LinkedList<Cuenta> attachedCuentasNew = new LinkedList<Cuenta>();
            for (Cuenta cuentasNewCuentaToAttach : cuentasNew) {
                cuentasNewCuentaToAttach = em.getReference(cuentasNewCuentaToAttach.getClass(), cuentasNewCuentaToAttach.getId());
                attachedCuentasNew.add(cuentasNewCuentaToAttach);
            }
            cuentasNew = attachedCuentasNew;
            personaFisica.setCuentas(cuentasNew);
            personaFisica = em.merge(personaFisica);
            for (Cuenta cuentasOldCuenta : cuentasOld) {
                if (!cuentasNew.contains(cuentasOldCuenta)) {
                    cuentasOldCuenta.setClienteDueño(null);
                    cuentasOldCuenta = em.merge(cuentasOldCuenta);
                }
            }
            for (Cuenta cuentasNewCuenta : cuentasNew) {
                if (!cuentasOld.contains(cuentasNewCuenta)) {
                    Cliente oldClienteDueñoOfCuentasNewCuenta = cuentasNewCuenta.getClienteDueño();
                    cuentasNewCuenta.setClienteDueño(personaFisica);
                    cuentasNewCuenta = em.merge(cuentasNewCuenta);
                    if (oldClienteDueñoOfCuentasNewCuenta != null && !oldClienteDueñoOfCuentasNewCuenta.equals(personaFisica)) {
                        oldClienteDueñoOfCuentasNewCuenta.getCuentas().remove(cuentasNewCuenta);
                        oldClienteDueñoOfCuentasNewCuenta = em.merge(oldClienteDueñoOfCuentasNewCuenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = personaFisica.getId();
                if (findPersonaFisica(id) == null) {
                    throw new NonexistentEntityException("The personaFisica with id " + id + " no longer exists.");
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
            PersonaFisica personaFisica;
            try {
                personaFisica = em.getReference(PersonaFisica.class, id);
                personaFisica.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The personaFisica with id " + id + " no longer exists.", enfe);
            }
            LinkedList<Cuenta> cuentas = personaFisica.getCuentas();
            for (Cuenta cuentasCuenta : cuentas) {
                cuentasCuenta.setClienteDueño(null);
                cuentasCuenta = em.merge(cuentasCuenta);
            }
            em.remove(personaFisica);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<PersonaFisica> findPersonaFisicaEntities() {
        return findPersonaFisicaEntities(true, -1, -1);
    }

    public List<PersonaFisica> findPersonaFisicaEntities(int maxResults, int firstResult) {
        return findPersonaFisicaEntities(false, maxResults, firstResult);
    }

    private List<PersonaFisica> findPersonaFisicaEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(PersonaFisica.class));
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

    public PersonaFisica findPersonaFisica(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(PersonaFisica.class, id);
        } finally {
            em.close();
        }
    }

    public int getPersonaFisicaCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<PersonaFisica> rt = cq.from(PersonaFisica.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
