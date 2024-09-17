package ch.teko.bir.jumpdude.CollisionHelper;

import ch.teko.bir.jumpdude.Hitbox.Hitbox;
import ch.teko.bir.jumpdude.Jetpack.JetpackModel;
import ch.teko.bir.jumpdude.Obstacles.ObstacleModel;

/**
 * Is the Middleware from Obstacle and Player and Jetpack. 
 * It's main job is to detect if a Player hits a obstacle.
 * The idea is, to remove the direct dependency between player and obstacle.
 **/
public class CollisionHelper {

    public ObstacleModel obstacleModel;
    public JetpackModel jetpackModel;

    public CollisionHelper(ObstacleModel obstacleModel, JetpackModel jetpackModel)
    {
        this.obstacleModel = obstacleModel;
        this.jetpackModel = jetpackModel;
    }    

    public boolean CheckIfPlayerHitsObstacle(Hitbox playerHitbox)
    {
        var obstacles = obstacleModel.getObstacleList();
        Boolean hitObstacle;

        for (var obstacle : obstacles) {
            hitObstacle = obstacle.hitbox.intersects(playerHitbox);
            if (hitObstacle)
            {
                return true;
            }
        }
        return false;
    }

    public boolean CheckIfPlayerHitsJetpack(Hitbox playerHitbox)
    {
        var jetpack = jetpackModel.getJetpack();

        var hitJetpack = jetpack.hitbox.intersects(playerHitbox);
        return hitJetpack;
    }
}
