package m06.uf1.p1.grup5.modelo;

public class Playlist{
    private int id;
    private String nom,ruta;
    
    public Playlist(int id, String nom, String ruta){
        this.id = id;
        this.nom = nom;
        this.ruta = ruta;
    }
    
//<editor-fold defaultstate="collapsed" desc="Getters">
    /***@return Devuelve la id de la lista*/
    public int getId() { return id; }
    /***@return Devuelve el nombre de la lista*/
    public String getNom() { return nom; }
    /***@return Devuelve la ruta del archivo json*/
    public String getRuta() { return ruta; }
//</editor-fold>
    
}
