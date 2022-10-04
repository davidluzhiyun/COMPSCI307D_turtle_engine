package oolala;

import java.util.Arrays;

public class LCommandRunner {
  public static String[] TYPE1_TOKENS = {"fd", "bk", "lt", "rt"};
  public static String[] TYPE2_TOKENS = {"pendown", "penup", "showt", "hidet", "home", "stamp"};
  private String[] myCommand;
  private int[] tokenTypes;
  private int myIndex;
  private String myError;
  private LController myController;
  private LModel cursor;

  public LCommandRunner(LController controller){
    myController = controller;
    cursor = myController.getModel();
    myCommand = null;
    myIndex = 0;
    myError = null;
  }

  /**
   *  Take a command, split it into tokens and label the types
   *  Store result in class variables
   */
  public void loadCommand(String command){
    myError = null;
    myCommand = command.split("\\s+");
    tokenTypes = new int[myCommand.length];
    for (int i = 0; i < tokenTypes.length; i++){
      tokenTypes[i] = typeCheck(myCommand[i]);
    }
    myIndex = 0;
  }

  /**
   * return an error message for current index
   */
  public void throwUnknownToken(){
    myError = "Don't know how to \"%s\"".formatted(myCommand[myIndex]);
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
      cursor.forward(parameter);
    }
    if (action.equals("bk")){
      cursor.backward(parameter);
    }
    if (action.equals("lt")){
      cursor.leftTurn(parameter);
    }
    if (action.equals("rt")){
      cursor.rightTurn(parameter);
    }
    myController.update();
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
      cursor.penDown();
    }
    if (action.equals("penup")){
      cursor.penUp();
    }
    if (action.equals("home")){
      cursor.home();
    }
    if (action.equals("stamp")){

    }
    myController.update();
    myIndex += 1;
  }

  /**
   * Runs tell
   * name can't be an action command
   * stop taking arguments when an action command is met
   */

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
    else {
      return 5;
    }
  }


}
