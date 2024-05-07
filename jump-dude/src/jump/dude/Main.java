package jump.dude;

import javax.swing.JFrame;

/**
 *
 * @author Sarah
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initializeLevel();
    }
    
    private static void initializeLevel(){
        JFrame level = new JFrame("Jump Dude");
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setSize(1000, 800);
        level.add(new Panel());
        level.setVisible(true);
    }
}
