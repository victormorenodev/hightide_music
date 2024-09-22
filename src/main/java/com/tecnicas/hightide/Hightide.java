/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tecnicas.hightide;

import com.tecnicas.hightide.controller.MusicController;
import static com.tecnicas.hightide.model.models.Musica.Genero.*;
import com.tecnicas.hightide.model.services.MusicaService;
        
/**
 *
 * @author Victor Moreno
 */
public class Hightide {

    public static void main(String[] args) {
        
        MusicController musicController = new MusicController();
        String musicTestUrl = "src/main/resources/musics/InDaClub.mp3";
        
        musicController.addMusic(musicTestUrl, RAP, "50 Cent");
        //musicController.deleteMusic("InDaClub");
        String musicaUrl = musicController.playMusic("InDaClub");
        
        MP3Player.tocarMusica(musicaUrl);
    }
}
