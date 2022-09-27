package oolala;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Hashtable;

public class TurtleController {

  TurtleModel model;
  ArrayList<TurtleModel> turtleModels;
  Dictionary<String, TurtleModel> allTurtles;
  Dictionary<String, TurtleView> allModels;
  TurtleCommandView commandView;
  Group totalGroup;
  private BorderPane root;

  public TurtleController(){
    model = new TurtleModel("first");
    turtleModels = new ArrayList<>();
    turtleModels.add(model);
    TurtleView view = new TurtleView();
    commandView = new TurtleCommandView(this);
    allTurtles = new Hashtable<String, TurtleModel>();
    allTurtles.put("first", turtleModels.get(0));
    allModels = new Hashtable<>();
    allModels.put("first", view);
  }


  public Scene makeScene(int width, int height){
    root = new BorderPane();
    totalGroup = makeTurtleDisplay();
    root.setCenter(totalGroup);
    HBox box = (HBox) commandView.makeInputPanel();
    root.setBottom(box);

    return new Scene(root, width, height);
  }

  private Group makeTurtleDisplay(){
    Group turtleGroup = allModels.get("first").getGroup();
    return new Group(turtleGroup);
  }
  public TurtleModel getInitialTurtle(){
    return turtleModels.get(0);
  }

  public Dictionary getTurtleDictionary(){
    return allTurtles;
  }

  public void update(TurtleModel turtle){
    TurtleView view = allModels.get(turtle.getName());
    view.update(turtle);
    showError();
  }
  public void createView(TurtleModel turtle){
    TurtleView newView = new TurtleView();
    allModels.put(turtle.getName(), newView);
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
