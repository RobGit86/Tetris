package tetris;

import java.awt.EventQueue;

public class Tetris {

    public static void main(String[] args)
    {      
        EventQueue.invokeLater(()->
        {       
            MainWindow mainWidnow = new MainWindow();
            
            Controller controller = new Controller(mainWidnow);
            controller.initialize();
        }); 
    }   
}