package m06.uf1.p1.grup5.controlador;

import m06.uf1.p1.grup5.controlador.Controlador;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;

public class ReproductorAudio {

    public static void main(String[] args) throws FileNotFoundException {
        try {
            LectorXML xml = new LectorXML();
            xml.cargarCanciones();
            Controlador controlador = new Controlador();

        } catch (IOException ex) {
            Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(ReproductorAudio.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
