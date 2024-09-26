/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnicas.hightide.controller.interfaces;

import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Musica.Genero;
import java.util.List;

/**
 *
 * @author Victor Moreno
 */
public interface IMusicaController {
    public List<Musica> listAllMusics();
    public List<Musica> listMusicsByGender(String gender);
    public Musica addMusic(String musicUrl, Genero gender, String artist);
    public Boolean deleteMusic(String musicTitle);
    public Musica playMusic(String musicTitle);
}