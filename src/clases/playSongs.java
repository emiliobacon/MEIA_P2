package clases;

import jaco.mp3.player.MP3Player;
import java.io.File;

public class playSongs {
    
     
    
    public static void play(String Cancion)
    {
        new MP3Player(new File("C:\\MEIA\\Musica\\" + Cancion + ".mp3")).stop(); 
    }
      public static void stop(String Cancion)
    {
        new MP3Player(new File("C:\\MEIA\\Musica\\" + Cancion + ".mp3")).stop();
    }
}
