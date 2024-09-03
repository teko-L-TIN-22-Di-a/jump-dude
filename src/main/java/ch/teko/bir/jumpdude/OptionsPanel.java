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

public class OptionsPanel extends JPanel {

    private Font font;

    public OptionsPanel()
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
        loadButton();
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

        var title = new JLabel("Options");
        title.setFont(font);

        title.setBorder(BorderFactory.createEmptyBorder(120, 0, 20, 0));
        add(title, gridBagConstraints);
    }

    private void loadButton()
    {
        var startButton = createButton("Back", font);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createMenuWindow();
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

    private void createMenuWindow()
    {
        MenuWindowFactory.createMenuWindow();
    }

    private void closeMenuWindow(ActionEvent e)
    {
        JComponent comp = (JComponent) e.getSource();
        var win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }
}
