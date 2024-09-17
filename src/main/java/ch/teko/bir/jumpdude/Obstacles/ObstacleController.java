package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.GameSpeedController;

public class ObstacleController {
    
    private final ObstacleModel obstacleModel;
    private boolean flyingState;

    public ObstacleController(ObstacleModel model)
    {
        this.obstacleModel = model;        
    }

    public void repaint(int windowWidth) {
        var obstacles = getObstacles();

        if (flyingState)
        {
            makeThemDisappear(obstacles);
        }
        else
        {
            for (var obstacle : obstacles) {
                obstacle.setX(obstacle.getX() - GameSpeedController.getRunningSpeed());
            }
        }
    }

    private void makeThemDisappear(ArrayList<Obstacle> obstacles)
    {
        for (var obstacle : obstacles) {
            obstacle.setY(obstacle.getY() + GameSpeedController.getFlyingSpeed());

            if (obstacle.getY() >= 1500) {
                obstacle.setY(0);
            }
        }
    }

    private ArrayList<Obstacle> getObstacles()
    {
        var obstacles = obstacleModel.getObstacleList();

        for (Obstacle obstacle : obstacles) {
            if (!flyingState)
            {
                if (obstacle.getX() <= -150) {
                    var newRandomObstacle = RandomObstacleGenerator.generateRandomGround(obstacleModel.getGroundY());
                    obstacle.setHeight(newRandomObstacle.getHeight());
                    obstacle.setWidth(newRandomObstacle.getWidth());
                    obstacle.setX(newRandomObstacle.getX());
                    obstacle.setY(newRandomObstacle.getY());
                }
            }
            else
            {
                if (obstacle.getY() >= 1200)
                {
                    var newRandomObstacle = RandomObstacleGenerator.generateRandomSky(obstacleModel.getGroundY());
                    obstacle.updateSky(newRandomObstacle.getX(), 
                    newRandomObstacle.getY(),
                    newRandomObstacle.getHeight(),
                    newRandomObstacle.getWidth());
                }
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

    public void setFlyingState(boolean state) {
        flyingState = state;
        var obstacles = obstacleModel.getObstacleList();
        for (var obstacle : obstacles) {
            obstacle.setFlyingState();
        }
    }
}