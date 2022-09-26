package oolala;

public class TurtleController {

    TurtleModel model;
    TurtleView view;

    public TurtleController(){
        model = new TurtleModel("first");
        view = new TurtleView(this);
    }
}
