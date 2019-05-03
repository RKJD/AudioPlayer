package m06.uf1.p1.grup5.modelo;

import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

public class Audio {

    BasicPlayer player;

    public Audio(String fitxerAudio) {
        player = new BasicPlayer();
        try {
            player.open(new File(fitxerAudio));
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public BasicPlayer getPlayer() {
        return player;
    }

    public void setPlayer(BasicPlayer player) {
        this.player = player;
    }

}
