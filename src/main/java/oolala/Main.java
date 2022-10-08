package oolala;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main extends Application {
 Stage mainStage;
 Timeline animation;
 BorderPane borderPane = new BorderPane();

 int mainWidth=800;
 int mainHeight=800;



  /**
   * A method to test (and a joke :).
   */
  public double getVersion () {
      return 0.001;
  }

  @Override
  public void start (Stage stage) throws IOException{
    mainStage = stage;
    mainStage.setScene(getSplashScreen());
    mainStage.setTitle("Turtle Time");
    mainStage.show();
    animation = new Timeline();
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.getKeyFrames().add(new KeyFrame(Duration.seconds((double) 1 / 60), e -> repeat()));
    animation.play();
    }

  public Scene getSplashScreen(){
    Text title = new Text("OOLALA");
    title.setFont(new Font(60));
    title.setTextAlignment(TextAlignment.CENTER);
    title.setX(285);
    title.setY(200);
    title.setFill(Color.RED);
    List<Button> buttons = new ArrayList<>();
    Group gButtons = new Group();
    gButtons.getChildren().add(title);
    List<String> apps = Arrays.asList("Turtle", "L-System");
    for(int i =0;i<=1;i++){
      Button play = new Button(apps.get(i));
      play.setFont(new Font(20));
      play.setTextAlignment(TextAlignment.CENTER);
      Font font = Font.font("Verdana", FontWeight.LIGHT, 25);
      play.setFont(font);
      play.setLayoutX(330);
      play.setLayoutY(400+(100)*(i-1));
      buttons.add(play);
      gButtons.getChildren().add(play);
    }

    buttons.get(0).setOnMouseClicked(e->startApp1());
    buttons.get(1).setOnMouseClicked(e->startApp2());


    return new Scene(gButtons, mainWidth, mainHeight,Color.BLACK);
  }


  public void startApp1(){
    mainStage.setScene(getTurtleScene());
    try{
      //FileHandler.newReadFile();
    }
    catch (Exception e){
      System.out.println("Oh crap"+e.getMessage());
    }

  }
  public void startApp2(){
    mainStage.setScene(getLScene());
  }
  public void startApp3(){

  }

  public Scene getTurtleScene(){
    TurtleController controller = new TurtleController();
    Scene turtleScene = controller.makeScene(mainWidth, mainHeight);
    return turtleScene;
  }

  public Scene getLScene(){
    LController controller = new LController();
    Scene lScene = controller.makeScene(mainWidth, mainHeight);
    return lScene;
  }

  private void repeat(){

    }
  public static void main (String[] args) {
        launch();
    }
}
