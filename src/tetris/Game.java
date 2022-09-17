package tetris;

import javax.swing.JOptionPane;
import javax.swing.Timer;
import static tetris.Board.CELL_HORIZONTAL;
import static tetris.Board.CELL_VERTICAL;
import static tetris.Board.CELL_VERTICAL_BUFFER;
import static tetris.Brick.randomBrick;

public class Game {
       
    private final Board board;
    private Timer gameTimer = null;
    
    private boolean isFinisihed = false;
    
    private int speed = 1;
    private int maxSpeed = 20;
    
    private static int level;
    private static int score;
    
    public Game(MainWindow window)
    {
        resetScore();
        
        board = window.getBoard();
        board.setCurrentPiece(randomBrick());
        board.getCurrentPiece().putBrickOnBoard(board);
    }
    
    public Timer startNewGame(MainWindow window)
    {   
        board.clearBoard();

        Timer timer; 

        timer = new Timer(50, event->
        {           
            if(speed == 1)
            {
                update();
                render(board);
            }
            
            changeSpeed();
            window.getRightPanel().getPointsLabel().setText("PUNKTY: "+score);
            window.getRightPanel().getLevelLabel().setText("POZIOM: "+level);
        });
        timer.setInitialDelay(0);
        timer.start(); 
        
        gameTimer = timer;  
        return timer;
    }   

    public void update() 
    {
        if(!isFinisihed) 
        { 
            if(board.getCurrentPiece().canMoveDown(board))
            {
                board.getCurrentPiece().moveDown(board);
            }
            else 
            {
                checkLine(board);
                board.repaint();
                Brick brick = randomBrick(); 
                brick.putBrickOnBoard(board);
                board.setCurrentPiece(brick);

                if(!brick.canMoveDown(board))
                {
                    isFinisihed = true;
                    JOptionPane.showMessageDialog(null, "GRA SKOŃCZONA!!\nUZYSKAŁEŚ "+score+" PUNKTY");
                }
                else
                    brick.moveDown(board);
            }
        }
    }
    
    public void render(Board board)
    {
        if(!isFinisihed)
            board.repaint();    
    }
    
    public Timer getGameTimer() 
    { 
        return gameTimer;
    }
    
    public void checkLine(Board board) 
    { 
        for(int i=2; i<CELL_VERTICAL+CELL_VERTICAL_BUFFER; i++)
        {            
            if(isRowFull(board, i))
            {
                moveRowsDown(board, i);
                addScore();
            }
        }                
    }

    private boolean isRowFull(Board board, int r) 
    {  
        for(int i=0; i<CELL_HORIZONTAL; i++)
        {
            if(board.getBrickArray()[r][i] == null)
                return false;
        }
        return true;
    }
    
    private void moveRowsDown(Board board, int r) 
    {
        for(int i=r; i>=CELL_VERTICAL_BUFFER; i--)
            System.arraycopy(board.getBrickArray()[i-1], 0, board.getBrickArray()[i], 0, CELL_HORIZONTAL);
    }
    
    public void changeSpeed()
    { 
        if(speed >= maxSpeed)
            speed = 0;
        speed++; 
    }
    
    public void addScore()
    { 
        score += 100;
        
        if(score%1000 == 0)
        {
            maxSpeed --;  
            level++;
        }
    }
    
    public static int getScore() 
    { 
        return score;
    }  
    
    public static int getLevel()
    {  
        return level;
    }
    
    public static void resetScore()
    { 
        score = 0;
        level = 1;
    }
}
