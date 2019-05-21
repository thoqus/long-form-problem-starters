package exceptions;

public class StaleCoffeeException extends Exception {

    private int timeSinceLastBrew;

    public StaleCoffeeException(int timeSinceLastBrew) {
        super("After " + timeSinceLastBrew + "hours the coffee has become stale.");

    }

    public int getTimeSinceLastBrew() {
        return timeSinceLastBrew;
    }
}
