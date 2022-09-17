package tetris;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import static tetris.Brick.BRICK_SIZE;

public class Board extends JComponent implements KeyListener {
   
    private final Image boardImage = new ImageIcon("data/Board.jpg").getImage();
    
    public final static int CELL_HORIZONTAL = 10;
    public final static int CELL_VERTICAL = 18;
    
    private final static int BOARD_WIDTH = CELL_HORIZONTAL*BRICK_SIZE;
    private final static int BOARD_HEIGHT = CELL_VERTICAL*BRICK_SIZE;
    
    public final static int CELL_VERTICAL_BUFFER = 2;
    
    private final Brick[][] brickArray;
    
    private Brick currentPiece;
    
    public Board() 
    {             
        addKeyListener(this);
        setFocusable(true);
        
        currentPiece = null;
        
        setPreferredSize(new Dimension(BOARD_WIDTH, BOARD_HEIGHT));
        
        brickArray = new Brick[CELL_VERTICAL+CELL_VERTICAL_BUFFER][CELL_HORIZONTAL];
        
        for(int i=0; i<CELL_VERTICAL+CELL_VERTICAL_BUFFER; i++) 
        {
            for(int j=0; j<CELL_HORIZONTAL; j++)
                brickArray[i][j] = null;
        }
    }
    
    @Override
    public void paintComponent(Graphics g) 
    {
        super.paintComponent(g);        
        
        g.drawImage(boardImage, 0 , 0, null);
        
        for(int i=2; i<CELL_VERTICAL+CELL_VERTICAL_BUFFER; i++) 
        {
            for(int j=0; j<CELL_HORIZONTAL; j++)
            {
                if(brickArray[i][j] != null)
                    g.drawImage(brickArray[i][j].getBrickImage(), j*30, i*30-2*Brick.BRICK_SIZE, this);      
            }   
        }   
    }   
    
    public void clearBoard() 
    {    
        for(int i=0; i<(CELL_VERTICAL+CELL_VERTICAL_BUFFER); i++) 
        {
            for(int j=0; j<CELL_HORIZONTAL; j++)
            {
                brickArray[i][j] = null;
            } 
        } 
    }
    
    public Brick[][] getBrickArray() 
    {
        return brickArray;
    }

    public void setCurrentPiece(Brick brick)
    {  
        currentPiece = brick;
    }
    
    public Brick getCurrentPiece() 
    {  
        return currentPiece;
    }
     
    @Override
    public void keyTyped(KeyEvent ke)
    {

    }

    @Override
    public void keyPressed(KeyEvent ke)
    {
        int key = ke.getKeyCode();
  
        if(!Controller.isTimerStopped()) {
            if(key == KeyEvent.VK_UP && currentPiece != null && currentPiece.canRotate(this))
            {
                currentPiece.rotate(this);
                this.repaint();    
            }

            if(key == KeyEvent.VK_RIGHT && currentPiece != null && currentPiece.canMoveRight(this))
            {
                currentPiece.moveRight(this);
                this.repaint();
            }

            if(key == KeyEvent.VK_LEFT && currentPiece != null && currentPiece.canMoveLeft(this))
            {
                currentPiece.moveLeft(this);
                this.repaint();
            }

            if(key == KeyEvent.VK_DOWN && currentPiece != null && currentPiece.canMoveDown(this))
            {
                currentPiece.moveDown(this);
                this.repaint();
            }

            if(key == KeyEvent.VK_SPACE && currentPiece != null) 
            {
                currentPiece.putDown(this);
                this.repaint();
            }  
        }
    }

    @Override
    public void keyReleased(KeyEvent ke)
    {

    }
}
