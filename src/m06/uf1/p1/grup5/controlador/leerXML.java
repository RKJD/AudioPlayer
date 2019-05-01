package m06.uf1.p1.grup5.controlador;

import m06.uf1.p1.grup5.modelo.Cancion;
import java.io.*;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class leerXML {

    private String archivo = "audios/canciones.xml";

    public void cargarCanciones() throws FileNotFoundException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {

            document = builder.parse(new File(archivo));
            Element arrel = document.getDocumentElement();
            NodeList listaCanciones = arrel.getChildNodes();
            for (int i = 0; i < listaCanciones.getLength(); i++) {
                Node node = listaCanciones.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element canciones = (Element) node;
                    Element ruta = (Element) canciones.getElementsByTagName("ruta").item(0);
                    Element autor = (Element) canciones.getElementsByTagName("autor").item(0);

                    Cancion canc = new Cancion(
                            ruta.getChildNodes().item(0).getNodeValue(),
                            autor.getChildNodes().item(0).getNodeValue()
                                               );
                   // Cancion.put(ruta,autor);
                    System.out.println(listaCanciones);
                }
            }
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
    }

}
