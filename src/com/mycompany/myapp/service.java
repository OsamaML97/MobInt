package com.mycompany.myapp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;



public class service {
  utils2 u= new utils2();
  private ConnectionRequest req;
  public static service  instance=null;
  public ArrayList<club> clubs;
  
   
   

    public service() {
         req = new ConnectionRequest();
    }
        public static service getInstance() {
        if (instance == null) {
            instance = new service();
        }
        return instance;
    }
    
      
        
        
        public ArrayList<club> parseClub(String jsonText){
        try {
            clubs =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> listjson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)listjson.get("root");
            System.out.print("size :"+list.size());
            for(Map<String,Object> obj : list){
                   club a = new club();
                   a.setIdclub((int)Float.parseFloat(obj.get("idclub").toString()));
                   a.setNomclub(obj.get("nomclub").toString());
                   a.setCap(obj.get("cap").toString());
            
                
                   clubs.add(a);
            }
            
            
            
        } catch (IOException ex) {
            
        }
        return clubs;
    }
        
        public ArrayList<club> getAllClub(){
            String url =u.PROD_URL;
            req.setUrl(url);
            req.setPost(false);
            req.addResponseListener(new ActionListener<NetworkEvent>() {
                @Override
                public void actionPerformed(NetworkEvent evt) {
                    clubs = parseClub(new String(req.getResponseData()));
                    req.removeResponseListener(this);
                }
            });
            NetworkManager.getInstance().addToQueueAndWait(req);
           
            return clubs;
     }
     
        
        
                         
}