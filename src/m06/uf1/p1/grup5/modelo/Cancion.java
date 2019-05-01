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

    private String nom;
    private String autor;
    private String album;
    private String durada;
    private String ruta;

    public Cancion() {
    }

    public Cancion(String nom, String autor, String album, String durada, String ruta) {
        this.nom = nom;
        this.autor = autor;
        this.album = album;
        this.durada = durada;
        this.ruta = ruta;
    }

    public String getNom() {
        return nom;
    }

    public String getAutor() {
        return autor;
    }

    public String getAlbum() {
        return album;
    }

    public String getDurada() {
        return durada;
    }

    public String getRuta() {
        return ruta;
    }

    @Override
    public String toString() {
        return "Nom de la canco: " + nom + "/ Nom del autor: " + autor + "/ Nom del album: " + album + "/ Durada: " + durada + "/ Ruta del arxiu: " + ruta;
    }

}
