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
    public Playlist createPlaylist(String titulo, List<Musica> musicas, String userId);
    public void addMusica(String playlistId, String musicaId);
    public void removeMusica(String playlistId, String musicaId);
    public void deletaPlaylist(String playlistId);
    public List<Musica> listaMusicasPlaylist(String playlistId);
    public List<Playlist> listaPlaylists(String usuarioId);
    public Playlist acessaPlaylist(String playlistId);
}
