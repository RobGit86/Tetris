package tetris;

import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.*;
import static tetris.Game.getLevel;
import static tetris.Game.getScore;

public class RightPanel extends JPanel
{  
    private final JButton startButton;
    private final JButton pauseButton;
    
    private final JLabel pointsLabel;
    private final JLabel levelLabel;
    
    public RightPanel() 
    {
        setLayout(new GridBagLayout());
        
        Color backgroundColor = Color.decode("#66c3ff");
        setBackground(backgroundColor);
        
        Border raisedetched = BorderFactory.createEtchedBorder(EtchedBorder.RAISED);
        setBorder(raisedetched);
             
        startButton = new JButton("NOWA GRA");
        startButton.setFocusable(false);
        pauseButton = new JButton("PAUZA");
        pauseButton.setFocusable(false);
        
        pointsLabel = new JLabel("PUNKTY: "+getScore());
        levelLabel = new JLabel("POZIOM:"+getLevel());
        
        add(startButton, new GBC(0,0).setInsets(5));
        add(pauseButton, new GBC(1,0).setInsets(5));
        
        add(pointsLabel, new GBC(0,1).setAnchor(GBC.NORTHWEST).setInsets(10));
        add(levelLabel, new GBC(0,2).setAnchor(GBC.NORTHWEST).setInsets(10));
    }
    
    public JButton getStartButton()
    {
        return startButton;
    }
    
    public JButton getPauseButton()
    {
        return pauseButton;
    }
    
    public JLabel getPointsLabel() 
    {
        return pointsLabel;
    }
    
    public JLabel getLevelLabel()
    {
        return levelLabel;
    }
}
