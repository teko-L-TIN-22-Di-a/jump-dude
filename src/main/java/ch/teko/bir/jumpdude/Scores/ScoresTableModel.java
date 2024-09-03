package ch.teko.bir.jumpdude.Scores;

import javax.swing.table.AbstractTableModel;

public class ScoresTableModel extends AbstractTableModel {

    private Score[] scoreData = null;
    private String[] columnNames =  {"Rank", "Score", "Name"};

    public ScoresTableModel() {}

    public ScoresTableModel(Score[] scoreData) {
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
        return scoreData.length;
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object scoreAttribute = null;
        Score score = scoreData[row];
        switch(column) {
            case 0: scoreAttribute = score.getRank(); break;
            case 1: scoreAttribute = score.getScore(); break;
            case 2: scoreAttribute = score.getName(); break;
            default: break;
        }
        return scoreAttribute;
    }

    public void addScore(Score score) {
        var newArrayLength = scoreData.length + 1;
        var newScoreData = new Score[newArrayLength];
   
        System.arraycopy(scoreData, 0, newScoreData, 0, newArrayLength); 
   
        newScoreData[newArrayLength] = score; 
        scoreData = newScoreData;
        fireTableDataChanged();
    }
}