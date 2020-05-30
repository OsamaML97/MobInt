/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.Log;
import com.codename1.io.NetworkManager;
import com.codename1.ui.Button;
import static com.codename1.ui.CN.addNetworkErrorListener;
import static com.codename1.ui.CN.updateNetworkThreadCount;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author OsamaML97
 */
public class Info extends Form{

    private Form current;


        public Info(Resources theme) {

                    current=this;
        setTitle("About the app");
        setLayout(BoxLayout.y());
        
        Toolbar tb = current.getToolbar();
                Image icon = theme.getImage("kinder.png"); 
        Container topBar = BorderLayout.east(new Label(icon));
        topBar.add(BorderLayout.SOUTH, new Label("Nursery School", "SidemenuTagline")); 
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);
            
       Form hi = new Form("", new BoxLayout(BoxLayout.Y_AXIS));
       
       
        String url="http://localhost/test.php";
        
        ConnectionRequest con=new ConnectionRequest();
        con.setUrl(url);
        
        con.addResponseListener((e)->{ 
        String str=new String(con.getResponseData());
        
        hi.add(str);
        });
        NetworkManager.getInstance().addToQueueAndWait(con);
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> new HomeForm(theme).show()); 
        tb.addMaterialCommandToSideMenu("Enfants", FontImage.MATERIAL_CHILD_CARE, e -> new EnfantWindow(theme).show()); 
        tb.addMaterialCommandToSideMenu("Events", FontImage.MATERIAL_CHILD_FRIENDLY, e -> new EventWindow(theme).show());
        tb.addMaterialCommandToSideMenu("Send a Message", FontImage.MATERIAL_MESSAGE, e -> new SendMessage(theme).show());
        
        getToolbar().addMaterialCommandToRightBar("LogOut", FontImage.MATERIAL_LOCK, e-> new SignIn(theme).show());
       addAll(hi);
       //hi.show();
       
            
            
//        Button btnValider = new Button("Get Started");
//         btnValider.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent evt) {
//            new SignIn().show();
                //ImageViewer rouge = new ImageViewer(theme.getImage("kinder.png"));
                //ImageViewer img = new ImageViewer();
                //img.setImage(theme.getImage("logo.jpg"));
                
//            }
//        });
//         addAll(btnValider);
        
        
    }
    
}
