package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

public class ObstacleModel {

    public ObstacleModel(){
        generateObstacles();
    }

    private ArrayList<Obstacle> obstacleList = new ArrayList<>();
    
    public void setObstacleList(ArrayList<Obstacle> obstacleList) {
        this.obstacleList = obstacleList;
    }

    public ArrayList<Obstacle> getObstacleList() {
        return obstacleList;
    }

    private void generateObstacles()
    {
        obstacleList.add(new Obstacle(Color.CYAN, 200, 550, 50, 50));
        obstacleList.add(new Obstacle(Color.CYAN, 500, 570, 30, 30));
        obstacleList.add(new Obstacle(Color.CYAN, 700, 550, 50, 50));
    }
}