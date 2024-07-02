package ch.teko.bir.jumpdude.Ground;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public class Ground {
    private final GroundModel groundModel;

    public Ground(GroundModel model)
    {
        groundModel = model;
    }

    public void draw(Graphics2D graphics2d, int windowWidth, JPanel panel)
    {        
        var groundSprite = groundModel.getImage();
        graphics2d.drawImage(groundSprite, groundModel.getGroundX(), groundModel.getGroundY(), groundSprite.getWidth(), groundSprite.getHeight(), panel);
        graphics2d.drawImage(groundSprite, groundModel.getGroundX() + groundSprite.getWidth(), groundModel.getGroundY(), groundSprite.getWidth(), groundSprite.getHeight(), panel);
        graphics2d.dispose();

        // graphics2d.setColor(groundModel.getGroundColor());
        // graphics2d.fillRect(groundModel.getGroundX(), groundModel.getGroundY(), windowWidth, groundModel.getGroundHeight());
    }
}