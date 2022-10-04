package oolala;

public class LModel {

  private static final int SIZE = 800;
  private String name;
  private double x, y;
  private int angle = 90;
  private boolean penDown = true;

  public LModel(){
    //set x and y to middle of Window
    x = SIZE/2;
    y = SIZE/2;
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
