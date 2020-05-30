/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;


import com.codename1.messaging.Message;
import com.codename1.ui.Display;
import com.codename1.messaging.Message;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.teknikindustries.bulksms.SMS;

/**
 *
 * @author OsamaML97
 */
public class SendMessage extends Form{
    Form current;

    public SendMessage(Resources theme) {

        current=this;
        setTitle("Message Window");
        setLayout(BoxLayout.y());
        
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
        tb.addMaterialCommandToSideMenu("Home", FontImage.MATERIAL_HOME, e -> new HomeForm(theme).show()); 
        tb.addMaterialCommandToSideMenu("Enfants", FontImage.MATERIAL_CHILD_CARE, e -> new EnfantWindow(theme).show()); 
        tb.addMaterialCommandToSideMenu("Events", FontImage.MATERIAL_CHILD_FRIENDLY, e -> new EventWindow(theme).show());

        tb.addMaterialCommandToSideMenu("info", FontImage.MATERIAL_INFO,  e-> new Info(theme).show());
    
        Label enf = new Label("-----------Email----------");    
        TextField ReciverMail = new TextField("","receiver Email");
        TextField Subject = new TextField("","subject of Email");
        

        
        Message m = new Message("-------write your message here---------");
        
        
        
        Button btnValider = new Button("Add Message");
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().sendMessage(new String[] {ReciverMail.getText()}, Subject.getText(), m);}
        
        

    
        });
        
        TextField ReciverSMS = new TextField("","receiver Phone");
        TextField SubjectSMS = new TextField("","subject of SMS");
        

        
        
        
        
        Label enfSMS = new Label("-----------SMS----------");
        Button btnValider2 = new Button("Add SMS");
        btnValider2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                    SMS send = new SMS();
        send.SendSMS("oussama97", "Esprit2019", " "+SubjectSMS.getText()+"","+216"+ReciverSMS.getText(), "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
            Dialog.show("Success","message sent to "+ReciverSMS.getText(),new Command("OK"));}
        
        

    
        });

        
        
        
        
    addAll(enf,ReciverMail,Subject,btnValider,enfSMS,ReciverSMS,SubjectSMS,btnValider2);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, e-> new HomeForm(theme).show());
    }}

