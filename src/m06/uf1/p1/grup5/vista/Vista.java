package m06.uf1.p1.grup5.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import m06.uf1.p1.grup5.modelo.AudioList;
import m06.uf1.p1.grup5.modelo.Cancion;
import m06.uf1.p1.grup5.modelo.Playlist;

public class Vista {

    private JFrame finestra;

    //PANEL que contiene todo
    private JPanel total; // Contiene parteMedio y parteAbajo
        // PANEL DEL MEDIO
        private JPanel parteMedio; //Contiene el panel parteIzquierda, vacio y parteDerecha            
            // PANELES IZQUIERDA
            private JPanel parteIzquierda;
                // CONTIENE       
                    private JTable lista;
                //

            // PANEL MEDIO
            private JPanel vacio;

            // PANELES DERECHA
            private JPanel parteDerecha;
                // CONTIENE
                    private JPanel panellDerecha;
                    // CONTIENE
                        private JComboBox elegir;
                        private JLabel imagePlaylist;
                        private JPanel auxDerecha;
                        // CONTIENE
                            private JLabel nombrePlayList;
                            private JLabel nPlayList;
                            private JLabel descripcion;
                            private JLabel nDescripcion;
                        //
                    //
                //
                

        //PANEL DE ABAJO
        private JPanel parteAbajo;
        // CONTIENE
            private JPanel contInfoCancion;
            // CONTIENE
                private JPanel contNombreCancion;
                // CONTIENE
                    private JLabel nombreCancion;
                    private JLabel nCancion;
                //
                private JPanel contInfoRestante;
                // CONTIENE
                    private JLabel autor;
                    private JLabel nAutor;
                    private JLabel nAlbum;
                    private JLabel nombreAlbum;
                //
            //
            private JPanel contTiempo;
            // CONTIENE
                private JSlider barra;// no se usa
                private JScrollBar scroll;
                    private int minimum;
                    private int maximum;
            //
            private JPanel auxAbajo;
            private JPanel panell;

    
    
    

    

    
    
    private JPanel aux3Abajo;
    
    

    private JButton play;
    private JButton stop;
    private JButton pausa;
    private JButton continuar;
    private JButton btnAnterior;
    private JButton btnSiguiente;
    private JButton btnShuffle;

    

    

