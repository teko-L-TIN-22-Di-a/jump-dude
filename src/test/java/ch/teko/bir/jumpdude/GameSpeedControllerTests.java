package ch.teko.bir.jumpdude;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

public class GameSpeedControllerTests {

    @BeforeEach
    void setUp() {
    }

    @Test
    void TestFlyingGamespeedValue() {
      var currentSpeed = GameSpeedController.getFlyingSpeed();
      var expectedSpeed = currentSpeed+5;

      GameSpeedController.increaseFlyingSpeed();

      assertEquals(expectedSpeed, GameSpeedController.getFlyingSpeed());
    }

    @Test
    void TestRunningGamespeedValue() {
      var currentSpeed = GameSpeedController.getRunningSpeed();
      var expectedSpeed = currentSpeed+5;

      GameSpeedController.increaseFlyingSpeed();

      assertEquals(expectedSpeed, GameSpeedController.getRunningSpeed());
    }
}
