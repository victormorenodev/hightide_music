/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.controller;

import com.tecnicas.hightide.controller.ControllerUtils.ControllerUtils;
import java.util.ArrayList;
import com.tecnicas.hightide.controller.interfaces.IMusicaController;
import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.services.MusicaService;
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
    
    @Override
    public List<Musica> listAllMusics() {
        //listaTodasMusicas(); 
        //retorna list 
        return musicaService.listaTodasMusicas();
    }

    @Override
    public List<Musica> listMusicsByGender(Musica.Genero gender) {
        //verifica se está vazio
        List<Musica> allmusic = new ArrayList<>(listAllMusics());
        
        //remove da lista se gender != musica.genero para toda musica em list
        for (Musica musica : allmusic){
            if(musica.getGenero() != gender){
                allmusic.remove(musica);
            }
        }
        //retorna list
        return allmusic;
        
    }

    @Override
    public Musica addMusic(String musicUrl, Musica.Genero gender, String artist) {
        //verifica se tem algum campo vazio
        if (!(controllerUtils.isStringValid(musicUrl) && controllerUtils.isStringValid(artist)) && controllerUtils.isMusicValid(musicUrl) ){
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
        return musicaService.createMusica(title, artist, urlcapa, musicUrl, gender);
        
        
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

    @Override
    public String playMusic(String musicTitle) {
        //verifica se está vazio
        if(!(controllerUtils.isStringValid(musicTitle) && controllerUtils.musicExists(musicTitle))){
            return null;
        }
        
        return musicaService.musicaByTitulo(musicTitle).getUrl();
        
        //musicaByTitulo(musicTitle);
        //retorna musica se != null
    }
}