package ch.teko.bir.jumpdude.Scores;

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
import java.io.StringReader;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import com.google.gson.Gson;
import com.google.gson.Strictness;
import com.google.gson.stream.JsonReader;

import ch.teko.bir.jumpdude.CollisionHelper.CollisionHelper;
import ch.teko.bir.jumpdude.KeyListener.MainKeyListener;
import ch.teko.bir.jumpdude.Main;
import ch.teko.bir.jumpdude.MenuPanel;
import ch.teko.bir.jumpdude.Obstacles.ObstacleModel;
import ch.teko.bir.jumpdude.PanelModel;
import ch.teko.bir.jumpdude.Player.PlayerController;

public class ScoresPanel extends JPanel {

    private Font font;

    private final Color COLOR = Color.CYAN;

    public ScoresPanel()
    {
        setBackground(COLOR);

        InputStream fontInputStream = MenuPanel.class.getResourceAsStream("/fonts/BACKTO1982.TTF");
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, fontInputStream);
            font = font.deriveFont(Font.BOLD, 40f);
        } catch (FontFormatException | IOException ex) {
        }

        setBorder(new EmptyBorder(10, 10, 30, 10));
        setLayout(new GridBagLayout());

        loadTitle();        
        loadTable();        
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

        var title = new JLabel("Scores");
        title.setFont(font);

        title.setBorder(BorderFactory.createEmptyBorder(10, 0, 30, 0));
        add(title, gridBagConstraints);
    }

    private void loadTable()
    { 
        var model = loadData();
        JTable table = new JTable(model) {
            @Override
            public Dimension getPreferredScrollableViewportSize() {
                return new Dimension(800, 400);
            }
        };
        
        var scrollPane = new JScrollPane(table);
        var tableFont = font.deriveFont(Font.BOLD, 30f);
        table.setFont(tableFont);
        table.setOpaque(true);
        table.setFillsViewportHeight(true);
        table.setBackground(COLOR);
        table.setRowHeight(50);
        setTableHeaders(table.getTableHeader(), tableFont, scrollPane.getWidth());

        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        add(scrollPane, gridBagConstraints);
    }

    private ScoresTableModel loadData()
    {        
        var scoresStream = getClass().getClassLoader().getResourceAsStream("scores.json");
        
        byte[] buffer = new byte[1000];
        StringBuilder stringBuilder = new StringBuilder();
        try {
            while (scoresStream.read(buffer) != -1) {
                stringBuilder.append(new String(buffer));
                buffer = new byte[10];
                scoresStream.close();
            }
        } catch (IOException ex) {
        }
        
        var scoresJson = stringBuilder.toString();
        System.out.println(scoresJson);
        
        Gson gson = new Gson();
        JsonReader reader = new JsonReader(new StringReader(scoresJson));
        Score[] scores = gson.fromJson(reader, Score[].class);
        reader.setStrictness(Strictness.LENIENT);

        return new ScoresTableModel(scores);
    }

    private void setTableHeaders(JTableHeader tableHeader, Font tableFont, int scrollPaneWidth)
    {       
        tableHeader.setFont(tableFont);
        tableHeader.setBackground(COLOR);
        tableHeader.setPreferredSize(new Dimension(scrollPaneWidth, 80));

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
        buttons.setBackground(COLOR);
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
        var panelModel = new PanelModel();
        var obstacleModel = new ObstacleModel(panelModel.getGroundY());
        var playerController = new PlayerController(new CollisionHelper(obstacleModel));
        
        var url = Main.class.getResource("/sprites/pink-man/jump.png");
        var kit = Toolkit.getDefaultToolkit();
        var img = kit.createImage(url);

        JFrame window = new JFrame("Jump Dude");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(1000, 800);
        window.add(new MenuPanel());
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
