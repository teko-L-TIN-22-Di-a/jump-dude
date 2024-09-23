package ch.teko.bir.jumpdude;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

import ch.teko.bir.jumpdude.Jetpack.JetpackController;
import ch.teko.bir.jumpdude.Jetpack.JetpackModel;

public class JetpackControllerTests {
    JetpackController testee;
    JetpackModel model = new JetpackModel(100);

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void emptyScoresJsoShouldInsertDefaultScore() {
        var gameSpeedController = new GameSpeedController();
        testee = new JetpackController(model, gameSpeedController);

        var jetpack = model.getJetpack();
        var expectedXValue = jetpack.getX() - gameSpeedController.getRunningSpeed();
        testee.repaint(100);

        assertEquals(expectedXValue, jetpack.getX());
    }
}
