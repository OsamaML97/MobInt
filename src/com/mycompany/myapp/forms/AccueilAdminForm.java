/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;

import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;

import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import java.io.IOException;

import models.Session;
import models.User;

/**
 *
 * @author aymen
 */
public class AccueilAdminForm extends Form {

    Resources theme;
    Form current;
    public AccueilAdminForm(Form previous) {
        super("ADMIN",BoxLayout.y());

        theme = UIManager.initFirstTheme("/theme");
     
     this.add("Bonjour Admin");
   
     


      

       
        this.getToolbar().addCommandToOverflowMenu("Users", null, ev -> {

            new ListUsersForm(this).show();
        });
        
        this.getToolbar().addCommandToOverflowMenu("Info", null, ev -> {

            new Detail_ProfilForm(this).show();

        });
     
        this.getToolbar().addCommandToOverflowMenu("Logout", null, ev -> {
            new LoginForm().show();
        });

    }

}
