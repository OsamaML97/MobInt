/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.codename1.components.ImageViewer;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import models.User;
import models.facture;
import services.User_Service;
import services.facture_Service;

/**
 *
 * @author aymen
 */
public class ListUsersForm extends Form {

    Resources theme;

    public ListUsersForm(Form previous) {
        super("Users",BoxLayout.y());
   
        Label logi = new Label("Les Parents");

        this.add(logi);

        theme = UIManager.initFirstTheme("/theme");

        for (User c : new User_Service().getAllusers()) {
            System.out.println(c.getRole());
            if (c.getRole().equals("[ROLE_PARENT, ROLE_USER]")) {
                this.add(addItem(c));
            }

        }

        this.getToolbar().addCommandToLeftBar(null, theme.getImage("back-command.png"), (evt) -> {
            new AccueilAdminForm(this).show();
        });
    }

    public Container addItem(User c) {
        Container cn1 = new Container(new BorderLayout());
        Container cn2 = new Container(BoxLayout.y());
        Label lab = new Label(c.getFname());
        Button btn = new Button(c.getMail());
     
        String url = "http://127.0.0.1/projet/web/uploads/images/" + c.getImage();
        ImageViewer imgv;
        Image imge;
        EncodedImage enc;

        enc = EncodedImage.createFromImage(theme.getImage("round.png"), false);
        imge = URLImage.createToStorage(enc, url, url);
        imgv = new ImageViewer(imge);

        cn2.add(lab).add(btn);
        cn1.add(BorderLayout.WEST, cn2);
        cn1.add(BorderLayout.EAST, imgv);

        btn.addActionListener(e -> {

            Form f2 = new Form("Details",BoxLayout.y());
            Label AJOUT = new Label("DETAILS");
          
            f2.add(AJOUT);

            Label USERNAME = new Label("USERNAME");
            Label lname = new Label(c.getLname());
            Label USERMAIL = new Label("USERMAIL");
            Label lemail = new Label(c.getMail());
            Label USERNUMBER = new Label("USERNUMBER");
            Label lnum = new Label(String.valueOf(c.getNumber()));
            Label USERAGE = new Label("USERAGE");
            Label lage = new Label(String.valueOf(c.getAge()));

           


            String url2 = "http://127.0.0.1/projet/web/uploads/images/" + c.getImage();
            ImageViewer imgv2;
            Image imge2;
            EncodedImage enc2;
            enc2 = EncodedImage.createFromImage(theme.getImage("round.png"), false);
            imge2 = URLImage.createToStorage(enc, url, url);
            imgv2 = new ImageViewer(imge2);
            Button btn_desactiver_activer;
            Button Affecter_facture = new Button("Affecter Facture");
            if (c.getEnabled() == 1) {
                btn_desactiver_activer = new Button("DESACTIVER");
            } else {
                btn_desactiver_activer = new Button("ACTIVER");
            }
            
Affecter_facture.addActionListener(aw->

{
                try {
                    facture f = new facture();
                    f.setId_user(c.getId());
                    new facture_Service().addfacture(f);
                    Dialog.show("Facture", "Facture attribue ", "OK", null);
                } catch (Exception ex) {
                 
                }
}

);
            btn_desactiver_activer.addActionListener(l
                    -> {
                if (c.getEnabled() == 1) {

                    new User_Service().DesactiverUser(c.getId());
                    Dialog.show("Desactivation", "Desactivation aves succsess ", "OK", null);

                    new ListUsersForm(f2).show();

                } else {
                    new User_Service().activerUser(c.getId());
                    Dialog.show("activation", "Activation aves succsess ", "OK", null);

                    new ListUsersForm(f2).show();

                }

            }
            );
    
            f2.getToolbar().addCommandToLeftBar(null, theme.getImage("back-command.png"), (evt) -> {
                this.show();
            });
           
            f2.add(USERNAME).add(lname).add(USERMAIL).add(lemail).add(USERNUMBER).add(lnum).add(USERAGE).add(lage).add(imgv2).add(btn_desactiver_activer);
            f2.add(Affecter_facture);
            f2.show();

        });

        cn1.setLeadComponent(btn);
        return cn1;

    }

}
