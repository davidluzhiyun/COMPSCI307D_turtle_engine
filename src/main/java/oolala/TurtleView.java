package oolala;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class TurtleView extends View{
  private ImageView cursor;
  public static final String TURTLE_IMAGE = "/images/turtle.png";
  Group lineGroup, totalGroup, stamps;
  public TurtleView(){
    super();
  }

  public void stamp(Model model){
    ImageView newStamp = new ImageView(new Image(TURTLE_IMAGE));
    newStamp.setX(cursor.getX());
    newStamp.setY(cursor.getY());
    newStamp.setRotate(90 - model.getAngle());
    stamps.getChildren().add(newStamp);
  }
  protected void createGroup(){
    lineGroup = new Group();
    stamps = new Group();
    totalGroup = new Group(cursor, lineGroup, stamps);
  }

}
