package oolala;

public class TurtleModel {

    private static final int SIZE = 800;

    private double x, y;

    private int angle = 0;

    public TurtleModel(){
        //set x and y to middle of Window
        x = SIZE/2;
        y = SIZE/2;
    }


    private void rightTurn(int angleChange){
        angle -= angleChange;
    }

    private void leftTurn(int angleChange){
        this.rightTurn(-1*angleChange);
    }

    private void forward(int distance){
        double radians = Math.toRadians(angle);
        x += ((double) distance) * Math.sin(radians);
        y += ((double) distance) * Math.cos(radians);
    }
    private void backward(int distance){
        this.forward(-1*distance);
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
}
