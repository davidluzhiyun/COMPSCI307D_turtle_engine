package oolala;

import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import util.DukeApplicationTest;

import javax.swing.text.View;


public class TurtleViewTest extends DukeApplicationTest{

  private TurtleView myView;


  @Override
  public void start (Stage stage) {
    myView = new TurtleView();
    // create application and add scene for testing to given stage
    stage.setScene(myView.getGroup().getScene());
    stage.show();
  }

  @Test
  void testTextFieldAction () {
    String expected = "ENTER test!";
    // GIVEN, app first starts up
    // WHEN, text is typed and action is activated with ENTER key
    // clickOn(myTextField).write(expected).write(KeyCode.ENTER.getChar());
    // THEN, check label text has been updated to match input
    // assertLabelText(expected);
  }
}
