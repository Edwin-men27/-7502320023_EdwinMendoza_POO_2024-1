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
import dominio.Cuenta;
import dominio.Empleado;
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
public class EmpleadoJpaController implements Serializable {

    public EmpleadoJpaController() {
        emf = Persistence.createEntityManagerFactory("EdwinMendozaAct1Poo20241PU");
    }

    public EmpleadoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Empleado empleado) {
        if (empleado.getCuentas() == null) {
            empleado.setCuentas(new LinkedList<Cuenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal afiliado = empleado.getAfiliado();
            if (afiliado != null) {
                afiliado = em.getReference(afiliado.getClass(), afiliado.getId());
                empleado.setAfiliado(afiliado);
            }
            LinkedList<Cuenta> attachedCuentas = new LinkedList<Cuenta>();
            for (Cuenta cuentasCuentaToAttach : empleado.getCuentas()) {
                cuentasCuentaToAttach = em.getReference(cuentasCuentaToAttach.getClass(), cuentasCuentaToAttach.getId());
                attachedCuentas.add(cuentasCuentaToAttach);
            }
            empleado.setCuentas(attachedCuentas);
            em.persist(empleado);
            if (afiliado != null) {
                afiliado.getEmpleados().add(empleado);
                afiliado = em.merge(afiliado);
            }
            for (Cuenta cuentasCuenta : empleado.getCuentas()) {
                dominio.Cliente oldClienteDueñoOfCuentasCuenta = cuentasCuenta.getClienteDueño();
                cuentasCuenta.setClienteDueño(empleado);
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

    public void edit(Empleado empleado) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Empleado persistentEmpleado = em.find(Empleado.class, empleado.getId());
            Sucursal afiliadoOld = persistentEmpleado.getAfiliado();
            Sucursal afiliadoNew = empleado.getAfiliado();
            LinkedList<Cuenta> cuentasOld = persistentEmpleado.getCuentas();
            LinkedList<Cuenta> cuentasNew = empleado.getCuentas();
            if (afiliadoNew != null) {
                afiliadoNew = em.getReference(afiliadoNew.getClass(), afiliadoNew.getId());
                empleado.setAfiliado(afiliadoNew);
            }
            LinkedList<Cuenta> attachedCuentasNew = new LinkedList<Cuenta>();
            for (Cuenta cuentasNewCuentaToAttach : cuentasNew) {
                cuentasNewCuentaToAttach = em.getReference(cuentasNewCuentaToAttach.getClass(), cuentasNewCuentaToAttach.getId());
                attachedCuentasNew.add(cuentasNewCuentaToAttach);
            }
            cuentasNew = attachedCuentasNew;
            empleado.setCuentas(cuentasNew);
            empleado = em.merge(empleado);
            if (afiliadoOld != null && !afiliadoOld.equals(afiliadoNew)) {
                afiliadoOld.getEmpleados().remove(empleado);
                afiliadoOld = em.merge(afiliadoOld);
            }
            if (afiliadoNew != null && !afiliadoNew.equals(afiliadoOld)) {
                afiliadoNew.getEmpleados().add(empleado);
                afiliadoNew = em.merge(afiliadoNew);
            }
            for (Cuenta cuentasOldCuenta : cuentasOld) {
                if (!cuentasNew.contains(cuentasOldCuenta)) {
                    cuentasOldCuenta.setClienteDueño(null);
                    cuentasOldCuenta = em.merge(cuentasOldCuenta);
                }
            }
            for (Cuenta cuentasNewCuenta : cuentasNew) {
                if (!cuentasOld.contains(cuentasNewCuenta)) {
                    var oldClienteDueñoOfCuentasNewCuenta = cuentasNewCuenta.getClienteDueño();
                    cuentasNewCuenta.setClienteDueño(empleado);
                    cuentasNewCuenta = em.merge(cuentasNewCuenta);
                    if (oldClienteDueñoOfCuentasNewCuenta != null && !oldClienteDueñoOfCuentasNewCuenta.equals(empleado)) {
                        oldClienteDueñoOfCuentasNewCuenta.getCuentas().remove(cuentasNewCuenta);
                        oldClienteDueñoOfCuentasNewCuenta = em.merge(oldClienteDueñoOfCuentasNewCuenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = empleado.getId();
                if (findEmpleado(id) == null) {
                    throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.");
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
            Empleado empleado;
            try {
                empleado = em.getReference(Empleado.class, id);
                empleado.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The empleado with id " + id + " no longer exists.", enfe);
            }
            Sucursal afiliado = empleado.getAfiliado();
            if (afiliado != null) {
                afiliado.getEmpleados().remove(empleado);
                afiliado = em.merge(afiliado);
            }
            LinkedList<Cuenta> cuentas = empleado.getCuentas();
            for (Cuenta cuentasCuenta : cuentas) {
                cuentasCuenta.setClienteDueño(null);
                cuentasCuenta = em.merge(cuentasCuenta);
            }
            em.remove(empleado);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Empleado> findEmpleadoEntities() {
        return findEmpleadoEntities(true, -1, -1);
    }

    public List<Empleado> findEmpleadoEntities(int maxResults, int firstResult) {
        return findEmpleadoEntities(false, maxResults, firstResult);
    }

    private List<Empleado> findEmpleadoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Empleado.class));
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

    public Empleado findEmpleado(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Empleado.class, id);
        } finally {
            em.close();
        }
    }

    public int getEmpleadoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Empleado> rt = cq.from(Empleado.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
