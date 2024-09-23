package ch.teko.bir.jumpdude.Ground;

public class Ground {    
    private int x = 0;
    private int y = 0;
    private int width = 0;
    private int height = 0;

    public Ground(int x, int y, int width, int height)
    {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    
    /** 
     * @return int
     */
    public int getX() {
        return x;
    }
    
    /** 
     * @param x
     */
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
}