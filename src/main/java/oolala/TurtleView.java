package oolala;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

import java.util.ArrayList;



public class TurtleView {
    private TurtleController controller;
    private ImageView turtle;
    private ArrayList<Line> lines;
    public static final String TURTLE_IMAGE = "/images/turtle.png";
    private boolean penDown = true;
    public TurtleView(TurtleController myController){
        controller = myController;
        turtle = new ImageView(new Image(TURTLE_IMAGE));
        turtle.setX(800/2);
        turtle.setY(800/2);
        lines = new ArrayList<>();
    }

    public void update(TurtleModel model){
        double oldX = turtle.getX();
        double oldY = turtle.getY();
        turtle.setX(model.getX());
        turtle.setY(model.getY());
        boolean moved = (oldX != model.getX()) && (oldY != model.getY());
        if(model.getPenState() && moved) {
            lines.add(new Line(oldX, oldY, turtle.getX(), turtle.getY()));
        }
    }
}
