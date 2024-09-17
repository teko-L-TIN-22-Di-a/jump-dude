/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package ch.teko.bir.jumpdude.Player;

import ch.teko.bir.jumpdude.Position;


class Flying {
    private static final int FLY_SPEED = 8;
    private static final int FLY_LIMIT = 350;

    public static Position Up(Position playerPositions) {
        if (playerPositions.getY() > FLY_LIMIT)
        {
            playerPositions.addToY(-FLY_SPEED);
        }
        
        return playerPositions;
    }

    public static Position Right()
    {
        throw new UnsupportedOperationException("Unimplemented method 'Up'");
    }
    
    public static Position Left()
    {
        throw new UnsupportedOperationException("Unimplemented method 'Up'");
    }
}
