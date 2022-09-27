package oolala;


import java.util.ArrayList;
import java.util.List;
/**
 * Class for handling command line input
 * The backstage implementation part
 * Primary target feature for now: Line by line input and running
 * Inspired by example_browser project
 * by Robert C. Duvall
 * Owen Astrachan
 * Marcin Dobosz
 * Yuzhang Han
 * Edwin Ward
 *
 * @author David Lu
 */
public class TurtleCommandHistoryModel {

  private String myCurrentCommand;
  private int myCurrentIndex;
  private List<String> myHistory;
  public TurtleCommandHistoryModel(){
    myCurrentCommand = null;
    myCurrentIndex = -1;
    myHistory = new ArrayList<>();

  }
  /**
   * From Robert C. Duvall
   * Returns true if there is a next URL available
   */
  private boolean hasNext () {
    return myCurrentIndex < (myHistory.size() - 1);
  }

  /**
   * From Robert C. Duvall
   * Returns true if there is a previous URL available
   */
  private boolean hasPrevious () {
    return myCurrentIndex > 0;
  }

  /**
   * Modified from Robert C. Duvall's code
   * Returns the previous command in command history, goes a full cycle if
   * bottom reached. Return null if history is empty
   */
  public String back (){
    if (myHistory.isEmpty()){
      return null;
    }
    else if (hasPrevious()) {
      myCurrentIndex -= 1;
    }
    else{
      myCurrentIndex = myHistory.size() - 1;
    }
    return myHistory.get(myCurrentIndex);
  }

  /**
   * Modified from Robert C. Duvall's code
   * Returns the next command in command history, goes a full cycle if
   * top reached. Return null if history is empty
   */
  public String next (){
    if (myHistory.isEmpty()){
      return null;
    }
    else if (hasNext()) {
      myCurrentIndex += 1;
    }
    else{
      myCurrentIndex = 0;
    }
    return myHistory.get(myCurrentIndex);
  }

  /**
   * Method for recording the current command
   */
  public void record(String command){
    if (command.equals("")){
      return;
    }
    else {
      myCurrentCommand = command;
      myHistory.add(myCurrentCommand);
      myCurrentIndex = myHistory.size() - 1;
    }
  }


}
