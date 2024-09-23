package ch.teko.bir.jumpdude;

import java.awt.Color;

public class MainPanelModel {

    private int windowWidth = 0;  
    private int levelTimer = 10;
    private int speedTimer = 10000;
    
    private Color groundColor = Color.GREEN;
    private int groundX = 0;

    private int groundY = 650;
    private int groundHeight = 200;

    public MainPanelModel()         
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
    
    public int getSpeedTimer()
    {
        return speedTimer;
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