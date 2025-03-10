package oolala;

public class TurtleBackwardCommand extends TurtleMovementCommand{
  public TurtleBackwardCommand(CommandRunner model){
    super(model);
  }

  @Override
  public void execute() {
    int parameter = parseParameter();
    CommandRunner model = getMyModel();
    for (Model turtle: model.getCurrentTurtles()){
      turtle.backward(parameter);
    }
  }
}
