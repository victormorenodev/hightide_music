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
        queue = new LinkedList<Musica>(musicas);
    }
    
    public List<Musica> getCurrentQueue() {
        return queue.subList(0, queue.size());
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
        // procura o índice da música atual na fila comparando os títulos
        int currentIndex = -1;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getTitulo().equals(musicaAtualNaFila.getTitulo())) {
                currentIndex = i;
                break;
            }
        }

        // calcula o índice da próxima música
        int proxMusicaIndex = currentIndex + 1;

        // se passou do tamanho da fila, volta para o início
        if (proxMusicaIndex >= queue.size()) {
            proxMusicaIndex = 0;
        }

        // define a próxima música como a atual
        setMusicaAtualNaFila(queue.get(proxMusicaIndex));
        return getMusicaAtualNaFila();
    }

    @Override
    public Musica musicaAnterior() {
        // procura o índice da música atual na fila comparando os títulos
        int currentIndex = -1;
        for (int i = 0; i < queue.size(); i++) {
            if (queue.get(i).getTitulo().equals(musicaAtualNaFila.getTitulo())) {
                currentIndex = i;
                break;
            }
        }

        // calcula o índice da música anterior
        int prevMusicaIndex = currentIndex - 1;

        // se o índice é menor que zero, volta para o fim da fila
        if (prevMusicaIndex < 0) {
            prevMusicaIndex = queue.size() - 1;
        }

        // define a música anterior como a atual
        setMusicaAtualNaFila(queue.get(prevMusicaIndex));
        return getMusicaAtualNaFila();
    }
}
