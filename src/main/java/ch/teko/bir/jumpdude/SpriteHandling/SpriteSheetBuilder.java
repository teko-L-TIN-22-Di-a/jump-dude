/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.teko.bir.jumpdude.SpriteHandling;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sarah
 */
public class SpriteSheetBuilder {

    private BufferedImage spriteSheet;
    private int columns;
    private int spriteWidth, spriteHeight;
    private int spriteCount;

    
    /** 
     * @param img
     * @return SpriteSheetBuilder
     */
    public SpriteSheetBuilder withSheet(BufferedImage img) {
        spriteSheet = img;
        return this;
    }

    
    /** 
     * @param cols
     * @return SpriteSheetBuilder
     */
    public SpriteSheetBuilder withColumns(int cols) {
        this.columns = cols;
        return this;
    }

    public SpriteSheetBuilder withSpriteSize(int width, int height) {
        this.spriteWidth = width;
        this.spriteHeight = height;
        return this;
    }

    public SpriteSheetBuilder withSpriteCount(int count) {
        this.spriteCount = count;
        return this;
    }

    protected int getSpriteCount() {
        return spriteCount;
    }

    protected int getCols() {
        return columns;
    }

    protected int getSpriteHeight() {
        return spriteHeight;
    }

    protected BufferedImage getSpriteSheet() {
        return spriteSheet;
    }

    protected int getSpriteWidth() {
        return spriteWidth;
    }

    public SpriteSheet build() {
        var count = getSpriteCount();
        var cols = getCols();
        if (count == 0) {
            count = cols;
        }

        var sheet = getSpriteSheet();

        int width = getSpriteWidth();
        int height = getSpriteHeight();
        if (width == 0) {
            width = sheet.getWidth() / cols;
        }
        if (height == 0) {
            height = sheet.getHeight();
        }

        int x = 0;
        int y = 0;
        List<BufferedImage> sprites = new ArrayList<>(count);

       for (int index = 0; index < count; index++) {
            var subImage = sheet.getSubimage(x, y, width, height);
            sprites.add(subImage);
            x += width;
            if (x >= width * cols) {
                x = 0;
                y += height;
            }
        }

        return new SpriteSheet(sprites);
    }
}