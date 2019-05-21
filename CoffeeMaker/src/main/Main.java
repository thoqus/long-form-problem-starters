package main;

import exceptions.BeansAmountException;
import exceptions.NoCupsRemainingException;
import exceptions.StaleCoffeeException;
import exceptions.WaterException;
import model.CoffeeMaker;

public class Main {

    public static void main(String[] args) {
        CoffeeMaker cm = new CoffeeMaker();
        try {
            cm.brew(2.6, 20);
        } catch (BeansAmountException e) {
            System.out.println(e.getMessage());
        } catch (WaterException e) {
            System.out.println(e.getMessage());
        }

        try {
            cm.brew(2.5, 15);
        } catch (BeansAmountException e) {
            System.out.println(e.getMessage());
        } catch (WaterException e) {
            System.out.println(e.getMessage());
        }

        try {

            for (int i = 0; i < 21; i++) {

                cm.pourCoffee();
            }
        } catch (NoCupsRemainingException e) {
            System.out.println(e.getMessage());
        } catch (StaleCoffeeException e) {
            System.out.println(e.getMessage());
        }

        cm.setTimeSinceLastBrew(61);

        try {
            cm.pourCoffee();
        } catch (NoCupsRemainingException e) {
            System.out.println(e.getMessage());
        } catch (StaleCoffeeException e) {
            System.out.println(e.getMessage());
        }


        System.out.println("Successfully caught it");
    }


}