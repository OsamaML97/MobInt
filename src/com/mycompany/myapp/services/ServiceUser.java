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
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 *
 * @author OsamaML97
 */
public class ServiceUser {
    public ArrayList<User> users;
    public User user;
    
    public static ServiceUser instance=null;
    public boolean resultOK;
    private ConnectionRequest req;

    private ServiceUser() {
         req = new ConnectionRequest();
    }

    public static ServiceUser getInstance() {
        if (instance == null) {
            instance = new ServiceUser();
        }
        return instance;
    }
    
        public ArrayList<User> parseUsers(String jsonText){
        try {
            users=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            if(list==null) return null ;
            for(Map<String,Object> obj : list){
                User u = new User();
                float id = Float.parseFloat(obj.get("id").toString());
                u.setId((int)id);
                u.setUsername(obj.get("username").toString());
                
                u.setEmail(obj.get("email").toString());
                u.setPassword(obj.get("password").toString());
                

                users.add(u);
            }
            
            
        } catch (IOException ex) {
            
        }
        return users;
    }
        
            public ArrayList<User> getAllUsers(){
        String url = Statics.BASE_URL+"/user/all";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUsers(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return users;
    }
    
    public User FindUser(String username){
        String url = Statics.BASE_URL+"/user/find/"+username;
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                users = parseUsers(new String(req.getResponseData()));
                req.removeResponseListener(this);
                try{
                    user = users.get(0);
                }catch(Exception e){
                }
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
                return user;
    }
    
        public boolean addUser(User t) {
        String url = Statics.BASE_URL + "/user/new?username=" + t.getUsername() + "&email=" + t.getEmail()+ "&password=" + t.getPassword();
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
