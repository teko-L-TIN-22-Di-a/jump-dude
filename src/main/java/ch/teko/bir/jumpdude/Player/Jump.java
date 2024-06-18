package ch.teko.bir.jumpdude.Player;

public class Jump {

    private static int jumpSpeed = 5;

    public static Position Up(Position playerPositions)
    {
        playerPositions.addToY(-jumpSpeed);
        
        return playerPositions;
    }

    public static Position Down(Position playerPositions)
    {
        playerPositions.addToY(+jumpSpeed);
        
        return playerPositions;
    }
}
