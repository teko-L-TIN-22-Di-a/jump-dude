package ch.teko.bir.jumpdude.Player;

import java.awt.Graphics2D;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.CollisionHelper.CollisionHelper;
import static ch.teko.bir.jumpdude.Player.Flying.Up;
import ch.teko.bir.jumpdude.SoundHandling.PlaySound;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteEngine;

public class PlayerController {
    
    private final Player player;
    private int initialPlayerYPosition;
    private final CollisionHelper collisionHelper;
    private static int spacingCorrection = 100;

    public PlayerController(CollisionHelper collistionHelper)
    {
        var groundY = 650;
        initialPlayerYPosition = groundY - spacingCorrection;
        player = new Player(initialPlayerYPosition);
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
        this.player.hitbox.draw(graphics2d, panel);
    }

    private void doMovementFromState(int windowWidth, int spriteWidth)
    {
        var playerState = player.getState();

        if (collisionHelper.CheckIfPlayerHitsObstacle(player.hitbox))
        {
            player.setState(PlayerState.Hitting);
        }
        if (collisionHelper.CheckIfPlayerHitsJetpack(player.hitbox))
        {
            player.setState(PlayerState.Flying);
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
            case Flying:
                executeFlying();
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

    public void FlyRight()
    {
        if (player.getState() == PlayerState.Flying)
        {
            executeFlyingRight();
        }
    }
    
    private void executeFlyingRight()
    {
        var newPlayerPosition = Flying.Right(player.getPosition());
        player.updatePosition(newPlayerPosition.getX(), newPlayerPosition.getY());
    }
    
    public void FlyLeft()
    {
        if (player.getState() == PlayerState.Flying)
        {
            executeFlyingLeft();
        }
    }
    
    private void executeFlyingLeft()
    {
        var newPlayerPosition = Flying.Left(player.getPosition());
        player.updatePosition(newPlayerPosition.getX(), newPlayerPosition.getY());
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

    private void executeFlying()
    {
        var newPlayerPosition = Up(player.getPosition());

        player.updatePosition(newPlayerPosition.getX(), newPlayerPosition.getY());
    }

    public boolean getPlayerGotHit() {
        return player.getState() == PlayerState.Hitting;
    }

    public boolean getPlayerIsFlying() {
        return player.getState() == PlayerState.Flying;
    }

    public void setGameOver() {
        player.setState(PlayerState.GameOver);
    }

    public String getPlayerName() {
        return player.getName();
    }
}
