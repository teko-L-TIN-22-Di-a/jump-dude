/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jump.dude;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.net.URL;

/**
 *
 * @author Sarah
 */
public class Player {
    public SpriteSheet spriteSheet;
    
    public Player(URL playerSprite)
    {
        try {
            var urlToSheet = this.getClass().getResource("resources\\sprites\\run.png");
            var sheet = ImageIO.read(urlToSheet);            
            spriteSheet = new SpriteSheetBuilder().
                    withSheet(sheet).
                    withColumns(12).
                    withSpriteCount(12).
                    build();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
