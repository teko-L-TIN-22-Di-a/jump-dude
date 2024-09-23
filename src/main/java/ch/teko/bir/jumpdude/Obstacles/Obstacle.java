package ch.teko.bir.jumpdude.Obstacles;

import java.awt.image.BufferedImage;

import ch.teko.bir.jumpdude.Hitbox.Hitbox;
import ch.teko.bir.jumpdude.Position;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteLoader;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;

public class Obstacle {

    public Position position;
    private int width = 0;
    private int height = 0;

    private SpriteSheet spriteSheet;
    private BufferedImage image;

    public Hitbox hitbox;
    private final int hitboxDifference = 20;
    private boolean flyingState = false;

    public Obstacle(int x, int y, int width, int height){
        this.position = new Position(x, y);
        this.width = width;
        this.height = height;
        
        this.spriteSheet = SpriteLoader.load("sprites/obstacle/spikes.png", 1, 1);
        this.image = spriteSheet.getSpriteAtIndex(0);

        var hitboxPosition = new Position(x, y);
        var hitboxWidth = width - hitboxDifference;
        var hitboxHeight = height - hitboxDifference;
        hitbox = new Hitbox(hitboxPosition, hitboxWidth, hitboxHeight);
    }

    
    /** 
     * @param x
     * @param y
     * @param width
     * @param height
     */
    public void updateSky(int x, int y, int width, int height)
    {
        this.spriteSheet = SpriteLoader.load("sprites/obstacle/bird.png", 1, 1);
        this.image = spriteSheet.getSpriteAtIndex(0);

        this.position.setX(x);
        this.hitbox.setX(x+(hitboxDifference/2));

        this.position.setY(y);
        this.hitbox.setY(y+(hitboxDifference/2));

        this.width = width;
        this.hitbox.setWidth(width - hitboxDifference);
    
        this.height = height;
        this.hitbox.setHeight(height - hitboxDifference);
    }
    
    public void setFlyingState()
    {
        flyingState = true;
    }

    
    /** 
     * @return int
     */
    public int getX() {
        return position.getX();
    }
    public void setX(int x) {
        this.position.setX(x);
        this.hitbox.setX(x+(hitboxDifference/2));
    }

    public int getY() {
        return position.getY();
    }
    public void setY(int y) {
        this.position.setY(y);
        this.hitbox.setY(y+(hitboxDifference/2));
    }

    public int getWidth() {
        return width;
    }
    public void setWidth(int width) {
        this.width = width;
        this.hitbox.setWidth(width - hitboxDifference);
    }
 
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
        this.hitbox.setHeight(height - hitboxDifference);
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public BufferedImage getImage() {
        return image;
    }
}