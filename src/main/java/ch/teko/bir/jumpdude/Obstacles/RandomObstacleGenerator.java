package ch.teko.bir.jumpdude.Obstacles;

import java.util.Random;

public class RandomObstacleGenerator {

    public static GroundObstacle generateRandom(int groundY)
    {
        var height = getRandomHeight();
        var spawnPoint = getRandomXValue();
        var width = getRandomWidth();
        return new GroundObstacle(spawnPoint, groundY - height, width, height);
    }

    private static int getRandomHeight()
    {
        return getRandomBetween(50, 120);
    }

    private static int getRandomBetween(int low, int high)
    {
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }

    private static int getRandomXValue()
    {
        return getRandomBetween(950, 1300);
    }
    
    private static int getRandomWidth()
    {
        return getRandomBetween(30, 80);
    }
}