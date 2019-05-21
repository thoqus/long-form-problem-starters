package exceptions;

public class BeansAmountException extends Exception {


    private double beans;

    public BeansAmountException(double beans) {
        super(beans + " beans!? Oi, mate! You fucked up the number of beans again.");
        this.beans = beans;
    }

    protected BeansAmountException(double beans, String message) {
        super(beans + message);
        this.beans = beans;



    }

    public double getBeans() {
        return beans;
    }


}
