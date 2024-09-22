/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tecnicas.hightide;

import com.tecnicas.hightide.controller.MusicController;
import com.tecnicas.hightide.controller.PlaylistController;
import static com.tecnicas.hightide.model.models.Musica.Genero.*;
import com.tecnicas.hightide.model.services.MusicaService;
import com.tecnicas.hightide.model.services.PlaylistService;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;
        
/**
 *
 * @author Victor Moreno
 */
public class Hightide {

    public static void main(String[] args) {
        
        MusicController musicController = new MusicController();
        PlaylistController playlistController = new PlaylistController();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml");
        
        String musicTestUrl = "src/main/resources/musics/InDaClub.mp3";
        String musicTestUrl2 = "src/main/resources/musics/FacasEBalas.mp3";
        musicController.addMusic(musicTestUrl, RAP, "50 Cent");
        musicController.addMusic(musicTestUrl2, RAP, "MC VV");
        
        playlistController.createPlaylist("Rivanio Tracks");
        playlistController.addMusicToPlaylist("Rivanio Tracks", "ViolentCrimes");
        playlistController.addMusicToPlaylist("Rivanio Tracks", "InDaClub");
        
        System.out.println("\n\n Playlists: "+playlistController.listAllPlaylists());
        System.out.println("\n\n Músicas do Rivânio Tracks: "+playlistController.listaMusicasPlaylist("Rivanio Tracks"));
        System.out.println("\n\n InDaClub is in Rivanio Tracks: "+playlistController.musicInPlaylist("Rivanio Tracks", "InDaClub"));
        
        playlistController.removeMusicFromPlaylist("Rivanio Tracks", "InDaClub");
        System.out.println("\n\n InDaClub is in Rivanio Tracks após deletar: "+playlistController.musicInPlaylist("Rivanio Tracks", "InDaClub"));
        
        System.out.println("\n\nRivanio Tracks existe: "+playlistController.playlistExists("Rivanio Tracks"));
        
        playlistController.deletePlaylist("Rivanio Tracks");
        
        System.out.println("\n\nRivanio Tracks existe após deletar: "+playlistController.playlistExists("Rivanio Tracks"));
        System.out.println("\n\n");
        
        String musicaUrl = musicController.playMusic("FacasEBalas");
        
        emf.close();
        MP3Player.tocarMusica(musicaUrl);
    }
}
