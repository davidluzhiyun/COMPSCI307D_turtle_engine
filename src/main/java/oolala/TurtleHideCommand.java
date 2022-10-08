package oolala;

public class TurtleHideCommand extends TurtleCommand{
  public TurtleHideCommand(CommandRunner model){
    super(model);
  }

  @Override
  public void execute() {
    CommandRunner model = getMyModel();
    for (Model turtle: model.getCurrentTurtles()){
      turtle.hide();
    }
    model.setMyIndex(model.getMyIndex()+1);
  }
}
