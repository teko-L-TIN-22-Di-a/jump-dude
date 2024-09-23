package ch.teko.bir.jumpdude.Ground;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import ch.teko.bir.jumpdude.SpriteHandling.SpriteLoader;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;

public class GroundModel {  
    private Color groundColor = Color.GREEN;
    private int groundX = 0;
    private int groundY = 650;
    private int groundHeight = 200;
    
    private final SpriteSheet spriteSheet;
    private final BufferedImage image;

    public GroundModel()         
    {
        spriteSheet = SpriteLoader.load("sprites/ground/basic.png", 1, 1);
        image = spriteSheet.getSpriteAtIndex(0);
        groundHeight = image.getHeight();
        generateGroundBricks(groundY);
    }

    private ArrayList<Ground> groundBrickList = new ArrayList<>();
    
    
    /** 
     * @param groundBrickList
     */
    public void setGroundBrickList(ArrayList<Ground> groundBrickList) {
        this.groundBrickList = groundBrickList;
    }

    
    /** 
     * @return ArrayList of Ground
     */
    public ArrayList<Ground> getGroundBrickList() {
        return groundBrickList;
    }

    private void generateGroundBricks(int groundY)
    {
        for (int i = 0; i < 15; i++) {
            groundBrickList.add(new Ground(groundX + (groundHeight * i), groundY, groundHeight, groundHeight));            
        }
    }

    public int getGroundY() {
        return groundY;
    }

    public void setGroundY(int groundY) {
        this.groundY = groundY;
    }
    
    public Color getGroundColor() {
        return groundColor;
    }

    public void setGroundColor(Color groundColor) {
        this.groundColor = groundColor;
    }

    public int getGroundHeight() {
        return groundHeight;
    }

    public void setGroundHeight(int groundHeight) {
        this.groundHeight = groundHeight;
    }

    public int getGroundX() {
        return groundX;
    }

    public void setGroundX(int groundX) {
        this.groundX = groundX;
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public BufferedImage getImage() {
        return image;
    }
}