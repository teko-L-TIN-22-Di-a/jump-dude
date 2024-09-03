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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;

import ch.teko.bir.jumpdude.Menu.MenuPanel;
import ch.teko.bir.jumpdude.Menu.MenuWindowFactory;

public class ScoresPanel extends JPanel {

    private Font font;
    private final Color COLOR = Color.CYAN;
    private ScoresTableModel model;
    private ScoresController controller;
    private Score currentScore = null;
    
    public ScoresPanel()
    {
        Initialize();
    }

    public ScoresPanel(Score score)
    {
        this.currentScore = score;
        Initialize();
        model.addScore(score);
    }

    private void Initialize()
    {
        controller = new ScoresController();
        setBackground(COLOR);

        var fontInputStream = MenuPanel.class.getResourceAsStream("/fonts/BACKTO1982.TTF");
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
        var gridBagConstraints = new GridBagConstraints();
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
        model = controller.loadJson();
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

        var gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        add(scrollPane, gridBagConstraints);
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

        var gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new Insets(10, 10, 10, 10);

        var buttons = new JPanel(new GridBagLayout());
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
        controller.saveJson(model.getScoreData());
        if (this.currentScore == null)
        {
            MenuWindowFactory.createMenuWindow();
        }
        else{
            MenuWindowFactory.createMenuWindow(this.currentScore.getName());

        }
    }

    private void closeMenuWindow(ActionEvent e)
    {
        JComponent comp = (JComponent) e.getSource();
        var win = SwingUtilities.getWindowAncestor(comp);
        win.dispose();
    }
}
