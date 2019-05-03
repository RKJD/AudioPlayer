package m06.uf1.p1.grup5.modelo;

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
    /***@return Devuelve la id de la cancion*/
    public int getId(){ return id;}
    /***@return Devuelve el nombre de la cancion*/
    public String getNom(){ return nom; }
    /***@return Devuelve el autor de la cancion*/
    public String getAutor(){ return autor; }
    /***@return Devuelve el album de la cancion*/
    public String getAlbum(){ return album; }
    /***@return Devuelve la duracion de la cancion*/
    public String getDurada(){ return durada; }
    /***@return Devuelve la ruta de la cancion*/
    public String getRuta() { return ruta; }
//</editor-fold>
    
    @Override
    public String toString() {
        return "Id: "+id+" /Nom de la canco: " + nom + "/ Nom del autor: " + autor + "/ Nom del album: " + album + "/ Durada: " + durada + "/ Ruta del arxiu: " + ruta;
    }

}
