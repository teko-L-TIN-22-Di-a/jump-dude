package ch.teko.bir.jumpdude.Obstacles;

import java.awt.image.BufferedImage;

import ch.teko.bir.jumpdude.Hitbox.Hitbox;
import ch.teko.bir.jumpdude.Player.Position;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteLoader;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;

public class Obstacle {

    public Position position;
    private int width = 0;
    private int height = 0;

    private final SpriteSheet spriteSheet;
    private final BufferedImage image;

    public Hitbox hitbox;

    public Obstacle(int x, int y, int width, int height){
        this.position = new Position(x, y);
        this.width = width;
        this.height = height;
        
        this.spriteSheet = SpriteLoader.load("sprites/obstacle/spikes.png", 1, 1);
        this.image = spriteSheet.getSpriteAtIndex(0);

        hitbox = new Hitbox(this.position, 
                            this.image.getWidth(), 
                            this.image.getHeight());

    }
    
    public int getX() {
        return position.getX();
    }
    public void setX(int x) {
        position.setX(x);
        hitbox.setX(x);
    }

    public int getY() {
        return position.getY();
    }
    public void setY(int y) {
        position.setY(y);
        hitbox.setY(y);
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

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public BufferedImage getImage() {
        return image;
    }
}