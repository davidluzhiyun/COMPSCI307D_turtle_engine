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

    Button play1 = new Button("play App 1");
    play1.setFont(new Font(20));
    play1.setTextAlignment(TextAlignment.CENTER);
    play1.setLayoutX(330);
    play1.setLayoutY(400);
    play1.setOnMouseClicked(e -> startApp());

    Button play2 = new Button("play App 2");
    play2.setFont(new Font(20));
    play2.setTextAlignment(TextAlignment.CENTER);
    play2.setLayoutX(330);
    play2.setLayoutY(500);
    play2.setOnMouseClicked(e -> startApp());

    Button play3 = new Button("play App 3");
    play3.setFont(new Font(20));
    play3.setTextAlignment(TextAlignment.CENTER);
    play3.setLayoutX(330);
    play3.setLayoutY(600);
    play3.setOnMouseClicked(e -> startApp());



    Group titleScreen = new Group(title,play1,play2,play3);
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
