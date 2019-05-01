package m06.uf1.p1.grup5.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private boolean isPlaying;
    private AudioList activeList, noList;
    
    public Controlador() {
        isPlaying = false;
        try {
            memoria = new XML();
            noList = new AudioList("No list", "No list selected", memoria.cargarCanciones());
            memoria.cargarListas();
            vista = new Vista();
            activeList = getPlaylistData(1);
            audio = new Audio(getCancion(activeList.getNextTrack()).getRuta());
            afegirListenerBotons();
            
            String[] nomCanciones = new String[activeList.getTracks().length];
            for (int i = 0; i < activeList.getTracks().length; i++) {
                nomCanciones[i] =  getCancion(activeList.getTrack(i)).getNom();
            }
            vista.updateSongsStart(nomCanciones);
            
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
            } else if (gestorEsdeveniments.equals(vista.getStop())) {
                //Si hem pitjat el boto stop
                audio.getPlayer().stop(); //parem la reproducció de l'àudio
                audio = new Audio(getCancion(activeList.getNextTrack()).getRuta());
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
    public Cancion getCancion(int id){
        return memoria.MapCanciones.get(id);
    }
    public Map<Integer, Playlist> getPlaylistMap(int id){
        return memoria.MapPlaylist;
    }
    public AudioList getPlaylistData(int id){
        if(id == 0) return noList;
        else return LeerJson.getList(memoria.MapPlaylist.get(id).getRuta());
        
    }
}
