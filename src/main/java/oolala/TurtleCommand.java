package oolala;


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