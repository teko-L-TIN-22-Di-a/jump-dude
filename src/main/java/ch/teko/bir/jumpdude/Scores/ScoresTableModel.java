package ch.teko.bir.jumpdude.Scores;

import javax.swing.table.AbstractTableModel;

public class ScoresTableModel extends AbstractTableModel {

    private Scores scoreData = new Scores();
    private String[] columnNames =  {"Rank", "Score", "Name"};

    public ScoresTableModel() {}

    public ScoresTableModel(Scores scoreData) {
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
        return scoreData.scores.size();
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object scoreAttribute = null;
        Score score = scoreData.scores.get(row);
        switch(column) {
            case 0: scoreAttribute = score.getRank(); break;
            case 1: scoreAttribute = score.getScore(); break;
            case 2: scoreAttribute = score.getName(); break;
            default: break;
        }
        return scoreAttribute;
    }

    public void addScore(Score score) {
        scoreData.scores.add(score);
        fireTableDataChanged();
    }
}