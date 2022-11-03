package clases;


import jaco.mp3.player.MP3Player;

import java.io.File;

public class PlaySong
{
    static MP3Player player = new MP3Player();
    
    public static void Crear(String ruta)
    {    
        player.addToPlayList(new File("C:\\MEIA\\Musica\\" + ruta + ".mp3"));
    }
    
    public static void Siguiente()
    {
        player.skipForward();
    }
    public static void Play()
    {
        player.play();
    }
    
    public static void Stop()
    {
        player.stop();
    }
    
  
}


