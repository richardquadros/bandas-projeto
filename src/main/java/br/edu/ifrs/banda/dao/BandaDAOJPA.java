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
        em.getTransaction().begin();
        em.persist(banda);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public Banda buscarPorId(Long id) {
        EntityManager em = emf.createEntityManager();
        Banda banda = em.find(Banda.class, id);
        em.close();
        return banda;
    }

    @Override
    public List<Banda> listarTodos() {
        EntityManager em = emf.createEntityManager();
        List<Banda> bandas = em.createQuery("SELECT b FROM Banda b", Banda.class).getResultList();
        em.close();
        return bandas;
    }

    @Override
    public void atualizar(Banda banda) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(banda);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void remover(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Banda banda = em.find(Banda.class, id);
        if (banda != null) {
            em.remove(banda);
        }
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public List<Banda> listarPorGenero(String genero) {
        EntityManager em = emf.createEntityManager();
        String jpql = "SELECT b FROM Banda b WHERE b.genero = :genero";
        TypedQuery<Banda> query = em.createQuery(jpql, Banda.class);
        query.setParameter("genero", genero);
        List<Banda> bandas = query.getResultList();
        em.close();
        return bandas;
    }
}