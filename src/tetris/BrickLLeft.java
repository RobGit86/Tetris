package tetris;

import javax.swing.ImageIcon;
import static tetris.Board.CELL_HORIZONTAL;
import static tetris.Board.CELL_VERTICAL;

public class BrickLLeft extends Brick 
{
    public BrickLLeft()
    {
        super.setBrickImage(new ImageIcon("data/Ll.jpg").getImage());
        
        super.setXY(3, 1, 
                    4, 1, 
                    5, 1,
                    3, 2);
    }
    
    @Override
    public boolean canMoveDown(Board board) 
    {
        if(getPosition() == 1 && 
           Y4() != CELL_VERTICAL+1 &&
           board.getBrickArray()[Y2()+1][X2()] == null &&
           board.getBrickArray()[Y3()+1][X3()] == null &&
           board.getBrickArray()[Y4()+1][X4()] == null)
            return true;
        else if(getPosition() == 2 && 
           Y3() != CELL_VERTICAL+1 &&
           board.getBrickArray()[Y3()+1][X3()] == null &&
           board.getBrickArray()[Y4()+1][X4()] == null)
            return true;
        else if(getPosition() == 3 && 
           Y2() != CELL_VERTICAL+1 &&
           board.getBrickArray()[Y1()+1][X1()] == null &&
           board.getBrickArray()[Y2()+1][X2()] == null &&
           board.getBrickArray()[Y3()+1][X3()] == null)
            return true;
        else if(getPosition() == 4 && 
           Y1() != CELL_VERTICAL+1 &&
           board.getBrickArray()[Y1()+1][X1()] == null &&
           board.getBrickArray()[Y4()+1][X4()] == null)
            return true;    
        
        return false; 
    }

    @Override
    public boolean canMoveRight(Board board) 
    {
        if(getPosition() == 1 && 
           X3() != CELL_HORIZONTAL-1 &&
           board.getBrickArray()[Y3()][X3()+1] == null &&
           board.getBrickArray()[Y4()][X4()+1] == null) 
           return true;
        else if(getPosition() == 2 && 
           X2() != CELL_HORIZONTAL-1 &&
           board.getBrickArray()[Y1()][X1()+1] == null &&
           board.getBrickArray()[Y2()][X2()+1] == null &&    
           board.getBrickArray()[Y3()][X3()+1] == null)      
           return true;
        else if(getPosition() == 3 && 
           X1() != CELL_HORIZONTAL-1 && 
           board.getBrickArray()[Y1()][X1()+1] == null &&
           board.getBrickArray()[Y4()][X4()+1] == null)          
           return true;
        else if(getPosition() == 4 && 
           X4() != CELL_HORIZONTAL-1 &&
           board.getBrickArray()[Y2()][X2()+1] == null &&
           board.getBrickArray()[Y3()][X3()+1] == null &&    
           board.getBrickArray()[Y4()][X4()+1] == null)          
           return true;
        
        return false;
    }
    
    @Override
    public boolean canMoveLeft(Board board) 
    {
        if(getPosition() == 1 &&
           X1() != 0 &&
           board.getBrickArray()[Y1()][X1()-1] == null &&
           board.getBrickArray()[Y4()][X4()-1] == null)  
           return true;
        else if(getPosition() == 2 &&
           X4() != 0 &&
           board.getBrickArray()[Y2()][X2()-1] == null &&
           board.getBrickArray()[Y3()][X3()-1] == null &&    
           board.getBrickArray()[Y4()][X4()-1] == null)
           return true;
        else if(getPosition() == 3 && 
           X3() != 0 &&
           board.getBrickArray()[Y3()][X3()-1] == null &&
           board.getBrickArray()[Y4()][X4()-1] == null)     
           return true;
        else if(getPosition() == 4 && 
           X2() != 0 &&
           board.getBrickArray()[Y1()][X1()-1] == null &&
           board.getBrickArray()[Y2()][X2()-1] == null &&    
           board.getBrickArray()[Y3()][X3()-1] == null)     
           return true;
        
        return false;
    }
    
    @Override
    public boolean canRotate(Board board) 
    {
        if(getPosition() == 1 && 
           board.getBrickArray()[Y2()-1][X2()] == null &&
           board.getBrickArray()[Y2()+1][X2()] == null &&
           board.getBrickArray()[Y2()-1][X2()-1] == null)
            return true;
        else if(getPosition() == 2 && 
           X2() != CELL_HORIZONTAL-1 && 
           board.getBrickArray()[Y2()][X2()-1] == null &&
           board.getBrickArray()[Y2()][X2()+1] == null &&
           board.getBrickArray()[Y2()-1][X2()+1] == null)
            return true;
        else if(getPosition() == 3 && 
           board.getBrickArray()[Y2()-1][X2()] == null &&
           board.getBrickArray()[Y2()+1][X2()] == null &&
           board.getBrickArray()[Y2()+1][X2()+1] == null)
            return true;
        else if(getPosition() == 4 && 
           X2() != 0 && 
           board.getBrickArray()[Y2()][X2()-1] == null &&
           board.getBrickArray()[Y2()][X2()+1] == null &&
           board.getBrickArray()[Y2()+1][X2()-1] == null)
            return true;
        return false;
    }
    
    @Override
    public void rotate(Board board) 
    {
        removeBrickFromBoard(board);

        switch (getPosition()) {
            case 1:
                setXY(X1()+1, Y1()-1, X2(), Y2(), X3()-1, Y3()+1, X4(), Y4()-2);       
                setPosition(2);
                break;
            case 2:
                setXY(X1()+1, Y1()+1, X2(), Y2(), X3()-1, Y3()-1, X4()+2, Y4());   
                setPosition(3);
                break;
            case 3:
                setXY(X1()-1, Y1()+1, X2(), Y2(), X3()+1, Y3()-1, X4(), Y4()+2);   
                setPosition(4);
                break;
            case 4:
                setXY(X1()-1, Y1()-1, X2(), Y2(), X3()+1, Y3()+1, X4()-2, Y4());   
                setPosition(1);
                break;
            default:
                break;
        }

        putBrickOnBoard(board);
    }
}
