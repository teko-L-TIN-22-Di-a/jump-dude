package ch.teko.bir.jumpdude.Obstacles;

import java.util.ArrayList;

public class ObstacleModel {
    private final int groundY;

    public ObstacleModel(int groundY){
        this.groundY = groundY;
        generateInitialObstacles();
    }

    private ArrayList<GroundObstacle> obstacleList = new ArrayList<>();

    public ArrayList<GroundObstacle> getObstacleList() {
        return obstacleList;
    }

    private void generateInitialObstacles()
    {
        int height = 100;
        obstacleList.add(new GroundObstacle(900, groundY - height, 80, height));
        height = 80;
        obstacleList.add(new GroundObstacle(800, groundY - height, 70, height));
        height = 80;
        obstacleList.add(new GroundObstacle(1500, groundY - height, 40, height));
    }

    public int getGroundY() {
        return groundY;
    }

    public void AddToObstacles(GroundObstacle obstacle) {
        obstacleList.add(obstacle);
    }
}