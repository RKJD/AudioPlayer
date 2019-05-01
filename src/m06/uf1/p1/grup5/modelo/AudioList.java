package m06.uf1.p1.grup5.modelo;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;

public class AudioList {
    private String name,desc, imgPath;
    private int[] tracks;
    private int currentSong;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public AudioList(String name, String description, int[] tracks){
        defineValues(name, description, tracks);
        imgPath = null;
    }
    public AudioList(String name, String description, String picture, int[] tracks){
        defineValues(name, description, tracks);
        imgPath = picture;
    }
    private void defineValues(String name, String description, int[] tracks){
        this.name = name;
        this.desc = description;
        this.tracks = tracks;
        currentSong = tracks.length-1;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters">
    /***@return Devuelve el nombre de la lista*/
    public String getName(){return name;}
    /***@return Devuelve la descripción de la lista*/
    public String getDescription(){return desc;}
    /***@return Devuelve el orden de ids en formato de array*/
    public int[] getTracks(){return tracks;}
    /***
     * Comprueba si la lista tiene una imagen y el archivo existe.
     * @exception NoSuchFieldException si esta lista no tiene imagen
     * @exception FileNotFoundException si el archivo no existe
     * @return Devuelve el archivo si existe
     */
    public File getImage() throws NoSuchFieldException, FileNotFoundException{
        if(imgPath.equals(null)) throw new NoSuchFieldException("This album have no Picture");
        else{
            File retorno = new File(imgPath);
            if(retorno.exists()) return retorno;
            else throw new FileNotFoundException("This file doesn't exist");
        }
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Nav Getters">
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
    public int getTrack(Random rand){return getTrack((int)(rand.nextFloat()*tracks.length));}
    /***@return Devuelve el id de la canción actual de la lista*/
    public int getTrack(){return tracks[currentSong];}
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Setters">
    /*** Selecciona una canción de la lista
     * @param i Número de canción seleccionada en el orden de la lista*/
    public void setCurrentSong(int i){
        if(tracks.length < i)
            currentSong = i;
        else
            throw new ArrayIndexOutOfBoundsException("Este número de canción no exite");
    }
//</editor-fold>
   
    @Override
    public String toString() {
        String lista = "";
        for(int t : tracks)
            lista+=","+tracks;
        return name +": "+desc+"\n Ubicado en "+imgPath+"\n ["+lista.substring(1)+"]";
    }
}
