package ch.teko.bir.jumpdude;

/**
 *
 * @author Sarah
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Panel extends JPanel implements ActionListener {
    private Player player = null;    
    
    private SpriteEngine spriteEngine;    
    private Graphics2D graphics2d;

    private int obstacleXOne = 200;
    private int obstacleXTwo = 500;
    private int obstacleXThree = 700;
    
    private PanelModel panelModel;
    
    public Panel(PanelModel model)         
    {        
        panelModel = model;

        createPlayer();
        createSpriteEngine();
        createLevelTimer();
    }

    private void createPlayer() {
        try {
            player = new Player(this.getClass().getResource("/sprites/pink-man/run.png"));
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
                   
    }
    
    private void createSpriteEngine() {
        spriteEngine = new SpriteEngine(25);
        
        spriteEngine.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });
        spriteEngine.start();
    }

    private void createLevelTimer() {
        Timer levelTimer = new Timer(panelModel.getLevelTimer(), this);
        levelTimer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics2d = (Graphics2D) g;       
        
        panelModel.setWindowWidth(super.getSize().width);
        setBackground(Color.BLUE);
        
        drawGround();
        drawObstacle();
        drawPlayer(panelModel.getGroundHeight());      
    }
    
    private void drawPlayer(int groundHeight)
    {        
        var sprite = player.spriteSheet.getSprite(spriteEngine.getCycleProgress());
                
        int spacingCorrection = 30;
        player.positionY = this.getHeight() - sprite.getHeight() - groundHeight - spacingCorrection;
        player.positionX = (this.getWidth() - sprite.getWidth()) / 2;
        
        graphics2d.drawImage(sprite, player.positionX, player.positionY, 100, 100, this);
        graphics2d.dispose();
    }
    
    private void drawGround()
    {
        var ground = new Ground(new GroundModel());
        ground.draw(graphics2d, panelModel.getWindowWidth());
    }
    
    private void drawObstacle()
    {
        graphics2d.setColor(Color.MAGENTA);
        graphics2d.fillRect(obstacleXOne, 550, 50, 50); // x, y, width, length
        graphics2d.fillRect(obstacleXTwo, 570, 30, 30);
        graphics2d.fillRect(obstacleXThree, 550, 50, 50);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int speed = 2;
        obstacleXOne -= speed;
        obstacleXTwo -= speed;
        obstacleXThree -= speed;
        
        if (obstacleXOne <= 0) {
            obstacleXOne = + panelModel.getWindowWidth();
        }
        if (obstacleXTwo <= 0) {
            obstacleXTwo = + panelModel.getWindowWidth();
        }
        if (obstacleXThree <= 0) {
            obstacleXThree = + panelModel.getWindowWidth();
        }
        repaint();
    }    
}
