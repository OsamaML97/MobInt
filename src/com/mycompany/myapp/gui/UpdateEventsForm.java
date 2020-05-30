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
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.services.ServiceEvents;

/**
 *
 * @author OsamaML97
 */
public class UpdateEventsForm extends Form{
        public UpdateEventsForm(Resources theme) {
        setTitle("update Event");
        setLayout(BoxLayout.y());
        
        TextField ANnom = new TextField("","event name");
        TextField AMonth= new TextField("", "event month");
        TextField AStart= new TextField("", "20XX-XX-XX");
        TextField AEnd= new TextField("", "20XX-XX-XX");
        TextField APur= new TextField("", "event purpose");
        TextField ADesc= new TextField("", "event descption");
        Button btnValider = new Button("update Event");
        
        String datez ="20";
        String t ="-";
        
        
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((ANnom.getText().length()==0)||(AMonth.getText().length()==0)||(AStart.getText().length()==0)||(AEnd.getText().length()==0)||(APur.getText().length()==0)
                        ||(ADesc.getText().length()==0)
                        )
                    Dialog.show("Alert", "incorrect form , please fill all the blanks", new Command("OK"));
                else if((AStart.getText().length()!=10)||(AEnd.getText().length()!=10)||!AStart.getText().startsWith(datez)||!AStart.getText().regionMatches(true,4, t, 0, 1)||!AStart.getText().regionMatches(true,7, t, 0, 1)||!AEnd.getText().startsWith(datez)||!AEnd.getText().regionMatches(true,4, t, 0, 1)||!AEnd.getText().regionMatches(true,7, t, 0, 1))
                          {
                 Dialog.show("Alert", "incorrect form , date in y-m-d", new Command("OK"));}
                else {
                
                    try {
                        
                        Event t = new Event(ANnom.getText(), AMonth.getText(),AStart.getText(),AEnd.getText(),APur.getText(),ADesc.getText());
                        if( ServiceEvents.getInstance().addEvents(t))
                        {    Dialog.show("Success","Connection accepted",new Command("OK"));
                        new ListEventsForm(theme).show();}
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Status must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(ANnom,AMonth,AStart,AEnd,APur,ADesc,btnValider);
                
    }
    
}
