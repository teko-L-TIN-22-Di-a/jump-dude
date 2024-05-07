package jump.dude;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

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
        var level = new level();
        level.show();
        level.setResizable(false);   
        level.setTitle("Jump Dude");
        level.setDefaultCloseOperation(DISPOSE_ON_CLOSE);        
    }
}
