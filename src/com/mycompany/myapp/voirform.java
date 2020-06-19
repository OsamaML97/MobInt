package com.mycompany.myapp;

import java.io.IOException;

import com.codename1.components.ShareButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.util.Resources;




public class voirform extends Form {
    
    public voirform(club a) throws IOException{
    	 Button r = new Button("retour");
    	    Resources theme = null;
    	    Button p = new Button("participer");
            
            SpanLabel contentSpanLabel = new SpanLabel(a.getNomclub());
            add(contentSpanLabel);
            add(r);
            add(p);
            r.addActionListener(event -> {
                new clubform(theme).show();
                
            });
            ShareButton share = new ShareButton();
            share.setUIID("LoginButton");

    
            share.setText("");
            share.setTextToShare(a.getNomclub());

            add(share);
            
            p.addActionListener(event -> {
                Dialog dlg = new Dialog("Confirmation");

				dlg.add(new SpanLabel("Merci pour votre confiance , vous aller recevoir un mail de confirmation", "DialogBody"));

				dlg.setDisposeWhenPointerOutOfBounds(true);
				dlg.show();
                
            });

            
            
    }
}
