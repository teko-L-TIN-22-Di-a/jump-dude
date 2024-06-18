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

    @Override
    public void keyPressed(KeyEvent e) {
        executeActionWhenArrowUpIsPressed(e);
    }

    private void executeActionWhenArrowUpIsPressed(KeyEvent e)
    {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            playerController.Jumping();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
