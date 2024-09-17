package ch.teko.bir.jumpdude.Player;

import ch.teko.bir.jumpdude.Hitbox.Hitbox;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteLoader;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteSheet;

/**
 *
 * @author Sarah
 */
public class Player {
    private String name = "player1";
    private SpriteSheet spriteSheet;
    private Position position;
    private int maxJumpHeight = 300;
    private int maxDoubleJumpingHeight = 200;
    private final int width = 100;
    private final int height = 100;
    private PlayerState state = PlayerState.Running;
    private final String runningSpritePath = "sprites/pink-man/run.png";
    private final String jumpingSpritePath = "sprites/pink-man/jump.png";
    private final String fallingSpritePath = "sprites/pink-man/fall.png";
    private final String doubleJumpingingSpritePath = "sprites/pink-man/doubleJump.png";
    private final String HittingSpritePath = "sprites/pink-man/hit.png";

    public Hitbox hitbox;

    public Player(String playerName, int y)
    {
        this.name = playerName;
        this.position = new Position(100, y);
        spriteSheet = SpriteLoader.load(runningSpritePath, 12, 12);
        var hitboxWidth = width - 35;
        var hitboxHeight = height - 35;
        hitbox = new Hitbox(this.position, hitboxWidth, hitboxHeight);
    }

    public String getName()
    {
        return name;
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
    
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
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
            case FirstDoubleJumping, SecondDoubleJumping -> spriteSheet = SpriteLoader.load(doubleJumpingingSpritePath, 6, 6);
            case Falling, FallingAfterFirstDoubleJumping, FallingAfterSecondDoubleJumping -> spriteSheet = SpriteLoader.load(fallingSpritePath, 1, 1);
            case Hitting -> spriteSheet =  SpriteLoader.load(HittingSpritePath, 7, 7);
            default -> {
            }
        }
    }
}
