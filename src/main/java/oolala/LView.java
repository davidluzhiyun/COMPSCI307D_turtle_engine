package oolala;

import javafx.scene.Group;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import static javafx.scene.paint.Color.BLACK;

public class LView extends View{

  private Circle cursor;

  private Group lineGroup, totalGroup;


  public LView(){
    cursor = new Circle();
    cursor.setCenterX(800/2);
    cursor.setCenterY(800/2);
    cursor.setRadius(5);
    cursor.setFill(BLACK);
    createGroup();
  }

  @Override
  public void update(Model model) {
    double oldX = cursor.getCenterX();
    double oldY = cursor.getCenterY();
    cursor.setCenterX(model.getX());
    cursor.setCenterY(model.getY());
    boolean moved = (oldX != model.getX()) || (oldY != model.getY());
    if(model.getPenState() && moved) {
      Line drawLine = new Line(oldX, oldY, cursor.getCenterX(), cursor.getCenterY());
      lineGroup.getChildren().add(drawLine);
    }
  }


  private Group createGroup() {
    lineGroup = new Group();
    totalGroup = new Group(cursor, lineGroup);
    return totalGroup;
  }
}
