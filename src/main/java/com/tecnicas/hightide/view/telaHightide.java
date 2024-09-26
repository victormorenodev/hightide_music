/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.tecnicas.hightide.view;

import com.tecnicas.hightide.controller.MusicController;
import com.tecnicas.hightide.controller.MusicPlayerController;
import com.tecnicas.hightide.controller.PlaylistController;
import com.tecnicas.hightide.controller.QueueController;
import com.tecnicas.hightide.model.interfaces.MusicPlayerObserver;
import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Playlist;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;

/**
 *
 * @author Usuario
 */
public class telaHightide extends javax.swing.JFrame implements MusicPlayerObserver{

    /**
     * Creates new form telaHightide
     */
    DefaultListModel listModel = new DefaultListModel();
    DefaultListModel playlistListModel = new DefaultListModel();
    DefaultListModel listGender = new DefaultListModel();
    MusicController musicController;
    Musica musicaAtual;
    PlaylistController playlistController;
    QueueController queue;  
    MusicPlayerController player;
    Musica musicaSelecionada = null;
    
    public telaHightide() {
        initComponents();
        musicController = new MusicController();
        List<Musica> musicsObjectList = new ArrayList<>(musicController.listAllMusics());
        queue = new QueueController(musicsObjectList);
        player = new MusicPlayerController(queue, this);
        for (Musica musica : musicsObjectList) {
            listModel.addElement(musica.getTitulo() + " - " + musica.getArtista());
        }
        musicsList.setModel(listModel);
        playButton.setText("PLAY");
        playButton.setEnabled(false);
        nextMusicButton.setEnabled(false);
        previousMusicButton.setEnabled(false);
        
        playlistController = new PlaylistController();
        List<Playlist> playlistObjectList = new ArrayList<>(playlistController.listAllPlaylists());
        for (Playlist playlist : playlistObjectList) {
            playlistListModel.addElement(playlist.getTitulo());
        }
        playlistsList.setModel(playlistListModel);
        
        
      
        
        
    }
    
     private void managePlayButton() {
        if (playButton.isEnabled() == false || nextMusicButton.isEnabled() == false || previousMusicButton.isEnabled() == false) {
            playButton.setEnabled(true);
            nextMusicButton.setEnabled(true);
            previousMusicButton.setEnabled(true);
        }
        // se o player seleciona uma música diferente da atual, ou não há música atual ainda
        if (player.getMusicaAtual() != null) {
            if (!musicaSelecionada.getTitulo().equals(player.getMusicaAtual().getTitulo())) { 
                playButton.setText("PLAY");
                playButton.setSelected(false);
            } else { // player está com a música atual selecionada
                if (player.getIsPlaying() == true) { // ela está tocando
                    playButton.setText("PAUSE");
                    playButton.setSelected(true);
                } else { // ela não está tocando
                    playButton.setText("PLAY");
                    playButton.setSelected(false);
                }
            }
        } else {
            playButton.setText("PLAY");
            playButton.setSelected(false);
        }
    }    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        musicsList = new javax.swing.JList<>();
        playButton = new javax.swing.JToggleButton();
        labelArtistaAtual = new javax.swing.JLabel();
        labelMusicaAtual = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nextMusicButton = new javax.swing.JButton();
        previousMusicButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        playlistsList = new javax.swing.JList<>();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HighTide");
        setBackground(new java.awt.Color(0, 0, 255));
        setResizable(false);
        setSize(new java.awt.Dimension(650, 400));

        musicsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                musicsListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(musicsList);

        playButton.setText("PLAY");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        labelArtistaAtual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelArtistaAtual.setText("-");

