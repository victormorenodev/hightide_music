/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.controller;

import com.tecnicas.hightide.model.models.Musica;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.*;

/**
 *
 * @author Victor Moreno
 */
public class MusicPlayerController {
    QueueController queue;
    Clip clip;
    Musica musicaAtual;
    Boolean isPlaying;
    
    public MusicPlayerController(QueueController q) {
        this.queue = q;
        this.isPlaying = false;
    }
    
    public void tocarMusica(Musica musica) {
        try {
            File audioFile = new File(musica.getUrl());
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            clip = AudioSystem.getClip();
            clip.open(audioStream);
            
            queue.setMusicaAtualNaFila(musica);
            setMusicaAtual(musica);
            clip.start();
            setIsPlaying(true);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
        }
    }
    
    // Método para pausar música
    public void pausarMusica() {
        clip.stop();
        setIsPlaying(false);
    }

    // Método para retomar música
    public void retomarMusica() {
        clip.start();
        setIsPlaying(true);
    }
    
    public void pararMusica() {
        clip.close();
        setIsPlaying(false);
    }
    
    public Musica proximaMusica() {
        clip.close();
        setMusicaAtual(queue.proxMusica());
        tocarMusica(getMusicaAtual());
        return getMusicaAtual();
    }
    
    public Musica musicaAnterior() {
        clip.close();
        setMusicaAtual(queue.musicaAnterior());
        tocarMusica(getMusicaAtual());
        return getMusicaAtual();
    }

    public Musica getMusicaAtual() {
        return musicaAtual;
    }

    public void setMusicaAtual(Musica musicaAtual) {
        this.musicaAtual = musicaAtual;
    }

    public Boolean getIsPlaying() {
        return isPlaying;
    }

    public void setIsPlaying(Boolean isPlaying) {
        this.isPlaying = isPlaying;
    }
    
    
}
