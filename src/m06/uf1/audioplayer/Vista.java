package m06.uf1.audioplayer;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Vista {

    private JFrame finestra;
    private JPanel panell;

    private JButton play;
    private JButton stop;
    private JButton pausa;
    private JButton continuar;

    public Vista() {

        finestra = new JFrame("Reproductor Àudio");
        finestra.setSize(400, 50);
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        finestra.setResizable(false);
        finestra.setLocationRelativeTo(null);
        panell = new JPanel();
        panell.setLayout(new GridLayout(1, 5));
        play = new JButton("Play");
        stop = new JButton("Stop");
        pausa = new JButton("Pause");
        continuar = new JButton("Continue");     
        panell.add(play);
        panell.add(pausa);
        panell.add(continuar);
        panell.add(stop);
        finestra.add(panell);
        finestra.setVisible(true);
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
}