        labelMusicaAtual.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        labelMusicaAtual.setText("-");

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 204, 0));
        jLabel1.setText("HighTide");

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel2.setText("Todas as músicas");

        nextMusicButton.setText(">>");
        nextMusicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextMusicButtonActionPerformed(evt);
            }
        });

        previousMusicButton.setText("<<");
        previousMusicButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousMusicButtonActionPerformed(evt);
            }
        });

        playlistsList.addHierarchyBoundsListener(new java.awt.event.HierarchyBoundsListener() {
            public void ancestorMoved(java.awt.event.HierarchyEvent evt) {
                playlistsListAncestorMoved(evt);
            }
            public void ancestorResized(java.awt.event.HierarchyEvent evt) {
            }
        });
        playlistsList.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                playlistsListPropertyChange(evt);
            }
        });
        playlistsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                playlistsListValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(playlistsList);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(51, 102, 0));
        jLabel3.setText("Playlists");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labelMusicaAtual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addComponent(labelArtistaAtual, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 134, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(previousMusicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nextMusicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(211, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(32, 32, 32))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(68, 68, 68))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(12, 12, 12)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(playButton)
                        .addComponent(nextMusicButton)
                        .addComponent(previousMusicButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(labelMusicaAtual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelArtistaAtual)))
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void musicsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_musicsListValueChanged
        if(musicsList.getSelectedValue() != null){
        musicaSelecionada = musicController.musicByTitle(musicsList.getSelectedValue().split(" - ")[0]);
        managePlayButton();
        }
        //jLabel7.setText(musicaSelecionada.getTitulo());
    }//GEN-LAST:event_musicsListValueChanged

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        if (player.getMusicaAtual() == null) {
            labelMusicaAtual.setText(musicaSelecionada.getTitulo());
            labelArtistaAtual.setText(musicaSelecionada.getArtista());
            player.tocarMusica(musicaSelecionada);
            managePlayButton();
            //jLabel6.setText(player.getMusicaAtual().getTitulo());
            //jLabel8.setText(player.getIsPlaying().toString());
            return;
        }
        if (!musicaSelecionada.getTitulo().equals(player.getMusicaAtual().getTitulo())) {
            labelMusicaAtual.setText(musicaSelecionada.getTitulo());
            labelArtistaAtual.setText(musicaSelecionada.getArtista());
            player.pararMusica();
            player.tocarMusica(musicaSelecionada);
            managePlayButton();
        } else {
            if (player.getIsPlaying() == true) {
                player.pausarMusica();
                managePlayButton();
            } else {
                player.retomarMusica();
                managePlayButton();
            }
        }
       //jLabel6.setText(player.getMusicaAtual().getTitulo());
       //jLabel8.setText(player.getIsPlaying().toString());
    }//GEN-LAST:event_playButtonActionPerformed

    @Override
    public void playNextMusic() {
        int currentIndex = musicsList.getSelectedIndex(); // Obtém o índice atual
        if (currentIndex < musicsList.getModel().getSize() - 1) { // Verifica se não é o último item
            musicsList.setSelectedIndex(currentIndex + 1); // Move para o próximo item
        } else {
            musicsList.setSelectedIndex(0);
        }
        player.proximaMusica();
        updateCurrentMusicInfo();
        managePlayButton();    
    }
    
    private void nextMusicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextMusicButtonActionPerformed
        playNextMusic();
    }//GEN-LAST:event_nextMusicButtonActionPerformed

    private void previousMusicButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousMusicButtonActionPerformed
        int currentIndex = musicsList.getSelectedIndex(); // Obtém o índice atual
        if (currentIndex > 0) { // Verifica se não é o primeiro item
            musicsList.setSelectedIndex(currentIndex - 1); // Move para o item anterior
        } else {
            musicsList.setSelectedIndex(musicsList.getModel().getSize() - 1);
        }
        player.musicaAnterior();
        updateCurrentMusicInfo();
        managePlayButton();
    }//GEN-LAST:event_previousMusicButtonActionPerformed

        private void updateCurrentMusicInfo() {
        if (musicaSelecionada != null) {
            labelMusicaAtual.setText(musicaSelecionada.getTitulo());
            labelArtistaAtual.setText(musicaSelecionada.getArtista());
        }
    }
    
    private void playlistsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_playlistsListValueChanged
        // TODO add your handling code here:
        if (!playlistsList.getSelectedValue().equals("") || playlistsList != null){
            listModel.clear();
            List<Musica> musicsObjectListPlaylist = new ArrayList (playlistController.listaMusicasPlaylist(playlistsList.getSelectedValue()));
            for (Musica musica : musicsObjectListPlaylist) {
                listModel.addElement(musica.getTitulo() + " - " + musica.getArtista());
            }
            musicsList.setModel(listModel);
            queue.setCurrentQueue(musicsObjectListPlaylist);
        }
    }//GEN-LAST:event_playlistsListValueChanged

    private void playlistsListPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_playlistsListPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_playlistsListPropertyChange

    private void playlistsListAncestorMoved(java.awt.event.HierarchyEvent evt) {//GEN-FIRST:event_playlistsListAncestorMoved
        // TODO add your handling code here:
    }//GEN-LAST:event_playlistsListAncestorMoved

    /**
     * @param args the command line arguments
     */
    //public static void main(String args[]) {}
     // Criando um JPanel

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelArtistaAtual;
    private javax.swing.JLabel labelMusicaAtual;
    private javax.swing.JList<String> musicsList;
    private javax.swing.JButton nextMusicButton;
    private javax.swing.JToggleButton playButton;
    private javax.swing.JList<String> playlistsList;
    private javax.swing.JButton previousMusicButton;
    // End of variables declaration//GEN-END:variables
}
