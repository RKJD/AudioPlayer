/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package m06.uf1.p1.grup5.controlador;

/**
 *
 * @author raulk
 */
public class Cancion {
    private String ruta;
    private String autor;
    
    public Cancion(){        
    }

    public Cancion(String ruta, String autor) {
        this.ruta = ruta;
        this.autor = autor;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getAutor() {
        return ruta;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Ruta "+ruta+" con autor "+autor;
    }
    
    
}

