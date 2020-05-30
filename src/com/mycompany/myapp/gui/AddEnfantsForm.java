/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.l10n.DateFormat;
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
import com.mycompany.myapp.entities.Enfants;
import com.mycompany.myapp.services.ServiceEnfants;
import java.util.Date;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;



/**
 *
 * @author bhk
 */
public class AddEnfantsForm extends Form{

    public AddEnfantsForm(Resources theme) {
        setTitle("Add a new Kid");
        setLayout(BoxLayout.y());
        
        TextField ANnom = new TextField("","nom");
        TextField Aprenom= new TextField("", "prenom");
        TextField Asexe= new TextField("", "f or m");
        TextField ALieuN= new TextField("", "place of birth");
        TextField Amed= new TextField("", "medication");
        TextField dateP= new TextField("", "20XX-XX-XX");
        TextField ANumMed= new TextField("", "medication number");
        Button btnValider = new Button("Add task");
        String f ="f";
        String m ="m";
        String datez ="20";
        String t ="-";
        
        
        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((ANnom.getText().length()==0)||(Aprenom.getText().length()==0)||ANumMed.getText().isEmpty()||Asexe.getText().isEmpty()||ALieuN.getText().isEmpty()
                        ||(dateP.getText().length()==0)||Amed.getText().isEmpty())
                    Dialog.show("Alert", "please fill in all the blanks", new Command("OK"));
             else if((!Asexe.getText().equals("f")&&!Asexe.getText().equals(m)))
             {
Dialog.show("Alert", "m for male / f for female", new Command("OK"));
             }
             else if ((dateP.getText().length()!=10)||!dateP.getText().startsWith(datez)||!dateP.getText().regionMatches(true,4, t, 0, 1)||!dateP.getText().regionMatches(true,7, t, 0, 1))
             
                          {
                 Dialog.show("Alert", "incorrect form , date in y-m-d", new Command("OK"));}
             
             else {
                    try {
                        
                        Enfants t = new Enfants(ANnom.getText(), Aprenom.getText(),Asexe.getText(),ALieuN.getText(),dateP.getText(),Amed.getText(),Integer.parseInt(ANumMed.getText()));
                        if( ServiceEnfants.getInstance().addEnfants(t))
                        { Dialog.show("Success","Connection accepted",new Command("OK"));
                        new ListEnfantsForm(theme).show();}
                      
                        else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "medicin number must be a number", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        
        addAll(ANnom,Aprenom,Asexe,ALieuN,dateP,Amed,ANumMed,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> new EnfantWindow(theme).show());
                
    }
    
    
}
