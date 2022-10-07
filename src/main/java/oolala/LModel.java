package oolala;

public class LModel extends Model{

  private static final int SIZE = 800;
  private int angle = 90;
  private boolean penDown = true;

  public LModel(){
    //set x and y to middle of Window
    x = SIZE/2;
    y = SIZE/2;
  }
}
