/*
 * nkc160130
 * Due: 11/24/18
 */
package djsetmaze;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * Displays all the windows (input screen, loading screen, output screen)
 * @author Kevin Chen
 */
public class Dialog 
{
    private final JFrame input, loading, output;
    
    public Dialog()
    {
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(ClassNotFoundException e){} catch (InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Dialog.class.getName()).log(Level.SEVERE, null, ex);
        }
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        /*Input screen display*/
        input = new JFrame("Disjoint Set Maze");
        JPanel p = new JPanel();
        
        input.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        input.setSize(screenSize.width/2, screenSize.height/2);
        input.getContentPane().setBackground(new Color(244, 244, 244));
        input.setLocationRelativeTo(null);
        //SwingUtilities.updateComponentTreeUI(input);
        ImageIcon img = new ImageIcon("icon.png");
        input.setIconImage(img.getImage());
        
        GridBagConstraints gb = new GridBagConstraints();
        GridBagLayout gbl = new GridBagLayout();
        p.setLayout(gbl);
        
        JLabel title = new JLabel("Disjoint Set Maze");
        title.setText("<html><style>@import url(\"https://fonts.googleapis.com/css?family=Roboto:300\");</style>"
                + "<h1 style='font-family:Roboto;font-size:125%;color:#373737;'>"
                + "Disjoint Set Maze</h1></html>");
        gb.gridx = 9;
        gb.gridy = 2;
        gb.gridwidth = 1;
        gb.gridheight = 1;
        gb.fill = GridBagConstraints.BOTH;
        gb.weightx = 1;
        gb.weighty = 1;
        gb.anchor = GridBagConstraints.NORTH;
        gbl.setConstraints( title, gb );
        p.add( title );
        p.add(title, gb);
        
        /*
        JLabel rows = new JLabel("Rows");
        rows.setText("<html><style>@import url(\"https://fonts.googleapis.com/css?family=Roboto:300\");</style>"
                + "<p style='font-family:Roboto;font-size:105%;color:#373737;text-align:left;'>"
                + "Rows: </p></html>");
        gb.weightx = 0.0;
        gb.gridwidth = 3;
        gb.gridx = 10;
        gb.gridy = 300;
        p.add(rows, gb);
        JTextField rows_in = new JTextField();
        rows_in.setColumns(1);
        p.add(rows_in);
        
        
        JButton submit = new JButton("Submit");
        submit.setText("<html><style>@import url(\"https://fonts.googleapis.com/css?family=Roboto:300\");</style>"
                + "<p style='font-family:Roboto;font-size:100%;color:#373737;'>"
                + "Submit</p></html>");
        p.add(submit);
        
        
        input.setContentPane(p);
        /*
        JTextField textField = new JTextField(20);
        input.add(textField);
        */
        
        
        loading = new JFrame("Loading...");
        loading.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loading.setSize(screenSize.width/4, screenSize.height/4);
        
        output = new JFrame("Disjoint Set Maze");
        output.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        output.setSize(screenSize.width, screenSize.height);
        
    }
    
    public void showInput(){input.setVisible(true);}
    public void hideInput(){input.setVisible(false);}
    
    public void showLoading(){loading.setVisible(true);}
    public void hideLoading(){loading.setVisible(false);}
    
    public void showOutput(){output.setVisible(true);}
    public void hideOutput(){output.setVisible(false);}
    
    public void getInput(Integer rows, Integer cols)
    {
        
    }
    
}
