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

import javax.swing.JPanel;
import javax.swing.Timer;

import ch.teko.bir.jumpdude.Ground.GroundController;
import ch.teko.bir.jumpdude.Ground.GroundModel;
import ch.teko.bir.jumpdude.Obstacles.ObstacleController;
import ch.teko.bir.jumpdude.Obstacles.ObstacleModel;
import ch.teko.bir.jumpdude.Player.PlayerController;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteEngine;

public class MainPanel extends JPanel implements ActionListener {
    private PlayerController playerController = null;    
    
    private SpriteEngine spriteEngine;    
    private Graphics2D graphics2d;
    
    private final PanelModel panelModel;
    private final ObstacleController obstacleController;
    private final GroundController groundController;
    
    public MainPanel(PanelModel model, PlayerController playerController)         
    {        
        panelModel = model;
        
        this.playerController = playerController;
        this.obstacleController = new ObstacleController(new ObstacleModel(panelModel.getGroundY()));
        this.groundController = new GroundController(new GroundModel());

        createSpriteEngine();
        createLevelTimer();
    }

    private void createSpriteEngine() {
        spriteEngine = new SpriteEngine(60);
        
        spriteEngine.addActionListener((ActionEvent e) -> {
            repaint();
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
        drawPlayer();      
    }
    
    private void drawPlayer()
    { 
        this.playerController.draw(graphics2d, this.getWidth(), this.getHeight(), panelModel.getGroundY(), spriteEngine, this);
    }
    
    private void drawGround()
    {
        groundController.draw(graphics2d, panelModel.getWindowWidth(), this);
    }
    
    private void drawObstacles()
    {
        obstacleController.draw(graphics2d, this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        obstacleController.repaint(panelModel.getWindowWidth());
        groundController.repaint(panelModel.getWindowWidth());
        repaint();
    }
}
