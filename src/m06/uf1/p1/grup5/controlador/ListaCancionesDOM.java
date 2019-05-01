package m06.uf1.p1.grup5.controlador;

import m06.uf1.p1.grup5.modelo.Cancion;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class ListaCancionesDOM {

    private String archivo = "audios/canciones.xml";
    public Map<Integer, Cancion> MapCanciones;

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
                    int id = Integer.parseInt(canciones.getAttribute("id"));
                    Element nom = (Element) canciones.getElementsByTagName("nom").item(0);
                    Element autor = (Element) canciones.getElementsByTagName("autor").item(0);
                    Element album = (Element) canciones.getElementsByTagName("album").item(0);
                    Element durada = (Element) canciones.getElementsByTagName("durada").item(0);
                    Element ruta = (Element) canciones.getElementsByTagName("ruta").item(0);

                    Cancion canc = new Cancion(
                            id,
                            nom.getChildNodes().item(0).getNodeValue(),
                            autor.getChildNodes().item(0).getNodeValue(),
                            album.getChildNodes().item(0).getNodeValue(),
                            durada.getChildNodes().item(0).getNodeValue(),
                            ruta.getChildNodes().item(0).getNodeValue()
                    );
                    System.out.println(id+ " y " +canc);
                    MapCanciones.put(id, canc);
                }
            }
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
    }
    
    public String listarCanciones() {
        String cadena = "LLISTAT DE Cancons: \nHi ha un total de " + MapCanciones.size() + " Cancons.\n";
        for (Map.Entry<Integer, Cancion> canci: MapCanciones.entrySet()){
            cadena += canci.getValue().toString() + "\n";
        }
        return cadena;
    }

}
