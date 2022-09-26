package oolala;

public class TurtleController {

    TurtleModel model;
    TurtleView view;

    public TurtleController(){
        model = new TurtleModel();
        view = new TurtleView(this);
    }
}
