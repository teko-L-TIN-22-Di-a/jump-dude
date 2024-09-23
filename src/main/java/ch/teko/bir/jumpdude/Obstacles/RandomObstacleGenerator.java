package ch.teko.bir.jumpdude.Obstacles;

import java.util.Random;

public class RandomObstacleGenerator {

    
    /** 
     * @param groundY
     * @return Obstacle
     */
    public static Obstacle generateRandomGround(int groundY)
    {
        var height = getRandomHeight();
        var spawnPoint = getRandomGroundXValue();
        var width = getRandomWidth();
        return new Obstacle(spawnPoint, groundY - height, width, height);
    }

    public static Obstacle generateRandomSky(int groundY)
    {
        var height = getRandomHeight();
        var width = getRandomWidth();
        var spawnPoint = getRandomSkyXValue();
        var spawnY = getRandomSkyYValue();
        return new Obstacle(spawnPoint, spawnY, width, height);
    }

    private static int getRandomHeight()
    {
        return getRandomBetween(70, 120);
    }

    private static int getRandomBetween(int low, int high)
    {
        Random r = new Random();
        int result = r.nextInt(high-low) + low;
        return result;
    }

    private static int getRandomGroundXValue()
    {
        return getRandomBetween(950, 1300);
    }
    
    private static int getRandomSkyXValue()
    {
        return getRandomBetween(10, 1000);
    }
    
    private static int getRandomSkyYValue()
    {
        return getRandomBetween(100, 900)*-1;
    }

    private static int getRandomWidth()
    {
        return getRandomBetween(30, 80);
    }
}