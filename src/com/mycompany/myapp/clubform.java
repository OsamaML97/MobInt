package com.mycompany.myapp;

import java.io.IOException;
import java.util.ArrayList;

import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.gui.HomeForm;


public class clubform extends Form{
	 
	   public clubform(Resources theme) {
		   super(BoxLayout.y());
	        ArrayList<club> clubs = service.getInstance().getAllClub();
	     
	        Container c = new Container(new LayeredLayout());
	
	        for(club a : clubs){
	      
	        	    Button v = new Button("voir plus");
		            SpanLabel p = new SpanLabel();
		            Label l = new Label();
		            Label o = new Label();
		    
		            
		            p.setText(a.getNomclub());
		            o.setText("place disponible");
		            l.setText(a.getCap());
		            
		  
		      
		            
		       
		            add(p);
		            add(o);
		            add(l);
		            add(v);
		            v.addActionListener(event -> {
		                try {
		                    new voirform(a).show();
		                } catch (IOException ex) {
		                }
		                
		            });
	          
	        }
	        add(c);
                getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_ARROW_BACK, e-> new HomeForm(theme).show());
	    
	        
	        
	   }
	 
}
