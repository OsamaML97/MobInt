/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import models.Session;
import models.User;

/**
 *
 * @author aymen
 */
public class Detail_ProfilForm extends Form {
    Resources theme = UIManager.initFirstTheme("/theme");

    public Detail_ProfilForm(Form previous) {
          super( "Profil",BoxLayout.y());
     
        Label logi = new Label("PROFIL ");
    
        this.add(logi);
          User u = Session.get();
          Label LASTNAME = new Label("LASTNAME");
            Label lname = new Label( u.getLname());
             Label FIRSTNAME = new Label("FIRSTNAME");
            Label fname = new Label( u.getFname());
             Label USERMAIL = new Label("USERMAIL");
            Label lemail = new Label( u.getMail());
             Label USERNUMBER = new Label("USERNUMBER");
            Label lnum = new Label(String.valueOf(u.getNumber()));
             Label USERAGE = new Label("USERAGE");
            Label lage = new Label(String.valueOf(u.getAge()));
             Label USERNAME = new Label("USERNAME");
            Label username = new Label(u.getUsername());
            Button btn = new Button("Edit Profil");
           
             
            String url = "http://127.0.0.1:1234/projet/web/uploads/images/" + u.getImage();
            ImageViewer imgv;
            Image imge;
            EncodedImage enc;
            enc = EncodedImage.createFromImage(theme.getImage("round.png"), false);
            imge = URLImage.createToStorage(enc, url, url);
            imgv = new ImageViewer(imge);

            this.add(imgv).add(LASTNAME).add(lname).add(FIRSTNAME).add(fname).add(USERNAME).add(username).add(USERMAIL).add(lemail).add(USERNUMBER).add(lnum).add(USERAGE).add(lage).add(btn);

            btn.addActionListener(ln
                    -> {
         
               new EditProfil(this).show();
            }
            );

         
             this.getToolbar().addCommandToLeftBar(null, theme.getImage("back-command.png"), (evt) -> {
            previous.showBack();
        });
    }
    
}
