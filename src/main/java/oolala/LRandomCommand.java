package oolala;

public abstract class LRandomCommand extends LCommand {
  public LRandomCommand(LRunnerModel model){
    super(model);
  }

  protected int[] rangeParse() throws AssertionError, IndexOutOfBoundsException,NumberFormatException{
    try {
      LRunnerModel model = getMyModel();
      String token1 = model.getMyCommand()[model.getMyIndex() + 1];
      String token2 = model.getMyCommand()[model.getMyIndex() + 2];
      model.setMyIndex(model.getMyIndex() + 3);
      int min = Integer.parseInt(token1);
      int max = Integer.parseInt(token2);
      assert max >= min;
      return new int[] {min, max};
    }
    catch (IndexOutOfBoundsException e){
      throw new IndexOutOfBoundsException("Incomplete Command");
    }
    catch (AssertionError e){
      throw new AssertionError("Please check the size of your bounds!");
    }
    catch (NumberFormatException e){
      throw new NumberFormatException("Make sure you are using integers for the bounds!");
    }
  }
}
