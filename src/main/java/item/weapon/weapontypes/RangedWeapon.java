package item.weapon.weapontypes;

import handler.OutputHandler;
import hero.HeroAttributeType;
import item.weapon.Weapon;

public class RangedWeapon implements Weapon {
    private final int BASE_DAMAGE = 5;
    private final int ADDED_DAMAGE_PER_LEVEL = 3;

    // the character attribute that boosts the damage dealt by this weapon
    private final HeroAttributeType BOOSTING_ATTRIBUTE = HeroAttributeType.DEXTERITY;

    // the factor by which the relevant character stats are multiplied for the boost
    private final double BOOSTING_FACTOR = 2;

    private String name;
    private int level;
    private int damage;

    public RangedWeapon(String name, int level) {
        this.name = name;
        this.level = level;
        this.damage = BASE_DAMAGE + ADDED_DAMAGE_PER_LEVEL * level;
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

    /*
    A non-zero boosting factor is only returned for the character attribute that is
    specific for this weapon type. Boosting factors for other attribute types are zero,
    which means that they do not contribute to the damage dealt.
     */
    @Override
    public double getStrengthBoostingFactor() {
        if (BOOSTING_ATTRIBUTE == HeroAttributeType.STRENGTH) {
            return BOOSTING_FACTOR;
        }
        return 0;
    }

    /*
    A non-zero boosting factor is only returned for the character attribute that is
    specific for this weapon type. Boosting factors for other attribute types are zero,
    which means that they do not contribute to the damage dealt.
     */
    @Override
    public double getDexterityBoostingFactor() {
        if (BOOSTING_ATTRIBUTE == HeroAttributeType.DEXTERITY) {
            return BOOSTING_FACTOR;
        }
        return 0;
    }

    /*
    A non-zero boosting factor is only returned for the character attribute that is
    specific for this weapon type. Boosting factors for other attribute types are zero,
    which means that they do not contribute to the damage dealt.
     */
    @Override
    public double getIntelligenceBoostingFactor() {
        if (BOOSTING_ATTRIBUTE == HeroAttributeType.INTELLIGENCE) {
            return BOOSTING_FACTOR;
        }
        return 0;
    }

    @Override
    public void displayStats() {
        OutputHandler.printWeaponStats(this);
    }
}
