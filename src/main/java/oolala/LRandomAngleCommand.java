package oolala;

public class LRandomAngleCommand extends LRandomCommand{
  public LRandomAngleCommand(LRunnerModel model){
    super(model);
  }
  @Override
  public void execute() {
    LRunnerModel model = getMyModel();
    model.setMyAngleRange(rangeParse());
  }
}
