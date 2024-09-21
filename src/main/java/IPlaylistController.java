
import com.tecnicas.hightide.model.models.Musica;
import com.tecnicas.hightide.model.models.Playlist;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

/**
 *
 * @author Victor Moreno
 */
public interface IPlaylistController {
    public List<Playlist> listAllPlaylists();
    public Playlist playPlaylist(String playlistTitle);
    public Playlist addMusicToPlaylist(String playlistTitle, String musicTitle);
    public Playlist removeMusicFromPlaylist(String playlistTitle, String musicTitle);
    public Playlist createPlaylist(String playlistTitle);
    public Boolean deletePlaylist(String playlistTitle);
    public List<Musica> listaMusicasPlaylist(String playlistId);
}
