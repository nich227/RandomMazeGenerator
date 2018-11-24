/*
 * nkc160130
 * Due: 11/24/18
 */
package djsetmaze;

import java.util.Scanner;

/**
 *
 * @author Kevin Chen
 */
public class Main {

    /**
     * The main function.
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        int rows, cols;
        Scanner in = new Scanner(System.in);
        /*
        Dialog windows = new Dialog();
        windows.showInput();
        */
        
        Input input = new Input();

        /*
        System.out.println("DISJOINT SET MAZE\n-----------------");
        System.out.print("# of rows: ");
        rows = in.nextInt(); 
        System.out.print("\n# of columns: ");
        cols = in.nextInt();
        
        MazeCreator gen = new MazeCreator(rows, cols);
        Block[] maze = new Block[rows*cols];
        maze = gen.generateMaze();
        */
    }
    
}
