package ch.teko.bir.jumpdude.SpriteHandling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Timer;

/**
 *
 * @author Sarah
 */
public class SpriteEngine {
    private Timer timer;
    private final int framesPerSecond;
    private Long cycleStartTime;
    private final TimerHandler timerHandler;
    private double cycleProgress;
    private final List<ActionListener> listeners;

    public SpriteEngine(int fps) {
        framesPerSecond = fps;
        timerHandler = new TimerHandler();
        listeners = new ArrayList<>(20);
    }

    
    /** 
     * @return int
     */
    public int getFramesPerSecond() {
        return framesPerSecond;
    }

    
    /** 
     * @return double
     */
    public double getCycleProgress() {
        return cycleProgress;
    }

    protected void invaldiate() {
        cycleProgress = 0;
        cycleStartTime = null;
    }

    public void stop() {
        if (timer != null) {
            timer.stop();
        }
        invaldiate();
    }

    public void start() {
        stop();
        timer = new Timer(1000 / framesPerSecond, (ActionListener) timerHandler);
        timer.start();
    }

public void addActionListener(ActionListener actionListener) {
        listeners.add(actionListener);
    }

    public void removeActionListener(ActionListener actionListener) {
        listeners.remove(actionListener);
    }

    protected class TimerHandler implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (cycleStartTime == null) {
                cycleStartTime = System.currentTimeMillis();
            }
            long diff = (System.currentTimeMillis() - cycleStartTime) % 1000;
            cycleProgress = diff / 1000.0;
            ActionEvent ae = new ActionEvent(SpriteEngine.this, ActionEvent.ACTION_PERFORMED, e.getActionCommand());
            for (ActionListener listener : listeners) {
                listener.actionPerformed(ae);
            }
        }
    }
}