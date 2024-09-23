package ch.teko.bir.jumpdude.Scores;

import java.awt.Toolkit;

import javax.swing.JFrame;

import ch.teko.bir.jumpdude.Main;

/**
 *
 * @author Sarah
 */

public class ScoresPanelFactory {

    public static void createScoresWindow()
    {        
        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame window = new JFrame("Jump Dude");
        window.setName("scores");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.add(new ScoresPanel());
        window.setVisible(true);
        window.setIconImage(img);
        window.setResizable(false);
    }

    
    /** 
     * @param playerName
     * @param score
     */
    public static void createScoresWindow(String playerName, int score)
    {        
        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame window = new JFrame("Jump Dude");
        window.setName("scores");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.add(new ScoresPanel(new Score(playerName, score)));
        window.setVisible(true);
        window.setIconImage(img);
        window.setResizable(false);
    }
}