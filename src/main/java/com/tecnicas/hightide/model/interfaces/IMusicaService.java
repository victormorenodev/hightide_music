/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnicas.hightide.model.interfaces;

import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Musica.Genero;
import java.util.List;

/**
 *
 * @author Victor Moreno
 */
public interface IMusicaService {
    public Musica createMusica(String titulo, String artista, String capa, String url, Genero genero);
    public Boolean deleteMusica(Integer id);
    public List<Musica> listaTodasMusicas();
    public Musica musicaByTitulo(String titulo);
}