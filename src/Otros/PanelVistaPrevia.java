/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Otros;


import java.awt.Image;

import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;


/**
 *
 * @author juan
 */
public class PanelVistaPrevia {
    ImageIcon thumbnail = null; 
      
     public PanelVistaPrevia(JFileChooser fc) { 
 	
     } 
      
     public void loadImage(File f) { 
         if (f == null) { 
             thumbnail = null; 
         } else { 
 	    ImageIcon tmpIcon = new ImageIcon(f.getPath()); 
 	    if(tmpIcon.getIconWidth() > 240 || tmpIcon.getIconWidth() < 240 ) { 
 		thumbnail = new ImageIcon( 
 		    tmpIcon.getImage().getScaledInstance(240, 180, Image.SCALE_DEFAULT)); 
 	    } else { 
 		thumbnail = tmpIcon; 
 	    }
 	} 
     } 
      
    
      
     
    
}
