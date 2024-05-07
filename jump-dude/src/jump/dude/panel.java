package jump.dude;

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

public class panel extends JPanel implements ActionListener {
    private Graphics2D graphics2d;
    private int obstacleXOne = 200; // startpoint from obstacle
    private int obstacleXTwo = 500;
    private int obstacleXThree = 700;
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        graphics2d = (Graphics2D) g;       
        
        var windowWidth = super.size().width;
        setBackground(Color.BLUE);
        
        Timer timer = new Timer(80, this);
        timer.start();
        
        drawGround(windowWidth);
        drawObstacle();
    }
    
    private void drawGround(int width)
    {
        var groundColor = Color.GREEN;
        graphics2d.setColor(groundColor);
        graphics2d.fillRect(0, 600, width, 200);
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
            obstacleXOne = +1000; // set to right again
        }
        if (obstacleXTwo <= 0) {
            obstacleXTwo = +1000; // set to right again
        }
        if (obstacleXThree <= 0) {
            obstacleXThree = +1000; // set to right again
        }
        repaint();
    }    
}