    //private ImageIcon icono;
    private JLabel tiempo;
    private JLabel tiempo1;
    private JLabel tiempo2;
    

    

//<editor-fold desc="Constructor">
    public Vista() {

        finestra = new JFrame("Reproductor Àudio");
        finestra.setSize(600, 450);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setResizable(false);
        finestra.setLocationRelativeTo(null);

        vacio = new JPanel();
        //vacio.setLayout(new GridLayout());
        total = new JPanel();
        total.setLayout(new BorderLayout());

        parteMedio = new JPanel();
        parteMedio.setLayout(new GridBagLayout());
        GridBagConstraints x = new GridBagConstraints();

        panell = new JPanel();
        panell.setLayout(new GridLayout(1, 5));
        auxAbajo = new JPanel();
        auxAbajo.setLayout(new GridLayout(1, 2));

        contInfoRestante = new JPanel();
        contInfoRestante.setLayout(new GridLayout(0, 4));
        contNombreCancion = new JPanel();
        contNombreCancion.setLayout(new GridLayout(0, 4));
        contInfoCancion = new JPanel();
        contInfoCancion.setLayout(new GridLayout(2, 0));
        contTiempo = new JPanel();
        contTiempo.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        aux3Abajo = new JPanel();
        //aux3Abajo.setLayout(new GridLayout(0,2));
        parteAbajo = new JPanel();
        parteAbajo.setLayout(new GridLayout(0, 1));

        panellDerecha = new JPanel();
        panellDerecha.setLayout(new BorderLayout());
        auxDerecha = new JPanel();
        auxDerecha.setLayout(new GridLayout(5, 0));
        parteDerecha = new JPanel();
        parteDerecha.setLayout(new GridLayout(0, 1));

        parteIzquierda = new JPanel();
        parteIzquierda.setLayout(new GridLayout(0, 1));

        lista = new JTable(15, 1);

        lista.setEnabled(true);
        lista.setShowVerticalLines(true);

        parteIzquierda.add(lista);

        ImageIcon erIcono = null;
        erIcono = pillarimagen("images/null.jpg");
        imagePlaylist = new JLabel(erIcono);
        nPlayList = new JLabel("Nom de la playList:");
        nombrePlayList = new JLabel("Sin Playlist");
        nDescripcion = new JLabel("Descripcion:");
        descripcion = new JLabel("No tienes ninguna playlist seleccionada.");

        elegir = new JComboBox(new String[]{"Sin lista"});

        //auxDerecha.add(imagePlaylist); 
        auxDerecha.add(nPlayList);
        auxDerecha.add(nombrePlayList);
        auxDerecha.add(nDescripcion);
        auxDerecha.add(descripcion);

        panellDerecha.add(elegir, BorderLayout.NORTH);
        panellDerecha.add(imagePlaylist, BorderLayout.CENTER);
        panellDerecha.add(auxDerecha, BorderLayout.SOUTH);
        parteDerecha.add(panellDerecha);

        nCancion = new JLabel("Nom de la canco:");
        nombreCancion = new JLabel();
        nAutor = new JLabel("Nom del autor:");
        autor = new JLabel();
        nAlbum = new JLabel("Nom del album:");
        nombreAlbum = new JLabel();
        contNombreCancion.add(nCancion);
        contNombreCancion.add(nombreCancion);
        contInfoRestante.add(nAutor);
        contInfoRestante.add(autor);
        contInfoRestante.add(nAlbum);
        contInfoRestante.add(nombreAlbum);
        contInfoCancion.add(contNombreCancion);
        contInfoCancion.add(contInfoRestante);

        minimum = 0;
        maximum = 16;
        barra = new JSlider(minimum, maximum);
        barra.setOrientation(0);
        barra.setValue(0);
        scroll = new JScrollBar();
        scroll.setMinimum(minimum);
        scroll.setMaximum(maximum);
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
        tiempo = new JLabel("00:00");
        tiempo1 = new JLabel("/");
        tiempo2 = new JLabel("00:00");
        auxAbajo.add(btnAnterior);
        auxAbajo.add(btnShuffle);
        auxAbajo.add(btnSiguiente);

        parteAbajo.add(contInfoCancion);
        //parteAbajo.add(barra);
        aux3Abajo.add(tiempo);
        aux3Abajo.add(tiempo1);
        aux3Abajo.add(tiempo2);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 4;
        c.gridwidth = 2;
        c.gridx = 0;
        c.gridy = 0;
        contTiempo.add(scroll, c);

        //aux4Abajo.add(contTiempo);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        contTiempo.add(aux3Abajo, c);
        parteAbajo.add(contTiempo);
        parteAbajo.add(auxAbajo);
        parteAbajo.add(panell);

        x.fill = GridBagConstraints.HORIZONTAL;
        x.weightx = 0.5;
        x.insets = new Insets(0, 5, 0, 0);
        x.gridx = 0;
        x.gridy = 0;
        parteMedio.add(parteIzquierda, x);

        x.fill = GridBagConstraints.HORIZONTAL;
        x.weightx = 0;
        //x.gridwidth = 0;
        x.insets = new Insets(0, 0, 0, 0);
        x.gridx = 1;
        x.gridy = 0;
        parteMedio.add(vacio, x);

        x.fill = GridBagConstraints.HORIZONTAL;
        x.weightx = 0.5;
        x.insets = new Insets(0, 0, 0, 5);
        x.gridx = 2;
        x.gridy = 0;
        parteMedio.add(parteDerecha, x);

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

    public JLabel getNombreAlbum() {
        return nombreAlbum;
    }

    public void setNombreALbum(JLabel nombre) {
        this.nombreAlbum = nombre;
    }

    public JLabel getNAlbum() {
        return nAlbum;
    }

    public void setNAlbum(JLabel nombre) {
        this.nAlbum = nombre;
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

    public JLabel getImagen() {
        return imagePlaylist;
    }

    public void setImagen(JLabel imagen) {
        this.imagePlaylist = imagen;
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
            nomPlaylist[i] = p.getValue().getNom();
            i++;
            elegir.addItem(p.getValue().getNom());
        }
        //elegir = new JComboBox(nomPlaylist);
    }

    public void updateListInfo(AudioList a) {
        nombrePlayList.setText(a.getName());
        descripcion.setText(a.getDescription());
        ImageIcon erIcono = null;
        try {
            erIcono = new ImageIcon(
                    a.getImage().toURI().toURL() //Imagen del album
            );
        } catch (FileNotFoundException e) {
            erIcono = pillarimagen("images/notFound.jpg");
        } catch (NoSuchFieldException e) {
            erIcono = pillarimagen("images/null.jpg");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        imagePlaylist.setIcon(erIcono);
    }

    public void updateSlider(int x) {
        barra.setValue(x);
    }

    public void updateScroll(String x) {
        String segundos = x.substring(3, 5);
        int sec = Integer.parseInt(segundos);
        String minutos = x.substring(0, 2);
        int min = Integer.parseInt(minutos);
        min = min * 60;
        int value = sec + min;
        scroll.getModel().setExtent(1);
        scroll.setMaximum(value + 1);
    }

    public void updateDuradaActual(int x) {
        int min = (int) (x / 60);
        int seg = x - (min * 60);
        if (seg < 10) {
            tiempo.setText(min + ":0" + seg);
        } else {
            tiempo.setText(min + ":" + seg);
        }
        scroll.setValue(x);
    }

    public void updateDurada(String x) {
        tiempo2.setText(x);
    }

    public void updateShuffleText(boolean mode) {
        if (mode) {
            btnShuffle.setText("in Shuffle mode");
        } else {
            btnShuffle.setText("in Bucle mode");
        }
    }

//</editor-fold>
    public void vaciarLista() {
        if (lista.getSize().height > 0) {
            lista.remove(0);
            vaciarLista();
        }
    }

    public ImageIcon pillarimagen(String ruta) {
        ImageIcon retorno = null;
        try {
            retorno = new ImageIcon(
                    (new File(ruta)).toURI().toURL()
            );
        } catch (MalformedURLException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
        return retorno;
    }

}
