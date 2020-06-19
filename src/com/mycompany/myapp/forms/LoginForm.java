/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import com.codename1.codescan.CodeScanner;
import com.codename1.codescan.ScanResult;
import com.codename1.components.ImageViewer;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;

import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

import models.Session;


/**
 *
 * @author aymen
 */
public class LoginForm extends Form {

    Form h = this;


    public LoginForm() {
        super( "Log in",BoxLayout.y());

        String url = "http://127.0.0.1/projet/mobile/cnx.php";

       
     
        TextField txtn, txtpass;
        Button btnvalid, btninscrire;

       
     
     
        

        txtn = new TextField("", "");

        ;

        txtpass = new TextField("", "", 5, TextField.PASSWORD);

        btnvalid = new Button("Confirm");

        btninscrire = new Button("Create account");




        this.add(txtn).add(txtpass).add(btnvalid).add(btninscrire);
                //.add(new ScaleImageLabel(GifImage.decode(getResourceAsStream("accueil.gif"), 1177720)));

       

        btninscrire.addActionListener(l
                -> {
            new SignUpForm(this).show();
        }
        );

        btnvalid.addActionListener(e -> {
            ConnectionRequest cnreq = new ConnectionRequest();
            cnreq.setPost(false);
            cnreq.addArgument("name", txtn.getText());
            cnreq.addArgument("password", txtpass.getText());
            cnreq.setUrl(url);
            cnreq.addResponseListener(ev -> {
                String chaine = new String(cnreq.getResponseData());
                System.out.println(chaine);
                if (chaine.equalsIgnoreCase("-1")) {

                    Dialog.show("Erreur", "Verifier votre USername and password", "OK", null);

                } else {
                    int id = Integer.valueOf(chaine);
                    Session.start(id);
                    System.out.println(Session.get());

                    if (Session.get().getEnabled() == 1) {

                        if (Session.get().getRole().equals("[ROLE_PARENT, ROLE_USER]")) {

                            new UserInterfaceForm(this).show();

                        } else {

                            new AccueilAdminForm(this).show();

                        }

                    } else {
                        Dialog.show("Erreur", "Compte Desactive", "OK", null);
                    }

                }

            });
            NetworkManager.getInstance().addToQueueAndWait(cnreq);
        });

    }

}
