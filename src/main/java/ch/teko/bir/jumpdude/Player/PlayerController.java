package ch.teko.bir.jumpdude.Player;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.CollisionElement;
import ch.teko.bir.jumpdude.CollisionHelper.CollisionHelper;
import ch.teko.bir.jumpdude.SoundHandling.PlaySound;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteEngine;

public class PlayerController extends CollisionElement {
    
    private final Player player;
    private int initialPlayerYPosition;

    private final CollisionHelper collisionHelper;

    public PlayerController(CollisionHelper collistionHelper)
    {
        player = new Player();
        this.collisionHelper = collistionHelper;
    }

    public void draw(Graphics2D graphics2d, int windowWidth, int windowHeight, int groundY, SpriteEngine spriteEngine, JPanel panel)
    {
        var playerSpriteSheet = player.getSpriteSheet();
        var playerSprite = playerSpriteSheet.getSprite(spriteEngine.getCycleProgress());
        var spacingCorrection = 100;
        initialPlayerYPosition = groundY - spacingCorrection;
        
        doMovementFromState(windowWidth, playerSprite.getWidth());

        graphics2d.drawImage(playerSprite, player.getPosition().getX(), player.getPosition().getY(), 100, 100, panel);
        graphics2d.dispose();
    }

    private void doMovementFromState(int windowWidth, int spriteWidth)
    {
        var playerState = player.getState();

        if (collisionHelper.CheckIfPlayerHitsObstacle(player.hitbox))
        {
            player.setState(PlayerState.Hitting);
        }

        switch (playerState) {
            case Running:
                setRunPlayerPosition(windowWidth, spriteWidth);
                break;
            case Jumping:
                executeJumping();                    
                break;
            case DoubleJumping:
                executeDoubleJumping();
                break;
            case Falling:
                executeFalling();
            case Hitting:
            // TODO
                break;
            default:
                break;
        }
    }

    private void setRunPlayerPosition(int windowWidth, int spriteWidth)
    {
        var playerPositionX = windowWidth / 2 - spriteWidth;
        var playerPositionY = initialPlayerYPosition;
        var position = new Position(playerPositionX, playerPositionY);
        player.setPosition(position);
    }
    
    public void Jumping()
    {
        if (player.getState() == PlayerState.Running)
        {
            player.setState(PlayerState.Jumping);
            playJumpSound();
            executeJumping();
        }
        else if (player.getState() == PlayerState.Jumping)
        {
            player.setState(PlayerState.DoubleJumping);
            executeDoubleJumping();
        }
    }

    public void Falling()
    {
        if (player.getState() == PlayerState.Jumping || player.getState() == PlayerState.DoubleJumping)
        {
            player.setState(PlayerState.Falling);
            executeFalling();
        }
    }

    private void executeJumping()
    {
        var newPlayerPosition = Jump.Up(player.getPosition());
        player.setPosition(newPlayerPosition);

        if (player.getMaxJumpHeight() >= newPlayerPosition.getY())
        {
            player.setState(PlayerState.Falling);
        }
    }

    private void playJumpSound()
    {
        var playSound = new PlaySound();
        playSound.jump();
    }

    private void executeDoubleJumping()
    {
        var newPlayerPosition = Jump.Up(player.getPosition());
        player.setPosition(newPlayerPosition);

        if (player.getMaxDoubleJumpingHeight() >= newPlayerPosition.getY())
        {
            player.setState(PlayerState.Falling);
        }
    }

    private void executeFalling()
    {
        var newPlayerPosition = Jump.Down(player.getPosition());
        player.setPosition(newPlayerPosition);

        if (initialPlayerYPosition <= newPlayerPosition.getY())
        {
            player.setState(PlayerState.Running);
        }
    }

    @Override
    public void repaint(int windowWidth) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void draw(Graphics2D graphics2d, JPanel panel) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    protected void handleCollision(CollisionElement collisionElement) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
