/*
 * nkc160130
 * Due: 11/24/18
 */
package djsetmaze;

/**
 * Building blocks for the maze.
 * @author Kevin Chen
 */
public class Block 
{
    //Walls of each block of the maze
    //Note: If boolean false, no wall; if true, there is a wall present
    private boolean left;
    private boolean bottom;
    private boolean top;
    private boolean right;
    
     /**
     * Construct a non-modified block of the maze.
     */
    public Block()
    {
        left = true;
        bottom = true;
        top = true;
        right = true;
    }
    
    //Knocks out a certain wall, connecting two different blocks.
    public void knockLeft(){left = false;}
    public void knockBottom(){bottom = false;}
    public void knockTop(){top = false;}
    public void knockRight(){right = false;}
    
    public boolean getLeft(){return left;}
    public boolean getBottom(){return bottom;}
    public boolean getTop(){return top;}
    public boolean getRight(){return right;}
    
}
