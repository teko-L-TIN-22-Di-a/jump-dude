package ch.teko.bir.jumpdude.CollisionHelper;

import ch.teko.bir.jumpdude.Hitbox.Hitbox;
import ch.teko.bir.jumpdude.Obstacles.ObstacleModel;

/**
 * Is the Middleware from Obstacle and Player. 
 * It's main job is to detect if a Player hits a obstacle.
 * The idea is, to remove the direct dependency between player and obstacle.
 **/
public class CollisionHelper {

    public CollisionHelper(ObstacleModel obstacleModel)
    {
        this.obstacleModel = obstacleModel;
    }
    
    public ObstacleModel obstacleModel;

    public boolean CheckIfPlayerHitsObstacle(Hitbox playerHitbox)
    {
        var obstacles = obstacleModel.getObstacleList();
        var hitObstacle = false;

        for (var obstacle : obstacles) {
            hitObstacle = obstacle.hitbox.intersects(playerHitbox);
            if (hitObstacle)
            {
                return true;
            }
        }
        return false;
    }
}