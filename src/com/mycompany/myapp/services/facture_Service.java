/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.l10n.DateFormat;
import com.codename1.l10n.Format;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.events.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import models.Session;
import models.facture;
import utils.DataSource;
import utils.Statics;

/**
 *
 * @author aymen
 */
public class facture_Service {
     private ConnectionRequest request;

    private boolean responseResult;
    public ArrayList<facture> factures;
        public facture_Service() {
        request = DataSource.getInstance().getRequest();
    }
         public boolean addfacture(facture f) throws Exception {
     
        String url = Statics.BASE_URL + "api/ADDFacture?idU=" + f.getId_user();

        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
             public ArrayList<facture> getAllfacture() {
        String url = Statics.BASE_URL + "api/ALLFacture";

        request.setUrl(url);
        request.setPost(false);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                try {
                    factures = parsefactures(new String(request.getResponseData()));
                } catch (ParseException ex) {
                   
                }
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return factures;
    }
                 public ArrayList<facture> parsefactures(String jsonText) throws ParseException {
        try {
            factures = new ArrayList<>();

            JSONParser jp = new JSONParser();
            Map<String, Object> tasksListJson = jp.parseJSON(new CharArrayReader(jsonText.toCharArray()));

            List<Map<String, Object>> list = (List<Map<String, Object>>) tasksListJson.get("root");
            for (Map<String, Object> obj : list) {
              
                int id = (int)Float.parseFloat(obj.get("id").toString());
            
             
     
       
                  float Montant = (float)Float.parseFloat(obj.get("Montant").toString());
              
                    String Etat = obj.get("Etat").toString();
                    int id_u = (int)Float.parseFloat(obj.get("idU").toString());
                     Map map1 = ((Map) obj.get("Delais"));
        
            Date date1 = new Date((((Double)map1.get("timestamp")).longValue()*1000)); 
        
            Format formatter = new SimpleDateFormat("yyyy-MM-dd");
    
            String s1 = formatter.format(date1);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
   
            Date Delais = new Date();
     
            Delais = df.parse(s1);

                  
                  
                factures.add(new facture(id, Montant, Delais, id_u, Etat));
            }

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return factures;
    }
                      public boolean payeefacture(facture f)  {
     
        String url = Statics.BASE_URL + "api/PayeFacture?id=" + f.getId();

        request.setUrl(url);
        request.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                responseResult = request.getResponseCode() == 200; // Code HTTP 200 OK
                request.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(request);

        return responseResult;
    }
    
}
