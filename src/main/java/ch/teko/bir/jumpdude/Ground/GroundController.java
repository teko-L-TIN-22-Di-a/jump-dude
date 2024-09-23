package ch.teko.bir.jumpdude.Ground;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.GameSpeedController;

public class GroundController {
    private final GroundModel groundModel;
    private boolean flyingState = false;;
    private boolean bricksVisible = true;
    private GameSpeedController gameSpeedController;

    public GroundController(GroundModel model, GameSpeedController gameSpeedController)
    {
        groundModel = model;
        this.gameSpeedController = gameSpeedController;
    }

    
    /** 
     * @param graphics2d
     * @param windowWidth
     * @param panel
     */
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

    
    /** 
     * @param windowWidth
     */
    public void repaint(int windowWidth)
    {
        var bricks = groundModel.getGroundBrickList();
        
        if (flyingState && bricksVisible)
        {
            makeThemDisappear(bricks);
        }
        else
        {
            for (var brick : bricks) {
                brick.setX(brick.getX() - gameSpeedController.getRunningSpeed());

                if (brick.getX() <= -150) {
                    brick.setX(brick.getX() + windowWidth + 200);
                }
            }
        }
    }

    private void makeThemDisappear(ArrayList<Ground> bricks)
    {
        for (var brick : bricks) {
            brick.setY(brick.getY() + gameSpeedController.getFlyingSpeed());

            if (brick.getY() <= -1200) {
                bricksVisible = false;
            }
        }
    }

    public void setFlying(boolean state)
    {
        flyingState = state;
    }
}