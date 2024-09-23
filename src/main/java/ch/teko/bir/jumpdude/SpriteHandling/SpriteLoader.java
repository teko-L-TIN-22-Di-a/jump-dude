package ch.teko.bir.jumpdude.SpriteHandling;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteLoader {
        
    
    /** 
     * @param spritePath
     * @param cols
     * @param withSpriteCount
     * @return SpriteSheet
     */
    public static SpriteSheet load(String spritePath, int cols, int withSpriteCount)
    {
        var sprite = SpriteLoader.class.getClassLoader().getResource(spritePath);
        BufferedImage sheet;
        SpriteSheet spriteSheet = null;
        try {
            sheet = ImageIO.read(sprite);
            spriteSheet = new SpriteSheetBuilder().
            withSheet(sheet).
            withColumns(cols).
            withSpriteCount(withSpriteCount).
            build();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return spriteSheet;
    }
}
