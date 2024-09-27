/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.controller;

import com.tecnicas.hightide.controller.ControllerUtils.ControllerUtils;
import java.util.ArrayList;
import com.tecnicas.hightide.controller.interfaces.IMusicaController;
import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Musica.Genero;
import com.tecnicas.hightide.model.services.MusicaService;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author rivan
 */
public class MusicController implements IMusicaController{
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml");
    MusicaService musicaService = new MusicaService(emf);
    ControllerUtils controllerUtils = new ControllerUtils(emf);
    PlaylistController playlistController = new PlaylistController();
    
    @Override
    public List<Musica> listAllMusics() {
        //listaTodasMusicas(); 
        //retorna list 
        return musicaService.listaTodasMusicas();
    }

    @Override
    public List<Musica> listMusicsByGender(String gender) {
        //verifica se está vazio
        List<Musica> allmusic = new ArrayList<>(listAllMusics());
        Genero genderEnum = Genero.valueOf(gender);

        Iterator<Musica> iterator = allmusic.iterator();
        while (iterator.hasNext()) {
            Musica musica = iterator.next();
            // Remover músicas que não pertencem ao gênero selecionado
            if (!musica.getGenero().equals(genderEnum)) {
                iterator.remove();
        }
    }
        //retorna list
        return allmusic;
    }

    @Override
    public Musica addMusic(String musicUrl, String gender, String artist) {
        //verifica se tem algum campo vazio
        if (!(controllerUtils.isStringValid(musicUrl) && controllerUtils.isStringValid(artist) && controllerUtils.isStringValid(gender)) && controllerUtils.isMusicValid(musicUrl) && controllerUtils.isValidGender(gender)){
            return null;
        }
        
        //authenticationMusic(MusicUrl) / verifica se é mp3
        String urlcapa = "src/main/resources/album.png";
        String title = controllerUtils.getMusicNameFromURL(musicUrl);
        
        //title <- nome do arquivo .mp3
        
        //musicaByTitutlo(title) / verifica se já existe musica com esse titulo
        if(controllerUtils.musicExists(title)){
            return null;
        }
        
        //adicionar urlcapa, verifica se o url é valido .png;
        
        
        //createMusica(title, artist, urlcapa, musicUrl, gender)
        Genero genero = Genero.valueOf(gender.toUpperCase());
        System.out.println("\n \n "+ gender + title +"\n \n \n");
        musicaService.createMusica(title, artist, urlcapa, musicUrl, genero);
        
        playlistController.addMusicToPlaylist(gender, title);
        playlistController.addMusicToPlaylist("Todas as Musicas", title);
        return musicaService.musicaByTitulo(title);
    }

    @Override
    public Boolean deleteMusic(String musicTitle) {
        if (!(controllerUtils.isStringValid(musicTitle) && (controllerUtils.musicExists(musicTitle)))){
            return false;
        }
        //verifica se a musica existe musicaByTitulo( musicTitle);
        
        //passa o id da musica pra deletar / deleteMusica(musica.getid());
        return musicaService.deleteMusica(musicaService.musicaByTitulo(musicTitle).getId());
        //retorna TRUE se a musica foi deletada
        
       
    }

    /*@Override
    public Musica playMusic(String musicTitle) {
        if((controllerUtils.isStringValid(musicTitle) && controllerUtils.musicExists(musicTitle))){
            if (musicaAtual == null) {
                musicaAtual = controllerUtils.accessMusic(musicTitle);
                player.tocarMusica(musicaAtual.getUrl());
                isPlaying = true;
            } else {
                if (musicaAtual.getTitulo().equals(musicTitle) == false) {
                    //posicaoAtualMusica = 0;
                    musicaAtual = controllerUtils.accessMusic(musicTitle);
                    player.pararMusica();
                    player.tocarMusica(musicaAtual.getUrl());
                    isPlaying = true;
                } else {
                    if (isPlaying == true) {
                        isPlaying = false;
                        player.pausarMusica();
                    } else {
                        isPlaying = true;
                        player.retomarMusica();
                    }
                }
            }
        }
        //musicaByTitulo(musicTitle);
        //retorna musica se != null
        return musicaAtual;
    }*/

    /*public Integer getPosicaoAtualMusica() {
        return posicaoAtualMusica;
    }

    public void setPosicaoAtualMusica(int posicaoAtualMusica) {
        this.posicaoAtualMusica = posicaoAtualMusica;
    }*/
    
    public Musica musicByTitle(String musicTitle) {
        if((controllerUtils.isStringValid(musicTitle) && controllerUtils.musicExists(musicTitle))){
            return controllerUtils.accessMusic(musicTitle);
        } else {
            return null;
        }
    }
}