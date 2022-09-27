package oolala;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

import java.util.ArrayList;



public class TurtleView {
  private ImageView turtle;
  public static final String TURTLE_IMAGE = "/images/turtle.png";
  Group lineGroup, totalGroup;
  public TurtleView(){
    turtle = new ImageView(new Image(TURTLE_IMAGE));
    turtle.setX(800/2);
    turtle.setY(800/2);
    createGroup();
  }

  public void update(TurtleModel model){
    double oldX = turtle.getX();
    double oldY = turtle.getY();
    turtle.setX(model.getX());
    turtle.setY(model.getY());
    boolean moved = (oldX != model.getX()) || (oldY != model.getY());
    double halfTurtleWidth = turtle.getBoundsInLocal().getWidth() / 2;
    double halfTurtleHeight = turtle.getBoundsInLocal().getHeight() / 2;
    if(model.getPenState() && moved) {
      Line drawLine = new Line(oldX + halfTurtleWidth, oldY + halfTurtleHeight, turtle.getX() + halfTurtleWidth, turtle.getY() + halfTurtleHeight);
      lineGroup.getChildren().add(drawLine);
    }
    turtle.setRotate(90 - model.getAngle());
  }
  public Group getGroup(){
    return totalGroup;
  }
  private Group createGroup(){
    lineGroup = new Group();
    totalGroup = new Group(turtle, lineGroup);
    return totalGroup;
  }
}
