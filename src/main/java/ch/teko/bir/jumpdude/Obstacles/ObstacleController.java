package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.CollisionElement;

public class ObstacleController extends CollisionElement {
    private final ObstacleModel obstacleModel;

    public ObstacleController(ObstacleModel model)
    {
        this.obstacleModel = model;        
    }
   
    public void draw(Graphics2D graphics2d, JPanel panel)
    {        
        var obstacleSprite = obstacleModel.getImage();
        var obstacles = obstacleModel.getObstacleList();

        for (var obstacle : obstacles) {
            graphics2d.drawImage(obstacleSprite, 
            obstacle.getX(), 
            obstacle.getY(), 
            obstacle.getWidth(), 
            obstacle.getHeight(), 
            panel); 
        }
    }

    public void repaint(int windowWidth)
    {
        int speed = 5;

        var obstacles = obstacleModel.getObstacleList();
        
        for (var obstacle : obstacles) {
            obstacle.setX(obstacle.getX() - speed);

            if (obstacle.getX() <= -150) {
                obstacle.setX(obstacle.getX() + windowWidth + 200);
            }
        }
    }
}