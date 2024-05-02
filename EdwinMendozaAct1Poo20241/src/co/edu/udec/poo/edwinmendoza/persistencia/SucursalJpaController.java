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
import dominio.Empleado;
import java.util.ArrayList;
import java.util.LinkedList;
import dominio.Cuenta;
import dominio.Sucursal;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Edwin
 */
public class SucursalJpaController implements Serializable {

    public SucursalJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public SucursalJpaController() {
        emf = Persistence.createEntityManagerFactory("EdwinMendozaAct1Poo20241PU");
    }
    
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Sucursal sucursal) {
        if (sucursal.getEmpleados() == null) {
            sucursal.setEmpleados(new LinkedList<Empleado>());
        }
        if (sucursal.getCuentas() == null) {
            sucursal.setCuentas(new LinkedList<Cuenta>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LinkedList<Empleado> attachedEmpleados = new LinkedList<Empleado>();
            for (Empleado empleadosEmpleadoToAttach : sucursal.getEmpleados()) {
                empleadosEmpleadoToAttach = em.getReference(empleadosEmpleadoToAttach.getClass(), empleadosEmpleadoToAttach.getId());
                attachedEmpleados.add(empleadosEmpleadoToAttach);
            }
            sucursal.setEmpleados(attachedEmpleados);
            LinkedList<Cuenta> attachedCuentas = new LinkedList<Cuenta>();
            for (Cuenta cuentasCuentaToAttach : sucursal.getCuentas()) {
                cuentasCuentaToAttach = em.getReference(cuentasCuentaToAttach.getClass(), cuentasCuentaToAttach.getId());
                attachedCuentas.add(cuentasCuentaToAttach);
            }
            sucursal.setCuentas(attachedCuentas);
            em.persist(sucursal);
            for (Empleado empleadosEmpleado : sucursal.getEmpleados()) {
                Sucursal oldAfiliadoOfEmpleadosEmpleado = empleadosEmpleado.getAfiliado();
                empleadosEmpleado.setAfiliado(sucursal);
                empleadosEmpleado = em.merge(empleadosEmpleado);
                if (oldAfiliadoOfEmpleadosEmpleado != null) {
                    oldAfiliadoOfEmpleadosEmpleado.getEmpleados().remove(empleadosEmpleado);
                    oldAfiliadoOfEmpleadosEmpleado = em.merge(oldAfiliadoOfEmpleadosEmpleado);
                }
            }
            for (Cuenta cuentasCuenta : sucursal.getCuentas()) {
                Sucursal oldCuentaCreadaOfCuentasCuenta = cuentasCuenta.getCuentaCreada();
                cuentasCuenta.setCuentaCreada(sucursal);
                cuentasCuenta = em.merge(cuentasCuenta);
                if (oldCuentaCreadaOfCuentasCuenta != null) {
                    oldCuentaCreadaOfCuentasCuenta.getCuentas().remove(cuentasCuenta);
                    oldCuentaCreadaOfCuentasCuenta = em.merge(oldCuentaCreadaOfCuentasCuenta);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Sucursal sucursal) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Sucursal persistentSucursal = em.find(Sucursal.class, sucursal.getId());
            LinkedList<Empleado> empleadosOld = persistentSucursal.getEmpleados();
            LinkedList<Empleado> empleadosNew = sucursal.getEmpleados();
            LinkedList<Cuenta> cuentasOld = persistentSucursal.getCuentas();
            LinkedList<Cuenta> cuentasNew = sucursal.getCuentas();
            LinkedList<Empleado> attachedEmpleadosNew = new LinkedList<Empleado>();
            for (Empleado empleadosNewEmpleadoToAttach : empleadosNew) {
                empleadosNewEmpleadoToAttach = em.getReference(empleadosNewEmpleadoToAttach.getClass(), empleadosNewEmpleadoToAttach.getId());
                attachedEmpleadosNew.add(empleadosNewEmpleadoToAttach);
            }
            empleadosNew = attachedEmpleadosNew;
            sucursal.setEmpleados(empleadosNew);
            LinkedList<Cuenta> attachedCuentasNew = new LinkedList<Cuenta>();
            for (Cuenta cuentasNewCuentaToAttach : cuentasNew) {
                cuentasNewCuentaToAttach = em.getReference(cuentasNewCuentaToAttach.getClass(), cuentasNewCuentaToAttach.getId());
                attachedCuentasNew.add(cuentasNewCuentaToAttach);
            }
            cuentasNew = attachedCuentasNew;
            sucursal.setCuentas(cuentasNew);
            sucursal = em.merge(sucursal);
            for (Empleado empleadosOldEmpleado : empleadosOld) {
                if (!empleadosNew.contains(empleadosOldEmpleado)) {
                    empleadosOldEmpleado.setAfiliado(null);
                    empleadosOldEmpleado = em.merge(empleadosOldEmpleado);
                }
            }
            for (Empleado empleadosNewEmpleado : empleadosNew) {
                if (!empleadosOld.contains(empleadosNewEmpleado)) {
                    Sucursal oldAfiliadoOfEmpleadosNewEmpleado = empleadosNewEmpleado.getAfiliado();
                    empleadosNewEmpleado.setAfiliado(sucursal);
                    empleadosNewEmpleado = em.merge(empleadosNewEmpleado);
                    if (oldAfiliadoOfEmpleadosNewEmpleado != null && !oldAfiliadoOfEmpleadosNewEmpleado.equals(sucursal)) {
                        oldAfiliadoOfEmpleadosNewEmpleado.getEmpleados().remove(empleadosNewEmpleado);
                        oldAfiliadoOfEmpleadosNewEmpleado = em.merge(oldAfiliadoOfEmpleadosNewEmpleado);
                    }
                }
            }
            for (Cuenta cuentasOldCuenta : cuentasOld) {
                if (!cuentasNew.contains(cuentasOldCuenta)) {
                    cuentasOldCuenta.setCuentaCreada(null);
                    cuentasOldCuenta = em.merge(cuentasOldCuenta);
                }
            }
            for (Cuenta cuentasNewCuenta : cuentasNew) {
                if (!cuentasOld.contains(cuentasNewCuenta)) {
                    Sucursal oldCuentaCreadaOfCuentasNewCuenta = cuentasNewCuenta.getCuentaCreada();
                    cuentasNewCuenta.setCuentaCreada(sucursal);
                    cuentasNewCuenta = em.merge(cuentasNewCuenta);
                    if (oldCuentaCreadaOfCuentasNewCuenta != null && !oldCuentaCreadaOfCuentasNewCuenta.equals(sucursal)) {
                        oldCuentaCreadaOfCuentasNewCuenta.getCuentas().remove(cuentasNewCuenta);
                        oldCuentaCreadaOfCuentasNewCuenta = em.merge(oldCuentaCreadaOfCuentasNewCuenta);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                int id = sucursal.getId();
                if (findSucursal(id) == null) {
                    throw new NonexistentEntityException("The sucursal with id " + id + " no longer exists.");
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
            Sucursal sucursal;
            try {
                sucursal = em.getReference(Sucursal.class, id);
                sucursal.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The sucursal with id " + id + " no longer exists.", enfe);
            }
            LinkedList<Empleado> empleados = sucursal.getEmpleados();
            for (Empleado empleadosEmpleado : empleados) {
                empleadosEmpleado.setAfiliado(null);
                empleadosEmpleado = em.merge(empleadosEmpleado);
            }
            LinkedList<Cuenta> cuentas = sucursal.getCuentas();
            for (Cuenta cuentasCuenta : cuentas) {
                cuentasCuenta.setCuentaCreada(null);
                cuentasCuenta = em.merge(cuentasCuenta);
            }
            em.remove(sucursal);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Sucursal> findSucursalEntities() {
        return findSucursalEntities(true, -1, -1);
    }

    public List<Sucursal> findSucursalEntities(int maxResults, int firstResult) {
        return findSucursalEntities(false, maxResults, firstResult);
    }

    private List<Sucursal> findSucursalEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Sucursal.class));
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

    public Sucursal findSucursal(int id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Sucursal.class, id);
        } finally {
            em.close();
        }
    }

    public int getSucursalCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Sucursal> rt = cq.from(Sucursal.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
