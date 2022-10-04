package oolala;

public class LRuleCommand extends LCommand{
  public LRuleCommand(LRunnerModel model){
    super(model);
  }

  @Override
  public void execute() throws AssertionError, IndexOutOfBoundsException{
    try {
      LRunnerModel model = getMyModel();
      String symbol = model.getMyCommand()[model.getMyIndex() + 1];
      String string = model.getMyCommand()[model.getMyIndex() + 2];
      assert symbol.length() == 1;
      model.getMyRules().put(symbol,string);
      model.setMyIndex(model.getMyIndex()+3);
    }
    catch (IndexOutOfBoundsException e){
      throw new IndexOutOfBoundsException("Incomplete Command");
    }
    catch (AssertionError e){
      throw new IndexOutOfBoundsException("Symbols can only be one character long");
    }
  }
}

