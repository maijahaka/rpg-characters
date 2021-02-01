package demo;

import hero.Hero;
import hero.HeroFactory;
import hero.HeroType;

import java.io.IOException;
import java.util.ArrayList;

public class Demo {
    public static void runDemo() {
        // create some characters for the demonstration
        Hero warrior = HeroFactory.getHero(HeroType.WARRIOR);
        Hero ranger = HeroFactory.getHero(HeroType.RANGER);
        Hero mage = HeroFactory.getHero(HeroType.MAGE);

        ArrayList<Hero> heroes = new ArrayList<>();
        heroes.add(warrior);
        heroes.add(ranger);
        heroes.add(mage);

        System.out.println("Welcome to RPG character demonstration!");
        System.out.println("We have three characters: a Warrior, a Ranger and a Mage. " +
                "Let's view their starting stats:");
        pressEnterToContinue();

        for (Hero hero : heroes) {
            hero.displayStats();
            pressEnterToContinue();
        }

        System.out.println("Thank you for viewing the demonstration! Have a nice day! :-)");
    }

    // enable viewing the demonstration bit by bit by pressing the Enter key
    private static void pressEnterToContinue() {
        try {
            System.out.println("--- Press Enter to continue ---");
            /* Stops the run until the user presses Enter.
            Does not work ideally if the user presses multiple keys or Enter multiple times,
            but functions well enough for the purposes of this demonstration. */
            System.in.read();
        } catch (IOException e) {
            System.out.println(e.getMessage());;
        }
    }
}
