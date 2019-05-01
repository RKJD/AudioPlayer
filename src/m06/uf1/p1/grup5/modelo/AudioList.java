/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.p1.grup5.modelo;

import java.util.Random;

/**
 *
 * @author Marc
 */
public class AudioList {
    private int[] tracks;
    private int currentSong;
    public AudioList(int[] tracks){
        this.tracks = tracks;
        currentSong = tracks.length-1;
    }
    /***@return Devuelve el orden de ids en formato de array*/
    public int[] getTracks(){return tracks;}
    /***@return Devuelve el id de una canción de la lista en la posición especificada*/
    public int getTrack(int i){
        currentSong = i;
        return tracks[i];
    }
    /***@param i Canción que se está reproduciendo actualmente
     * @return Devuelve el id de la siguiente canción en orden*/
    public int getNextTrack(int i){
        if(i<tracks.length) return getTrack(i);
        else return getTrack(0);
    }
    /***@return Devuelve el id de la siguiente canción en orden*/
    public int getNextTrack(){
        if(currentSong<tracks.length) return getTrack(currentSong);
        else return getTrack(0);
    }
    /***@return Devuelve el id de una canción aleatória de la lista*/
    public int getTrack(Random rand){return tracks[(int)(rand.nextFloat()*tracks.length)];}
    public void test(){
    }
}
