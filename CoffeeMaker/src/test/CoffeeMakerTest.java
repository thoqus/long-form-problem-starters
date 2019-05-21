package test;

import exceptions.*;
import model.CoffeeMaker;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

public class CoffeeMakerTest {

    private CoffeeMaker cmTest;

    @Before
    public void setUp(){
        cmTest = new CoffeeMaker();
    }

    @Test
    public void testBrewNotEnoughWater(){

        try {
            cmTest.brew(2.5, 10);
            fail("This should not be printed!");
        } catch (WaterException e) {
            System.out.println(e.getMessage());
        } catch (BeansAmountException e) {
            System.out.println(e.getMessage());
        }

    }

    @Test (expected = BeansAmountException.class)
    public void testBrewTooManyBeans() throws BeansAmountException, WaterException {
        cmTest.brew(2.8, 15);

    }

    @Test
    public void testBrewJustEnoughWater(){
        try {
            cmTest.brew(2.5, 14.76);
            assertEquals(cmTest.getTimeSinceLastBrew(), 0);
        } catch (BeansAmountException e) {
            fail("There shouldn't be an Exception");
        } catch (WaterException e) {
            fail("There shouldn't be an Exception");
        }
    }

    @Test
    public void testPourCoffeeOnce(){
        try {
            cmTest.brew(2.5, 15);
            cmTest.pourCoffee();
        } catch (Exception e) {
            fail("This should not be printed.");
        }
    }

    @Test (expected = NoCupsRemainingException.class)
    public void testPourCoffeeUntilNoCUpRemaining() throws BeansAmountException, WaterException, NoCupsRemainingException, StaleCoffeeException {
        cmTest.brew(2.5, 15);
        for (int i=0; i<21; i++){
            cmTest.pourCoffee();
        }
    }

    @Test (expected = StaleCoffeeException.class)
    public void testPourCoffeeIsStale() throws BeansAmountException, WaterException, NoCupsRemainingException, StaleCoffeeException {
        cmTest.brew(2.5, 15);
        cmTest.setTimeSinceLastBrew(60);
        cmTest.pourCoffee();
    }

    @Test
    public void testPourCoffeePass() throws BeansAmountException, WaterException {
        cmTest.brew(2.5, 15);
        try {
            cmTest.pourCoffee();
            cmTest.pourCoffee();
            cmTest.pourCoffee();
            cmTest.pourCoffee();
            cmTest.pourCoffee();
            cmTest.setTimeSinceLastBrew(59);
            assertEquals(cmTest.getCupsRemaining(), 15);
            cmTest.pourCoffee();
        } catch (Exception e) {
            fail();
        }
    }

    @Test (expected = WaterException.class)
    public void testBrewFailNotEnoughWater() throws BeansAmountException, WaterException {
        cmTest.brew(2.5, 14.75);
    }

    @Test (expected = WaterException.class)
    public void testBrewFailBothWrongWaterFirst() throws BeansAmountException, WaterException {
        cmTest.brew(2.1, 14);
    }


}
