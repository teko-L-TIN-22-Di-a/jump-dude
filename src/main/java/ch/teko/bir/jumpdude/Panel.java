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
    private org.apache.logging.log4j.Logger logger;
    
    private Player player = null;    
    
    private SpriteEngine spriteEngine;    
    private Graphics2D graphics2d;
    private int obstacleXOne = 200; // startpoint from obstacle
    private int obstacleXTwo = 500;
    private int obstacleXThree = 700;
    private int windowWidth = 0;
    
    public Panel(org.apache.logging.log4j.Logger logger2)         
    {
        logger = logger2;
        
        createPlayer();                
        createSpriteEngine();      
        
        createLevelTimer();
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

    private void createPlayer() {
        try {
            player = new Player(this.getClass().getResource("/sprites/pink-man/run.png"));
        } catch (IOException ex) {
            Logger.getLogger(Panel.class.getName()).log(Level.SEVERE, null, ex);
        }
        logger.info("Player successfully created.");
    }
    

    private void createLevelTimer() {
        Timer levelTimer = new Timer(10, this);
        levelTimer.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics2d = (Graphics2D) g;       
        
        windowWidth = super.size().width;
        setBackground(Color.BLUE);
        
        int groundHeight = 200;
        drawGround(windowWidth, groundHeight);
        drawObstacle();
        drawPlayer(groundHeight);                
    }
    
    private void drawPlayer(int groundHeight)
    {        
        var sprite = player.spriteSheet.getSprite(spriteEngine.getCycleProgress());
        int x = (this.getWidth() - sprite.getWidth()) / 2;
        
        int spacingCorrection = 30;
        int y = this.getHeight() - sprite.getHeight() - groundHeight - spacingCorrection;
        graphics2d.drawImage(sprite, x, y, 100, 100, this);
        graphics2d.dispose();
    }
    
    private void drawGround(int width, int height)
    {
        var groundColor = Color.GREEN;
        graphics2d.setColor(groundColor);
        graphics2d.fillRect(0, 600, width, height);
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
            obstacleXOne = + windowWidth;
        }
        if (obstacleXTwo <= 0) {
            obstacleXTwo = + windowWidth;
        }
        if (obstacleXThree <= 0) {
            obstacleXThree = + windowWidth;
        }
        repaint();
    }    
}
