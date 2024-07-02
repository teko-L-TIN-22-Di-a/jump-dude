package ch.teko.bir.jumpdude;

import java.awt.Toolkit;

import javax.swing.JFrame;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.teko.bir.jumpdude.KeyListener.MainKeyListener;
import ch.teko.bir.jumpdude.Player.PlayerController;

/**
 *
 * @author Sarah
 */
public class Main {    
    protected static final Logger logger = LogManager.getLogger();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initializeLevel();
    }
    
    private static void initializeLevel(){
        var playerController = new PlayerController();

        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame level = new JFrame("Jump Dude");
        level.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        level.setSize(1000, 800);
        level.add(new MainPanel(new PanelModel(), playerController));
        level.addKeyListener(new MainKeyListener(playerController));
        level.setVisible(true);
        level.setIconImage(img);
    }
}
