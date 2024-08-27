/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ch.teko.bir.jumpdude.Player;

import ch.teko.bir.jumpdude.Hitbox.Hitbox;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteLoader;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;

/**
 *
 * @author Sarah
 */
public class Player {
    private SpriteSheet spriteSheet;
    private Position position;
    private int maxJumpHeight = 300;
    private int maxDoubleJumpingHeight = 200;
    private PlayerState state = PlayerState.Running;
    private final String runningSpritePath = "sprites/pink-man/run.png";
    private final String jumpingSpritePath = "sprites/pink-man/jump.png";
    private final String FallingSpritePath = "sprites/pink-man/fall.png";
    private final String doubleJumpingingSpritePath = "sprites/pink-man/doubleJump.png";

    public Hitbox hitbox;

    public Player(int y)
    {
        this.position = new Position(100, y);
        spriteSheet = SpriteLoader.load(runningSpritePath, 12, 12);
        var image = spriteSheet.getSpriteAtIndex(0);
        var imageWidth = image.getWidth() + 30;
        var imageHeight = image.getHeight() + 30;
        hitbox = new Hitbox(this.position, 
                            imageWidth, 
                            imageHeight);
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
    public void updatePosition(int x, int y) {
        this.position.setX(x);
        this.position.setY(y);
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
            case Running -> spriteSheet = SpriteLoader.load(runningSpritePath, 12, 12);
            case Jumping -> spriteSheet = SpriteLoader.load(jumpingSpritePath, 1, 1);
            case DoubleJumping -> spriteSheet = SpriteLoader.load(doubleJumpingingSpritePath, 6, 6);
            case Falling -> spriteSheet = SpriteLoader.load(FallingSpritePath, 1, 1);
            default -> {
            }
        }
    }
}
