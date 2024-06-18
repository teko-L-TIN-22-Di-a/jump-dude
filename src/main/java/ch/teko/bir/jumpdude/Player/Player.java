/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.teko.bir.jumpdude.Player;

import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheetBuilder;

import java.net.URL;
import java.io.IOException;
import javax.imageio.ImageIO;
/**
 *
 * @author Sarah
 */
public class Player {
    private SpriteSheet spriteSheet;
    private Position position;
    private int maxJumpHeight = 300;
    private State state = State.running;

    public Player(URL playerSprite) throws IOException
    {
        var sheet = ImageIO.read(playerSprite);            
        spriteSheet = new SpriteSheetBuilder().
                withSheet(sheet).
                withColumns(12).
                withSpriteCount(12).
                build();
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    public void setSpriteSheet(SpriteSheet spriteSheet) {
        this.spriteSheet = spriteSheet;
    }

    public Position getPosition() {
        return position;
    }
    public void setPosition(Position position) {
        this.position = position;
    }
    
    public int getMaxJumpHeight() {
        return maxJumpHeight;
    }

    public void setMaxJumpHeight(int maxJumpHeight) {
        this.maxJumpHeight = maxJumpHeight;
    }
    
    public State getState() {
        return state;
    }
    public void setState(State state) {
        this.state = state;
    }
}
