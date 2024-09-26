/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.tecnicas.hightide;

import com.tecnicas.hightide.controller.MusicController;
import com.tecnicas.hightide.controller.PlaylistController;
import com.tecnicas.hightide.model.models.Musica.Genero;
import static com.tecnicas.hightide.model.models.Musica.Genero.*;
import com.tecnicas.hightide.view.telaHightide;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
        
/**
 *
 * @author Victor Moreno
 */
public class Hightide {

    public static void main(String[] args) {
     
        MusicController musicController = new MusicController();
        PlaylistController playlistController = new PlaylistController();
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistence.xml");
        
        String musicTestUrl = "src/main/resources/musics/InDaClub.wav";
        String musicTestUrl2 = "src/main/resources/musics/Machuca.wav";
        String musicTestUrl3 = "src/main/resources/musics/Pinguinos.wav";
        for (Genero genero : Genero.values()) {
            playlistController.createPlaylist(genero.toString().toUpperCase());
        }
        musicController.addMusic(musicTestUrl, "RAP", "50 Cent");
        musicController.addMusic(musicTestUrl2, "RAP", "DJ Arana");
        musicController.addMusic(musicTestUrl3, "POP", "La van a Mascar");
       
        
        
        playlistController.createPlaylist("Rivanio Tracks");
        playlistController.addMusicToPlaylist("Rivanio Tracks", "InDaClub");
        playlistController.addMusicToPlaylist("Rivanio Tracks", "Machuca");
        playlistController.createPlaylist("Todas as Musicas");
        playlistController.addMusicToPlaylist("Todas as Musicas", "InDaClub");
        playlistController.addMusicToPlaylist("Todas as Musicas", "Machuca");
        playlistController.addMusicToPlaylist("Todas as Musicas", "Pinguinos");
        
        
        emf.close();
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(telaHightide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(telaHightide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(telaHightide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(telaHightide.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new telaHightide().setVisible(true);
            }
        });
    }
}
