/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.model.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Victor Moreno
 */

@Entity
@Table(name = "musicas")
public class Musica implements Serializable{
    
    public enum Genero {
        RAP, POP, ELETRONICA, TRAP, CLASSICA, MPB;
    }
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;
    private String capa;
    private String titulo;
    private String artista;
    private String url;
    @Enumerated(EnumType.STRING)
    private Genero genero;
    
    public Musica() {
        
    }

    public Musica(Integer id, String capa, String titulo, String artista, String url, Genero genero) {
        this.id = id;
        this.capa = capa;
        this.titulo = titulo;
        this.artista = artista;
        this.url = url;
        this.genero = genero;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return "Musica{" + "id=" + id + ", capa=" + capa + ", titulo=" + titulo + ", artista=" + artista + ", url=" + url + ", genero=" + genero + '}';
    }

   
}
