package m06.uf1.p1.grup5.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import m06.uf1.p1.grup5.modelo.Audio;
import m06.uf1.p1.grup5.vista.Vista;

public class Controlador implements ActionListener {

    private Vista vista;
    private Audio audio;

    public Controlador() {
        vista = new Vista();
        audio = new Audio("audios/stepahead.mp3");
        afegirListenerBotons();
    }

    public void afegirListenerBotons() {
        vista.getPlay().addActionListener(this);
        vista.getStop().addActionListener(this);
        vista.getPausa().addActionListener(this);
        vista.getContinuar().addActionListener(this);
    }

    //Dotem de funcionalitat als botons
    public void actionPerformed(ActionEvent esdeveniment) {
        //Declarem el gestor d'esdeveniments
        Object gestorEsdeveniments = esdeveniment.getSource();
        try {
            if (gestorEsdeveniments.equals(vista.getPlay())) { //Si hem pitjat el boto play
                audio.getPlayer().play(); //reproduim l'àudio
            } else if (gestorEsdeveniments.equals(vista.getStop())) {
                //Si hem pitjat el boto stop
                audio.getPlayer().stop(); //parem la reproducció de l'àudio
            } else if (gestorEsdeveniments.equals(vista.getPausa())) {
                //Si hem pitjat el boto stop
                audio.getPlayer().pause(); //pausem la reproducció de l'àudio
            } else if (gestorEsdeveniments.equals(vista.getContinuar())) {
                //Si hem pitjat el boto stop
                audio.getPlayer().resume(); //continuem la reproducció de l'àudio
            }
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }
}
