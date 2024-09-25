/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide.controller;

import com.tecnicas.hightide.controller.interfaces.IQueueController;
import com.tecnicas.hightide.model.models.Musica;
import java.util.*;

/**
 *
 * @author Victor Moreno
 */
public class QueueController implements IQueueController{
    LinkedList<Musica> queue;
    Musica musicaAtualNaFila;
    
    public QueueController(List<Musica> musicas) {
        queue = new LinkedList<Musica>();
    }
    
    public List<Musica> getCurrentQueue() {
        return queue.subList(0, queue.size()-1);
    }
    
    public List<Musica> setCurrentQueue(List<Musica> list) {
        LinkedList<Musica> newQueue = new LinkedList<Musica>(list);
        setQueue(newQueue);
        return getCurrentQueue();
    }
            
    public LinkedList<Musica> getQueue() {
        return queue;
    }

    public void setQueue(LinkedList<Musica> queue) {
        this.queue = queue;
    }

    public Musica getMusicaAtualNaFila() {
        return musicaAtualNaFila;
    }

    public void setMusicaAtualNaFila(Musica musicaAtualNaFila) {
        this.musicaAtualNaFila = musicaAtualNaFila;
    }

    @Override
    public Musica proxMusica() {
        Integer proxMusicaIndex = queue.indexOf(musicaAtualNaFila)+1;
        if (proxMusicaIndex > queue.size()-1) {
            setMusicaAtualNaFila(queue.get(0));
            return getMusicaAtualNaFila();
        }
        else {
            setMusicaAtualNaFila(queue.get(proxMusicaIndex));
            return getMusicaAtualNaFila();
        }
    }

    @Override
    public Musica musicaAnterior() {
        Integer proxMusicaIndex = queue.indexOf(musicaAtualNaFila)-1;
        if (proxMusicaIndex < 0) {
            setMusicaAtualNaFila(queue.get(queue.size()-1));
            return getMusicaAtualNaFila();
        }
        else {
            setMusicaAtualNaFila(queue.get(proxMusicaIndex));
            return getMusicaAtualNaFila();
        }
    }
    
    
}
