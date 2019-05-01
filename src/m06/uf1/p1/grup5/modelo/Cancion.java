/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.p1.grup5.modelo;

/**
 *
 * @author raulk
 */
public class Cancion {

    private int id;
    private String nom, autor, album, durada, ruta;
    
//<editor-fold defaultstate="collapsed" desc="Constructors">
    public Cancion(int id, String nom, String autor, String album, String durada, String ruta) {
        this.id = id;
        this.nom = nom;
        this.autor = autor;
        this.album = album;
        this.durada = durada;
        this.ruta = ruta;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Getters">
    public int getId(){ return id;}
    public String getNom(){ return nom; }
    public String getAutor(){ return autor; }
    public String getAlbum(){ return album; }
    public String getDurada(){ return durada; }
    public String getRuta() { return ruta; }
//</editor-fold>
    
    @Override
    public String toString() {
        return "Id: "+id+" /Nom de la canco: " + nom + "/ Nom del autor: " + autor + "/ Nom del album: " + album + "/ Durada: " + durada + "/ Ruta del arxiu: " + ruta;
    }

}
