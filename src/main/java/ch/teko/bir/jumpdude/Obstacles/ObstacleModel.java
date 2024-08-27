package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ch.teko.bir.jumpdude.SpriteHandling.SpriteLoader;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;

public class ObstacleModel {    
    private final SpriteSheet spriteSheet;
    private final BufferedImage image;

    public ObstacleModel(int groundY){
        spriteSheet = SpriteLoader.load("/sprites/obstacle/spikes.png", 1, 1);
        image = spriteSheet.getSpriteAtIndex(0);
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
    
    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public BufferedImage getImage() {
        return image;
    }
}