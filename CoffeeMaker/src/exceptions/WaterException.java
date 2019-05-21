package exceptions;

public class WaterException extends Exception{


    private double  amountWater;

    public WaterException(double amountWater) {
        super(amountWater + " is not enough water, dumbass");
    }


    public double getAmountWater() {
        return amountWater;
    }

}
