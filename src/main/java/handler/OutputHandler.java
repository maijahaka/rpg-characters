package handler;

import hero.Hero;
import item.armor.Armor;
import item.weapon.Weapon;

public class OutputHandler {

    public static void printHeroStats(Hero hero) {
        // displays the name of the instantiated class, i.e. the specific character type
        System.out.println(hero.getClass().getSimpleName() + " details:");

        System.out.println("HP: " + hero.getEffectiveHealth());
        System.out.println("Str: " + hero.getEffectiveStrength());
        System.out.println("Dex: " + hero.getEffectiveDexterity());
        System.out.println("Int: " + hero.getEffectiveIntelligence());
        System.out.println("Lvl: " + hero.getLevel());
        System.out.println("XP to next: " + hero.getLevelUpRequirement());
        System.out.println("Attacking for " + hero.getEffectiveDamageDealt());
    }

    public static void printWeaponStats(Weapon weapon) {
        System.out.println("Item stats for: " + weapon.getName());
        System.out.println("Weapon type: " + formatWeaponType(weapon));
        System.out.println("Weapon level: " + weapon.getLevel());
        System.out.println("Damage: " + weapon.getDamage());
    }

    public static void printArmorStats(Armor armor) {
        System.out.println("Item stats for: " + armor.getName());
        System.out.println("Armor type: " + formatArmorType(armor));
        System.out.println("Slot: " + armor.getSlot().toString());
        System.out.println("Armor level: " + armor.getLevel());
        System.out.println("Bonus HP: " + armor.getBonusHP());

        // do not print bonus attributes if they are not relevant for the armor item
        if (armor.getBonusStrength() != 0) {
            System.out.println("Bonus Str: " + armor.getBonusStrength());
        }
        if (armor.getBonusDexterity() != 0) {
            System.out.println("Bonus Dex: " + armor.getBonusDexterity());
        }
        if (armor.getBonusIntelligence() != 0) {
            System.out.println("Bonus Int: " + armor.getBonusIntelligence());
        }
    }

    public static void printAttackMessage(Hero hero) {
        System.out.println("A " + hero.getClass().getSimpleName() +
                " attacked with " + hero.getWeapon().getName() +
                " and dealt " + hero.getEffectiveDamageDealt() + " damage!");
    }

    // removes the ending 'Weapon' from the weapon class name to get the weapon type
    private static String formatWeaponType(Weapon weapon) {
        String weaponClassName = weapon.getClass().getSimpleName();
        int indexOfWeaponInClassName = weapon.getClass().getSimpleName().lastIndexOf("Weapon");
        return weaponClassName.substring(0, indexOfWeaponInClassName);
    }

    // removes the ending 'Armor' from the armor class name to get the armor type
    private static String formatArmorType(Armor armor) {
        String armorClassName = armor.getClass().getSimpleName();
        int indexOfArmorInClassName = armor.getClass().getSimpleName().lastIndexOf("Armor");
        return armorClassName.substring(0, indexOfArmorInClassName);
    }
}
