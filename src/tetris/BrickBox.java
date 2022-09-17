package tetris;

import javax.swing.ImageIcon;
import static tetris.Board.CELL_HORIZONTAL;
import static tetris.Board.CELL_VERTICAL;

public class BrickBox extends Brick {
    
    public BrickBox() {
        
        super.setBrickImage(new ImageIcon("data/Box.jpg").getImage());
        
        super.setXY(4, 1, 
                    5, 1, 
                    4, 2,
                    5, 2);  
    } 

    @Override
    public boolean canMoveDown(Board board) {
        
        return Y4() != CELL_VERTICAL+1 &&
                board.getBrickArray()[Y3()+1][X3()] == null &&
                board.getBrickArray()[Y4()+1][X4()] == null;        
    }

    @Override
    public boolean canMoveRight(Board board) {

        return X2() != CELL_HORIZONTAL-1 &&
               board.getBrickArray()[Y2()][X2()+1] == null &&
               board.getBrickArray()[Y4()][X4()+1] == null;
    }

    @Override
    public boolean canMoveLeft(Board board) {
 
        return X1() != 0 &&
               board.getBrickArray()[Y1()][X1()-1] == null &&
               board.getBrickArray()[Y3()][X3()-1] == null;
    }
    
    @Override
    public void rotate(Board board) {

    }

    @Override
    public boolean canRotate(Board board) {
        return false;
    }
}
