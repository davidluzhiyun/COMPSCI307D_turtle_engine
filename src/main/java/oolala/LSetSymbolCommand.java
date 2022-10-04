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
      assert symbol.length() == 1;
      String logoFirst = model.getMyCommand()[model.getMyIndex() + 2];
      assert logoFirst.startsWith("\"");
      int counter = 1;
      String logo;
      if(logoFirst.endsWith("\"")){
        logo = logoFirst.replace("\"", "");
        model.getMyTurtleRules().put(symbol, " "+logo);
      }
      else{
        StringBuilder logoBuild = new StringBuilder(logoFirst.replace("\"", ""));
        while(!model.getMyCommand()[model.getMyIndex() + 2 + counter].contains("\"")){
          logoBuild.append(" "+ model.getMyCommand()[model.getMyIndex() + 2 + counter]);
          counter++;
        }
        logoBuild.append(" "+ model.getMyCommand()[model.getMyIndex() + 2 + counter].replace("\"", ""));
        counter++;
        logo = logoBuild.toString();
      }
      model.getMyTurtleRules().put(symbol, logo + " ");
      model.setMyIndex(model.getMyIndex() + 2 + counter);
    }
    catch (IndexOutOfBoundsException e){
      throw new IndexOutOfBoundsException("Incomplete Command");
    }
    catch (AssertionError e){
      throw new AssertionError("Symbols can only be one character long");
    }
  }
}
