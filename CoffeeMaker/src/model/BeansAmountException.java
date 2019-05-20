package model;

public class BeansAmountException extends Exception {


    private double beans;

    public BeansAmountException(double beans) {super(beans + " beans!? Oi, mate! You fucked up the number of beans again.");}

    protected BeansAmountException(double beans, String message){
        super("calls the Exception super constructor that takes a String. This String should be a combination of both parameters.");
        this.beans = beans;
    }

    public double getBeans() {
        return beans;
    }


}
