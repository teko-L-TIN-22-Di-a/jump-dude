package ch.teko.bir.jumpdude.Clouds;

import java.awt.Graphics2D;
import java.util.ArrayList;

import javax.swing.JPanel;

import ch.teko.bir.jumpdude.GameSpeedController;
import net.bytebuddy.utility.privilege.GetMethodAction;

public class CloudsController {
    private ArrayList<Clouds> clouds = new ArrayList<Clouds>();
    private boolean flyingState = false;
    private GameSpeedController gameSpeedController;

    public CloudsController(GameSpeedController gameSpeedController)
    {
        this.gameSpeedController = gameSpeedController;
        generateClouds();
    }

    private void generateClouds()
    {
        clouds.add(new Clouds(100, -100, 200, 100));
        clouds.add(new Clouds(600, -600, 200, 100));
        clouds.add(new Clouds(300, -800, 200, 100));
        clouds.add(new Clouds(800, -900, 200, 100));
    }

    
    /** 
     * @param graphics2d
     * @param panel
     */
    public void draw(Graphics2D graphics2d, JPanel panel)
    {
        for (var cloud : clouds) {
            graphics2d.drawImage(cloud.getImage(), 
            cloud.getX(), 
            cloud.getY(), 
            cloud.getWidth(), 
            cloud.getHeight(), 
            panel); 
        }
    }

    public void repaint()
    {        
        if (flyingState)
        {
            for (var cloud : clouds) {
                cloud.setY(cloud.getY() + gameSpeedController.getFlyingSpeed());
    
                if (cloud.getY() >= 1200) {
                    cloud.setY(-100);
                }
            }
        }
    }

    public void setFlyingState(boolean state)
    {
        this.flyingState = state;
    }
}
