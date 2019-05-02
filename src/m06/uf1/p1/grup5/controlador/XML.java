package m06.uf1.p1.grup5.controlador;

import m06.uf1.p1.grup5.modelo.Cancion;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.*;
import m06.uf1.p1.grup5.modelo.AudioList;
import m06.uf1.p1.grup5.modelo.Playlist;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

public class XML {

    private String archivo = "audios/canciones.xml";
    public Map<Integer, Cancion> MapCanciones = new HashMap();
    public Map<String, Playlist> MapPlaylist = new HashMap();
    
    public int[] cargarCanciones() throws FileNotFoundException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        DocumentBuilder builder = factory.newDocumentBuilder();
        int[] retorno = null;
        try {

            document = builder.parse(new File(archivo));
            Element arrel = document.getDocumentElement();
            NodeList listaCanciones = arrel.getElementsByTagName("cancion");
            retorno = new int [listaCanciones.getLength()];
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
                    retorno[i] = id;
                    MapCanciones.put(id, canc);
                }
            }
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
        return retorno;
    }

    public void cargarListas() throws FileNotFoundException, IOException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document document;
        DocumentBuilder builder = factory.newDocumentBuilder();

        try {

            document = builder.parse(new File(archivo));
            Element arrel = document.getDocumentElement();
            NodeList listaPlaylist = arrel.getElementsByTagName("playlist");
            
            for (int i = 0; i < listaPlaylist.getLength(); i++) {
                Node node = listaPlaylist.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element canciones = (Element) node;
                    int id = Integer.parseInt(canciones.getAttribute("id"));
                    Element nom = (Element) canciones.getElementsByTagName("nom").item(0);
                    Element ruta = GetRuta(canciones);
                    
                    Playlist pl = new Playlist(id,
                            nom.getChildNodes().item(0).getNodeValue(),
                            ruta.getChildNodes().item(0).getNodeValue());
                    MapPlaylist.put(nom.getChildNodes().item(0).getNodeValue(), pl);
                    System.out.println("llego");
                }
            }
        } catch (SAXException ex) {
            ex.printStackTrace();
        }
    }
    private Element GetRuta(Element canciones){
        Element ruta = (Element) canciones.getElementsByTagName("ruta").item(0);
        return ruta;
    }
}
