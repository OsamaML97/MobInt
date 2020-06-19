/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;


import com.codename1.components.ImageViewer;
import com.codename1.components.InfiniteProgress;
import com.codename1.components.MultiButton;
import com.codename1.contacts.Contact;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;



import models.Session;
import models.facture;
import services.facture_Service;


/**
 *
 * @author aymen
 */
public class UserInterfaceForm extends Form {

    Resources theme = UIManager.initFirstTheme("/theme");

    public UserInterfaceForm(Form previous) {
        super("User",BoxLayout.y());

        this.add(new InfiniteProgress());
        Display.getInstance().scheduleBackgroundTask(() -> {
            // this will take a while...

            Display.getInstance().callSerially(() -> {
                this.removeAll();
     


               
                for (facture c : new facture_Service().getAllfacture()) {

                
                    try {
                        if (c.getId_user()==Session.getCurrentSession())
                        { 
                            this.add(addItem_facture(c));
                        }
                    } catch (Exception ex) {
                       
                    }
                

                }
               

                this.revalidate();
            });
        });

        this.getToolbar().addSearchCommand(e -> {
            String text = (String) e.getSource();
            if (text == null || text.length() == 0) {
                // clear search
                for (Component cmp : this.getContentPane()) {
                    cmp.setHidden(false);
                    cmp.setVisible(true);
                }
                this.getContentPane().animateLayout(150);
            } else {
                text = text.toLowerCase();
                for (Component cmp : this.getContentPane()) {
                    MultiButton mb = (MultiButton) cmp;
                    String line1 = mb.getTextLine1();
                    String line2 = mb.getTextLine2();
            
           ;
                    boolean show = line1 != null && line1.toLowerCase().indexOf(text) > -1
                            || line2 != null && line2.toLowerCase().indexOf(text) > -1;
                    mb.setHidden(!show);
                    mb.setVisible(show);
                }
                this.getContentPane().animateLayout(150);
            }
        }, 4);
        
 
        this.getToolbar().addCommandToSideMenu("Factures", null, e -> {
            this.show();
        });

      
        this.getToolbar().addCommandToSideMenu("Profil", null, e -> {
            new Detail_ProfilForm(this).show();
        });
     
     
        
      
     
   


        this.getToolbar().addCommandToSideMenu("Logout", null, e -> {
            new LoginForm().show();
        });

    }

   
    public MultiButton addItem_facture(facture c) {
        MultiButton m = new MultiButton();
        m.setTextLine1(String.valueOf(c.getDelais()));
        m.setTextLine2(c.getEtat());
  
        

       
        m.setIcon(theme.getImage("round.png"));
        m.setEmblem(theme.getImage("cal_right_arrow.png"));
        m.addActionListener(l
                -> {

                   Form f2 = new Form("DETAILS",BoxLayout.y());
           
            Label type1 = new Label("Delais");
            Label Delais = new Label(String.valueOf(c.getDelais()));
            Label type2 = new Label("Montant");
            Label Montant = new Label(String.valueOf(c.getMontant()));
            Label type3 = new Label("Etat");
            Label etat = new Label(c.getEtat());
 if (c.getEtat().equals("non paye")) {
            etat.getStyle().setFgColor(0xd61f1f);
        } else {
            etat.getStyle().setFgColor(0x1b7021);
        }
            Button Payee = new Button("Payee");
    

         Payee.addActionListener(ll-> 
         
         {
                 
     
         
           facture f  =new facture();
           f.setId(c.getId());
new facture_Service().payeefacture(f);
                  Dialog.show("Facture", "Paiement avec succès", "OK", null);
  new UserInterfaceForm(this).show();
         }
         
         );
            
          

            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back-command.png"), (evt) -> {
                this.showBack();
            });

       
             
            
          

              f2.add(type1).add(Delais).add(type2).add(Montant).add(type3).add(etat);

            if (c.getEtat().equals("non paye")) {
            f2.add(Payee);
        } else {
             f2.add(Payee);
        }
            
            f2.show();

        }
        );

        return m;
    }
 
}
