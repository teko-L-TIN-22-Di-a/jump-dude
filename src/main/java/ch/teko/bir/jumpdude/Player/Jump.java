package ch.teko.bir.jumpdude.Player;

import ch.teko.bir.jumpdude.Position;

public class Jump {
    private static final int JUMP_SPEED = 5;

    
    /** 
     * @param playerPositions
     * @return Position
     */
    public static Position Up(Position playerPositions)
    {
        playerPositions.addToY(-JUMP_SPEED);
        
        return playerPositions;
    }

    
    /** 
     * @param playerPositions
     * @return Position
     */
    public static Position Down(Position playerPositions)
    {
        playerPositions.addToY(+JUMP_SPEED);
        
        return playerPositions;
    }

    public static int getJumpSpeed() {
        return JUMP_SPEED;
    }
}
