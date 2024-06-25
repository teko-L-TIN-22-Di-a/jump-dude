package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Graphics2D;

import ch.teko.bir.jumpdude.ILevelElement;

public class ObstacleController implements ILevelElement {

    private final ObstacleModel obstacleModel;

    public ObstacleController(ObstacleModel model)
    {
        this.obstacleModel = model;        
    }

    public void draw(Graphics2D graphics2d, int windowWidth)
    {
        var obstacles = obstacleModel.getObstacleList();

        for (var obstacle : obstacles) {
            graphics2d.setColor(obstacle.getColor());
            graphics2d.fillRect(obstacle.getX(), obstacle.getY(), obstacle.getWidth(), obstacle.getHeight());
        }
    }

    public void repaint(int windowWidth)
    {
        int speed = 5;

        var obstacles = obstacleModel.getObstacleList();
        
        for (var obstacle : obstacles) {
            obstacle.setX(obstacle.getX() - speed);

            if (obstacle.getX() <= 0) {
                obstacle.setX(obstacle.getX() + windowWidth);
            }
        }
    }
}