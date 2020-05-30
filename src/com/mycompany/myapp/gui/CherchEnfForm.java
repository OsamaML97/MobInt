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
import com.mycompany.myapp.services.ServiceEnfants;
import com.mycompany.myapp.services.ServiceEvents;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author bhk
 */
public class CherchEnfForm extends Form{
Form current;
    public CherchEnfForm(Resources theme) {
        current=this;
        setTitle("cherch Enfants");
        

        Label nom = new Label("nom");
        Label sp = new Label("List Enfants") ;
        TextField ANnom = new TextField("","cherch nom");
        Container con1=new Container(BoxLayout.y());
        ComboBox gouv = new ComboBox() ;
        Container con3=new Container(BoxLayout.y());
        
        
        Button bcherch=new Button("search child");
        con3.addAll(ANnom,bcherch);
        current.add(con3);
        

                        bcherch.addActionListener(e->{
                            List <Enfants> l = new ArrayList() ;
              l =  ServiceEnfants.getInstance().getNomEnfants(ANnom.getText()) ;
              
                            for(Enfants a : l){
                    Label enf = new Label("-------------------------Child--------------------");
                    int ids = a.getId();
                    String Noms= a.getNom();
                    String prenomS=  a.getPrenom();
                    String SexeS =a.getSexe();
                    String LieuS=  a.getLieuN();
                    String DateS=  a.getDateN();
                    String MedicinS=  a.getMedicin();
                    int MedNumS=   a.getMedNum();
                    Label lNom=new Label("Nom: "+Noms);
                    Label lPrenom=new Label("Prenom: "+prenomS);
                    Label lSexe=new Label("sexe: "+SexeS);
                    Label lieu=new Label("lieu naissance: "+LieuS);
                    Label datess=new Label("date naissance: "+DateS);
                    Label medicinss=new Label("Medecin: "+MedicinS);
                    Label numss=new Label("MedNum: "+MedNumS);
                    
                    
                    
                    current.addAll(enf,lNom,lPrenom,lSexe,lieu,datess,medicinss,numss);
                    current.show();
                    
                    
                    

                            }
                        
                        });
                       
        
                 
        
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK,  e-> new EnfantWindow(theme).show());
    }
    
    
}
