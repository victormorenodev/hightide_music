/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.model.services;

import com.tecnicas.hightide.model.interfaces.IPlaylistService;
import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Playlist;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Victor Moreno
 */
public class PlaylistService implements IPlaylistService{

    @Override
    public Playlist createPlaylist(String titulo, List<Musica> musicas) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Playlist playlist = null;
        try {
            emf = Persistence.createEntityManagerFactory("persistence.xml");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            playlist = new Playlist(null, titulo, musicas);
            em.persist(playlist);
            
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
        return playlist;
    }

    @Override
    public void addMusica(String playlistTitulo, String musicaTitulo) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Playlist playlist = null;
        Musica musica = null;
        MusicaService musicaService = new MusicaService();
        
        try {
            emf = Persistence.createEntityManagerFactory("persistence.xml");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            playlist = acessaPlaylist(playlistTitulo);
            musica = musicaService.musicaByTitulo(musicaTitulo);
            playlist.getMusicas().add(musica);
            em.merge(playlist);
            
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
    }

    @Override
    public void removeMusica(String playlistTitulo, String musicaTitulo) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Playlist playlist = null;
        Musica musica = null;
        MusicaService musicaService = new MusicaService();
        
        try {
            emf = Persistence.createEntityManagerFactory("persistence.xml");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            playlist = acessaPlaylist(playlistTitulo);
            musica = musicaService.musicaByTitulo(musicaTitulo);
            playlist.getMusicas().remove(musica);
            em.merge(playlist);
            
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
    }

    @Override
    public Boolean deletaPlaylist(String playlistId) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        try {
            emf = Persistence.createEntityManagerFactory("persistence.xml");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            Playlist playlist = em.find(Playlist.class, playlistId);
            em.remove(playlist);
            
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
    public List<Playlist> listaPlaylists() {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        List<Playlist> playlists = null;
        try {
            emf = Persistence.createEntityManagerFactory("persistence.xml");
            em = emf.createEntityManager();
            em.getTransaction().begin();
            
            playlists = em.createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList();
            
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
        return playlists;
    }

    @Override
    public Playlist acessaPlaylist(String playlistTitle) {
        EntityManagerFactory emf = null;
        EntityManager em = null;
        Playlist playlistByTitle = null;
        try {
            List<Playlist> playlists = listaPlaylists();
            for (Playlist playlist : playlists) {
                if (playlist.getTitulo().equalsIgnoreCase(playlistTitle)) {
                    playlistByTitle = playlist;
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
        return playlistByTitle;
    }
    
}
