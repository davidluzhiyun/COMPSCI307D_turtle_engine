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

public class LController {

  LModel model;
  LView view;

  //LCommandView commandView;
  Group totalGroup;

  private BorderPane root;
  private int colorIndex;
  List<Color> colorList;



  public LController(){
    model = new LModel();
    view = new LView();
    colorList = Arrays.asList(Color.RED, Color.BLUEVIOLET, Color.LAWNGREEN, Color.GRAY, Color.AQUAMARINE);
    //commandView = new LCommandView(this);
  }


  public Scene makeScene(int width, int height){
    root = new BorderPane();
    root.setCenter(makeDisplay());
    HBox topBar = new HBox(15);

    Text text = new Text("L-Time");
    text.setFont(new Font(20));

    Button button = new Button("Change Color");
    Background background = new Background(new BackgroundFill(Color.BLUE, CornerRadii.EMPTY, Insets.EMPTY));
    root.setBackground(background);
    button.setOnMouseClicked(e->changeBackgroundColor());


    topBar.getChildren().addAll(text,button);

    GridPane topGrid = new GridPane();
    topGrid.add(button, 5, 0);
    root.setTop(topGrid);
    //HBox box = (HBox) LCommandView.makeInputPanel();
    //root.setBottom(box);

    return new Scene(root, width, height);
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

}
