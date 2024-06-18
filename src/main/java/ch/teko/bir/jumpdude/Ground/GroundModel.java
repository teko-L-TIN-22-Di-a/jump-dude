package ch.teko.bir.jumpdude.Ground;

import java.awt.Color;

public class GroundModel {  
    private Color groundColor = Color.GREEN;
    private int groundX = 0;

    private int groundY = 600;

    private int groundHeight = 200;

    public GroundModel()         
    {

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
}