package ch.teko.bir.jumpdude.Player;

public class Position {

    public Position(int x, int y)
    {
        this.X = x;
        this.Y = y;
    }
    private int X;
    private int Y;

    public int getX() {
        return X;
    }
    public void setX(int x) {
        X = x;
    }
    public int getY() {
        return Y;
    }
    public void setY(int y) {
        Y = y;
    }

    public void addToX(int value)
    {
        this.X += value;
    }
    public void addToY(int value)
    {
        this.Y += value;
    }
}
