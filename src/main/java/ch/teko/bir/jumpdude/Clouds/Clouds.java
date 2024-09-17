package ch.teko.bir.jumpdude.Clouds;

import java.awt.image.BufferedImage;

import ch.teko.bir.jumpdude.Position;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteLoader;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;

//* Only Grapical, no Hitbox needed. */
public class Clouds {

    public Position position;
    private int width = 0;
    private int height = 0;

    private final SpriteSheet spriteSheet;
    private final BufferedImage image;

    public Clouds(int x, int y, int width, int height){
        this.position = new Position(x, y);
        this.width = width;
        this.height = height;
        
        this.spriteSheet = SpriteLoader.load("sprites/clouds/clouds.png", 1, 1);
        this.image = spriteSheet.getSpriteAtIndex(0);
    }
    
    public int getX() {
        return position.getX();
    }
    public void setX(int x) {
        this.position.setX(x);
    }

    public int getY() {
        return position.getY();
    }
    public void setY(int y) {
        this.position.setY(y);
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
