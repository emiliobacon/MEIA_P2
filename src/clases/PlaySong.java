package clases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class PlaySong {
    
    public void Reproducir() throws FileNotFoundException, JavaLayerException
    {
        FileInputStream fileInputStream = new FileInputStream("song.mp3");

        Player player = new Player(fileInputStream);

        System.out.println("Song is playing...");
        player.play();
        
    }


}