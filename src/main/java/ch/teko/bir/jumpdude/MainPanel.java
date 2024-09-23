package ch.teko.bir.jumpdude;

/**
 *
 * @author Sarah
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import ch.teko.bir.jumpdude.Clouds.CloudsController;
import ch.teko.bir.jumpdude.Ground.GroundController;
import ch.teko.bir.jumpdude.Ground.GroundModel;
import ch.teko.bir.jumpdude.Jetpack.JetpackController;
import ch.teko.bir.jumpdude.Jetpack.JetpackModel;
import ch.teko.bir.jumpdude.Menu.MenuPanel;
import ch.teko.bir.jumpdude.Obstacles.ObstacleController;
import ch.teko.bir.jumpdude.Obstacles.ObstacleModel;
import ch.teko.bir.jumpdude.Options.Options;
import ch.teko.bir.jumpdude.Player.PlayerController;
import ch.teko.bir.jumpdude.Scores.ScoresPanelFactory;
import ch.teko.bir.jumpdude.SpriteHandling.SpriteEngine;

public class MainPanel extends JPanel implements ActionListener {
    private Timer levelTimer;
    private Timer speedTimer;
    private PlayerController playerController = null;
    private Timer stopWatch;
    private int elapsedTime = 0;
    
    private SpriteEngine spriteEngine;    
    private Graphics2D graphics2d;
    
    private final MainPanelModel panelModel;
    private final ObstacleController obstacleController;
    private final GroundController groundController;
    private final JetpackController jetpackController;
    private CloudsController cloudsController;
    private GameSpeedController gameSpeedController;
    
    private Font font;

    public MainPanel(MainPanelModel model, PlayerController playerController, ObstacleModel obstacleModel, JetpackModel jetpackModel)         
    {
        this.panelModel = model;
        
        this.playerController = playerController;
        this.gameSpeedController = new GameSpeedController();
        this.obstacleController = new ObstacleController(obstacleModel, gameSpeedController);
        this.groundController = new GroundController(new GroundModel(), gameSpeedController);
        this.jetpackController = new JetpackController(jetpackModel, gameSpeedController);        
        this.cloudsController = new CloudsController(gameSpeedController);

        this.gameSpeedController.setInitialRunningSpeed();

        loadFont();
        createSpriteEngine();
        createLevelTimer();
        startStopWatch();
    }

    private void loadFont()
    {
        InputStream fontInputStream = MenuPanel.class.getResourceAsStream("/fonts/BACKTO1982.TTF");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontInputStream);
            font = font.deriveFont(Font.BOLD, 20f);
        } catch (FontFormatException | IOException ex) {
        }
    }
    
    private void createSpriteEngine() {
        spriteEngine = new SpriteEngine(60);
        
        spriteEngine.addActionListener((ActionEvent e) -> {
            repaint();
        });
        spriteEngine.start();
    }

    private void createLevelTimer() {
        levelTimer = new Timer(panelModel.getLevelTimer(), this);
        levelTimer.start();
    }

    private void createSpeedTimer() {
        speedTimer = new Timer(panelModel.getSpeedTimer(), this);
        speedTimer.start();
    }
    
    private void startStopWatch() {
        stopWatch = new Timer(1000, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (playerController.getPlayerGotHit())
                {
                    ScoresPanelFactory.createScoresWindow(Options.PLAYER_NAME, elapsedTime);
                    playerController.setGameOver();
                    closeWindow();
                }
                {
                    elapsedTime += 1000;
                }
            }
        });
        stopWatch.start();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics2d = (Graphics2D) g;       
        
        panelModel.setWindowWidth(super.getSize().width);
        setBackground(Color.BLUE);
        
        updateTimeLabel();
        drawGround();
        drawObstacles();
        drawJetPack();
        drawClouds();        
        drawPlayer();
        graphics2d.dispose();
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
    
    private void updateTimeLabel()
    {
        graphics2d.setColor(Color.black);
        graphics2d.setFont(font);

        int minutes = (elapsedTime % 3600000) / 60000;
        int seconds = (elapsedTime % 60000) / 1000;
        String time = String.format("%02d:%02d", minutes, seconds);
        graphics2d.drawString(time, 850, 50);
    }

    private void drawJetPack()
    {
        jetpackController.draw(graphics2d, this);
    }

    private void drawClouds()
    {
        cloudsController.draw(graphics2d, this);
    }
        
    private void closeWindow()
    {
        var window = SwingUtilities.getWindowAncestor(this);
        window.dispose();
        System.gc();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == levelTimer)
        {
            if (playerController.getPlayerGotHit())
            {
                this.gameSpeedController.setRunningSpeedToIdle();
            }
            else if (playerController.getPlayerIsFlying())
            {
                this.gameSpeedController.setRunningSpeedToIdle();
                obstacleController.setFlyingState(true);
                groundController.setFlying(true);
                jetpackController.removeJetPack();
                cloudsController.setFlyingState(true);
            }
            obstacleController.repaint(panelModel.getWindowWidth());
            groundController.repaint(panelModel.getWindowWidth());
            jetpackController.repaint(panelModel.getWindowWidth());
            cloudsController.repaint();
            repaint();
        }
        else if (e.getSource() == speedTimer)
        {
            increaseSpeedEvery10Seconds();
        }
    }

    private void increaseSpeedEvery10Seconds()
    {
        int seconds = elapsedTime / 1000;

        if (seconds > 10)
        {
            var test = seconds % 10;
            if (test == 0)
            {
                this.gameSpeedController.increaseRunningSpeed();
            }
        }
    }
}
