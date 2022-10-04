package oolala;

public abstract class LCommand {

  private LRunnerModel myModel;
  public LCommand(LRunnerModel model){
    myModel = model;
  }

  public LRunnerModel getMyModel() {
    return myModel;
  }

  public abstract void execute();

}
