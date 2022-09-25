package oolala;


import javafx.application.Application;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
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
        mainStage.setTitle("Nish's mega awesome breakout gamefr");
        mainStage.show();
        animation = new Timeline();
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.getKeyFrames().add(new KeyFrame(Duration.seconds((double) 1 / 60), e -> repeat()));
        animation.play();
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
