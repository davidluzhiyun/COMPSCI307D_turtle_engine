package oolala;

import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.util.*;

import static oolala.Main.DEFAULT_CSS_PATH;
import static oolala.Main.DEFAULT_RESOURCE_PATH;

public class LController {

  Model model;
  View view;

  LCommandView commandView;

  private BorderPane root;
  private int colorIndex;
  List<Color> colorList;
  private GridPane topGrid;
  private static final String APP_CSS_PATH = "lView.css";



  public LController(){
    model = new Model();
    model.hide();
    view = new View();
    view.update(model);
    colorList = Arrays.asList(Color.RED, Color.BLUEVIOLET, Color.LAWNGREEN, Color.GRAY, Color.AQUAMARINE);
    commandView = new LCommandView(this);
  }


  public Scene makeScene(int width, int height){
    root = new BorderPane();
    root.setCenter(makeDisplay());
    Scene lScene = new Scene(root, width, height);
    lScene.getStylesheets().add(getClass().getResource(DEFAULT_RESOURCE_PATH+DEFAULT_CSS_PATH+APP_CSS_PATH).toExternalForm());
    HBox topBar = new HBox(15);

    Text text = new Text("L-Time");
    text.setFont(new Font(20));

    Button button = new Button("Change Background Color");
    Background background = new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY));
    root.setBackground(background);
    button.setOnMouseClicked(e->changeBackgroundColor());
    topBar.getChildren().addAll(text,button);
    topGrid = new GridPane();
    topGrid.add(button, 5, 0);
    root.setTop(topGrid);
    HBox box = (HBox) commandView.makeInputPanel();
    root.setBottom(box);

    return lScene;
  }

  private void changeBackgroundColor() {
    colorIndex++;
    colorIndex %= colorList.size();
    Background background = new Background(new BackgroundFill(colorList.get(colorIndex), CornerRadii.EMPTY, Insets.EMPTY));
    root.setBackground(background);
  }


  private Group makeDisplay(){
    return view.getGroup();
  }

  public Model getModel () {
    return model;
  }


  public void update(){
    view.update(model);
    showError();
  }
  public void showError(){
    if(commandView.getMyErrorMessage() != null){
      root.setTop(new Text(commandView.getMyErrorMessage()));
    }
    else {
      root.setTop(topGrid);
    }
  }
}
