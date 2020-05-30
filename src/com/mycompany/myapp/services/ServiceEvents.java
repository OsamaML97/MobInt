/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Enfants;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author OsamaML97
 */
public class ServiceEvents {
    
    
    public ArrayList<Event> event;
    public static ServiceEvents instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceEvents() {
         req = new ConnectionRequest();
    }

    public static ServiceEvents getInstance() {
        if (instance == null) {
            instance = new ServiceEvents();
        }
        return instance;
    }
    
     public boolean addEvents(Event t) {
        String url = Statics.BASE_URL + "/events/new?EvName=" + t.getEvName() + "&EvMonth=" + t.getEvMonth()+ "&EvStart=" + t.getEvStart()+ "&EvEnd=" +t.getEvEnd()+  "&EvPur=" + t.getEvPur()+ "&EvDesc="+ t.getEvDesc() ;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }
    
    
    
            public ArrayList<Event> parseEvents(String jsonText){
        try {
            event =new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Event e = new Event();
                float id = Float.parseFloat(obj.get("id").toString());
                e.setId((int)id);
                e.setEvName(obj.get("evName").toString());
                e.setEvMonth(obj.get("evMonth").toString());
                e.setEvStart(obj.get("evStart").toString());
                e.setEvEnd(obj.get("evEnd").toString());
                e.setEvPur(obj.get("evPur").toString());
                e.setEvDesc(obj.get("evDesc").toString());
                
                
                event.add(e);
            }
            
            
        } catch (IOException ex) {
            
        }
        return event;
    }
    
    
        public ArrayList<Event> getAllEvents(){
        String url = Statics.BASE_URL+"/events/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                event = parseEvents(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return event;
    }
        
        public ArrayList<Event> getMonthEvent(String evMonth){
        String url = Statics.BASE_URL+"/events/findEv/"+evMonth;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                event = parseEvents(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return event;
    }  
      public Boolean supEv(int id){
        String url = Statics.BASE_URL+"/event/delete/"+id;
        req.setUrl(url);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

        
}
    
