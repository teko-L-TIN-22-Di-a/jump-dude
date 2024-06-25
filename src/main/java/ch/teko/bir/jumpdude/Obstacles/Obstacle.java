package ch.teko.bir.jumpdude.Obstacles;

import java.awt.Color;

import ch.teko.bir.jumpdude.CollisionElement;

public class Obstacle extends CollisionElement {

    public Obstacle(){

    }

    public Obstacle(Color color, int x, int y, int width, int height){
        this.color = color;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
    
    private Color color = Color.white;
    private int x = 0;
    private int y = 0;
    private int width = 0;
    private int height = 0;

    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
    }
 
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}