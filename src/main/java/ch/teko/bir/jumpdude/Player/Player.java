/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.teko.bir.jumpdude.Player;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import ch.teko.bir.jumpdude.CollisionElement;
import ch.teko.bir.jumpdude.Hitbox.Hitbox;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheetBuilder;
/**
 *
 * @author Sarah
 */
public class Player extends CollisionElement{
    private SpriteSheet spriteSheet;
    private Position position;
    private int maxJumpHeight = 300;
    private int maxDoubleJumpingHeight = 200;
    private PlayerState state = PlayerState.Running;
    private final String runingSpritePath = "/sprites/pink-man/run.png";
    private final String jumpingSpritePath = "/sprites/pink-man/jump.png";
    private final String FallingSpritePath = "/sprites/pink-man/fall.png";
    private final String doubleJumpingingSpritePath = "/sprites/pink-man/doubleJump.png";

    public Player()
    {
        loadSprite(runingSpritePath, 12, 12);
    }

    public Player(Hitbox hitbox)
    {
        this.hitbox = hitbox;
        loadSprite(runingSpritePath, 12, 12);
    }

    public boolean collides(CollisionElement collisionElement) {
        return hitbox.intersects(collisionElement.hitbox);
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
    public int getMaxDoubleJumpingHeight() {
        return maxDoubleJumpingHeight;
    }

    public void setMaxDoubleJumpingHeight(int maxDoubleJumpingHeight) {
        this.maxDoubleJumpingHeight = maxDoubleJumpingHeight;
    }
    public PlayerState getState() {
        return state;
    }
    public void setState(PlayerState state) {
        this.state = state;
        
        switch (this.state) {
            case Running:
                loadSprite(runingSpritePath, 12, 12);                
                break;        
            case Jumping:
                loadSprite(jumpingSpritePath, 1, 1);
                break;    
            case DoubleJumping:
                loadSprite(doubleJumpingingSpritePath, 6, 6);
                break;
            case Falling:
                loadSprite(FallingSpritePath, 1, 1);
                break;
            default:
                break;
        }
    }
}
