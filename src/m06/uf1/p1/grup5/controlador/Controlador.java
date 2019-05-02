package m06.uf1.p1.grup5.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.xml.parsers.ParserConfigurationException;
import javazoom.jlgui.basicplayer.BasicPlayerException;
import m06.uf1.p1.grup5.modelo.Audio;
import m06.uf1.p1.grup5.modelo.AudioList;
import m06.uf1.p1.grup5.modelo.Cancion;
import m06.uf1.p1.grup5.modelo.Playlist;
import m06.uf1.p1.grup5.vista.Vista;

public class Controlador implements ActionListener {

    private Vista vista;
    private Audio audio;
    private XML memoria;
    private boolean isPlaying, isShuffle;
    private AudioList activeList, noList;
    private Random shuffleMode;

    public Controlador() {
        shuffleMode = new Random();
        isPlaying = false;
        isShuffle = false;
        try {
            memoria = new XML();
            noList = new AudioList("Sin Playlist", "No tienes ninguna playlist seleccionada.", memoria.cargarCanciones());
            memoria.cargarListas();
            vista = new Vista();
            activeList = getPlaylistData("Sin lista");

            afegirListenerBotons();

            String[] nomCanciones = new String[activeList.getTracks().length];
            for (int i = 0; i < activeList.getTracks().length; i++) {
                nomCanciones[i] = getCancion(activeList.getTrack(i)).getNom();
            }

            vista.updateBox(getPlaylistMap());
            vista.updateSongsStart(nomCanciones);
            audio = new Audio(getCancion(activeList.getNextTrack()).getRuta());
        } catch (IOException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void afegirListenerBotons() {
        vista.getPlay().addActionListener(this);
        vista.getStop().addActionListener(this);
        vista.getPausa().addActionListener(this);
        vista.getContinuar().addActionListener(this);
        vista.getAnteriro().addActionListener(this);
        vista.getSiguiente().addActionListener(this);
        vista.getComboBox().addActionListener(this);        
        vista.getTable().getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (!lse.getValueIsAdjusting() && vista.getTable().getSelectedRow() != -1) {
                    try {
                        audio.getPlayer().stop();
                        if (isShuffle) {
                            audio = new Audio(getCancion(activeList.getTrack(vista.getTable().getSelectedRow())).getRuta());
                        }
                        vista.updateSongInfo(getCancion(activeList.getTrack()));
                        if (isPlaying) {
                            audio.getPlayer().play();
                        }
                    } catch (BasicPlayerException ex) {
                        Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.out.println(vista.getTable().getSelectedRow());
                }
            }
        });
    }

//Dotem de funcionalitat als botons
    public void actionPerformed(ActionEvent esdeveniment) {
        //Declarem el gestor d'esdeveniments
        Object gestorEsdeveniments = esdeveniment.getSource();
        try {
            if (gestorEsdeveniments.equals(vista.getPlay())) { //Si hem pitjat el boto play
                audio.getPlayer().play(); //reproduim l'àudio
                vista.updateSongInfo(getCancion(activeList.getTrack()));
                isPlaying = true;
                vista.updateSlider(2);
            } else if (gestorEsdeveniments.equals(vista.getStop())) {
                //Si hem pitjat el boto stop
                audio.getPlayer().stop(); //parem la reproducció de l'àudio
                isPlaying = false;
                vista.updateSlider(4);
            } else if (gestorEsdeveniments.equals(vista.getPausa())) {
                //Si hem pitjat el boto stop
                audio.getPlayer().pause(); //pausem la reproducció de l'àudio
                isPlaying = false;
                vista.updateSlider(8);
            } else if (gestorEsdeveniments.equals(vista.getContinuar())) {
                //Si hem pitjat el boto stop
                audio.getPlayer().resume(); //continuem la reproducció de l'àudio
                isPlaying = true;
                vista.updateSlider(16);
            } else if (gestorEsdeveniments.equals(vista.getAnteriro())) {
                tryToNav(activeList.getPreviousTrack());
            } else if (gestorEsdeveniments.equals(vista.getSiguiente())) {
                tryToNav(activeList.getNextTrack());
            } else if (gestorEsdeveniments.equals(vista.getComboBox())) {
                //Si hem cambiat el comboBox
                activeList = getPlaylistData(vista.getComboBox().getSelectedItem().toString());
                vista.updateListInfo(getPlaylistData(vista.getComboBox().getSelectedItem().toString()));
                String[] nomCanciones = new String[activeList.getTracks().length];
                for (int i = 0; i < activeList.getTracks().length; i++) {
                    nomCanciones[i] = getCancion(activeList.getTrack(i)).getNom();
                }
                vista.updateSongsStart(nomCanciones);
                wipeSong();
                audio = new Audio(getCancion(activeList.getNextTrack()).getRuta());
            }
        } catch (BasicPlayerException e) {
            e.printStackTrace();
        }
    }

    public Cancion getCancion(int id) {
        return memoria.MapCanciones.get(id);
    }

    public Map<String, Playlist> getPlaylistMap() {
        return memoria.MapPlaylist;
    }

    public AudioList getPlaylistData(String nombre) {
        if (nombre.equals("Sin lista")) {
            return noList;
        } else {
            return LeerJson.getList(memoria.MapPlaylist.get(nombre).getRuta());
        }
    }

    public boolean tryToNav(int i) {
        try {
            audio.getPlayer().stop();
            if (isShuffle) {
                audio = new Audio(getCancion(activeList.getTrack(shuffleMode)).getRuta());
            } else {
                audio = new Audio(getCancion(i).getRuta());
            }
            vista.updateSongInfo(getCancion(activeList.getTrack()));
            if (isPlaying) {
                audio.getPlayer().play();
            }
        } catch (BasicPlayerException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public void wipeSong() {
        try {
            vista.updateSongInfo(new Cancion(0, "", "", "", "", ""));
            audio.getPlayer().stop();

        } catch (BasicPlayerException ex) {
            Logger.getLogger(Controlador.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }
}
