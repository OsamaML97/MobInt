/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.ServiceUser;



/**
 *
 * @author OsamaML97
 */
public class SignIn extends Form{

    public SignIn(Resources theme) {
        
        
        
        setTitle("Log in");
        setLayout(BoxLayout.y());
        TextField Email = new TextField("","Username");
        TextField Pass= new TextField("", "Password",20, TextField.PASSWORD);
        Form F3=new Form("About",BoxLayout.y());
        ImageViewer img=new ImageViewer(theme.getImage("kinder.png"));


        Button signIn = new Button("Confirm");
        Button CreateAccount = new Button("Create account");
        
        addAll(img,Email,Pass,signIn,CreateAccount);
        
    
    signIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                User usr = ServiceUser.getInstance().FindUser(Email.getText());
                if(usr == null){
                    Dialog.show("alert", "no users", "OK", null);
                    
                  
                }
                else if(!usr.getPassword().equals(Pass.getText())){
                        Dialog.show("alert", "password incorrect", "OK", null);
                    }else {
                        new HomeForm(theme).show();
                        System.out.println("do stuff");
                        System.out.println(usr.getPassword());
                        System.out.println(Pass.getText());
                        
                    
                        
                    }
                }
            });
      CreateAccount.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            
            new CreatAccount(theme).show();
            
            }});

}}
