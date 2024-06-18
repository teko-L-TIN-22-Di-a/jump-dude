/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.teko.bir.jumpdude;

import java.io.IOException;
import javax.imageio.ImageIO;

import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheetBuilder;

import java.net.URL;

/**
 *
 * @author Sarah
 */
public class Player {
    public SpriteSheet spriteSheet;
    
    public Player(URL playerSprite) throws IOException
    {
        var sheet = ImageIO.read(playerSprite);            
        spriteSheet = new SpriteSheetBuilder().
                withSheet(sheet).
                withColumns(12).
                withSpriteCount(12).
                build();
    }    
}
