package item.weapon.weapontypes;

import handler.OutputHandler;
import item.weapon.Weapon;

public class MeleeWeapon implements Weapon {
    private final int INITIAL_BASE_DAMAGE = 15;
    private final int ADDED_DAMAGE_PER_LEVEL = 2;

    private String name;
    private int level;
    private int damage;

    public MeleeWeapon(String name, int level) {
        this.name = name;
        this.level = level;
        this.damage = INITIAL_BASE_DAMAGE + ADDED_DAMAGE_PER_LEVEL * level;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public int getDamage() {
        return damage;
    }

    @Override
    public void displayStats() {
        OutputHandler.printWeaponStats(this);
    }
}
