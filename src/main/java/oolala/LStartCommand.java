package oolala;

public class LStartCommand extends LCommand{
  public LStartCommand(LRunnerModel model){
    super(model);
  }

  @Override
  public void execute() throws IndexOutOfBoundsException {
    try {
      LRunnerModel model = getMyModel();
      String start = model.getMyCommand()[model.getMyIndex() + 1];
      model.setMyExpandedCommand(start);
      model.setMyIndex(model.getMyIndex()+2);
    }
    catch (IndexOutOfBoundsException e){
      throw new IndexOutOfBoundsException("Incomplete Command");
    }
  }
}
