package ch.teko.bir.jumpdude.Scores;

public class Score {

    private Integer rank;
    private Integer score;
    private String name;

    public Score()
    {

    }

    public Score(String name, int score)
    {
        this.name = name;
        this.score = score;
    }

    
    /** 
     * @return Integer
     */
    public Integer getRank()
    {
        return rank;
    }

    public void setRank(int value)
    {
        rank = value;
    }

    public Integer getScore()
    {
        return score;
    }
    
    public String getName()
    {
        return name;
    }
}