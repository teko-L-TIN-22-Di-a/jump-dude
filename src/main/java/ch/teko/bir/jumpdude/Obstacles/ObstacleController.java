package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

public class ObstacleController {

    private int speed = 5;
    private final ObstacleModel obstacleModel;

    public ObstacleController(ObstacleModel model)
    {
        this.obstacleModel = model;        
    }
   
    public void setIdleSpeed()
    {
        speed = 0;
    }

    public void repaint(int windowWidth) {
        var obstacles = getObstacles();

        for (var obstacle : obstacles) {
            obstacle.setX(obstacle.getX() - speed);
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
        }
    }
}