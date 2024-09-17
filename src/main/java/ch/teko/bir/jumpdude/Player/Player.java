package ch.teko.bir.jumpdude.Player;

import ch.teko.bir.jumpdude.Hitbox.Hitbox;
import ch.teko.bir.jumpdude.Options.Options;
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
    private final String hittingSpritePath = "sprites/pink-man/hit.png";
    private final String flyingSpritePath = "sprites/pink-man/fly.png";

    public Hitbox hitbox;
    private final int hitboxDifference = 30;

    public Player(int groundY)
    {
        this.name = Options.PLAYER_NAME;
        this.position = new Position(100, groundY);
        spriteSheet = SpriteLoader.load(runningSpritePath, 12, 12);

        var hitboxPosition = new Position(100, groundY);
        var hitboxWidth = width - hitboxDifference;
        var hitboxHeight = height - hitboxDifference;
        hitbox = new Hitbox(hitboxPosition, hitboxWidth, hitboxHeight);
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
        this.hitbox.setX(x+(hitboxDifference/2));
        this.hitbox.setY(y+(hitboxDifference/2));
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
            case Flying -> spriteSheet = SpriteLoader.load(flyingSpritePath, 1, 1);
            case Hitting -> spriteSheet =  SpriteLoader.load(hittingSpritePath, 7, 7);
            default -> {
            }
        }
    }
}
