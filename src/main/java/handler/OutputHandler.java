package handler;

import hero.Hero;
import item.weapon.Weapon;

public class OutputHandler {

    public static void printHeroStats(Hero hero) {
        // displays the name of the instantiated class, i.e. the specific character type
        System.out.println(hero.getClass().getSimpleName() + " details:");

        System.out.println("HP: " + hero.getHealth());
        System.out.println("Str: " + hero.getStrength());
        System.out.println("Dex: " + hero.getDexterity());
        System.out.println("Int: " + hero.getIntelligence());
        System.out.println("Lvl: " + hero.getLevel());
        System.out.println("XP to next: " + hero.getLevelUpRequirement());
    }

    public static void printWeaponStats(Weapon weapon) {
        System.out.println("Item stats for: " + weapon.getName());
        System.out.println("Weapon type: " + formatWeaponType(weapon));
        System.out.println("Weapon level: " + weapon.getLevel());
        System.out.println("Damage: " + weapon.getDamage());
    }

    // removes the ending 'Weapon' from the weapon class name to get the weapon type
    private static String formatWeaponType(Weapon weapon) {
        String weaponClassName = weapon.getClass().getSimpleName();
        int indexOfWeaponInClassName = weapon.getClass().getSimpleName().lastIndexOf("Weapon");
        return weaponClassName.substring(0, indexOfWeaponInClassName);
    }
}
