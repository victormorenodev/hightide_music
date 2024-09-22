/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.model.services;

import com.tecnicas.hightide.model.interfaces.IPlaylistService;
import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Playlist;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Victor Moreno
 */
public class PlaylistService implements IPlaylistService{
    private EntityManagerFactory emf;
    private EntityManager em;
    
    public PlaylistService(EntityManagerFactory entityFactory) {
        this.emf = entityFactory;
    }
    
    @Override
    public Playlist createPlaylist(String titulo, List<Musica> musicas) {
        EntityManager em = emf.createEntityManager();
        Playlist playlist = null;
        try {
            em.getTransaction().begin();
            
            playlist = new Playlist(null, titulo, musicas);
            em.persist(playlist);
            
            em.getTransaction().commit();
         } catch(Exception e) {
             if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
             }
         } finally {
            em.close(); 
        } 
        return playlist;
    }

    @Override
    public void addMusica(String playlistTitulo, String musicaTitulo) {
        EntityManager em = emf.createEntityManager();
        Playlist playlist = null;
        Musica musica = null;
        MusicaService musicaService = new MusicaService(emf);
        
        try {
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
            em.close(); 
        } 
    }

    @Override
    public void removeMusica(String playlistTitulo, String musicaTitulo) {
        Playlist playlist = null;
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            
            playlist = acessaPlaylist(playlistTitulo);
           
            for (Musica musica : playlist.getMusicas()) {
                if (musica.getTitulo().equals(musicaTitulo)) {
                    List<Musica> novaLista = new ArrayList<>(playlist.getMusicas());
                    novaLista.remove(musica);
                    playlist.setMusicas(novaLista);
                }
            }
            
            em.merge(playlist);
            
            em.getTransaction().commit();
         } catch(Exception e) {
             if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
             }
         } finally {
            em.close(); 
        } 
    }

    @Override
    public Boolean deletaPlaylist(Integer playlistId) {
        EntityManager em = emf.createEntityManager();
        try {
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
            em.close(); 
        } 
        return true;
    }

    @Override
    public List<Playlist> listaPlaylists() {
        EntityManager em = emf.createEntityManager();
        List<Playlist> playlists = null;
        try {
            em.getTransaction().begin();
            
            playlists = em.createQuery("SELECT p FROM Playlist p", Playlist.class).getResultList();
            
            em.getTransaction().commit();
         } catch(Exception e) {
             if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
             }
         } finally {
            em.close(); 
        } 
        return playlists;
    }

    @Override
    public Playlist acessaPlaylist(String playlistTitle) {
        EntityManager em = emf.createEntityManager();
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
            em.close(); 
        } 
        return playlistByTitle;
    }
    
}
