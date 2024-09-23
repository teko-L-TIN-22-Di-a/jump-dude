package ch.teko.bir.jumpdude.Jetpack;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.GameSpeedController;

public class JetpackController {

    private JetpackModel model;
    private GameSpeedController gameSpeedController;

    public JetpackController(JetpackModel jetpackModel, GameSpeedController gameSpeedController)
    {
        this.model = jetpackModel;
        this.gameSpeedController = gameSpeedController;
    }

    
    /** 
     * @param windowWidth
     */
    public void repaint(int windowWidth) {
        var jetpack = getJetpack(windowWidth);
        jetpack.setX(jetpack.getX() - gameSpeedController.getRunningSpeed());
    }

    private Jetpack getJetpack(int windowWidth)
    {
        var jetpack = model.getJetpack();

        // reset location if needed
        if (jetpack.getX() <= -150) {
            jetpack.setX(jetpack.getX() + windowWidth + 6000);
        }

        return jetpack;
    }


    public void draw(Graphics2D graphics2d, JPanel panel) {
        var jetpack = model.getJetpack();

        graphics2d.drawImage(jetpack.getImage(), 
        jetpack.getX(), 
        jetpack.getY(), 
        jetpack.getWidth(), 
        jetpack.getHeight(), 
        panel);

        jetpack.hitbox.draw(graphics2d, panel);
    }

    public void removeJetPack() {
        model.disposeJetpack();
    }
}