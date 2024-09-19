package ch.teko.bir.jumpdude;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import ch.teko.bir.jumpdude.Scores.ScoresController;

public class ScoresControllerTests {

  ScoresController testee = new ScoresController();

    @BeforeEach
    public void setUp() {
      
    }

    @Test
    public void emptyScoresJsoShouldInsertDefaultScore() {
      var sampleJson = "";
      
      var result = testee.parseJson(sampleJson);

      assertNotEquals(null, result);
      assertEquals(null, result.getValueAt(0, 0));
      assertEquals(1000, result.getValueAt(0, 1));
      assertEquals("kek", result.getValueAt(0, 2));
    }
  
    @Test
    public void sampleJsonCanBeParsed() {      
      var sampleJson = "[{\"rank\":1,\"score\":21000,\"name\":\"ds\"},{\"rank\":2,\"score\":1000,\"name\":\"kek\"}]\r\n";
      
      var result = testee.parseJson(sampleJson);

      assertNotEquals(null, result);
    }

    @Test
    public void loadInvalidJson()  {      
      var sampleJson = "[{\"rank111\":1,\"test\":21000,\"invalid\":\"ds\"},{\"rank\":2,\"score\":1000,\"name\":\"kek\"}]\r\n";
      
      var result = testee.parseJson(sampleJson);

      assertEquals(null, result.getValueAt(0, 0));
      assertEquals(null, result.getValueAt(0, 1));
      assertEquals(null, result.getValueAt(0, 2));
      assertEquals(2, result.getValueAt(1, 0));
      assertEquals(1000, result.getValueAt(1, 1));
      assertEquals("kek", result.getValueAt(1, 2));
    }
}
