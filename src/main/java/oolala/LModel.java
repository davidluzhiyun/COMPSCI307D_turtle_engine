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

  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }

  public void penDown(){
    penDown = true;
  }
  public void penUp(){
    penDown = false;
  }
  public void home(){
    x = SIZE/2;
    y = SIZE/2;
    angle = 90;
  }
  public boolean getPenState(){
    return penDown;
  }

  public int getAngle() {
    return angle;
  }

}
