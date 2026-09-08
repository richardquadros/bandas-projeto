package br.edu.ifrs.banda;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import dominio.Banda;
import dominio.Integrante;
import dominio.Album;
import dominio.Musica;

public class Principal {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("bandas-pu");
        EntityManager em = emf.createEntityManager();

        Banda banda = new Banda("Cachorro Grande", "Rock");
        Integrante integrante = new Integrante("Beto Bruno", "Vocal");
        Album album = new Album("Pista Livre", 2005);
        Musica musica = new Musica("Sinceramente", 3.20f);

        banda.adicionarIntegrante(integrante);
        banda.adicionarAlbum(album);
        album.adicionarMusica(musica);

        em.getTransaction().begin();
        
        em.persist(banda);
        em.persist(integrante);
        em.persist(album);
        em.persist(musica);
        
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println("Dados da banda Cachorro Grande persistidos com sucesso!");
    }
}