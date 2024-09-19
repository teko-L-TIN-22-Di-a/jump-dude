package ch.teko.bir.jumpdude.Menu;

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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import ch.teko.bir.jumpdude.Main;
import ch.teko.bir.jumpdude.MainWindowFactory;
import ch.teko.bir.jumpdude.Options.Options;
import ch.teko.bir.jumpdude.Options.OptionsPanel;
import ch.teko.bir.jumpdude.Scores.ScoresPanelFactory;

public class MenuPanel extends JPanel {

    private Font font;
    private JTextField nameField;

    public MenuPanel()
    {
        Initialize();
    }

    private void Initialize()
    {
        setBackground(Color.CYAN);
        loadFont();
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setLayout(new GridBagLayout());
        loadTitle();
        loadNameTextField();       
        loadButtons();
    }

    private void loadFont()
    {
        var fontInputStream = MenuPanel.class.getResourceAsStream("/fonts/BACKTO1982.TTF");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontInputStream);
            font = font.deriveFont(Font.BOLD, 40f);
        } catch (FontFormatException | IOException ex) {
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    private void loadTitle() 
    {
        var gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.VERTICAL;

        var title = new JLabel("Jump Dude");
        title.setFont(font);

        title.setBorder(BorderFactory.createEmptyBorder(120, 0, 20, 0));
        add(title, gridBagConstraints);
    }

    private void loadNameTextField() {
        var nameLabel = new JLabel("Name:");
        nameLabel.setFont(font);
        nameField = new JTextField(Options.PLAYER_NAME, 8);
           nameField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) { 
                if (nameField.getText().length() >= 10 ) // limit textfield to 3 characters
                    e.consume(); 
            }  
        });
        nameField.selectAll();
        nameField.setFont(font);
        
        var gridBagConstraintsPanel = new GridBagConstraints();
        gridBagConstraintsPanel.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraintsPanel.anchor = GridBagConstraints.CENTER;
        gridBagConstraintsPanel.fill = GridBagConstraints.HORIZONTAL;
        add(nameField, gridBagConstraintsPanel);
    }

    private void loadButtons()
    {
        var startButton = createButton("Start", font);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createMainWindow();
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

        var gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);

        var buttons = new JPanel(new GridBagLayout());
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

    private void createMainWindow()
    {
        Options.PLAYER_NAME = nameField.getText();
        MainWindowFactory.createMainWindow();
    }

    private void createScoresWindow()
    {
        ScoresPanelFactory.createScoresWindow();
    }

    private void createOptionsWindow()
    {        
        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame window = new JFrame("Jump Dude");
        window.setName("options");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.add(new OptionsPanel());
        window.setVisible(true);
        window.setIconImage(img);
        window.setResizable(false);
    }

    private void closeMenuWindow(ActionEvent e)
    {
        var window = SwingUtilities.getWindowAncestor(this);
        window.dispose();
    }
}
