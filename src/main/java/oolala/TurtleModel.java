package oolala;

public class TurtleModel {

  private static final int SIZE = 800;
  private String name;

  private double x, y;

  private int angle = 0;
  private boolean penDown = true;
  private boolean show = true;

  public TurtleModel(String myName){
    //set x and y to middle of Window
    x = SIZE/2;
    y = SIZE/2;
    name = myName;
  }


  public void rightTurn(int angleChange){
    angle -= angleChange;
  }

  public void leftTurn(int angleChange){
    this.rightTurn(-1*angleChange);
  }

  public void forward(int distance){
    double radians = Math.toRadians(angle);
    x += ((double) distance) * Math.sin(radians);
    y -= ((double) distance) * Math.cos(radians);
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
  public void show(){
    show = true;
  }
  public void hide(){
    show = false;
  }
  public void stamp(){

  }
  public void home(){
    x = SIZE/2;
    y = SIZE/2;
  }
  public boolean getPenState(){
    return penDown;
  }
  public boolean isShow(){
    return show;
  }

  public String getName(){
    return name;
  }
}
