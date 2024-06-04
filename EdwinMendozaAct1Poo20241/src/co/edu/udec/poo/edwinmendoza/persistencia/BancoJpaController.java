/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.udec.poo.edwinmendoza.persistencia;

import co.edu.udec.poo.edwinmendoza.persistencia.exceptions.NonexistentEntityException;
import dominio.Banco;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import dominio.Sucursal;
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
public class BancoJpaController implements Serializable {

    public BancoJpaController() {
        emf = Persistence.createEntityManagerFactory("EdwinMendozaAct1Poo20241PU");
    }

    
    public BancoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Banco banco) {
        if (banco.getSucursales() == null) {
            banco.setSucursales(new LinkedList<Sucursal>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            LinkedList<Sucursal> attachedSucursales = new LinkedList<Sucursal>();
            for (Sucursal sucursalesSucursalToAttach : banco.getSucursales()) {
                sucursalesSucursalToAttach = em.getReference(sucursalesSucursalToAttach.getClass(), sucursalesSucursalToAttach.getId());
                attachedSucursales.add(sucursalesSucursalToAttach);
            }
            banco.setSucursales(attachedSucursales);
            em.persist(banco);
            for (Sucursal sucursalesSucursal : banco.getSucursales()) {
                Banco oldBancoAfiliadoOfSucursalesSucursal = sucursalesSucursal.getBancoAfiliado();
                sucursalesSucursal.setBancoAfiliado(banco);
                sucursalesSucursal = em.merge(sucursalesSucursal);
                if (oldBancoAfiliadoOfSucursalesSucursal != null) {
                    oldBancoAfiliadoOfSucursalesSucursal.getSucursales().remove(sucursalesSucursal);
                    oldBancoAfiliadoOfSucursalesSucursal = em.merge(oldBancoAfiliadoOfSucursalesSucursal);
                }
            }
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Banco banco) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Banco persistentBanco = em.find(Banco.class, banco.getCodigoIdentificador());
            LinkedList<Sucursal> sucursalesOld = persistentBanco.getSucursales();
            LinkedList<Sucursal> sucursalesNew = banco.getSucursales();
            LinkedList<Sucursal> attachedSucursalesNew = new LinkedList<Sucursal>();
            for (Sucursal sucursalesNewSucursalToAttach : sucursalesNew) {
                sucursalesNewSucursalToAttach = em.getReference(sucursalesNewSucursalToAttach.getClass(), sucursalesNewSucursalToAttach.getId());
                attachedSucursalesNew.add(sucursalesNewSucursalToAttach);
            }
            sucursalesNew = attachedSucursalesNew;
            banco.setSucursales(sucursalesNew);
            banco = em.merge(banco);
            for (Sucursal sucursalesOldSucursal : sucursalesOld) {
                if (!sucursalesNew.contains(sucursalesOldSucursal)) {
                    sucursalesOldSucursal.setBancoAfiliado(null);
                    sucursalesOldSucursal = em.merge(sucursalesOldSucursal);
                }
            }
            for (Sucursal sucursalesNewSucursal : sucursalesNew) {
                if (!sucursalesOld.contains(sucursalesNewSucursal)) {
                    Banco oldBancoAfiliadoOfSucursalesNewSucursal = sucursalesNewSucursal.getBancoAfiliado();
                    sucursalesNewSucursal.setBancoAfiliado(banco);
                    sucursalesNewSucursal = em.merge(sucursalesNewSucursal);
                    if (oldBancoAfiliadoOfSucursalesNewSucursal != null && !oldBancoAfiliadoOfSucursalesNewSucursal.equals(banco)) {
                        oldBancoAfiliadoOfSucursalesNewSucursal.getSucursales().remove(sucursalesNewSucursal);
                        oldBancoAfiliadoOfSucursalesNewSucursal = em.merge(oldBancoAfiliadoOfSucursalesNewSucursal);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = banco.getCodigoIdentificador();
                if (findBanco(id) == null) {
                    throw new NonexistentEntityException("The banco with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Banco banco;
            try {
                banco = em.getReference(Banco.class, id);
                banco.getCodigoIdentificador();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The banco with id " + id + " no longer exists.", enfe);
            }
            LinkedList<Sucursal> sucursales = banco.getSucursales();
            for (Sucursal sucursalesSucursal : sucursales) {
                sucursalesSucursal.setBancoAfiliado(null);
                sucursalesSucursal = em.merge(sucursalesSucursal);
            }
            em.remove(banco);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Banco> findBancoEntities() {
        return findBancoEntities(true, -1, -1);
    }

    public List<Banco> findBancoEntities(int maxResults, int firstResult) {
        return findBancoEntities(false, maxResults, firstResult);
    }

    private List<Banco> findBancoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Banco.class));
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

    public Banco findBanco(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Banco.class, id);
        } finally {
            em.close();
        }
    }

    public int getBancoCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Banco> rt = cq.from(Banco.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
