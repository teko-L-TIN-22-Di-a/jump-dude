package ch.teko.bir.jumpdude.Obstacles;

import java.util.ArrayList;

public class ObstacleModel {

    public ObstacleModel(int groundY){
        generateObstacles(groundY);
    }

    private ArrayList<Obstacle> obstacleList = new ArrayList<>();
    
    public void setObstacleList(ArrayList<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }

    public ArrayList<Obstacle> getObstacleList() {
        return obstacleList;
    }

    private void generateObstacles(int groundY)
    {
        int height = 100;
        obstacleList.add(new Obstacle(900, groundY - height, 80, height));
        height = 80;
        obstacleList.add(new Obstacle(800, groundY - height, 70, height));
        height = 80;
        obstacleList.add(new Obstacle(1500, groundY - height, 40, height));
    }
}