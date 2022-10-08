package oolala;


import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.util.Duration;
import java.io.IOException;
import java.util.List;
import java.util.ResourceBundle;

public class Main extends Application {
  private Stage mainStage;
  private Timeline animation;

  public static final int mainWidth=800;
  public static final int mainHeight=800;

  public static final String DEFAULT_RESOURCE_PACKAGE = "properties.";
  private static final String DEFAULT_APPS_PACKAGE = DEFAULT_RESOURCE_PACKAGE + "Apps";
  public static final String DEFAULT_RESOURCE_PATH = "/";
  public static final String DEFAULT_CSS_PATH = "view/";
  private static final String SPLASH_CSS_PATH = "/splashScreen.css";


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
    Pane root = new Pane();
    root.setId("root");
    Scene splashScreen = new Scene(root, mainWidth, mainHeight);
    splashScreen.getStylesheets().add(getClass().getResource(DEFAULT_RESOURCE_PATH+DEFAULT_CSS_PATH+SPLASH_CSS_PATH).toExternalForm());
    Text title = new Text("OOLALA");
    title.setTextAlignment(TextAlignment.CENTER);
    title.setX(285);
    title.setY(200);
    List<Button> buttons = new ArrayList<>();
    root.getChildren().add(title);
    ResourceBundle myApps = ResourceBundle.getBundle(DEFAULT_APPS_PACKAGE);
    for(int i =0;i<=1;i++){
      Button play = new Button(myApps.getString("Apps").split(" ")[i]);
      play.setFont(new Font(20));
      play.setTextAlignment(TextAlignment.CENTER);
      Font font = Font.font("Verdana", FontWeight.LIGHT, 25);
      play.setFont(font);
      buttons.add(play);
      root.getChildren().add(play);
      play.relocate(330, 400+(100)*(i-1));
      play.getLayoutX();
      System.out.println(play.getWidth());
    }

    buttons.get(0).setOnMouseClicked(e->startLogo());
    buttons.get(1).setOnMouseClicked(e->startL());



    return splashScreen;
  }


  public void startLogo(){
    Scene logoScene = getTurtleScene();
    mainStage.setScene(logoScene);
    try{
      //FileHandler.newReadFile();
    }
    catch (Exception e){
      System.out.println("Oh crap"+e.getMessage());
    }

  }
  public void startL(){
    mainStage.setScene(getLScene());
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
