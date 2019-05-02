package m06.uf1.p1.grup5.controlador;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import m06.uf1.p1.grup5.modelo.AudioList;
import org.json.simple.*;
import org.json.simple.parser.*;

public class LeerJson {

    public static AudioList getList(String path) {
        JSONParser parser = new JSONParser();
        try {
            JSONObject playlist = (JSONObject) parser.parse(new FileReader(path));
            JSONArray stringTracks = (JSONArray) playlist.get("arxius");
            int[] tracks = new int[stringTracks.size()];
            int i = 0;
            for (Object r : stringTracks) {
                tracks[i] = Integer.parseInt(r.toString());
                i++;
            }
            AudioList retorno = new AudioList(
                    playlist.get("nom").toString(),
                    playlist.get("descripcio").toString(),
                    getImage(playlist), tracks);
            return retorno;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    private static String getImage(JSONObject playlist){
        try{
            return playlist.get("imatge").toString();
        } catch (NullPointerException e) {
            return "nope";
        }
        
    }
}
