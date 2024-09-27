/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.controller.ControllerUtils;

import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Musica.Genero;
import java.io.File;
import com.tecnicas.hightide.model.services.MusicaService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rivan
 */
public class ControllerUtils {
    private MusicaService musicService;
    public ControllerUtils(EntityManagerFactory entityFactory) {
        musicService = new MusicaService(entityFactory);
    }
    
    public Boolean musicExists(String musicTitle){
        return musicService.musicaByTitulo(musicTitle) != null;
    }
    
    public Boolean isValidGender(String gender) {
        try {
            Genero.valueOf(gender.toUpperCase());  // Tenta converter
            return true;
        } catch (IllegalArgumentException e) {
            return false;  // Caso lance exceção, a string não é válida
        }
    }
    
    public Musica accessMusic(String musicTitle){
        return musicService.musicaByTitulo(musicTitle);
    }
    
    public Boolean isMusicValid(String musicUrl){
        File music = new File(musicUrl);
        //verificar se é .mp3
        return music.exists() && music.isFile() && musicUrl.toLowerCase().endsWith(".mp3");
    }
    
    public Boolean isStringValid(String input) {
        return input != null && !input.trim().isEmpty();
    }
    
    public String getMusicNameFromURL(String musicUrl){
    int lastSlashIndex = Math.max(musicUrl.lastIndexOf("/"), musicUrl.lastIndexOf("\\"));
    
    if (lastSlashIndex == -1) {
        lastSlashIndex = 0;
    } else {
        lastSlashIndex += 1; 
    }
        return musicUrl.substring(lastSlashIndex, musicUrl.length()-4);
    }
}
