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
        int height = 50;
        obstacleList.add(new Obstacle(200, groundY - height, 50, height));
        height = 60;
        obstacleList.add(new Obstacle(500, groundY - height, 30, height));
        height = 50;
        obstacleList.add(new Obstacle(700, groundY - height, 30, height));
    }
}