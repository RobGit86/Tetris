package tetris;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.BorderFactory;
import javax.swing.border.*;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftPanel extends JPanel 
{
    
    public LeftPanel() 
    {   
        setLayout(new GridBagLayout());
        
        Color backgroundColor = Color.decode("#53d8fb");
        setBackground(backgroundColor);
       
        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        setBorder(raisedetched);
        
        add(new JLabel("KLAWISZE:"), new GBC(0,0).setAnchor(GBC.NORTHWEST).setInsets(5));
        add(new JLabel("<-: PRZESUŃ W LEWO"), new GBC(0,1).setAnchor(GBC.WEST).setInsets(5));
        add(new JLabel("->: PRZESUŃ W PRAWO"), new GBC(0,2).setAnchor(GBC.WEST).setInsets(5));
        add(new JLabel("|/: PRZESUŃ W DÓŁ"), new GBC(0,3).setAnchor(GBC.WEST).setInsets(5));
        add(new JLabel("^ : OBRÓT"), new GBC(0,4).setAnchor(GBC.WEST).setInsets(5));
        add(new JLabel("SPACJA: UPUŚĆ"), new GBC(0,5).setAnchor(GBC.WEST).setInsets(5));
    }
}
