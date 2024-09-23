package ch.teko.bir.jumpdude.KeyListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import ch.teko.bir.jumpdude.Player.PlayerController;

public class MainKeyListener extends JFrame implements KeyListener {
    
    private PlayerController playerController;

    public MainKeyListener(PlayerController playerController) {
        this.playerController = playerController;
    }

    
    /** 
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        executeActionWhenArrowUpIsPressed(e);
    }

    
    /** 
     * @param e
     */
    private void executeActionWhenArrowUpIsPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_W) {
            playerController.Jumping();
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_A) {
            playerController.FlyRight();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT|| e.getKeyCode() == KeyEvent.VK_D) {
            playerController.FlyLeft();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
