package br.edu.ifrs.banda.dao;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import dominio.Banda;

public class BandaDAOJPA implements BandaDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("bandas-pu");

    @Override
    public void salvar(Banda banda) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(banda);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public Banda buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Banda.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Banda> listarTodos() {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT b FROM Banda b", Banda.class).getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public void atualizar(Banda banda) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(banda);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Banda banda = em.find(Banda.class, id);
            if (banda != null) {
                em.remove(banda);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public List<Banda> listarPorGenero(String genero) {
        EntityManager em = emf.createEntityManager();
        try {
            String jpql = "SELECT b FROM Banda b WHERE b.genero = :genero";
            TypedQuery<Banda> query = em.createQuery(jpql, Banda.class);
            query.setParameter("genero", genero);
            return query.getResultList();
        } finally {
            em.close();
        }
    }
}