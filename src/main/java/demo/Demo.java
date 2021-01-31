package demo;

import hero.Hero;
import hero.Mage;
import hero.Ranger;
import hero.Warrior;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void runDemo() {
        Hero warrior = new Warrior();
        Hero ranger = new Ranger();
        Hero mage = new Mage();

        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(warrior);
        heroes.add(ranger);
        heroes.add(mage);

        System.out.println("Welcome to RPG character demonstration!");
        System.out.println("There are " + heroes.size() + " characters. Let's view their starting stats.");
        pressEnterToContinue();

        for (Hero hero : heroes) {
            hero.displayStats();
            pressEnterToContinue();
        }

        System.out.println("Thank you for viewing the demonstration! Have a nice day! :-)");
    }

    private static void pressEnterToContinue() {
        try {
            System.out.println("--- Press Enter to continue ---");
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
