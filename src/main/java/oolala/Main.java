package oolala;


import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import java.io.IOException;

public class Main extends Application {
   Stage mainStage;
   Timeline animation;
   BorderPane borderPane = new BorderPane();

   int mainWidth=600;
   int mainHeight=600;



    /**
     * A method to test (and a joke :).
     */
    public double getVersion () {
        return 0.001;
    }

    @Override
    public void start (Stage stage) throws IOException{
        mainStage = stage;
        //splashScreen = placeSplash(); // needs to return a group and a scene and will take in a stage

        mainStage.setScene(getMainScene());
        mainStage.setTitle("Turtle Time");
        mainStage.show();
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(new KeyFrame(Duration.seconds((double) 1 / 60), e -> repeat()));
        animation.play();
    }

  public Scene getSplashScreen(){
    Text title = new Text("!");
    title.setFont(new Font(60));
    title.setTextAlignment(TextAlignment.CENTER);
    title.setX(85);
    title.setY(200);
    title.setFill(Color.RED);
    Button playApp = new Button("play App");
    playApp.setFont(new Font(20));
    playApp.setTextAlignment(TextAlignment.CENTER);
    playApp.setLayoutX(200);
    playApp.setLayoutY(400);
    playApp.setOnMouseClicked(e -> startApp());

    Group titleScreen = new Group(title,playApp);
    return new Scene(titleScreen, mainWidth, mainHeight,Color.BLACK);
    }


    public void startApp(){

    }


    public Scene getMainScene(){
        Text test = new Text("Hello World");
        borderPane.setCenter(test);
        Scene scene = new Scene(borderPane,mainWidth,mainHeight,Color.LIGHTBLUE);
        return scene;
    }

    private void repeat(){

    }
    public static void main (String[] args) {
        launch();
    }
}
