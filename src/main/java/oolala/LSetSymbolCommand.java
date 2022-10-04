package oolala;

public class LSetSymbolCommand extends LCommand{
  public LSetSymbolCommand(LRunnerModel model) {
    super(model);
  }

  @Override
  public void execute() throws AssertionError, IndexOutOfBoundsException{
    try {
      LRunnerModel model = getMyModel();
      String symbol = model.getMyCommand()[model.getMyIndex() + 1];
      String logo = model.getMyCommand()[model.getMyIndex() + 2];
      assert symbol.length() == 1;
      model.getMyTurtleRules().put(symbol, " "+logo);
    }
    catch (IndexOutOfBoundsException e){
      throw new IndexOutOfBoundsException("Incomplete Command");
    }
    catch (AssertionError e){
      throw new AssertionError("Symbols can only be one character long");
    }
  }
}
