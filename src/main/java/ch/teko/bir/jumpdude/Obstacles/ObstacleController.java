package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Graphics2D;

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
        var obstacles = obstacleModel.getObstacleList();
        
        for (var obstacle : obstacles) {
            obstacle.setX(obstacle.getX() - speed);

            if (obstacle.getX() <= -150) {
                obstacle.setX(obstacle.getX() + windowWidth + 200);
            }
        }
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