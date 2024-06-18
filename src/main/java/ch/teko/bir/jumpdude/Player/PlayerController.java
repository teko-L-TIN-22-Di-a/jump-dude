package ch.teko.bir.jumpdude.Player;

import java.awt.Graphics2D;
import javax.swing.JPanel;

import ch.teko.bir.jumpdude.SpriteHandling.SpriteEngine;

public class PlayerController {
    
    private Player player;
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
        
        doMovementFromState(windowWidth, windowHeight, playerSprite.getWidth());

        graphics2d.drawImage(playerSprite, player.getPosition().getX(), player.getPosition().getY(), 100, 100, panel);
        graphics2d.dispose();
    }

    private void doMovementFromState(int windowHeight, int windowWidth, int spriteWidth)
    {
        var playerState = player.getState();

        switch (playerState) {
            case Running:
                setRunningPlayerPosition(windowHeight, windowWidth, spriteWidth);
                break;
            case JumpUp:
                executeJumpUp();                    
                break;
            case DoubleJump:
                executeDoubleJump();
                break;
            case JumpDown:
                executeJumpDown();
            default:
                break;
        }
    }

    private void setRunningPlayerPosition(int windowHeight, int windowWidth, int spriteWidth)
    {
        var playerPositionX = windowWidth / 2 - spriteWidth;
        var playerPositionY = initialPlayerYPosition;
        var position = new Position(playerPositionX, playerPositionY);
        player.setPosition(position);
    }
    
    public void jumpUp()
    {
        if (player.getState() == PlayerState.Running)
        {
            player.setState(PlayerState.JumpUp);
            executeJumpUp();
        }
        else if (player.getState() == PlayerState.JumpUp)
        {
            player.setState(PlayerState.DoubleJump);
            executeDoubleJump();
        }
    }

    public void jumpDown()
    {
        if (player.getState() == PlayerState.JumpUp || player.getState() == PlayerState.DoubleJump)
        {
            player.setState(PlayerState.JumpDown);
            executeJumpDown();
        }
    }

    private void executeJumpUp()
    {
        var newPlayerPosition = Jump.Up(player.getPosition());
        player.setPosition(newPlayerPosition);

        if (player.getMaxJumpHeight() >= newPlayerPosition.getY())
        {
            player.setState(PlayerState.JumpDown);
        }
    }

    private void executeDoubleJump()
    {
        var newPlayerPosition = Jump.Up(player.getPosition());
        player.setPosition(newPlayerPosition);

        if (player.getMaxDoubleJumpHeight() >= newPlayerPosition.getY())
        {
            player.setState(PlayerState.JumpDown);
        }
    }


    private void executeJumpDown()
    {
        var newPlayerPosition = Jump.Down(player.getPosition());
        player.setPosition(newPlayerPosition);

        if (initialPlayerYPosition <= newPlayerPosition.getY())
        {
            player.setState(PlayerState.Running);
        }
    }
}
