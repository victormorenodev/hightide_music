/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.model.services;

import com.tecnicas.hightide.model.interfaces.IMusicaService;
import com.tecnicas.hightide.model.models.Musica;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor Moreno
 */
public class MusicaService implements IMusicaService {

    @Override
    public Musica createMusica(String titulo, String artista, String capa, String url, Musica.Genero genero) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Musica musica = null;
        try {
            emf = Persistence.createEntityManagerFactory("persistence.xml");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            musica = new Musica(null, capa, titulo, artista, url, genero);
            em.persist(musica);
            em.getTransaction().commit();
         } catch(Exception e) {
             if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
             }
         } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return musica;
    }

    @Override
    public Boolean deleteMusica(Integer id) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("persistence.xml");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            Musica musica = em.find(Musica.class, id);
            em.remove(musica);
            
            em.getTransaction().commit();
         } catch(Exception e) {
             if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
             }
             return false;
         } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return true;
    }

    @Override
    public List<Musica> listaTodasMusicas() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<Musica> musicas = null;
        try {
            emf = Persistence.createEntityManagerFactory("persistence.xml");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            musicas = em.createQuery("SELECT m FROM Musica m", Musica.class).getResultList();
            
            em.getTransaction().commit();
         } catch(Exception e) {
             if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
             }
         } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }    
            
        }
        return musicas;
    }

    @Override
    public Musica musicaByTitulo(String titulo) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Musica musicaByTitle = null;
        try {
            List<Musica> musicas = listaTodasMusicas();
            for (Musica musica : musicas) {
                if (musica.getTitulo().equalsIgnoreCase(titulo)) {
                    musicaByTitle = musica;
                }
            }
         } catch(Exception e) {
             if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
             }
         } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
        return musicaByTitle;
    }
    
}
