/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tecnicas.hightide;

import java.io.FileInputStream;
import java.io.IOException;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

/**
 *
 * @author Victor Moreno
 */
public class MP3Player {
    public static void tocarMusica(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Player player = new Player(fileInputStream);
            player.play(); // Toca a música
        } catch (JavaLayerException e) {
            System.out.println("Erro ao tocar o MP3: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erro ao abrir o arquivo: " + e.getMessage());
        }
    }
}
