/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.User;
import com.mycompany.myapp.services.ServiceUser;

/**
 *
 * @author OsamaML97
 */
public class CreatAccount extends Form{
     Form current;
        public CreatAccount(Resources theme) {
            current=this;
        setTitle("create an account");
        setLayout(BoxLayout.y());
        
        TextField Auser = new TextField("","username");
        TextField Aemail= new TextField("", "email");
        TextField Apass= new TextField("", "password",20, TextField.PASSWORD);
        TextField Apass2= new TextField("", "confirm password",20, TextField.PASSWORD);

        Button btnValider = new Button("Add account");
        

        
        
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if (!Apass.getText().equals(Apass2.getText()))
                        
                    Dialog.show("Alert", "password is not the same", new Command("OK"));
                else
                {
                    try {
                        
                        User t = new User(Auser.getText(), Aemail.getText(),Apass.getText());
                        if( ServiceUser.getInstance().addUser(t))
                        { Dialog.show("Success","Connection accepted",new Command("OK"));
                        new SignIn(theme).show();}
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(Auser,Aemail,Apass,Apass2,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new SignIn(theme).show());
        
                
    }
    
    
}
