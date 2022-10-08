package oolala;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class ModelTest {

  private Model turtle = new Model("test");
  private static final int SIZE = 800;

  @Test
  void rightTurn() {
    assertEquals(turtle.getAngle(), 90);
    turtle.rightTurn(50);
    assertEquals(turtle.getAngle(), 40);
    turtle.rightTurn(41);
    assertEquals(turtle.getAngle(), 359);
  }

  @Test
  void leftTurn(){
    assertEquals(turtle.getAngle(), 90);
    turtle.leftTurn(50);
    assertEquals(turtle.getAngle(), 140);
    turtle.leftTurn(220);
    assertEquals(turtle.getAngle(), 0);
  }

  @Test
  public void forward(){
    assertEquals(turtle.getX(), SIZE/2);
    assertEquals(turtle.getY(), SIZE/2);
    turtle.forward(50);
    assertEquals(turtle.getX(), SIZE/2);
    assertEquals(turtle.getY(), SIZE/2 - 50);
    turtle.leftTurn(90);
    turtle.forward(50);
    assertEquals(turtle.getX(), SIZE/2 - 50);
    assertEquals(turtle.getX(), SIZE/2 - 50);
  }
  @Test
  public void backward(){
    assertEquals(SIZE/2, turtle.getX());
    assertEquals(SIZE/2, turtle.getY());
    turtle.backward(50);
    assertEquals(SIZE/2, turtle.getX());
    assertEquals(SIZE/2 + 50, turtle.getY());
    turtle.leftTurn(90);
    turtle.backward(50);
    assertEquals(SIZE/2 + 50, turtle.getX());
    assertEquals(SIZE/2 + 50, turtle.getX());
  }
  @Test
  public void penDownAndUp(){
    assertEquals(true, turtle.getPenState());
    turtle.penDown();
    assertEquals(true, turtle.getPenState());
    turtle.penUp();
    assertEquals(false, turtle.getPenState());
    turtle.penDown();
    assertEquals(true, turtle.getPenState());
  }
  @Test
  public void showAndHide(){
    assertEquals(true, turtle.isShow());
    turtle.show();
    assertEquals(true, turtle.isShow());
    turtle.hide();
    assertEquals(false, turtle.isShow());
    turtle.show();
    assertEquals(true, turtle.isShow());
  }
  @Test
  public void home(){
    turtle.rightTurn(45);
    turtle.forward(20);
    assertNotEquals(SIZE/2, turtle.getX());
    assertNotEquals(SIZE/2, turtle.getY());
    assertNotEquals(90, turtle.getAngle());
    turtle.home();
    assertEquals(SIZE/2, turtle.getX());
    assertEquals(SIZE/2, turtle.getY());
    assertEquals(90, turtle.getAngle());
  }
  @Test
  public void getName(){
    assertEquals("test", turtle.getName());
    assertEquals("hello", new Model("hello").getName());
  }
}
