package oolala;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;

public class View {

  public final int SIZE = 800;

  protected Group totalGroup, lineGroup, stamps;

  protected ImageView cursor;

  protected final String TURTLE_IMAGE = "/images/turtle.png";

  public View(){
    cursor = new ImageView(new Image(TURTLE_IMAGE));
    cursor.setX((float) SIZE/2);
    cursor.setY((float) SIZE/2);
    createGroup();
  }

/**
*
 * @param model is the model that the view will be basing its changes off of
*/
  public void update(Model model){
    cursor.visibleProperty().set(model.isShow());

    double oldX = cursor.getX();
    double oldY = cursor.getY();
    cursor.setX(model.getX());
    cursor.setY(model.getY());
    boolean moved = (oldX != model.getX()) || (oldY != model.getY());
    double halfTurtleWidth = cursor.getBoundsInLocal().getWidth() / 2;
    double halfTurtleHeight = cursor.getBoundsInLocal().getHeight() / 2;
    if(model.getPenState() && moved) {
      Line drawLine = new Line(oldX + halfTurtleWidth, oldY + halfTurtleHeight, cursor.getX() + halfTurtleWidth, cursor.getY() + halfTurtleHeight);
      lineGroup.getChildren().add(drawLine);
    }
    cursor.setRotate(90 - model.getAngle());
  }

  public void stamp(Model model){
    ImageView newStamp = new ImageView(new Image(TURTLE_IMAGE));
    newStamp.setX(cursor.getX());
    newStamp.setY(cursor.getY());
    newStamp.setRotate(90 - model.getAngle());
    stamps.getChildren().add(newStamp);
  }


  private void createGroup(){
    lineGroup = new Group();
    stamps = new Group();
    totalGroup = new Group(cursor, lineGroup, stamps);
  }
  public Group getGroup() {
    return totalGroup;
  }
}
