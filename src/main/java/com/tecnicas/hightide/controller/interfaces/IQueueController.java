/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.tecnicas.hightide.controller.interfaces;

import com.tecnicas.hightide.model.models.Musica;
import java.util.List;

/**
 *
 * @author Victor Moreno
 */
public interface IQueueController {
    public List<Musica> getCurrentQueue();
    public Musica proxMusica();
    public Musica musicaAnterior();
}
