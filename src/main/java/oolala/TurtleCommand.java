package oolala;

/**
 * Abstract class for turtle commands. execute should carry out action for
 * each turtle under control (unless command is tell) and manipulate the
 * index.
 */
public abstract class TurtleCommand {
/*
  public static String[] TYPE1_TOKENS = {"fd", "bk", "lt", "rt"};
  public static String[] TYPE2_TOKENS = {"pendown", "penup", "showt", "hidet", "home", "stamp"};
  */
  private CommandRunner myModel;
  public TurtleCommand(CommandRunner model){
    myModel = model;
  }

  public CommandRunner getMyModel() {
    return myModel;
  }

  public abstract void execute();

}