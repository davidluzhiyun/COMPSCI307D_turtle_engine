package oolala;

public class Model {

  private final int SIZE = 800;
  private final int STRAIGHT_UP_ANGLE = 90;

  private String name;

  protected double x, y;

  private int angle;
  private boolean penDown = true;
  private boolean show = true;

  public Model(){
    x = SIZE/2;
    y = SIZE/2;
    angle = STRAIGHT_UP_ANGLE;
  }




  public void rightTurn(int angleChange){
    angle -= angleChange;
    if(angle < 0){
      angle += 360;
    }
    angle %= 360;
  }

  public void leftTurn(int angleChange){
    this.rightTurn(-1*angleChange);
  }


  public void forward(int distance){
    double radians = Math.toRadians(angle);
    x += ((double) distance) * Math.cos(radians);
    y -= ((double) distance) * Math.sin(radians);
  }
  public void backward(int distance){
    this.forward(-1*distance);
  }

  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }

  public void home(){
    x = SIZE/2;
    y = SIZE/2;
    angle = STRAIGHT_UP_ANGLE;
  }

  public boolean getPenState(){
    return penDown;
  }

}
