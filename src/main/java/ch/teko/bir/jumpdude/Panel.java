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

import ch.teko.bir.jumpdude.Ground.Ground;
import ch.teko.bir.jumpdude.Ground.GroundModel;
import ch.teko.bir.jumpdude.Obstacles.ObstacleController;
import ch.teko.bir.jumpdude.Obstacles.ObstacleModel;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteEngine;

public class Panel extends JPanel implements ActionListener {
    private Player player = null;    
    
    private SpriteEngine spriteEngine;    
    private Graphics2D graphics2d;
    
    private PanelModel panelModel;
    private ObstacleController obstacleController;
    
    public Panel(PanelModel model)         
    {        
        panelModel = model;
        
        this.obstacleController = new ObstacleController(new ObstacleModel());

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
        drawObstacles();
        drawPlayer(panelModel.getGroundHeight());      
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
    
    private void drawGround()
    {
        var ground = new Ground(new GroundModel());
        ground.draw(graphics2d, panelModel.getWindowWidth());
    }
    
    private void drawObstacles()
    {
        obstacleController.draw(graphics2d, panelModel.getWindowWidth());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        obstacleController.repaint(panelModel.getWindowWidth());
        repaint();
    }
}
