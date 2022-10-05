package oolala;

public class TurtleModel extends Model{

  private static final int SIZE = 800;
  private String name;

  private double x, y;

  private int angle = 90;
  private boolean penDown = true;
  private boolean show = true;

  public TurtleModel(String myName){
    //set x and y to middle of Window
    x = SIZE/2;
    y = SIZE/2;
    name = myName;
  }



  public void forward(int distance){
    double radians = Math.toRadians(angle);
    x += ((double) distance) * Math.cos(radians);
    y -= ((double) distance) * Math.sin(radians);
    if(x > 700){
      x = 700;
    }
    if(y > 700){
      y = 700;
    }
    if(x < 0){
      x = 0;
    }
    if(y < 0){
      y = 0;
    }
  }



  public void penDown(){
    penDown = true;
  }
  public void penUp(){
    penDown = false;
  }
  public void show(){
    show = true;
  }
  public void hide(){
    show = false;
  }
  public boolean isShow(){
    return show;
  }

  public String getName(){
    return name;
  }

  public int getAngle() {
    return angle;
  }
}
