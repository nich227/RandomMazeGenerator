/*
 * nkc160130
 * Due: 11/24/18
 */
package djsetmaze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * The window that draws the maze onto a JFrame.
 * @author Kevin Chen
 */
public class MazeGUI extends JFrame
{
    private Block[] maze;
    private int rows, cols;
    public final Color background_color = new Color(244, 244, 244);
    public final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private JPanel p;
    
    protected final int RECT_SIZE = 25;
    protected final int INIT_X = 5;
    protected final int INIT_Y = 5;
    
    public MazeGUI(Block[] m, int r, int c)
    {
        maze = m;
        rows = r;
        cols = c;
        
        p = new JPanel();
        p.setLayout(new BorderLayout());
        
        //Panel on which the maze will be drawn
        Canvas canv = new Canvas();
        
        //Modify properties of the window
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(new Dimension(INIT_X + (RECT_SIZE) * (cols + 4), 
                INIT_X + (RECT_SIZE) * (rows + 4)));
        this.setPreferredSize(new Dimension(screenSize.width/2, screenSize.height/2));
        //this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        //this.setContentPane(p);
        p.add(canv);
        
        this.add(new JScrollPane(p));
        
        //Set icons and titles
        this.setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("icon.png")));
        this.setTitle("Knight's Adventure Maze");
        
        
    }
    
    /**
    * The canvas where the maze is drawn.
    * @author Kevin Chen
    */
    protected class Canvas extends JPanel
    {
        
        public Canvas()
        {
            this.setLayout(new BorderLayout());
            this.setBackground(background_color);
            this.setOpaque(true);
        }
        
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(INIT_X + (RECT_SIZE) * (cols + 2), INIT_X + (RECT_SIZE) * (rows + 2));
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            Graphics2D art = (Graphics2D) g;
            //Draws all of the squares that makes up the maze
            for(int i = 0; i < cols; i++)
            {
                for(int j = 0; j < rows; j++)
                    art.drawRect(INIT_X + (RECT_SIZE)*(i+1), INIT_Y +(RECT_SIZE)*(j+1), RECT_SIZE, RECT_SIZE);      
            }
            
            int thisRow = 0;
            art.setColor(background_color); 
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < cols; j++)
                {
                    //Knocks out left wall
                    if(maze[thisRow+j].getLeft() == false)
                        art.drawLine(INIT_X + (RECT_SIZE)*(j+1), INIT_Y +(RECT_SIZE)*(i+1), INIT_X + (RECT_SIZE)*(j+1) , INIT_Y +(RECT_SIZE)*(i+1)+RECT_SIZE-1);
                    
                    //Knocks out right wall
                    if(maze[thisRow+j].getRight() == false)
                        art.drawLine(INIT_X + (RECT_SIZE)*(j+1)+RECT_SIZE, INIT_Y +(RECT_SIZE)*(i+1), INIT_X + (RECT_SIZE)*(j+1)+RECT_SIZE, INIT_Y +(RECT_SIZE)*(i+1)+RECT_SIZE-1);
                    
                    //Knocks out bottom wall
                    if(maze[thisRow+j].getBottom() == false)
                        art.drawLine(INIT_X + (RECT_SIZE)*(j+1), INIT_Y +(RECT_SIZE)*(i+1)+RECT_SIZE, INIT_X + (RECT_SIZE)*(j+1)+RECT_SIZE, INIT_Y +(RECT_SIZE)*(i+1)+RECT_SIZE);
                                                
                    
                    //Knocks out top wall
                    if(maze[thisRow+j].getTop() == false)
                        art.drawLine(INIT_X + (RECT_SIZE)*(j+1), INIT_Y +(RECT_SIZE)*(i+1), INIT_X + (RECT_SIZE)*(j+1)+RECT_SIZE, INIT_Y +(RECT_SIZE)*(i+1));
                    
                }
                if(rows == cols)
                    thisRow+=rows;
                else
                    thisRow+=cols;
            }
            
            //Marks start and finish blocks
            art.setColor(new Color(255,255,255));
            
            //start (draw left and top)
            art.drawLine(INIT_X + (RECT_SIZE), INIT_Y +(RECT_SIZE), INIT_X + (RECT_SIZE) , INIT_Y +(RECT_SIZE)+RECT_SIZE-1);
            art.drawLine(INIT_X + (RECT_SIZE), INIT_Y +(RECT_SIZE), INIT_X + (RECT_SIZE)+RECT_SIZE, INIT_Y +(RECT_SIZE));
            
            //finish (draw right and bottom)
            art.drawLine(INIT_X + (RECT_SIZE)*(cols)+RECT_SIZE, INIT_Y +(RECT_SIZE)*(rows), INIT_X + (RECT_SIZE)*(cols)+RECT_SIZE, INIT_Y +(RECT_SIZE)*(rows)+RECT_SIZE-1);
            art.drawLine(INIT_X + (RECT_SIZE)*(cols), INIT_Y +(RECT_SIZE)*(rows)+RECT_SIZE, INIT_X + (RECT_SIZE)*(cols)+RECT_SIZE, INIT_Y +(RECT_SIZE)*(rows)+RECT_SIZE);
        }      
    }
}
