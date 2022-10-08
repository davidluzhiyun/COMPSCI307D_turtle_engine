package oolala;

public class TurtleForwardCommand extends TurtleMovementCommand{
  public TurtleForwardCommand(CommandRunner model){
    super(model);
  }

  @Override
  public void execute() {
    int parameter = parseParameter();
    CommandRunner model = getMyModel();
    for (Model turtle: model.getCurrentTurtles()){
      turtle.forward(parameter);
    }
  }
}
