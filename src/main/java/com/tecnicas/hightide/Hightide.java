/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tecnicas.hightide;

import com.tecnicas.hightide.model.models.Musica;
import static com.tecnicas.hightide.model.models.Musica.Genero.*;
import com.tecnicas.hightide.model.services.MusicaService;
        
/**
 *
 * @author Victor Moreno
 */
public class Hightide {

    public static void main(String[] args) {
        MusicaService musicaService = new MusicaService();

        musicaService.createMusica("Musica Rap1", "Rivanio", "Capa", "url", RAP);
        musicaService.createMusica("Musica Rap2", "Rivanio", "Capa", "url", RAP);
        musicaService.createMusica("Musica Pop1", "RivanioPop", "Capa", "url", POP);
        
     
        System.out.println("Musicas: \n + " + musicaService.listaTodasMusicas());
        
        Musica musicaPop = musicaService.musicaByTitulo("Musica Pop1");
        System.out.println("\n\nMusica Pop: " + musicaPop);
    
        musicaService.deleteMusica(musicaPop.getId());
        
        System.out.println("\n\nMusicas depois de deletar Musica Pop: \n" + musicaService.listaTodasMusicas());
    }
}
