package oolala;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import static oolala.Main.DEFAULT_CSS_PATH;
import static oolala.Main.DEFAULT_RESOURCE_PATH;

public class TurtleController {

  Model model;
  ArrayList<Model> turtleModels;
  Hashtable<String, Model> allTurtles;
  Dictionary<String, View> allViews;
  TurtleCommandView commandView;
  Group totalGroup;
  private BorderPane root;
  private static final String APP_CSS_PATH = "turtleView.css";
  /**
   * TurtleController is the Controller for the Logo App
   * It handles the creation of the initial model and view for the app, and initiates the UI and Command Runner
   *
   * @author Andrew Demma
   *
   */
  public TurtleController(){
    String firstTurtleName = "first";
    model = new Model(firstTurtleName);
    turtleModels = new ArrayList<>();
    turtleModels.add(model);
    View view = new View();
    commandView = new TurtleCommandView(this);
    allTurtles = new Hashtable<>();
    allTurtles.put(firstTurtleName, turtleModels.get(0));
    allViews = new Hashtable<>();
    allViews.put(firstTurtleName, view);
  }
/**
* Creates the Scene which has the Turtle, text box, and buttons for control
 * @param width is the width of the screen
 * @param height is the height of the screen
 * @return the created Scene
*/
  public Scene makeScene(int width, int height){
    root = new BorderPane();
    root.setCenter(makeTurtleDisplay());
    Scene turtleScene = new Scene(root, width, height);
    turtleScene.getStylesheets().add(getClass().getResource(DEFAULT_RESOURCE_PATH+DEFAULT_CSS_PATH+APP_CSS_PATH).toExternalForm());
    TurtleCommandView InputView = new TurtleCommandView(this);
    HBox box = (HBox) InputView.makeInputPanel();
    root.setBottom(box);
    return turtleScene;
  }

  private Group makeTurtleDisplay(){
    totalGroup = allViews.get("first").getGroup();
    return new Group(totalGroup);
  }
  public Model getInitialTurtle(){
    return turtleModels.get(0);
  }

  public Hashtable<String, Model> getTurtleDictionary(){
    return allTurtles;
  }

  public void update(Model turtle){
    View view = allViews.get(turtle.getName());
    view.update(turtle);
    showError();
  }
  public void stamp(Model turtle){
    View view = allViews.get(turtle.getName());
    view.stamp();
    showError();
  }
  public void createView(Model turtle){
    View newView = new View();
    allViews.put(turtle.getName(), newView);
    totalGroup.getChildren().add(newView.getGroup());
  }

  public void showError(){
    if(commandView.getMyErrorMessage() != null){
      root.setTop(new Text(commandView.getMyErrorMessage()));
    }
    else {
      root.setTop(null);
    }
  }

}
