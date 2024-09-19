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
      var currentSpeed = GameSpeedController.getFlyingSpeed();
      var expectedSpeed = currentSpeed+5;

      GameSpeedController.increaseFlyingSpeed();

      assertEquals(expectedSpeed, GameSpeedController.getFlyingSpeed());
    }

    @Test
    public void TestRunningGamespeedValue() {
      var currentSpeed = GameSpeedController.getRunningSpeed();
      var expectedSpeed = currentSpeed+5;

      GameSpeedController.increaseRunningSpeed();

      assertEquals(expectedSpeed, GameSpeedController.getRunningSpeed());
    }
}
