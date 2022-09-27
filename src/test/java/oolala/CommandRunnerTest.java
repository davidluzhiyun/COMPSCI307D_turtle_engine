package oolala;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommandRunnerTest {

  @Test
  void loadCommand_number() {
    assertEquals(3,CommandRunner.typeCheck("-99"));
  }
}