/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ch.teko.bir.jumpdude.Player;

import ch.teko.bir.jumpdude.Position;


class Flying {
    private static final int FLY_SPEED = 8;
    private static final int FLY_LIMIT = 350;
    private static final int RIGHT_LIMIT = 900;
    private static final int LEFT_LIMIT = -5;

    
    /** 
     * @param playerPositions
     * @return Position
     */
    public static Position Up(Position playerPositions) {
        if (playerPositions.getY() > FLY_LIMIT)
        {
            playerPositions.addToY(-FLY_SPEED);
        }
        
        return playerPositions;
    }

    public static Position Right(Position playerPositions) {
        if (playerPositions.getX() < RIGHT_LIMIT)
        {
            playerPositions.addToX(FLY_SPEED);
        }
        else
        {
            playerPositions.setX(LEFT_LIMIT);
        }

        return playerPositions;
    }
    
    public static Position Left(Position playerPositions) {
        if (playerPositions.getX() > LEFT_LIMIT)
        {
            playerPositions.addToX(-FLY_SPEED);
        }
        else
        {
            playerPositions.setX(RIGHT_LIMIT);
        }

        return playerPositions;
    }
}
