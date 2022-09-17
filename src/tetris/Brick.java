package tetris;

import java.awt.Image;
import java.util.Random;

public abstract class Brick 
{
    public final static int BRICK_SIZE = 30;
   
    private int x1, x2, x3, x4;
    private int y1, y2, y3, y4;
    
    private int position = 1;
 
    private Image brickImage;
    
    public void setBrickImage(Image image) 
    {      
        brickImage = image;
    }
    
    public Image getBrickImage() 
    {       
        return brickImage;
    }
    
    public Image getImage() 
    {        
        return brickImage;
    }
    
    public static Brick randomBrick()
    {       
        Random rand = new Random();
        int n = rand.nextInt(7)+1;
        
        switch (n)
        {
            case 1:
                return new BrickT();
            case 2:
                return new BrickBox();
            case 3:
                return new BrickI();
            case 4:
                return new BrickZLeft();
            case 5:
                return new BrickZRight();
            case 6:
                return new BrickLLeft();
            case 7:
                return new BrickLRight();
            default:
                break;
        }
        return null;
    }
    
    public int X1() 
    {       
        return x1;
    }
    
    public int X2()
    {
        return x2;
    }
    
    public int X3()
    {
        return x3;
    }
    
    public int X4()
    {
        return x4;
    }
    
    public int Y1() 
    {
        return y1;
    }
    
    public int Y2() 
    {
        return y2;
    }
    
    public int Y3() 
    {
        return y3;
    }
    
    public int Y4() 
    {
        return y4;
    }
    
    public void setXY(int x1, int y1, int x2, int y2, 
                      int x3, int y3, int x4, int y4) 
    {
        this.x1 = x1;
        this.x2 = x2;
        this.x3 = x3;
        this.x4 = x4;
        
        this.y1 = y1;
        this.y2 = y2;
        this.y3 = y3;
        this.y4 = y4;
    }
    
    public int getPosition() 
    {
        return position;
    }
    
    public void setPosition(int p)
    {
        position = p;
    }
    
    public void putBrickOnBoard(Board board)
    {
        board.getBrickArray()[Y1()][X1()] = 
        board.getBrickArray()[Y2()][X2()] = 
        board.getBrickArray()[Y3()][X3()] = 
        board.getBrickArray()[Y4()][X4()] = this;
    }
    
    public void removeBrickFromBoard(Board board) 
    { 
        board.getBrickArray()[Y1()][X1()] =
        board.getBrickArray()[Y2()][X2()] = 
        board.getBrickArray()[Y3()][X3()] = 
        board.getBrickArray()[Y4()][X4()] = null;
    }

    public void moveDown(Board board) 
    { 
        removeBrickFromBoard(board);
            
        setXY(X1(), Y1()+1,
              X2(), Y2()+1,
              X3(), Y3()+1,
              X4(), Y4()+1);
   
        putBrickOnBoard(board);
    }
    
    public void moveRight(Board board) {
        
        removeBrickFromBoard(board);
        
        setXY(X1()+1, Y1(),
              X2()+1, Y2(),
              X3()+1, Y3(),
              X4()+1, Y4());
   
        putBrickOnBoard(board);        
    }

    public void moveLeft(Board board) 
    {   
        removeBrickFromBoard(board);
        
        setXY(X1()-1, Y1(),
              X2()-1, Y2(),
              X3()-1, Y3(),
              X4()-1, Y4());
   
        putBrickOnBoard(board);        
    }   
    
    public void putDown(Board board)
    {
        
        while(canMoveDown(board)){
            moveDown(board);
        }
    }
    
    public abstract boolean canMoveDown(Board board);
    public abstract boolean canMoveRight(Board board);
    public abstract boolean canMoveLeft(Board board);
    public abstract boolean canRotate(Board board);
    public abstract void rotate(Board board);
}
