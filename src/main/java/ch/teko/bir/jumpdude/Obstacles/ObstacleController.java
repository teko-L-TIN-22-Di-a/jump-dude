package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.GameSpeedController;

public class ObstacleController {
    
    private final ObstacleModel obstacleModel;

    public ObstacleController(ObstacleModel model)
    {
        this.obstacleModel = model;        
    }

    public void repaint(int windowWidth) {
        var obstacles = getObstacles();

        for (var obstacle : obstacles) {
            obstacle.setX(obstacle.getX() - GameSpeedController.getSpeed());
        }
    }

    private ArrayList<Obstacle> getObstacles()
    {
        var obstacles = obstacleModel.getObstacleList();

        for (Obstacle obstacle : obstacles) {
            if (obstacle.getX() <= -150) {
                var newRandomObstacle = RandomObstacleGenerator.generateRandom(obstacleModel.getGroundY());
                obstacle.setHeight(newRandomObstacle.getHeight());
                obstacle.setWidth(newRandomObstacle.getWidth());
                obstacle.setX(newRandomObstacle.getX());
                obstacle.setY(newRandomObstacle.getY());
            }
        }
        
        return obstacles;
    }

    public void draw(Graphics2D graphics2d, JPanel panel) {
        var obstacles = obstacleModel.getObstacleList();

        for (var obstacle : obstacles) {
            graphics2d.drawImage(obstacle.getImage(), 
            obstacle.getX(), 
            obstacle.getY(), 
            obstacle.getWidth(), 
            obstacle.getHeight(), 
            panel); 
            
            obstacle.hitbox.draw(graphics2d, panel);
        }
    }
}