/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.teko.bir.jumpdude.Player;

import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheetBuilder;

import java.awt.image.BufferedImage;
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
    private int maxDoubleJumpHeight = 200;
    private PlayerState state = PlayerState.Running;
    private String runningSpritePath= "/sprites/pink-man/run.png";
    private String jumpUpSpritePath= "/sprites/pink-man/jump.png";
    private String jumpDownSpritePath= "/sprites/pink-man/fall.png";
    private String doubleJumpSpritePath = "/sprites/pink-man/doubleJump.png";

    public Player()
    {
        loadSprite(runningSpritePath, 12, 12);
    }

    public SpriteSheet getSpriteSheet() {
        return spriteSheet;
    }

    private void loadSprite(String spritePath, int cols, int withSpriteCount)
    {
        var playerSprite = this.getClass().getResource(spritePath);
        BufferedImage sheet;
        try {
            sheet = ImageIO.read(playerSprite);
            spriteSheet = new SpriteSheetBuilder().
            withSheet(sheet).
            withColumns(cols).
            withSpriteCount(withSpriteCount).
            build();
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public int getMaxDoubleJumpHeight() {
        return maxDoubleJumpHeight;
    }

    public void setMaxDoubleJumpHeight(int maxDoubleJumpHeight) {
        this.maxDoubleJumpHeight = maxDoubleJumpHeight;
    }
    public PlayerState getState() {
        return state;
    }
    public void setState(PlayerState state) {
        this.state = state;
        
        switch (this.state) {
            case Running:
                loadSprite(runningSpritePath, 12, 12);                
                break;        
            case JumpUp:
                loadSprite(jumpUpSpritePath, 1, 1);
                break;    
            case DoubleJump:
                loadSprite(doubleJumpSpritePath, 6, 6);
                break;
            case JumpDown:
                loadSprite(jumpDownSpritePath, 1, 1);
                break;
            default:
                break;
        }
    }
}
