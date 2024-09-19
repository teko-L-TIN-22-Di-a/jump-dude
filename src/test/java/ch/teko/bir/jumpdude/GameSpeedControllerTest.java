package ch.teko.bir.jumpdude;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import static junit.framework.Assert.assertEquals;

class GameSpeedControllerTest {

    private Main cut;

    @BeforeEach
    void setUp() {
      this.cut = new Main();
    }
  
    @Test
    void firstTest() {
      String input = "duke";
    
      assertThat("asdfasd").isEqualTo("DUKE");
    }

    @Test
    void testFlyingSpeed() {
        Integer flyingSpeed = GameSpeedController.getFlyingSpeed();
        var expectedFlyingSpeed = flyingSpeed + 5;

        GameSpeedController.increaseFlyingSpeed();
        var newFlyingSpeed =  GameSpeedController.getFlyingSpeed();

        assertEquals(expectedFlyingSpeed, newFlyingSpeed);
    }
}
