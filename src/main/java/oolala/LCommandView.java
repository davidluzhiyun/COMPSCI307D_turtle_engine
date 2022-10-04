package oolala;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

import java.util.*;

public class LCommandView {
  public static final int FIELD_WIDTH = 40;
  public static final String BUTTON_NAME_RUN = "Run";
  public static final String BUTTON_NAME_CLEAR = "Clear";

  //Class variables
  private TextArea mySingleLineInput;
  private String myErrorMessage;
  private LCommandRunner myRunner;
  private LController myController;
  //Blank saved for some way to manage the turtles
  //There should be a list of all turtles and a list of current turtles
  //Or you can plug in seperated classes for managing turtles in the methods

  /**
   * Never intended to use alone
   * Always use the Hbox returned by makeInputPanel
   */
  public LCommandView(LController controller){
    myErrorMessage = null;

    myController = controller;
    myRunner = new LCommandRunner(myController);
  }

  //methods we might need

  private void run (String command){
    String[] commands = command.split("\\s+");
    for (int i = 0; i < commands.length; i++) {
      commands[i] = commands[i].toLowerCase();
    }
    LRunnerModel lRunnerModel = new LRunnerModel(commands);
    lRunnerModel.setMyLevels(4);
    String turtleCode = lRunnerModel.genTurtleCode();
    if(myErrorMessage != null){
      myController.showError();
    }
    System.out.println(turtleCode);
    myRunner.run(turtleCode);
  }

  private void clear (){
    mySingleLineInput.clear();
  }


  //Handles special keys for tracing history or running
  private void handleKeyInput (KeyCode code) {
    switch (code) {
      case ENTER -> run(mySingleLineInput.getText());
    }
  }


  // Button creation code simplified from Robert C. Duvall
  // Use original code for more complex behavior
  private Button makeButton (String name, EventHandler<ActionEvent> handler){
    Button result = new Button(name);
    result.setOnAction(handler);
    return result;
  }

  // Typical code to create text field for input from Robert C. Duvall
  // For single line input
  private TextArea makeInputField (int width) {
    TextArea result = new TextArea();
    result.setPrefColumnCount(width);
    return result;
  }


  // Make user-entered text field and buttons
  // Modified from Robert C. Duvall's code
  // For single line case
  // Go take the returned node to add to scene
  public Node makeInputPanel () {
    HBox result = new HBox();
    mySingleLineInput = makeInputField(FIELD_WIDTH);
    Button runButton = makeButton(BUTTON_NAME_RUN, event -> run(mySingleLineInput.getText()));
    Button clearButton = makeButton(BUTTON_NAME_CLEAR, event -> clear());
    result.getChildren().add(clearButton);
    result.getChildren().add(mySingleLineInput);
    result.getChildren().add(runButton);
    return result;
  }

  public String getMyErrorMessage() {
    return myErrorMessage;
  }
}
