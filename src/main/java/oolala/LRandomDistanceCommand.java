package oolala;

public class LRandomDistanceCommand extends LRandomCommand {
  public LRandomDistanceCommand(LRunnerModel model){
    super(model);
  }
  @Override
  public void execute() {
    LRunnerModel model = getMyModel();
    model.setMyDistanceRange(rangeParse());
  }
}
