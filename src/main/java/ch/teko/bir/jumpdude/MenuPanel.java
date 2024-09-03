package ch.teko.bir.jumpdude;

/**
 *
 * @author Sarah
 */
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import ch.teko.bir.jumpdude.CollisionHelper.CollisionHelper;
import ch.teko.bir.jumpdude.KeyListener.MainKeyListener;
import ch.teko.bir.jumpdude.Obstacles.ObstacleModel;
import ch.teko.bir.jumpdude.Player.PlayerController;
import ch.teko.bir.jumpdude.Scores.ScoresPanel;
import ch.teko.bir.jumpdude.Scores.ScoresPanelFactory;

public class MenuPanel extends JPanel {

    private Font font;

    public MenuPanel()
    {
        setBackground(Color.CYAN);

        InputStream fontInputStream = MenuPanel.class.getResourceAsStream("/fonts/BACKTO1982.TTF");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontInputStream);
            font = font.deriveFont(Font.BOLD, 40f);
        } catch (FontFormatException ex) {
        } catch (IOException ex) {
        }

        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());

        loadTitle();        
        loadButtons();
    }
        
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void loadTitle() 
    {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;

        var title = new JLabel("Jump Dude");
        title.setFont(font);

        title.setBorder(BorderFactory.createEmptyBorder(120, 0, 20, 0));
        add(title, gridBagConstraints);
    }

    private void loadButtons()
    {
        var startButton = createButton("Start", font);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createLevelWindow();
                closeMenuWindow(e);
            }
        });

        var scroesButton = createButton("Scores", font);
        scroesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createScoresWindow();
                closeMenuWindow(e);
            }
        });

        var optionsButton = createButton("Options", font);        
        optionsButton.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                createOptionsWindow();
                closeMenuWindow(e);
            }
        });

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);

        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(Color.cyan);
        buttons.add(startButton, gridBagConstraints);
        buttons.add(scroesButton, gridBagConstraints);
        buttons.add(optionsButton, gridBagConstraints);

        add(buttons, gridBagConstraints);
    }

    private JButton createButton(String text, Font font)
    {
        var button = new JButton(text);
        button.setPreferredSize(new Dimension(400, 100));
        button.setFont(font);
        button.setBackground(new Color(3, 127, 252));

        return button;
    }

    private void createLevelWindow()
    {
        var panelModel = new PanelModel();
        var obstacleModel = new ObstacleModel(panelModel.getGroundY());
        var playerController = new PlayerController(new CollisionHelper(obstacleModel));
        
        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame window = new JFrame("Jump Dude");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.add(new MainPanel(panelModel, playerController, obstacleModel));
        window.addKeyListener(new MainKeyListener(playerController));
        window.setVisible(true);
        window.setIconImage(img);
        window.setResizable(false);
    }

    private void createScoresWindow()
    {
        ScoresPanelFactory.createScoresWindow();
    }

    private void createOptionsWindow()
    {
        var panelModel = new PanelModel();
        var obstacleModel = new ObstacleModel(panelModel.getGroundY());
        var playerController = new PlayerController(new CollisionHelper(obstacleModel));
        
        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame window = new JFrame("Jump Dude");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.add(new OptionsPanel());
        window.addKeyListener(new MainKeyListener(playerController));
        window.setVisible(true);
        window.setIconImage(img);
        window.setResizable(false);
    }

    private void closeMenuWindow(ActionEvent e)
    {
        JComponent comp = (JComponent) e.getSource();
        var win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }
}
