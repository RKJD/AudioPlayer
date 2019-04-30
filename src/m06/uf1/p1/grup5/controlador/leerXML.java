package m06.uf1.p1.grup5.controlador;

import java.io.File;
import java.io.FileReader;

public class leerXML {

    public static void main(String[] args) {
        try {
            File canciones = new File("audios/canciones.xml");
            FileReader leer = new FileReader(canciones);
            System.out.println(leer);
            // file reader no lee xml, necesitamos un lector de xml en si
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
