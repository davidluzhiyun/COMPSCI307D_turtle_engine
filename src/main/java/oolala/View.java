package oolala;

import javafx.scene.Group;

public abstract class View {

  private Group totalGroup;

  public View(){
  }

  public abstract void update(Model model);


  public Group getGroup() {
    return totalGroup;
  }
}
