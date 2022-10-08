package oolala;

public class Model {

  public final int SIZE = 800;

  private final String name;
  protected double x, y;

  private int angle;
  protected boolean draw = true;
  private boolean show = true;
  /**
   * Model is the data structure which holds the position and properties of the cursor for the system
   *
   *
   * @author Andrew Demma
   *
   */

  public Model(){
    this("default");
  }
  public Model(String myName){
    name = myName;
    this.home();
  }

/**
* Turns the model to the right at the specified number of degrees
 * @param angleChange the angle, in degrees, that the model will turn to the right
*/
  public void rightTurn(int angleChange){
    angle -= angleChange;
    if(angle < 0){
      angle += 360;
    }
    angle %= 360;
  }

/**
* Turns the model to the right at the specified number of degrees
 * Does exactly what right turn does, but opposite, hence the negative call to rightTurn
 * @param angleChange the angle, in degrees, that the model will turn to the left
*/
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

/**
* returns the model back to it's starting position
*/
  public void home(){
    x = (float) SIZE/2;
    y = (float) SIZE/2;
    int STRAIGHT_UP_ANGLE = 90;
    angle = STRAIGHT_UP_ANGLE;
  }

  public boolean getPenState(){
    return draw;
  }

  public void show(){
    show = true;
  }
  public void hide(){
    show = false;
  }

  public void penDown(){
    draw = true;
  }
  public void penUp(){
    draw = false;
  }

  public int getAngle(){
    return angle;
  }

  public boolean isShow(){
    return show;
  }
/**
* getName returns the name of the model. This is used when moving specific turtles in the view, and the name is the key to know which turtle it is moving
 * @return the name of the model
*/
  public String getName(){
    return name;
  }

}
