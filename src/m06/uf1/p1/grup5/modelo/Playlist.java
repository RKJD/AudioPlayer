package m06.uf1.p1.grup5.modelo;

/**
 *
 * @author Marc
 */
public class Playlist{
    private int id;
    private String nom,ruta;
    public Playlist(int id, String nom, String ruta){
        this.id = id;
        this.nom = nom;
        this.ruta = ruta;
    }
    public int getId() {
        return id;
    }
    public String getNom() {
        return nom;
    }
    public String getRuta() {
        return ruta;
    }
}
