package ch.teko.bir.jumpdude;

import java.awt.Color;

public class PanelModel {

    private int windowWidth = 0;  
    private int levelTimer = 10;
    
    private Color groundColor = Color.GREEN;
    private int groundX = 0;

    private int groundY = 600;
    private int groundHeight = 200;

    public PanelModel()         
    {

    }

    public int getGroundY() {
        return groundY;
    }

    public void setGroundY(int groundY) {
        this.groundY = groundY;
    }

    public int getWindowWidth()
    {
        return windowWidth;
    }
    
    public void setWindowWidth(int windowWidth)
    {
       this. windowWidth = windowWidth;
    }

    public int getLevelTimer()
    {
        return levelTimer;
    }

    public void setLevelTimer(int levelTimer) {
        this.levelTimer = levelTimer;
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
}