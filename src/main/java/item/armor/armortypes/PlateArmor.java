package item.armor.armortypes;

import handler.OutputHandler;
import item.armor.Armor;
import item.armor.Slot;

public class PlateArmor implements Armor {
    // armor provides its user with bonus attribute points
    private final int BASE_BONUS_HP = 30;
    private final int BASE_BONUS_STRENGTH = 3;
    private final int BASE_BONUS_DEXTERITY = 1;
    private final int BASE_BONUS_INTELLIGENCE = 0;

    private final int ADDED_BONUS_HP_PER_LEVEL = 12;
    private final int ADDED_BONUS_STRENGTH_PER_LEVEL = 2;
    private final int ADDED_BONUS_DEXTERITY_PER_LEVEL = 1;
    private final int ADDED_BONUS_INTELLIGENCE_PER_LEVEL = 0;

    private String name;
    private int level;
    private Slot slot;

    private int bonusHP;
    private int bonusStrength;
    private int bonusDexterity;
    private int bonusIntelligence;

    public PlateArmor(String name, int level, Slot slot) {
        this.name = name;
        this.level = level;
        this.slot = slot;

        // the bonus stats are scaled according to the slot of the armor item
        double scalingFactor = slot.scalingFactor;

        this.bonusHP = (int) (scalingFactor * (BASE_BONUS_HP +
                ADDED_BONUS_HP_PER_LEVEL * level));
        this.bonusStrength = (int) (scalingFactor * (BASE_BONUS_STRENGTH +
                ADDED_BONUS_STRENGTH_PER_LEVEL * level));
        this.bonusDexterity = (int) (scalingFactor * (BASE_BONUS_DEXTERITY +
                ADDED_BONUS_DEXTERITY_PER_LEVEL * level));
        this.bonusIntelligence = (int) (scalingFactor * (BASE_BONUS_INTELLIGENCE +
                ADDED_BONUS_INTELLIGENCE_PER_LEVEL * level));
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Slot getSlot() {
        return this.slot;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getBonusHP() {
        return this.bonusHP;
    }

    @Override
    public int getBonusStrength() {
        return this.bonusStrength;
    }

    @Override
    public int getBonusDexterity() {
        return this.bonusDexterity;
    }

    @Override
    public int getBonusIntelligence() {
        return this.bonusIntelligence;
    }

    @Override
    public void displayStats() {
        OutputHandler.printArmorStats(this);
    }
}
