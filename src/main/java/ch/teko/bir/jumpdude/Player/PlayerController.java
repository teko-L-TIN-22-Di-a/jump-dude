package ch.teko.bir.jumpdude.Player;

import java.awt.Graphics2D;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.Panel;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteEngine;

public class PlayerController {
    
    private Player player;
    private int initialPlayerYPosition;

    public PlayerController()
    {
        try {
            player = new Player(this.getClass().getResource("/sprites/pink-man/run.png"));
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void draw(Graphics2D graphics2d, int windowWidth, int windowHeight, int groundHeight, SpriteEngine spriteEngine, JPanel panel)
    {
        var playerSpriteSheet = player.getSpriteSheet();
        var playerSprite = playerSpriteSheet.getSprite(spriteEngine.getCycleProgress());
        var spacingCorrection = 30;
        initialPlayerYPosition = windowHeight - playerSprite.getHeight() - groundHeight - spacingCorrection;
        
        var playerState = player.getState();
        if (playerState == State.running)
        {
            setRunningPlayerPosition(windowHeight, windowWidth, playerSprite.getHeight(), playerSprite.getWidth(), groundHeight);
        }
        else if (playerState == State.JumpUp)
        {
            executeJumpUp();
        }
        else if (playerState == State.JumpDown)
        {
            executeJumpDown();
        }

        graphics2d.drawImage(playerSprite, player.getPosition().getX(), player.getPosition().getY(), 100, 100, panel);
        graphics2d.dispose();
    }

    private void setRunningPlayerPosition(int windowHeight, int windowWidth, int spriteHeight, int spriteWidth,int groundHeight)
    {
        var playerPositionX = windowWidth / 2 - spriteWidth;
        var playerPositionY = initialPlayerYPosition;
        var position = new Position(playerPositionX, playerPositionY);
        player.setPosition(position);
    }
    
    public void jump()
    {
        if (player.getState() == State.running)
        {
            player.setState(State.JumpUp);
            executeJumpUp();
        }
    }

    private void executeJumpUp()
    {
        var newPlayerPosition = Jump.Up(player.getPosition());
        player.setPosition(newPlayerPosition);

        if (player.getMaxJumpHeight() >= newPlayerPosition.getY())
        {
            player.setState(State.JumpDown);
        }
    }

    private void executeJumpDown()
    {
        var newPlayerPosition = Jump.Down(player.getPosition());
        player.setPosition(newPlayerPosition);

        if (initialPlayerYPosition <= newPlayerPosition.getY())
        {
            player.setState(State.running);
        }
    }
}
