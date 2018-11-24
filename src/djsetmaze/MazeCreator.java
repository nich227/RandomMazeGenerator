/*
 * nkc160130
 * Due: 11/24/18
 */
package djsetmaze;

import java.util.Random;

/**
 * Creates a random maze given rows and column sizes.
 * @author Kevin Chen
 */
public class MazeCreator 
{
    private int rows, cols;
    
    //Accessors
    public int getSize(){return rows*cols;}
    public int getRows(){return rows;}
    public int getCols(){return cols;}
    
    //Mutators
    public void setRows(int r){rows = r;}
    public void setCols(int c){cols = c;}
    
    public MazeCreator(int r, int c)
    {
        rows = r;
        cols = c;
    }
    
    public Block[] generateMaze()
    {
        DisjSets maze;
        Block[] mazeGUI;
        maze = new DisjSets(getSize());
        mazeGUI = new Block[getSize()];
        for(int i=0; i<getSize(); i++)
            mazeGUI[i] = new Block();
        
        //Knock out walls for first and last blocks
        mazeGUI[0].knockLeft();
        mazeGUI[0].knockTop();
        mazeGUI[getSize()-1].knockBottom();
        mazeGUI[getSize()-1].knockRight();
        
        int[] adjNodes = new int[4];
        int node;
        int nodeAdj;
        boolean allConnected = false;
        
        while(allConnected == false)  
        {
            node = RandIntGen.genRandomNumber(0, getSize() - 1);
            adjNodes[0] = node - 1;
            adjNodes[1] = node - cols;
            adjNodes[2] = node + cols;
            adjNodes[3] = node + 1;
            int whichNode;
            
            //Special case for 2x1 maze
            if(cols < 2)
            {
                if(node == 0)
                    whichNode = 2;
                else
                    whichNode = 1;
            }
            
            //Special case for 1x2 maze
            else if(rows < 2)
            {
                if(node == 0)
                    whichNode = 3;
                else
                    whichNode = 0;
            }
            
            


            
            //Beginning of maze case
            else if(node == 0)
                whichNode = RandIntGen.genRandomNumber(2,3);
            
            //End of maze case 
            else if (node == getSize() - 1)
                whichNode = RandIntGen.genRandomNumber(0,1);
            
            //First row case
            else if (node - cols < 0)
            {
                
                //Last element of first row
                if(node == cols - 1)
                {
                    int posValues[] = {0,2};
                    whichNode = posValues[new Random().nextInt(2)];
                }
                else
                {
                    int posValues[] = {0,2,3};
                    whichNode = posValues[new Random().nextInt(3)];
                }
            }
            
            //Last row case
            else if (node + cols >= getSize())
            {
                //First element of last row
                if(node == getSize() - cols)
                {
                    int posValues[] = {1,3};
                    whichNode = posValues[new Random().nextInt(2)];
                }
                else
                {
                    int posValues[] = {0,1,3};
                    whichNode = posValues[new Random().nextInt(3)];
                }

            }
            
            //Beginning of row case
            else if (node % cols == 0)
                whichNode = RandIntGen.genRandomNumber(1,3);
            
            //End of row case
            else if (Math.abs((node % cols) - cols) == 1)
                whichNode = RandIntGen.genRandomNumber(0,2);
            
            //All other cases
            else
                whichNode = RandIntGen.genRandomNumber(0,3);
            
            nodeAdj = adjNodes[whichNode];
            
            //They are disjoint
            if(maze.find(node) != maze.find(nodeAdj))
            {
                maze.union(maze.find(node), maze.find(nodeAdj));
                
                switch(whichNode)
                {
                    //Left wall out
                    case 0:
                        mazeGUI[node].knockLeft();
                        break;
                    //Top wall out
                    case 1:
                        mazeGUI[node].knockTop();
                        break;
                    //Bottom wall out
                    case 2:
                        mazeGUI[node].knockBottom();
                        break;
                    //Right wall out
                    case 3:
                        mazeGUI[node].knockRight();
                        break;
                        
                }
            }
            
            allConnected = true;
            //Check if all the nodes are connected to the entrance
            for(int i = 0; i < getSize(); i++)
            {
                if(maze.find(0) != maze.find(i))
                {
                    allConnected = false;
                    break;
                }
            }
        }
        
        return mazeGUI;
    }
    
    
    
}
