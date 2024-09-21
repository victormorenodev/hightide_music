/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.controller;

import java.util.ArrayList;
import java.util.List;
import com.tecnicas.hightide.controller.interfaces.IMusicaController;
import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.services.MusicaService;
import java.util.List;
import java.io.File;

/**
 *
 * @author rivan
 */
public class MusicController implements IMusicaController{
    MusicaService musicaservice = new MusicaService();
    @Override
    public List<Musica> listAllMusics() {
        //listaTodasMusicas(); 
        //retorna list 
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Musica addMusic(String musicUrl, Musica.Genero gender, String artist) {
        //verifica se tem algum campo vazio
        if (!(isStringValid(musicUrl) && isStringValid(artist)) && isMusicValid(musicUrl) ){
            return null;
        }
        
        //authenticationMusic(MusicUrl) / verifica se é mp3
        String urlcapa = "capa.png";
        String title = getMusicNameFromURL(musicUrl);
        
        //title <- nome do arquivo .mp3
        
        //musicaByTitutlo(title) / verifica se já existe musica com esse titulo
        if(!musicExists(title)){
            return null;
        }
        
        //adicionar urlcapa, verifica se o url é valido .png;
        
        
        //createMusica(title, artist, urlcapa, musicUrl, gender)
        return musicaservice.createMusica(title, artist, urlcapa, musicUrl, gender);
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Boolean deleteMusic(String musicTitle) {
        if (!(isStringValid(musicTitle) && (musicExists(musicTitle)))){
            return false;
        }
        //verifica se a musica existe musicaByTitulo( musicTitle);
        
        //passa o id da musica pra deletar / deleteMusica(musica.getid());
        return musicaservice.deleteMusica(musicaservice.musicaByTitulo(musicTitle).getId());
        //retorna TRUE se a musica foi deletada
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Musica playMusic(String musicTitle) {
        //verifica se está vazio
        if(!(isStringValid(musicTitle) && musicExists(musicTitle))){
            return null;
        }
        
        return musicaservice.musicaByTitulo(musicTitle);
        
        //musicaByTitulo(musicTitle);
        //retorna musica se != null
        
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Boolean musicExists(String musicTitle){
        return musicaservice.musicaByTitulo(musicTitle) != null;
    }
    
    public Boolean isMusicValid(String musicUrl){
        File music = new File(musicUrl);
        //verificar se é .mp3
        return music.exists() && music.isFile() && musicUrl.toLowerCase().endsWith(".mp3");
    }
    
    public Boolean isStringValid(String input) {
        return input != null && !input.trim().isEmpty();
    }
    
    public static String getMusicNameFromURL(String musicUrl){
        return musicUrl.substring(musicUrl.lastIndexOf("/") + 1 );
    }
    
}