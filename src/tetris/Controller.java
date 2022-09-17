package tetris;

import javax.swing.Timer;

public class Controller
{    
    private final MainWindow mainWindow;
    
    private Timer timer = null;
    private static boolean isTimerStopped;
      
    public Controller(MainWindow mainWindow)
    {
        this.mainWindow = mainWindow;   
    }
    
    public void initialize() 
    {           
        mainWindow.getRightPanel().getStartButton().addActionListener(event->
        {  
            if(timer == null) 
            {
                Game newGame = new Game(mainWindow);
                timer = newGame.startNewGame(mainWindow);              
            } else 
            {               
                timer.stop();
                Game newGame = new Game(mainWindow);
                timer = newGame.startNewGame(mainWindow);
            } 
            
            isTimerStopped = false;
        });
        
        mainWindow.getRightPanel().getPauseButton().addActionListener(event->
        {
            if(timer != null) 
            {         
                if(!isTimerStopped)
                {
                    timer.stop();
                    isTimerStopped = true;
                }
                else
                {
                    timer.start();
                    isTimerStopped = false;
                }
            }         
        });
        
    }  
    
    public static boolean isTimerStopped() 
    {
        return isTimerStopped;
    }
}
