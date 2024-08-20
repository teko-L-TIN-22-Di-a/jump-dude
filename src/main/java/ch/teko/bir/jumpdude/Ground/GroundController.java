package ch.teko.bir.jumpdude.Ground;

import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GroundController {
    private final GroundModel groundModel;

    public GroundController(GroundModel model)
    {
        groundModel = model;
    }

    public void draw(Graphics2D graphics2d, int windowWidth, JPanel panel)
    {        
        var groundSprite = groundModel.getImage();
        var bricks = groundModel.getGroundBrickList();

        for (var brick : bricks) {
            graphics2d.drawImage(groundSprite, 
            brick.getX(), 
            brick.getY(), 
            brick.getWidth(), 
            brick.getHeight(), 
            panel); 
        }
    }

    public void repaint(int windowWidth)
    {
        int speed = 5;

        var bricks = groundModel.getGroundBrickList();
        
        for (var brick : bricks) {
            brick.setX(brick.getX() - speed);

            if (brick.getX() <= -150) {
                brick.setX(brick.getX() + windowWidth + 200);
            }
        }
    }
}