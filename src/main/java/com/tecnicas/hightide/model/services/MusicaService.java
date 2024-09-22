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
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public MusicaService(EntityManagerFactory entityFactory) {
        this.emf = entityFactory;
    }
    
    @Override
    public Musica createMusica(String titulo, String artista, String capa, String url, Musica.Genero genero) {
        Musica musica = null;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            musica = new Musica(null, capa, titulo, artista, url, genero);
            em.persist(musica);
            em.getTransaction().commit();
         } catch(Exception e) {
             if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
             } 
         } finally {
            em.close(); 
        }
        return musica;
    }

    @Override
    public Boolean deleteMusica(Integer id) {
        EntityManager em = emf.createEntityManager();
        try {
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
            em.close(); 
        } 
        return true;
    }

    @Override
    public List<Musica> listaTodasMusicas() {
        EntityManager em = emf.createEntityManager();
        List<Musica> musicas = null;
        try {
            em.getTransaction().begin();
            
            musicas = em.createQuery("SELECT m FROM Musica m", Musica.class).getResultList();
            
            em.getTransaction().commit();
         } catch(Exception e) {
             if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
             }
         } finally {
            em.close(); 
        }  
        return musicas;
    }

    @Override
    public Musica musicaByTitulo(String titulo) {
        EntityManager em = emf.createEntityManager();
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
            em.close(); 
        }  
        return musicaByTitle;
    }
    
}
