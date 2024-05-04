/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package jump.dude;

import java.awt.Graphics2D;
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
