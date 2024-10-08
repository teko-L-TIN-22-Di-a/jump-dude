package ch.teko.bir.jumpdude;

import java.awt.Toolkit;

import javax.swing.JFrame;

import ch.teko.bir.jumpdude.CollisionHelper.CollisionHelper;
import ch.teko.bir.jumpdude.Jetpack.JetpackModel;
import ch.teko.bir.jumpdude.KeyListener.MainKeyListener;
import ch.teko.bir.jumpdude.Obstacles.ObstacleModel;
import ch.teko.bir.jumpdude.Player.PlayerController;

public class MainWindowFactory {
    
    public static void createMainWindow()
    {
        var panelModel = new MainPanelModel();
        var obstacleModel = new ObstacleModel(panelModel.getGroundY());
        var jetpackModel = new JetpackModel(panelModel.getGroundY());
        var playerController = new PlayerController(new CollisionHelper(obstacleModel, jetpackModel));
        
        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame window = new JFrame("Jump Dude");
        window.setName("main");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.add(new MainPanel(panelModel, playerController, obstacleModel, jetpackModel));
        window.addKeyListener(new MainKeyListener(playerController));
        window.setVisible(true);
        window.setIconImage(img);
        window.setResizable(false);
    }
    
}
