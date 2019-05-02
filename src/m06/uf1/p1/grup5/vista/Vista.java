package m06.uf1.p1.grup5.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JTabbedPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import m06.uf1.p1.grup5.controlador.Controlador;
import m06.uf1.p1.grup5.modelo.AudioList;
import m06.uf1.p1.grup5.modelo.Cancion;
import m06.uf1.p1.grup5.modelo.Playlist;

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
    private JPanel auxAbajo;
    private JPanel aux2Abajo;
    private JPanel aux3Abajo;
    private JPanel aux4Abajo;

    private JButton play;
    private JButton stop;
    private JButton pausa;
    private JButton continuar;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnShuffle;

    private JTable lista;

    private JComboBox elegir;

    private JLabel nombreCancion;
    private JLabel nCancion;
    private JLabel descripcion;
    private JLabel nDescripcion;
    private JLabel autor;
    private JLabel nAutor;    
    private JLabel imagePlaylist;
    private ImageIcon icono;
    private JLabel tiempo;
    private JLabel tiempo1;
    private JLabel tiempo2;
    

    private JLabel nombrePlayList;
    private JLabel nPlayList;

    private JSlider barra;
    private JScrollBar scroll;
    private int minimum;
    private int maximum;

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
        auxAbajo = new JPanel();
        auxAbajo.setLayout(new GridLayout(1, 2));

        aux = new JPanel();
        aux.setLayout(new GridLayout(0, 4));
        aux2Abajo=new JPanel();
        aux2Abajo.setLayout(new GridLayout(0,1));
        aux4Abajo=new JPanel();
        aux4Abajo.setLayout(new GridLayout(0,2));
        aux3Abajo=new JPanel();
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

        lista = new JTable(15, 1);
        
       
        lista.setEnabled(true);
        lista.setShowVerticalLines(true);

        parteIzquierda.add(lista);

        
        /*icono = new javax.swing.ImageIcon(getClass().getResource("images/chill.jpg"));
        Image imagen = icono.getImage();
        ImageIcon iconoEscalado = new ImageIcon(imagen.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
        imagePlaylist.setIcon(iconoEscalado);*/

        nPlayList = new JLabel("Nom de la playList:");
        nombrePlayList = new JLabel("Sin Playlist");
        nDescripcion = new JLabel("Descripcion:");
        descripcion = new JLabel("No tienes ninguna playlist seleccionada.");

        elegir = new JComboBox(new String[]{"Sin lista"});
        auxDerecha.add(nPlayList);
        auxDerecha.add(nombrePlayList);
        auxDerecha.add(nDescripcion);
        auxDerecha.add(descripcion);
        //auxDerecha.add(imagePlaylist);                      
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
        minimum = 0;
        maximum = 16;
        barra = new JSlider(minimum, maximum);
        barra.setOrientation(0);
        barra.setValue(0);
        scroll=new JScrollBar();
        scroll.setOrientation(0);
        play = new JButton("Play");
        stop = new JButton("Stop");
        pausa = new JButton("Pause");
        continuar = new JButton("Continue");
        panell.add(play);
        panell.add(pausa);
        panell.add(continuar);
        panell.add(stop);

        btnAnterior = new JButton("Anterior");
        btnSiguiente = new JButton("Siguiente");
        btnShuffle = new JButton("in Bucle mode");
        tiempo=new JLabel("00:00");
        tiempo1=new JLabel("/");
        tiempo2=new JLabel("00:00");
        auxAbajo.add(btnAnterior);
        auxAbajo.add(btnShuffle);
        auxAbajo.add(btnSiguiente);
               
        parteAbajo.add(aux);
        //parteAbajo.add(barra);
        aux3Abajo.add(tiempo);
        aux3Abajo.add(tiempo1);
        aux3Abajo.add(tiempo2);
        aux2Abajo.add(scroll);
        
        //aux4Abajo.add(aux2Abajo);
        aux2Abajo.add(aux3Abajo);
        parteAbajo.add(aux2Abajo);
        parteAbajo.add(auxAbajo);
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
    public JTable getTable() {
        return lista;
    }

    public void setTable(JTable table) {
        this.lista = table;
    }

    public JComboBox getComboBox() {
        return elegir;
    }

    public void setComboBox(JComboBox comboBox) {
        this.elegir = comboBox;
    }

    public JSlider getSlider() {
        return barra;
    }

    public void setSlider(JSlider slider) {
        this.barra = slider;
    }

    public JLabel getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(JLabel nombre) {
        this.nombreCancion = nombre;
    }

    public JLabel getNombrePlayList() {
        return nombrePlayList;
    }

    public void setNombrePlayList(JLabel nombre) {
        this.nombrePlayList = nombre;
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

    public JButton getAnteriro() {
        return btnAnterior;
    }

    public void setAnterior(JButton anterior) {
        this.btnAnterior = anterior;
    }

    public JButton getSiguiente() {
        return btnSiguiente;
    }

    public void setSiguiente(JButton siguiente) {
        this.btnSiguiente = siguiente;
    }

    public JButton getShuffle() {
        return btnShuffle;
    }

    public void setShuffle(JButton shuffle) {
        this.btnShuffle = shuffle;
    }
//</editor-fold>

//<editor-fold desc="Updates">
    public void updateSongInfo(Cancion info) {
        this.nombreCancion.setText(info.getNom());
        this.autor.setText(info.getAutor());
    }

    public void updateSongsStart(String[] info) {
        for (int x = 0; x < 15; x++) {
            lista.setValueAt("", x, 0);
        }
        for (int x = 0; x < info.length; x++) {
            lista.setValueAt((x + 1) + ". " + info[x], x, 0);
        }
    }

    public void updateBox(Map<String, Playlist> playlist) {
        String[] nomPlaylist = new String[playlist.size()];
        int i = 0;
        for (Map.Entry<String, Playlist> p : playlist.entrySet()) {
            System.out.println(p.getValue().getNom());
            nomPlaylist[i] = p.getValue().getNom();
            i++;
            elegir.addItem(p.getValue().getNom());
        }
        //elegir = new JComboBox(nomPlaylist);
    }

    public void updateListInfo(AudioList a) {
        nombrePlayList.setText(a.getName());
        descripcion.setText(a.getDescription());
    }

    public void updateSlider(int x) {
        barra.setValue(x);
    }
    
    public void updateDurada(String x){
        tiempo2.setText(x);
    }
    
    public void updateShuffleText(boolean mode) {
        if(mode) btnShuffle.setText("in Shuffle mode");
        else  btnShuffle.setText("in Bucle mode");
    }
//</editor-fold>

    public void vaciarLista() {
        if (lista.getSize().height > 0) {
            lista.remove(0);
            vaciarLista();
        }
    }

}
