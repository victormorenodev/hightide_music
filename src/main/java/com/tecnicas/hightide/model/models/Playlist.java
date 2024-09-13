/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.model.models;
import com.tecnicas.hightide.model.models.Musica;
import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author Victor Moreno
 */

@Entity
@Table(name = "playlists")
public class Playlist implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    
    @ManyToMany
    @JoinTable(name="playlist_musicas", joinColumns=
            {@JoinColumn(name="playlist_id")}, inverseJoinColumns=
                    {@JoinColumn(name="musicas_id")})
    private List<Musica> musicas;
    
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private User usuario;
    
    public Playlist () {
        
    }

    public Playlist(Integer id, String titulo, List<Musica> musicas, User usuario) {
        this.id = id;
        this.titulo = titulo;
        this.usuario = usuario;
        this.musicas = musicas;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return "Playlist{" + "id=" + id + ", titulo=" + titulo + ", usuario=" + usuario + ", musicas=" + musicas + '}';
    }
    
   
}
