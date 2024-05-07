package jump.dude;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Sarah
 */
public class TestPane extends JPanel {

    private SpriteSheet spriteSheet;
    private SpriteEngine spriteEngine;

    public TestPane() {
        try {
            var urlToSheet = this.getClass().getResource("resources\\sprites\\run.png");
            var sheet = ImageIO.read(urlToSheet);            
            spriteSheet = new SpriteSheetBuilder().
                    withSheet(sheet).
                    withColumns(12).
                    withSpriteCount(12).
                    build();

            spriteEngine = new SpriteEngine(25);
            spriteEngine.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    repaint();
                }
            });
            spriteEngine.start();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 200);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();
        var sprite = spriteSheet.getSprite(spriteEngine.getCycleProgress());
        int x = (getWidth() - sprite.getWidth()) / 2;
        int y = (getHeight() - sprite.getHeight()) / 2;
        g2d.drawImage(sprite, x, y, 100, 100, this);
        g2d.dispose();
    }

}