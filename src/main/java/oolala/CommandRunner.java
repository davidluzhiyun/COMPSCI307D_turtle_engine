package oolala;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;


public class CommandRunner {
  public static String[] TYPE1_TOKENS = {"fd", "bk", "lt", "rt"};
  public static String[] TYPE2_TOKENS = {"pendown", "penup", "showt", "hidet", "home", "stamp"};
  private Dictionary<String, TurtleModel> allTurtles;
  private List<TurtleModel> currentTurtles;
  private String[] myCommand;
  private int[] tokenTypes;
  private int myIndex;
  private String myError;

  public CommandRunner(){
    allTurtles =new Hashtable<String, TurtleModel>();
    currentTurtles = new ArrayList<>();
    TurtleModel defaultTurtle = new TurtleModel("default");
    allTurtles.put("default", defaultTurtle);
    currentTurtles.add(defaultTurtle);
    myCommand = null;
    myIndex = 0;
    myError = null;
  }

  /**
   *  Take a command, split it into tokens and label the types
   *  Store result in class variables
   */
  public void loadCommand(String command){
    myCommand = command.split("\\s+");
    tokenTypes = new int[myCommand.length];
    for (int i = 0; i < tokenTypes.length; i++){
      tokenTypes[i] = typeCheck(myCommand[i]);
    }
    myIndex = 0;
  }

  /**
   * return a error message for current index
   */
  public void throwUnknownToken(){
    myError = "Don't know how to {}".formatted(myCommand[myIndex]);
  }

  public void throwUnexpectedEnd(){
    myError = "Unexpected end of instruction";
  }

  /**
   * Run actions that require two tokens
   */
  public void runType1(){
    if (errorHandleType1()){
      myIndex += 2;
      return;
    }
    int parameter = Integer.parseInt(myCommand[myIndex+1]);
    String action = (myCommand[myIndex]);
    if (action.equals("fd")){
      for (TurtleModel turtle: currentTurtles){
        turtle.forward(parameter);
      }
    }
    if (action.equals("bk")){
      for (TurtleModel turtle: currentTurtles){
        turtle.backward(parameter);
      }
    }
    if (action.equals("lt")){
      for (TurtleModel turtle: currentTurtles){
        turtle.leftTurn(parameter);
      }
    }
    if (action.equals("rt")){
      for (TurtleModel turtle: currentTurtles){
        turtle.rightTurn(parameter);
      }
    }
    myIndex += 2;
  }

  /**
   * Handle error for actions that require two tokens
   */
  public boolean errorHandleType1(){
    if(myIndex + 1 >= tokenTypes.length){
      throwUnexpectedEnd();
    }
    else{
      int parameterType = tokenTypes[myIndex + 1];
      if (parameterType == 3){
        return false;
      }
      if (parameterType == 5){
        throwUnknownToken();
        return true;
      }
    }
    return true;
  }

  /**
   * Run actions that require one token
   */
  public void runType2(){
    String action = (myCommand[myIndex]);
    if (action.equals("pendown")){
      for (TurtleModel turtle: currentTurtles){
        turtle.penDown();
      }
    }
    if (action.equals("penup")){
      for (TurtleModel turtle: currentTurtles){
        turtle.penUp();
      }
    }
    if (action.equals("showt")){
      for (TurtleModel turtle: currentTurtles){
        turtle.show();
      }
    }
    if (action.equals("hidet")){
      for (TurtleModel turtle: currentTurtles){
        turtle.hide();
      }
    }
    if (action.equals("home")){
      for (TurtleModel turtle: currentTurtles){
        turtle.home();
      }
    }
    if (action.equals("stamp")){
      for (TurtleModel turtle: currentTurtles){
        turtle.stamp();
      }
    }
    myIndex += 1;
  }

  /**
   * Runs tell
   * name can't be an action command
   * stop taking arguments when an action command is met
   */
  public void runTell(){
    currentTurtles = new ArrayList<>();
    myIndex += 1;
    while ((myIndex < myCommand.length) && ((tokenTypes[myIndex] == 5) || (tokenTypes[myIndex] == 3))){
      String name = myCommand[myIndex];
      if(((Hashtable)allTurtles).containsKey(name)){
        currentTurtles.add(allTurtles.get(name));
      }
      else {
        TurtleModel newTurtle = new TurtleModel(name);
        allTurtles.put(name,newTurtle);
        currentTurtles.add(newTurtle);
      }
      myIndex += 1;
    }
  }
  /**
   * The overall running command, returns error message.
   */
  public String run(String command){
    loadCommand(command);
    while ((myError == null) && (myIndex < myCommand.length)){
      if (tokenTypes[myIndex] == 1){
        runType1();
      }
      else if (tokenTypes[myIndex] == 2) {
        runType2();
      }
      else if (tokenTypes[myIndex] == 4) {
        runTell();
      }
      else {
        throwUnknownToken();
        break;
      }
    }
    return myError;
  }

  /**
   * Auxiliary method for checking the type of token
   * 1 and 2 listed above
   * 3 for numbers
   * 4 for tell
   * 5 for other
   * Inspired by https://www.digitalocean.com/community/tutorials/java-array-contains-value
   */
  public static int typeCheck(String token){
    if (Arrays.asList(TYPE1_TOKENS).contains(token)){
      return 1;
    }
    else if (Arrays.asList(TYPE2_TOKENS).contains(token)){
      return 2;
    }
    else if (token.matches("-?[0-9]+")){
      return 3;
    }
    else if (token.equals("tell")) {
      return 4;
    }
    else {
      return 5;
    }
  }

}
