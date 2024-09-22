/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.controller;

import com.tecnicas.hightide.controller.ControllerUtils.ControllerUtils;
import com.tecnicas.hightide.controller.interfaces.IPlaylistController;
import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Playlist;
import com.tecnicas.hightide.model.services.PlaylistService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rivan
 */
public class PlaylistController implements IPlaylistController{
    PlaylistService playlistService = new PlaylistService();
    ControllerUtils controllerUtils = new ControllerUtils();
    
    @Override
    public List<Playlist> listAllPlaylists() {
        return playlistService.listaPlaylists();
    }

    @Override
    public Playlist playPlaylist(String playlistTitle) {
        if (!(controllerUtils.isStringValid(playlistTitle) && playlistExists(playlistTitle))){
            return null;
        }
        return playlistService.acessaPlaylist(playlistTitle);
    }
    
    @Override
    public Playlist addMusicToPlaylist(String playlistTitle, String musicTitle) {
        if(!(controllerUtils.isStringValid(playlistTitle) && controllerUtils.isStringValid(musicTitle) && controllerUtils.musicExists(musicTitle) && playlistExists(playlistTitle))){
            return null;
        }
        playlistService.addMusica(playlistTitle, musicTitle);
        return playlistService.acessaPlaylist(playlistTitle);
    }

    @Override
    public Playlist removeMusicFromPlaylist(String playlistTitle, String musicTitle) {
        if(!(controllerUtils.isStringValid(playlistTitle) && controllerUtils.isStringValid(musicTitle) && controllerUtils.musicExists(musicTitle) && playlistExists(playlistTitle) && musicInPlaylist(playlistTitle, musicTitle))){
            return null;
        }
        playlistService.removeMusica(playlistTitle, musicTitle);
        return playlistService.acessaPlaylist(playlistTitle);
    }

    @Override
    public List<Musica> listaMusicasPlaylist(String playlistTitle) {
        if(controllerUtils.isStringValid(playlistTitle) && playlistExists(playlistTitle)){
            return playlistService.acessaPlaylist(playlistTitle).getMusicas();
        }
        return null;
    }

    @Override
    public Playlist createPlaylist(String playlistTitle) {
        List<Musica> newPlaylist = new ArrayList<>();
        if (controllerUtils.isStringValid(playlistTitle) && !(playlistExists(playlistTitle))){
            return playlistService.createPlaylist(playlistTitle, newPlaylist);
        }
        return null;
    }

    @Override
    public Boolean deletePlaylist(String playlistTitle) {
        if (controllerUtils.isStringValid(playlistTitle) && playlistExists(playlistTitle)){
            playlistService.deletaPlaylist(playlistTitle);
            return true;
        }
        return false;
    }
    
    public Boolean playlistExists(String playlistTitle){
        return playlistService.acessaPlaylist(playlistTitle) != null;
    }
    
    public Boolean musicInPlaylist(String playlistTitle, String musicTitle){
        List<Musica> playlist = new ArrayList<>(playlistService.acessaPlaylist(playlistTitle).getMusicas());
        return playlist.contains(controllerUtils.accessMusic(musicTitle));
    }
}
