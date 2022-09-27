package oolala;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;

/**
 * Class for handling command line input
 * Primary target feature for now: Line by line input and running
 * Inspired by example_browser project
 * by Robert C. Duvall
 * Owen Astrachan
 * Marcin Dobosz
 * Yuzhang Han
 * Edwin Ward
 *
 * @author David Lu
 */
public class TurtleCommandView {
  //Useful constants
  public static final int FIELD_WIDTH = 40;
  public static final String BUTTON_NAME_RUN = "Run";
  public static final String BUTTON_NAME_CLEAR = "Clear";

  //Class variables
  private TextField mySingleLineInput;
  private String myErrorMessage;
  //Subject to change
  private TurtleCommandHistoryModel myModel;
  private CommandRunner myRunner;
  //Blank saved for some way to manage the turtles
  //There should be a list of all turtles and a list of current turtles
  //Or you can plug in seperated classes for managing turtles in the methods

  /**
   * Never intended to use alone
   * Always use the Hbox returned by makeInputPanel
   */
  public TurtleCommandView(){
    myErrorMessage = null;
    myModel = new TurtleCommandHistoryModel();
    myRunner = new CommandRunner();
  }

  //methods we might need
  private void next (){
    mySingleLineInput.setText(myModel.next());
  }
  private void back (){
    mySingleLineInput.setText(myModel.back());
  }
  private void run (String command){
    myModel.record(command);
    myErrorMessage = myRunner.run(command);
  }

  private void clear (){
    mySingleLineInput.clear();
  }


  //Handles special keys for tracing history or running
  private void handleKeyInput (KeyCode code) {
    switch (code) {
      case UP -> back();
      case DOWN -> next();
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
  private TextField makeInputField (int width, EventHandler<KeyEvent> handler) {
    TextField result = new TextField();
    result.setPrefColumnCount(width);
    result.setOnKeyPressed(handler);
    return result;
  }


  // Make user-entered text field and buttons
  // Modified from Robert C. Duvall's code
  // For single line case
  // Go take the returned node to add to scene
  public Node makeInputPanel () {
    HBox result = new HBox();
    mySingleLineInput = makeInputField(FIELD_WIDTH, event -> handleKeyInput(event.getCode()));
    Button runButton = makeButton(BUTTON_NAME_RUN, event -> run(mySingleLineInput.getText()));
    Button clearButton = makeButton(BUTTON_NAME_CLEAR, event -> clear());
    result.getChildren().add(clearButton);
    result.getChildren().add(mySingleLineInput);
    result.getChildren().add(runButton);
    return result;
  }

}
