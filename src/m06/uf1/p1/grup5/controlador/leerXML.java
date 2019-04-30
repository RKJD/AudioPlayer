package m06.uf1.p1.grup5.controlador;

import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;

public class leerXML {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document documento = null;
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            documento = builder.parse( new File("audios/canciones.xml"));
            documento.getNodeName();
            System.out.println(documento.getDoctype());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
