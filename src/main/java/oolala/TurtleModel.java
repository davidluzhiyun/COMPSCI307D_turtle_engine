package oolala;

/**
 * Mock up turtle
 */
public class TurtleModel {
  private String name;
  public TurtleModel(String myName){
    name = myName;
  }
  public void foward(int pixels){
    System.out.println("fd {}".formatted(pixels));
  }
  public void back(int pixels){
    System.out.println("bk {}".formatted(pixels));
  }
  public void rightTurn(int degrees){
    System.out.println("rt {}".formatted(degrees));
  }
  public void leftTurn(int degrees) {
    System.out.println("lt {}".formatted(degrees));
  }
  public void penDown(){
    System.out.println("pendown");
  }
  public void penUp(){
    System.out.println("penup");
  }
  public void show(){
    System.out.println("showt");
  }
  public void hide(){
    System.out.println("hidet");
  }
  public void home(){
    System.out.println("home");
  }
  public void stamp(){
    System.out.println("stamp");
  }
  public String getName() {
    return name;
  }
}
