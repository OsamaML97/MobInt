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
 * @author bhk
 */
public class ServiceEnfants {

    public ArrayList<Enfants> enfants;
    public Enfants enfant;
    public ArrayList<Event> event;
    public static ServiceEnfants instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceEnfants() {
         req = new ConnectionRequest();
    }

    public static ServiceEnfants getInstance() {
        if (instance == null) {
            instance = new ServiceEnfants();
        }
        return instance;
    }

    public boolean addEnfants(Enfants t) {
        String url = Statics.BASE_URL + "/enfants/new?nom=" + t.getNom() + "&prenom=" + t.getPrenom()+ "&sexe=" + t.getSexe()+ "&lieuNaissance=" + t.getLieuN()+ "&dateNaissance=" + t.getDateN()+ "&medicin=" + t.getMedicin()+ "&medecinNumero=" + t.getMedNum();
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
    
       

    public ArrayList<Enfants> parseEnfants(String jsonText){
        try {
            enfants=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Enfants t = new Enfants();
                float id = Float.parseFloat(obj.get("id").toString());
                t.setId((int)id);
                t.setNom(obj.get("nom").toString());
                t.setPrenom(obj.get("prenom").toString());
                t.setSexe(obj.get("sexe").toString());
                t.setLieuN(obj.get("lieuNaissance").toString());
                t.setDateN(obj.get("dateNaissance").toString());
                t.setMedicin(obj.get("medicin").toString());
                t.setMedNum(((int)Float.parseFloat(obj.get("medecinNumero").toString())));
                enfants.add(t);
            }
            
            
        } catch (IOException ex) {
            
        }
        return enfants;
    }
    

    public ArrayList<Enfants> getAllEnfants(){
        String url = Statics.BASE_URL+"/enfants/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                enfants = parseEnfants(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return enfants;
    }
    
        public ArrayList<Enfants> getNomEnfants(String nom){
        String url = Statics.BASE_URL+"/enfants/findE/"+nom;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                enfants = parseEnfants(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return enfants;
    }
    
    public Boolean supEnf(int id){
        String url = Statics.BASE_URL+"/enfants/delete/"+id;
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
    

