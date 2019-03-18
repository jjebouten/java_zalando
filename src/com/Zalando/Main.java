package com.Zalando;

import java.util.Scanner;

public class Main {

    private static int MINIMAL_AMOUNT_PRODUCTS = 8000;
    private static int ORDER_FROM_GERMANY = 2400;
    private static int MAX_STORAGE = 12000;

    public static void main(String[] args) {

        System.out.print("Start amount of supply: ");

        int supply = 0;
        int orders = 0;
        int retour = 0;
        int retourFastSellers = 0;
        int retourToGermany = 0;
        int newSupply = 0;


        System.out.print("Start amount of supply: ");
        supply = scanInt();

        if (!checkAmountOfSupply(supply)) {
            System.exit(1);
        }

        System.out.print("Amount of supply ordered: ");
        orders = scanInt();

        System.out.print("Total amount of supply returned: ");
        retour = scanInt();
        System.out.print("How much of those were fast sellers?: ");
        retourFastSellers = scanInt();

        if (retourFastSellers > retour) {
            System.out.println("Fast sellers can never be higher than total amount");
            System.out.println("Total amount retour given " + retour);
            System.out.println("Fast sellers given " + retourFastSellers);
            System.exit(1552934457);
        }


        newSupply = (calculateNewSupply(supply, orders, retourFastSellers));
        retourToGermany = (orders - retourFastSellers);
        if (!checkAmountOfSupply(newSupply)) {
            System.out.println("Return the surpassing amount to germany");
            retourToGermany = retourToGermany + (newSupply - MAX_STORAGE);
            newSupply = newSupply - retourToGermany;
        }

        System.out.println("New Supply = " + newSupply);
        System.out.println("retourToGermany = " + retourToGermany);

    }

    private static boolean checkAmountOfSupply(int supply) {
        if (supply > 12000) {
            System.out.println("Supply is larger then 12000");
            return false;
        } else return true;
    }

    private static boolean checkMinimalAmountOfSupply(int supply) {
        return supply < MINIMAL_AMOUNT_PRODUCTS;
    }

    private static int scanInt() {
        int value = 0;
        Scanner scanner = new Scanner(System.in);
        try {
            value = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Please enter an int");
            System.out.println("Aborting program");
            System.exit(1552934489);
        }
        return value;
    }

    private static int calculateNewSupply(int supply, int orders, int retourFastSellers) {
        int newSupply = (supply - orders) + retourFastSellers;

        if (checkMinimalAmountOfSupply(newSupply)) {
            newSupply += ORDER_FROM_GERMANY;
        }
        return newSupply;
    }

}
