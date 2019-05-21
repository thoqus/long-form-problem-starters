package model;

import exceptions.*;

/**
 * A coffee maker used to train baristas.
 *
 * Class invariant: cups remaining >= 0, time since last brew >= 0
 */

public class CoffeeMaker {

    private int timeSinceLastBrew;

    private int cupsRemaining;



    public CoffeeMaker(){
        this.timeSinceLastBrew = 0;
        this.cupsRemaining=0;
    }

    // getters
    public int getTimeSinceLastBrew() {
        return this.timeSinceLastBrew;
    }
    public int getCupsRemaining() {
        return this.cupsRemaining;
    }

    // EFFECTS: return true if there are coffee cups remaining
    public boolean areCupsRemaining() {
        return getCupsRemaining()>0?true:false;
    }

    //REQUIRES: a non-negative integer
    //EFFECTS: sets time since last brew
    public void setTimeSinceLastBrew(int time) {
        this.timeSinceLastBrew = time;
    }

    //EFFECTS: sets cups remaining to full (20 cups) and time since last brew to 0, throws a lot of exceptions...
    //         throws BeansAmountException if beans are not between 2.4 and 2.6 cups,
    //         throws WaterException if water <= 14.75
    public void brew(double beans, double water) throws BeansAmountException, WaterException {
        if (water<=14.75) throw new WaterException(water);
        else if (beans<2.4) throw new NotEnoughBeansException(beans);
        else if (beans>2.6) throw new TooManyBeansException(beans);
        else{
            this.setTimeSinceLastBrew(0);
            this.cupsRemaining=20;
        }
    }

    //MODIFIES: this
    //EFFECTS: subtracts one cup from cups remaining
    //         throws NoCupsRemainingException if cups remaining <= 0
    //         throws StaleCoffeeException if time since last brew >= 60
    public void pourCoffee() throws NoCupsRemainingException, StaleCoffeeException {
        if (!areCupsRemaining()) throw new NoCupsRemainingException();
        else if (getTimeSinceLastBrew()>=60) throw new StaleCoffeeException(getTimeSinceLastBrew());
        else{
            this.cupsRemaining--;
        }

    }


}
