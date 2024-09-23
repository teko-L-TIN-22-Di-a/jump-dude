package ch.teko.bir.jumpdude.SpriteHandling;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sarah
 */
public class SpriteSheet {
    private final List<BufferedImage> sprites;
    public SpriteSheet(List<BufferedImage> sprites) {        
        this.sprites = new ArrayList<>(sprites);
    }

    
    /** 
     * @return int
     */
    public int count() {
        return sprites.size();
    }

    public BufferedImage getSprite(double progress) {
        int frame = (int) (count() * progress);
        return sprites.get(frame);
    }
    
    public BufferedImage getSpriteAtIndex(int index) {
        return sprites.get(index);
    }
}
