package oolala;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.Queue;

public class LRunnerModel {
  private String[] myCommand;
  private int myIndex;

  private String myExpandedCommand;
  private int myExpandedIndex;
  private int myLevels;
  private Dictionary<String,String> myRules;
  private Dictionary<String,String> myTurtleRules;

  //Subject to change
  public LRunnerModel(String[] command){
    myCommand = command;
    myIndex = 0;
    myExpandedCommand = "";
    myExpandedIndex = 0;
    myLevels = 0;
    myRules = new Hashtable<String, String>();
    //Please add the rule to translate to turtle
  }

  //Expand command according to rules
  private void expand(){
    for (int i = 0; i < myLevels; i++) {
      myExpandedCommand = replace(myExpandedCommand, myRules);
    }
  }
  
  
  //package friendly for testing
  //Auxiliary method for expanding that can be used for other purpose
  String replace(String original, Dictionary<String,String> rules){
    String result = "";
    for (int i = 0; i < original.length(); i++) {
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
}
