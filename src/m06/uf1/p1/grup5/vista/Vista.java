package m06.uf1.p1.grup5.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import m06.uf1.p1.grup5.controlador.Controlador;
import m06.uf1.p1.grup5.modelo.Cancion;

public class Vista {

    private JFrame finestra;
    private JPanel panell;
    private JPanel panellDerecha;
    private JPanel aux;
    private JPanel parteDerecha;
    private JPanel auxDerecha;
    private JPanel parteIzquierda;
    private JPanel parteAbajo;
    private JPanel parteMedio;
    private JPanel vacio;
    private JPanel total;

    private JButton play;
    private JButton stop;
    private JButton pausa;
    private JButton continuar;

    private JTable lista;

    private JComboBox elegir;

    private JLabel nombreCancion;
    private JLabel nCancion;
    private JLabel descripcion;
    private JLabel nDescripcion;
    private JLabel autor;
    private JLabel nAutor;
    private JLabel imagen;

    private JLabel nombrePlayList;
    private JLabel nPlayList;

    private JSlider barra;
    
//<editor-fold desc="Constructor">
    public Vista() {

        finestra = new JFrame("Reproductor Àudio");
        finestra.setSize(500, 400);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setResizable(false);
        finestra.setLocationRelativeTo(null);

        vacio = new JPanel();
        vacio.setLayout(new GridLayout());
        total = new JPanel();
        total.setLayout(new BorderLayout());

        parteMedio = new JPanel();
        parteMedio.setLayout(new GridLayout(1, 2));

        panell = new JPanel();
        panell.setLayout(new GridLayout(1, 5));

        aux = new JPanel();
        aux.setLayout(new GridLayout(0, 4));
        parteAbajo = new JPanel();
        parteAbajo.setLayout(new GridLayout(0, 1));

        panellDerecha = new JPanel();
        panellDerecha.setLayout(new BorderLayout());
        auxDerecha = new JPanel();
        auxDerecha.setLayout(new GridLayout(10, 0));
        parteDerecha = new JPanel();
        parteDerecha.setLayout(new GridLayout(0, 1));

        parteIzquierda = new JPanel();
        parteIzquierda.setLayout(new GridLayout(0, 1));

        lista = new JTable(15, 2);
        lista.setEnabled(true);
        //Controlador cont=new Controlador();

        //------------------
        for (int i = 0; i != 15; i++) {
            lista.setValueAt(i + 1, i, 0);
        }
        for (int x = 0; x != 15; x++) {
            //lista.setValueAt(cont.getCancion(x).getNom(), x, 1);
        }

        System.out.println(lista.getRowCount() + " " + lista.getColumnCount());
        lista.setShowVerticalLines(true);
        //-----------------
        parteIzquierda.add(lista);

        nPlayList = new JLabel("Nom de la playList:");
        nombrePlayList = new JLabel("pepe");
        nDescripcion = new JLabel("Descripcion:");
        descripcion = new JLabel("desc");
        imagen = new JLabel(new ImageIcon("images/abrupto.jpg"));

        elegir = new JComboBox();
        auxDerecha.add(nPlayList);
        auxDerecha.add(nombrePlayList);
        auxDerecha.add(nDescripcion);
        auxDerecha.add(descripcion);
        //auxDerecha.add(imagen);                      
        panellDerecha.add(elegir, BorderLayout.NORTH);
        panellDerecha.add(auxDerecha, BorderLayout.SOUTH);
        parteDerecha.add(panellDerecha);

        nCancion = new JLabel("Nom de la canco:");
        nombreCancion = new JLabel();
        nAutor = new JLabel("Nom del autor:");
        autor = new JLabel();
        aux.add(nCancion);
        aux.add(nombreCancion);
        aux.add(nAutor);
        aux.add(autor);

        barra = new JSlider();
        barra.setOrientation(0);
        play = new JButton("Play");
        stop = new JButton("Stop");
        pausa = new JButton("Pause");
        continuar = new JButton("Continue");
        panell.add(play);
        panell.add(pausa);
        panell.add(continuar);
        panell.add(stop);

        parteAbajo.add(aux);
        parteAbajo.add(barra);
        parteAbajo.add(panell);

        parteMedio.add(parteIzquierda);
        parteMedio.add(parteDerecha);

        total.add(parteMedio, BorderLayout.CENTER);
        total.add(parteAbajo, BorderLayout.SOUTH);
        finestra.add(total);
        finestra.setVisible(true);
    }
//</editor-fold>

//<editor-fold defaultstate="collapsed" desc="Getters y Setters">
    public JTable getTable(){
        return lista;
    }
    public void setTable(JTable table){
        this.lista=table;
    }
    
    public JComboBox getComboBox(){
        return elegir;
    }
    
    public void setComboBox(JComboBox comboBox){
        this.elegir=comboBox;
    }
    
    public JSlider getSlider(){
        return barra;
    }
    
    public void setSlider(JSlider slider){
        this.barra=slider;
    }
    
    public JLabel getNombreCancion(){
     return nombreCancion;
    }
    
    public void setNombreCancion(JLabel nombre){
        this.nombreCancion=nombre;
    }
    
    public JLabel getNombrePlayList(){
     return nombrePlayList;
    }
    
    public void setNombrePlayList(JLabel nombre){
        this.nombrePlayList=nombre;
    }
    
    public JLabel getAutor(){
     return autor;
    } 
    
    public void setAutor(JLabel nombre){
        this.autor=nombre;
    }
        
    public JLabel getDescripcion(){
     return descripcion;
    }
    
    public void setDescripcion(JLabel nombre){
        this.descripcion=nombre;
    }
    
    public JLabel getImatge(){
     return imagen;
    }
    
    public void setImatge(JLabel nombre){
        this.imagen=nombre;
    }   
    
    public JFrame getFinestra() {
        return finestra;
    }

    public void setFinestra(JFrame finestra) {
        this.finestra = finestra;
    }

    public JPanel getPanell() {
        return panell;
    }

    public void setPanell(JPanel panell) {
        this.panell = panell;
    }

    public JButton getPlay() {
        return play;
    }

    public void setPlay(JButton play) {
        this.play = play;
    }

    public JButton getStop() {
        return stop;
    }

    public void setStop(JButton stop) {
        this.stop = stop;
    }

    public JButton getPausa() {
        return pausa;
    }

    public void setPausa(JButton pausa) {
        this.pausa = pausa;
    }

    public JButton getContinuar() {
        return continuar;
    }

    public void setContinuar(JButton continuar) {
        this.continuar = continuar;
    }
//</editor-fold>
    
//<editor-fold defaultstate="collapsed" desc="Updates">
    public void updateSongInfo(Cancion info){
        this.nombreCancion.setText(info.getNom());
        this.autor.setText(info.getAutor());
    }
//</editor-fold>
}
