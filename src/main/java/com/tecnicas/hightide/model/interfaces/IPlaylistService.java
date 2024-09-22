/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnicas.hightide.model.interfaces;

import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Playlist;
import java.util.List;

/**
 *
 * @author Victor Moreno
 */
public interface IPlaylistService {
    public Playlist createPlaylist(String titulo, List<Musica> musicas);
    public void addMusica(String playlistTitulo, String musicaTitulo);
    public void removeMusica(String playlistTitulo, String musicaTitulo);
    public Boolean deletaPlaylist(Integer playlistId);
    public List<Playlist> listaPlaylists();
    public Playlist acessaPlaylist(String playlistTitle);
}
