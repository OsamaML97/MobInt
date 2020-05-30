/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author bhk
 */
public class HomeForm extends Form{
Form current;
    public HomeForm(Resources theme) {
 
        current=this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        ImageViewer img=new ImageViewer(theme.getImage("kinderhome.png"));
        Toolbar tb = current.getToolbar();
        Image icon = theme.getImage("kinder.png"); 
        Container topBar = BorderLayout.east(new Label(icon));
        topBar.add(BorderLayout.SOUTH, new Label("Nursery School", "SidemenuTagline")); 
        topBar.setUIID("SideCommand");
        tb.addComponentToSideMenu(topBar);
        
    
        //Image img = theme.getImage("/kinder.png");
        //ImageViewer img = new ImageViewer();
        //img.setImage(theme.getImage("icon.jpg"));
        //ImageViewer imgCon = new ImageViewer();
        //ImageViewer rouge = new ImageViewer(theme.getImage("logo.png"));
        tb.addMaterialCommandToSideMenu("Enfants", FontImage.MATERIAL_CHILD_CARE, e -> new EnfantWindow(theme).show()); 
        tb.addMaterialCommandToSideMenu("Events", FontImage.MATERIAL_CHILD_FRIENDLY, e -> new EventWindow(theme).show());
        tb.addMaterialCommandToSideMenu("Send a Message", FontImage.MATERIAL_MESSAGE, e -> new SendMessage(theme).show());
        tb.addMaterialCommandToSideMenu("info", FontImage.MATERIAL_INFO,  e-> new Info(theme).show());
        
        
        
        
        getToolbar().addMaterialCommandToRightBar("LogOut", FontImage.MATERIAL_LOCK, e-> new SignIn(theme).show());
        
        
        TextArea lbl = new TextArea("KinderGarden will help your child develop socially and emotionally. In preschool, your children will learn how to compromise, be respectful towards others, and solve problems.");
        lbl.setEditable(false);
        lbl.setFocusable(false);
        lbl.setUIID("Label");


        
       
        //Button showUsers =new Button("Users ");
        


        
        //showUsers.addActionListener(e-> new ListUsers(current).show());
        
        addAll(lbl);
        
        

    }
    
    
}
