package oolala;

import java.util.Dictionary;
import java.util.Hashtable;

public class LRunnerModel {

  public static final int DEFAULT_DISTANCE = 2;
  public static final int DEFAULT_ANGLE = 60;
  private String[] myCommand;
  private int myIndex;

  private String myExpandedCommand;
  private int myLevels;
  private Dictionary<String,String> myRules;
  private Dictionary<String,String> myTurtleRules;

  private int[] myDistanceRange;
  private int[] myAngleRange;
  //Subject to change
  public LRunnerModel(String[] command){
    myCommand = command;
    myIndex = 0;
    myExpandedCommand = "";
    myLevels = 0;
    myRules = new Hashtable<String, String>();
    myDistanceRange = new int[]{DEFAULT_DISTANCE, DEFAULT_DISTANCE};
    myAngleRange = new int[]{DEFAULT_ANGLE, DEFAULT_ANGLE};
    myTurtleRules = new Hashtable<String, String> ();
    updateTurtleRules();
    myTurtleRules.put("X", "stamp");
  }
  // Runs everything and output the turtle commands
  public String genTurtleCode() throws AssertionError{
    try{
      while (myIndex < myCommand.length){
        LCommand currentCommand;
        String action = (myCommand[myIndex]);
        if (action.equals("start")){
          currentCommand = new LStartCommand(this);
        }
        else if (action.equals("rule")){
          currentCommand = new LRuleCommand(this);
        }
        else if (action.equals("randomd")){
          currentCommand = new LRandomDistanceCommand(this);
        }
        else if (action.equals("randoma")){
          currentCommand = new LRandomAngleCommand(this);
        }
        else if (action.equals("set")){
          currentCommand = new LSetSymbolCommand(this);
        }
        else {
          assert false;
          break;
        }
        currentCommand.execute();
      }
      expand();
      return translate();
    }
    catch (AssertionError e){
      throw new AssertionError("Manual crash. Check command syntax or code related to index progression");
    }
  }


  //Expand command according to rules
  private void expand(){
    for (int i = 0; i < myLevels; i++) {
      myExpandedCommand = replace(myExpandedCommand, myRules);
    }
  }

  //Translate expanded command to turtle. Need additional code to run. Use after expanding.
  private String translate(){
    return replace(myExpandedCommand, myTurtleRules);
  }

  //Update turtle rules
  private void updateTurtleRules(){
    myTurtleRules.put("f", "pendown fd " + randomizeParameter(myDistanceRange) + " ");
    myTurtleRules.put("g", "penup fd " + randomizeParameter(myDistanceRange) + " ");
    myTurtleRules.put("a", "penup bk " + randomizeParameter(myDistanceRange) + " ");
    myTurtleRules.put("b", "pendown bk " + randomizeParameter(myDistanceRange) + " ");
    myTurtleRules.put("+", "rt " + randomizeParameter(myAngleRange) + " ");
    myTurtleRules.put("-", "lt " + randomizeParameter(myAngleRange) + " ");
  }

  //Generate random ints in String form according to range
  //package friendly for testing
  String randomizeParameter(int[] bounds){
    int randomParameter = bounds[0] + (int)((bounds[1] - bounds[0] + 1)* Math.random());
    return Integer.toString(randomParameter);
  }

  
  //package friendly for testing
  //Auxiliary method for expanding that can be used for other purpose
  String replace(String original, Dictionary<String,String> rules){
    String result = "";
    for (int i = 0; i < original.length(); i++) {
      //line added for turtle
      updateTurtleRules();
      //
      String symbol = Character.toString(original.charAt(i));
      if (((Hashtable<String,String>)rules).containsKey(symbol)){
        result += rules.get(symbol);
      }
      else {
        result += symbol;
      }
    }
    return result;
  }


  //Setters and getters
  public void setMyLevels(int myLevels) {
    this.myLevels = myLevels;
  }

  public int getMyIndex() {
    return myIndex;
  }

  public void setMyIndex(int myIndex) {
    this.myIndex = myIndex;
  }

  public String[] getMyCommand() {
    return myCommand;
  }

  public void setMyExpandedCommand(String myExpandedCommand) {
    this.myExpandedCommand = myExpandedCommand;
  }

  public String getMyExpandedCommand() {
    return myExpandedCommand;
  }

  public Dictionary<String, String> getMyRules() {
    return myRules;
  }

  public void setMyAngleRange(int[] myAngleRange) {
    this.myAngleRange = myAngleRange;
  }

  public void setMyDistanceRange(int[] myDistanceRange) {
    this.myDistanceRange = myDistanceRange;
  }

  public Dictionary<String, String> getMyTurtleRules() {
    return myTurtleRules;
  }
}
