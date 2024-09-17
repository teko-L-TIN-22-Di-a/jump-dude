package ch.teko.bir.jumpdude.Player;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.CollisionHelper.CollisionHelper;
import ch.teko.bir.jumpdude.SoundHandling.PlaySound;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteEngine;

public class PlayerController {
    
    private final Player player;
    private int initialPlayerYPosition;
    private final CollisionHelper collisionHelper;
    private static int spacingCorrection = 100;

    public PlayerController(String playerName, CollisionHelper collistionHelper)
    {
        var groundY = 650;
        initialPlayerYPosition = groundY - spacingCorrection;
        player = new Player(playerName, initialPlayerYPosition);
        setRunPlayerPosition(500, 100);
        this.collisionHelper = collistionHelper;
    }

    public void draw(Graphics2D graphics2d, int windowWidth, int windowHeight, int groundY, SpriteEngine spriteEngine, JPanel panel)
    {
        var playerSpriteSheet = player.getSpriteSheet();
        var playerSprite = playerSpriteSheet.getSprite(spriteEngine.getCycleProgress());
        initialPlayerYPosition = groundY - spacingCorrection;
        
        doMovementFromState(windowWidth, playerSprite.getWidth());

        graphics2d.drawImage(playerSprite, player.getPosition().getX(), player.getPosition().getY(), player.getWidth(), player.getHeight(), panel);
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
            case FirstDoubleJumping, SecondDoubleJumping:
                executeDoubleJumping();
                break;
            case FallingAfterFirstDoubleJumping, FallingAfterSecondDoubleJumping:
                FallingAfterDoubleJumping();
                break;
            case Falling:
                executeFalling();
                break;
            case Hitting:
                break;
            default:
                break;
        }
    }

    private void setRunPlayerPosition(int windowWidth, int spriteWidth)
    {
        var playerPositionX = windowWidth / 2 - spriteWidth;
        var playerPositionY = initialPlayerYPosition;
        player.updatePosition(playerPositionX, playerPositionY);
    }
    
    public void Jumping()
    {
        if (player.getState() == PlayerState.Running)
        {
            player.setState(PlayerState.Jumping);
            playJumpSound();
            executeJumping();
        }
        else if (player.getState() == PlayerState.Jumping || player.getState() == PlayerState.Falling)
        {
            player.setState(PlayerState.FirstDoubleJumping);
            executeDoubleJumping();
        }
        else if (player.getState() == PlayerState.FallingAfterFirstDoubleJumping)
        {
            player.setState(PlayerState.SecondDoubleJumping);
            executeDoubleJumping();
        }
    }

    public void Falling()
    {
        if (player.getState() == PlayerState.Jumping)
        {
            player.setState(PlayerState.Falling);
            executeFalling();
        }
    }

    public void FallingAfterDoubleJumping()
    {
        if (player.getState() == PlayerState.FirstDoubleJumping)
        {
            player.setState(PlayerState.FallingAfterFirstDoubleJumping);
        }
        if (player.getState() == PlayerState.SecondDoubleJumping)
        {
            player.setState(PlayerState.FallingAfterSecondDoubleJumping);
        }
        executeFalling();
    }

    private void executeJumping()
    {
        var newPlayerPosition = Jump.Up(player.getPosition());
        player.updatePosition(newPlayerPosition.getX(), newPlayerPosition.getY());

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
        player.updatePosition(newPlayerPosition.getX(), newPlayerPosition.getY());

        if (player.getMaxDoubleJumpingHeight() >= newPlayerPosition.getY())
        {
            if (player.getState() == PlayerState.FirstDoubleJumping)
            {
                player.setState(PlayerState.FallingAfterFirstDoubleJumping);
            }
            else
            {
                player.setState(PlayerState.FallingAfterSecondDoubleJumping);
            }
        }
    }

    private void executeFalling()
    {
        var newPlayerPosition = Jump.Down(player.getPosition());
        player.updatePosition(newPlayerPosition.getX(), newPlayerPosition.getY());

        if (initialPlayerYPosition <= newPlayerPosition.getY())
        {
            player.setState(PlayerState.Running);
        }
    }

    public boolean getPlayerGotHit() {
        return player.getState() == PlayerState.Hitting;
    }

    public void setGameOver() {
        player.setState(PlayerState.GameOver);
    }

    public String getPlayerName() {
        return player.getName();
    }
}
