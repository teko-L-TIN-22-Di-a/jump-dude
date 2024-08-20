package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Color;
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
        obstacleList.add(new Obstacle(Color.CYAN, 200, groundY - height, 50, height));
        height = 30;
        obstacleList.add(new Obstacle(Color.CYAN, 500, groundY - height, 30, height));
        height = 50;
        obstacleList.add(new Obstacle(Color.CYAN, 700, groundY - height, 30, height));
    }
}