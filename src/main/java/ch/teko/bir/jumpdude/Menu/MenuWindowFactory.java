package ch.teko.bir.jumpdude.Menu;

import java.awt.Toolkit;

import javax.swing.JFrame;

import ch.teko.bir.jumpdude.Main;

public class MenuWindowFactory {
    
    public static void createMenuWindow()
    {        
        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame window = new JFrame("Jump Dude");
        window.setName("menu");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.add(new MenuPanel());
        window.setVisible(true);
        window.setIconImage(img);
        window.setResizable(false);
    }
    
    public static void createMenuWindow(String playerName)
    {        
        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame window = new JFrame("Jump Dude");
        window.setName("menu");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.add(new MenuPanel(playerName));
        window.setVisible(true);
        window.setIconImage(img);
        window.setResizable(false);
    }
}
