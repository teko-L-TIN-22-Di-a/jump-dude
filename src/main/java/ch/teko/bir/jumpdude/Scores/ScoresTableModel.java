package ch.teko.bir.jumpdude.Scores;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class ScoresTableModel extends AbstractTableModel {

    private Score[] scoreData = null;
    private String[] columnNames =  {"Rank", "Score", "Name"};

    public ScoresTableModel() {}

    public ScoresTableModel(Score[] scoreData) {
        this.scoreData = scoreData;
    }

    public Score[] getScoreData()
    {
        return scoreData;
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
        var newArrayLength = scoreData.length+1;
        var newScoreData = new Score[newArrayLength];
        
        System.arraycopy(scoreData, 0, newScoreData, 0, scoreData.length); 
        
        newScoreData[newArrayLength-1] = score; 
        scoreData = reOrderScores(newScoreData);        
        fireTableDataChanged();
    }

    private Score[] reOrderScores(Score[] scores)
    {
        List<Score> orderedScores = Arrays.asList(scores);
        Collections.sort(orderedScores, new ScoreComparator());

        orderedScores = updateRanking(orderedScores); 
        Score[] test = new Score[orderedScores.size()];
        return orderedScores.toArray(test);
    }

    private List<Score> updateRanking(List<Score> scores)
    {
        int i = 1;
        for (var score : scores) {
            score.setRank(i);
            i++;
        }
        return scores;
    }
}