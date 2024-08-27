package ch.teko.bir.jumpdude.Scores;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ScoresTableModel extends AbstractTableModel {

    private List<Score> scoreData = new ArrayList<Score>();
    private String[] columnNames =  {"Rank", "Score", "Name"};

    public ScoresTableModel() {}

    public ScoresTableModel(List<Score> scoreData) {
        this.scoreData = scoreData;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return scoreData.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object scoreAttribute = null;
        Score score = scoreData.get(row);
        switch(column) {
            case 0: scoreAttribute = score.getRank(); break;
            case 1: scoreAttribute = score.getScore(); break;
            case 2: scoreAttribute = score.getName(); break;
            default: break;
        }
        return scoreAttribute;
    }

    public void addScore(Score score) {
        scoreData.add(score);
        fireTableDataChanged();
    }
}