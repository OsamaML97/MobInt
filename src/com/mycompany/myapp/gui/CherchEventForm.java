/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Command;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Enfants;
import com.mycompany.myapp.entities.Event;
import com.mycompany.myapp.services.ServiceEnfants;
import com.mycompany.myapp.services.ServiceEvents;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author OsamaML97
 */
public class CherchEventForm extends Form{
Form current;
    public CherchEventForm(Resources theme) {
        current=this;
        setTitle("cherch event");
        

        Label nom = new Label("event month");
        Label sp = new Label("List event") ;
        TextField ANnom = new TextField("","de cherch event");
        Container con1=new Container(BoxLayout.y());
        ComboBox gouv = new ComboBox() ;
        Container con3=new Container(BoxLayout.y());
        
        
        Button bcherch=new Button("search event");
        con3.addAll(ANnom,bcherch);
        current.add(con3);
        

                        bcherch.addActionListener(e->{
                            List <Event> l = new ArrayList() ;
              l =  ServiceEvents.getInstance().getMonthEvent(ANnom.getText()) ;
              
                    for(Event a : l){
                    Label enf = new Label("-------------------------Event--------------------");
                    int ids = a.getId();
                    String Noms= a.getEvName();
                    String prenomS=  a.getEvMonth();
                    String LieuS=  a.getEvStart();
                    String DateS=  a.getEvEnd();
                    String MedicinS=  a.getEvPur();
                    String MedNumS=   a.getEvDesc();
                    Label lNom=new Label("event name: "+Noms);
                    Label lPrenom=new Label("event month: "+prenomS);
                    Label lieu=new Label("event start: "+LieuS);
                    Label datess=new Label("event end: "+DateS);
                    Label medicinss=new Label("event purpose: "+MedicinS);
                    Label numss=new Label("event desc :"+MedNumS);
                    
                    
                    
                    current.addAll(enf,lNom,lPrenom,lieu,datess,medicinss,numss);
                    current.show();
                    
                    
                    

                            }
                        
                        });
                       
        
                 
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,  e-> new EventWindow(theme).show());
    }
    
    
}
