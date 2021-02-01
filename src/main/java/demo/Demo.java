package demo;

import hero.Hero;
import hero.HeroFactory;
import hero.HeroType;
import item.weapon.Weapon;
import item.weapon.WeaponFactory;
import item.weapon.WeaponType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void runDemo() {
        // create some characters for the demonstration
        Hero warrior = HeroFactory.getHero(HeroType.WARRIOR);
        Hero ranger = HeroFactory.getHero(HeroType.RANGER);
        Hero mage = HeroFactory.getHero(HeroType.MAGE);

        List<Hero> heroes = new ArrayList<>();
        heroes.add(warrior);
        heroes.add(ranger);
        heroes.add(mage);

        System.out.println("Welcome to RPG character demonstration!");
        System.out.println("We have three characters: a Warrior, a Ranger and a Mage. " +
                "Let's view their starting stats:");
        pressEnterToContinue();

        displayCharacterStats(heroes);

        System.out.println("Let's give 50 XP to our Warrior, 100 XP to our Ranger and " +
                "300 XP to our Mage. Here are their stats now:");
        pressEnterToContinue();

        warrior.gainXP(50);
        ranger.gainXP(100);
        mage.gainXP(300);

        displayCharacterStats(heroes);

        System.out.println("Let's create three weapons: a melee weapon, a ranged weapon and " +
                "a magic weapon. Here are their stats:");
        pressEnterToContinue();

        Weapon meleeWeapon = WeaponFactory.getWeapon(WeaponType.MELEE, "Sword for the Warrior",
                1);
        Weapon rangedWeapon = WeaponFactory.getWeapon(WeaponType.RANGED, "Bow for the Ranger",
                2);
        Weapon magicWeapon = WeaponFactory.getWeapon(WeaponType.MAGIC, "Staff for the Mage",
                3);

        List<Weapon> weapons = new ArrayList<>();
        weapons.add(meleeWeapon);
        weapons.add(rangedWeapon);
        weapons.add(magicWeapon);

        displayWeaponStats(weapons);

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

    private static void displayCharacterStats(List<Hero> heroes) {
        for (Hero hero : heroes) {
            hero.displayStats();
            pressEnterToContinue();
        }
    }

    private static void displayWeaponStats(List<Weapon> weapons) {
        for (Weapon weapon : weapons) {
            weapon.displayStats();
            pressEnterToContinue();
        }
    }
}
