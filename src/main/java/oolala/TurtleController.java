package oolala;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

import java.util.ArrayList;

public class TurtleController {

    TurtleModel model;
    TurtleView view;

    public TurtleController(){
        model = new TurtleModel("first");
        view = new TurtleView(this);
    }


    public Scene makeScene(int width, int height){
        BorderPane root = new BorderPane();
        root.setCenter(makeTurtleDisplay());
        HBox topBar = new HBox(15);

        Text text = new Text("TurtleTime");
        text.setFont(new Font(20));

        Button button = new Button("Change Color");
        button.setOnMouseClicked(e->view.changeContrast(-1.0));


        topBar.getChildren().addAll(text,button);


        root.setTop(topBar);
        TurtleCommandView commandView = new TurtleCommandView();
        HBox box = (HBox) commandView.makeInputPanel();
        root.setBottom(box);

        return new Scene(root, width, height);
    }

    private Group makeTurtleDisplay(){
        Group turtleGroup = view.getGroup();
        return new Group(turtleGroup);
    }

}
