package oolala;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LRunnerModelTest {

  @Test
  void replace() {
    String[] answer= {
    "F-F++F-F",
    "F-F++F-F-F-F++F-F++F-F++F-F-F-F++F-F",
    "F-F++F-F-F-F++F-F++F-F++F-F-F-F++F-F-F-F++F-F-F-F++F-F++F-F++F-F-F-F++F-F++F-F++F-F-F-F++F-F++F-F++F-F-F-F++F-F-F-F++F-F-F-F++F-F++F-F++F-F-F-F++F-F"};
    String command = "F";
    String[] placeholder = {"F","G"};
    LRunnerModel model = new LRunnerModel(placeholder);
    model.getMyRules().put("F", "F-F++F-F");
    for (int i = 0; i < 3; i++) {
      command = model.replace(command, model.getMyRules());
      assertEquals(answer[i],command);
    }
  }
}