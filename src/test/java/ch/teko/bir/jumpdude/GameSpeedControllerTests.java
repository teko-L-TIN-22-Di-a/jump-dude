package ch.teko.bir.jumpdude;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class GameSpeedControllerTests {

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void TestFlyingGamespeedValue() {
      var gameSpeedController = new GameSpeedController();
      var currentSpeed = gameSpeedController.getFlyingSpeed();
      var expectedSpeed = currentSpeed+5;

      gameSpeedController.increaseFlyingSpeed();

      assertEquals(expectedSpeed, gameSpeedController.getFlyingSpeed());
    }

    @Test
    public void TestRunningGamespeedValue() {
      
      var gameSpeedController = new GameSpeedController();
      var currentSpeed = gameSpeedController.getRunningSpeed();
      var expectedSpeed = currentSpeed+5;

      gameSpeedController.increaseRunningSpeed();

      assertEquals(expectedSpeed, gameSpeedController.getRunningSpeed());
    }
}
