package tetris;

import java.awt.GridBagLayout;
import javax.swing.JFrame;

public class MainWindow extends JFrame 
{  
    private final LeftPanel leftPanel;
    private final Board board;
    private final RightPanel rightPanel;
      
    public MainWindow() 
    {    
        setLayout(new GridBagLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(1200, 800);
              
        leftPanel = new LeftPanel();
        board = new Board();
        rightPanel = new RightPanel(); 
                       
        add(leftPanel, new GBC(0,0).setAnchor(GBC.NORTH));
        add(board, new GBC(1,0));
        add(rightPanel, new GBC(2,0).setAnchor(GBC.NORTH));
        
        setVisible(true);
    }
    
    public Board getBoard() 
    {
        return board;
    }
    
    public RightPanel getRightPanel() 
    {       
        return rightPanel;
    }
}
