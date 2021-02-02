package demo;

import hero.Hero;
import hero.HeroFactory;
import hero.HeroType;
import item.armor.Armor;
import item.armor.ArmorFactory;
import item.armor.ArmorType;
import item.armor.Slot;
import item.weapon.Weapon;
import item.weapon.WeaponFactory;
import item.weapon.WeaponType;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void runDemo() {
        //region Initialize characters and display their initial stats
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
        //endregion

        //region Give XP to characters and display updated stats
        System.out.println("Let's give 50 XP to our Warrior, 100 XP to our Ranger and " +
                "300 XP to our Mage. Here are their stats now:");
        pressEnterToContinue();

        warrior.gainXP(50);
        ranger.gainXP(100);
        mage.gainXP(300);

        displayCharacterStats(heroes);
        //endregion

        //region Create some armor items and display their stats
        System.out.println("Let's create three armor pieces: a cloth armor, a leather armor " +
                "and a plate armor. Here are their stats:");
        pressEnterToContinue();

        Armor clothArmor = ArmorFactory.getArmor(ArmorType.CLOTH,
                "Cloth Robes of the Mage", 3, Slot.BODY);
        Armor leatherArmor = ArmorFactory.getArmor(ArmorType.LEATHER,
                "Leather Boots of the Ranger", 2, Slot.LEGS);
        Armor plateArmor = ArmorFactory.getArmor(ArmorType.PLATE,
                "Plate Helmet of the Warrior", 1, Slot.HEAD);

        List<Armor> armors = new ArrayList<>();
        armors.add(clothArmor);
        armors.add(leatherArmor);
        armors.add(plateArmor);

        displayArmorStats(armors);
        //endregion

        //region Equip each character with an armor item
        System.out.println("Now, let's equip our characters with some armor items.");
        System.out.println();

        System.out.println("First, we will equip our Warrior with a helmet.");
        System.out.println("As a reminder, here are the warrior's stats before this addition:");
        warrior.displayStats();
        pressEnterToContinue();
        System.out.println("And here are the stats after the addition:");
        warrior.equipWithArmor(plateArmor);
        warrior.displayStats();
        pressEnterToContinue();

        System.out.println("Next, we will equip our Ranger with boots and our Mage with robes.");
        System.out.println("Here are their stats before these additions:");
        ranger.displayStats();
        mage.displayStats();
        pressEnterToContinue();
        System.out.println("And here are the stats after the addition:");
        ranger.equipWithArmor(leatherArmor);
        mage.equipWithArmor(clothArmor);
        ranger.displayStats();
        mage.displayStats();
        pressEnterToContinue();
        //endregion

        //region Add a second armor item to a character
        System.out.println("Maybe our Mage would like to have boots as well? " +
                "Here are the Mage's stats after this addition:");
        mage.equipWithArmor(leatherArmor);
        mage.displayStats();
        pressEnterToContinue();
        //endregion

        //region Change an armor item equipped by a character
        System.out.println("Ah, we found a new cloth item! Here are its stats:");
        Armor clothHat = ArmorFactory.getArmor(ArmorType.CLOTH, "A Pretty Cloth Hat",
                1, Slot.HEAD);
        clothHat.displayStats();
        pressEnterToContinue();

        System.out.println("Maybe our Warrior would like to try this item? " +
                "Here are the Warrior's stats after this change:");
        warrior.equipWithArmor(clothHat);
        warrior.displayStats();
        pressEnterToContinue();

        System.out.println("This probably isn't the best choice for a warrior... " +
                "So let's revert back to the original equipment.");
        System.out.println("The stats should have returned back to their previous values:");
        warrior.equipWithArmor(plateArmor);
        warrior.displayStats();
        pressEnterToContinue();
        //endregion

        //region Create some weapons and display their stats
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
        //endregion

        //region Equip each character with a weapon
        System.out.println("As we saw earlier, the characters deal no damage if they " +
                "are not equipped with a weapon.");
        System.out.println("Let's equip each of our characters with a weapon. Here are " +
                "their updated stats:");
        pressEnterToContinue();

        warrior.equipWithWeapon(meleeWeapon);
        ranger.equipWithWeapon(rangedWeapon);
        mage.equipWithWeapon(magicWeapon);

        displayCharacterStats(heroes);
        //endregion

        //region Change the weapon equipped by a character
        System.out.println("What if our Warrior would like to try a bow?");
        System.out.println("Here are the stats after the change:");

        Weapon levelOneBow = WeaponFactory.getWeapon(WeaponType.RANGED, "Level 1 Bow", 1);

        warrior.equipWithWeapon(levelOneBow);
        warrior.displayStats();
        pressEnterToContinue();

        System.out.println("Again, this does not seem like a good option for a warrior, ");
        System.out.println("so let's give him his sword back:");
        warrior.equipWithWeapon(meleeWeapon);
        warrior.displayStats();
        pressEnterToContinue();
        //endregion

        //region Make each character attack
        System.out.println("Finally, each of our characters performs an attack.");
        System.out.println("Here is what happens:");
        pressEnterToContinue();

        warrior.attack();
        ranger.attack();
        mage.attack();
        pressEnterToContinue();
        //endregion

        //region End the demonstration
        System.out.println("Thank you for viewing the demonstration! Have a nice day! :-)");
        //endregion
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

    private static void displayArmorStats(List<Armor> armors) {
        for (Armor armor : armors) {
            armor.displayStats();
            pressEnterToContinue();
        }
    }
}
