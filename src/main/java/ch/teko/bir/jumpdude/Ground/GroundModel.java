package ch.teko.bir.jumpdude.Ground;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheetBuilder;

public class GroundModel {  
    private Color groundColor = Color.GREEN;
    private int groundX = 0;
    private int groundY = 600;

    private int groundHeight = 200;
    private SpriteSheet spriteSheet;
    private BufferedImage image;

    public GroundModel()         
    {
        loadSprite("/sprites/ground/basic.png", 1, 1);
        image = spriteSheet.getSpriteAtIndex(0);
        groundHeight = image.getHeight();
    }
    
    private void loadSprite(String spritePath, int cols, int withSpriteCount)
    {
        var groundSprite = this.getClass().getResource(spritePath);
        BufferedImage sheet;
        try {
            sheet = ImageIO.read(groundSprite);
            spriteSheet = new SpriteSheetBuilder().
            withSheet(sheet).
            withColumns(cols).
            withSpriteCount(withSpriteCount).
            build();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public BufferedImage getImage() {
        return image;
    }
}