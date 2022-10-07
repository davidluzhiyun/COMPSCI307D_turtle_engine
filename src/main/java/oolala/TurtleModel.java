package oolala;

public class TurtleModel extends Model{

  private String name;

  private int angle = 90;

  public TurtleModel(){
    super();
  }
  public TurtleModel(String myName){
    //set x and y to middle of Window
    x = SIZE/2;
    y = SIZE/2;
    name = myName;
  }

}
