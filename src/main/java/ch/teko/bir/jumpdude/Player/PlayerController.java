package ch.teko.bir.jumpdude.Player;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.SoundHandling.PlaySound;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteEngine;

public class PlayerController {
    
    private final Player player;
    private int initialPlayerYPosition;

    public PlayerController()
    {
        player = new Player();
    }

    public void draw(Graphics2D graphics2d, int windowWidth, int windowHeight, int groundHeight, SpriteEngine spriteEngine, JPanel panel)
    {
        var playerSpriteSheet = player.getSpriteSheet();
        var playerSprite = playerSpriteSheet.getSprite(spriteEngine.getCycleProgress());
        var spacingCorrection = 30;
        initialPlayerYPosition = windowHeight - playerSprite.getHeight() - groundHeight - spacingCorrection;
        
        doMovementFromState(windowWidth, playerSprite.getWidth());

        graphics2d.drawImage(playerSprite, player.getPosition().getX(), player.getPosition().getY(), 100, 100, panel);
        graphics2d.dispose();
    }

    private void doMovementFromState(int windowWidth, int spriteWidth)
    {
        var playerState = player.getState();

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
}
