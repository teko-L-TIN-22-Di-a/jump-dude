package ch.teko.bir.jumpdude;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ch.teko.bir.jumpdude.Menu.MenuWindowFactory;

/**
 *
 * @author Sarah
 */
public class Main {    
    protected static final Logger logger = LogManager.getLogger();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        initzializeMenu();
    }
    
    private static void initzializeMenu(){
        MenuWindowFactory.createMenuWindow();
    }
}
