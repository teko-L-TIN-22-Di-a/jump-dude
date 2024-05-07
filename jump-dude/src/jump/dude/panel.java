package jump.dude;

/**
 *
 * @author Sarah
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

public class panel extends JPanel {
    private Graphics2D graphics2d;
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics2d = (Graphics2D) g;       
        
        var windowWidth = super.size().width;
        
        drawGround(windowWidth);
        drawObstacle();
    }
    
    private void drawGround(int width)
    {
        graphics2d.drawLine(0, 600, width, 600);        
    }
    
    private void drawObstacle()
    {
        graphics2d.setColor(Color.RED);
        graphics2d.fillRect(200, 550, 50, 50); // x, y, width, length
        graphics2d.fillRect(500, 570, 30, 30);
        graphics2d.fillRect(700, 560, 50, 50);
    }
}
