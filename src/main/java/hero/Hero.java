package hero;

import handler.OutputHandler;
import item.armor.Armor;
import item.armor.Slot;
import item.weapon.Weapon;
import level.CharacterLevelManager;

import java.util.HashMap;
import java.util.Map;

// all character classes should inherit this abstract class
public abstract class Hero {

    // the increments added to each attribute value on level-up
    private final int GAINED_HEALTH_ON_LEVEL_UP;
    private final int GAINED_STRENGTH_ON_LEVEL_UP;
    private final int GAINED_DEXTERITY_ON_LEVEL_UP;
    private final int GAINED_INTELLIGENCE_ON_LEVEL_UP;

    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;

    // armor that the character is equipped with
    private Map<Slot, Armor> slotsEquippedWithArmor;

    // the bonus attributes gained form armor
    private int healthFromArmor;
    private int strengthFromArmor;
    private int dexterityFromArmor;
    private int intelligenceFromArmor;

    private int level;

    // the XP required to reach the next level
    private int levelUpRequirement;

    public Hero(int initialHealth, int initialStrength, int initialDexterity,
                int initialIntelligence, int gainedHealthOnLevelUp, int gainedStrengthOnLevelUp,
                int gainedDexterityOnLevelUp, int gainedIntelligenceOnLevelUp) {

        // initial attribute values are given as parameters for each character type
        this.health = initialHealth;
        this.strength = initialStrength;
        this.dexterity = initialDexterity;
        this.intelligence = initialIntelligence;

        // initially the character equips no armor
        this.slotsEquippedWithArmor = new HashMap<>();

        this.healthFromArmor = 0;
        this.strengthFromArmor = 0;
        this.dexterityFromArmor = 0;
        this.intelligenceFromArmor = 0;

        // all characters start at level 1
        this.level = 1;

        // the XP required to reach level 2
        this.levelUpRequirement = CharacterLevelManager.getInitialLevelUpRequirement();

        // values for the attribute increments on level-up are given as constructor parameters
        GAINED_HEALTH_ON_LEVEL_UP = gainedHealthOnLevelUp;
        GAINED_STRENGTH_ON_LEVEL_UP = gainedStrengthOnLevelUp;
        GAINED_DEXTERITY_ON_LEVEL_UP = gainedDexterityOnLevelUp;
        GAINED_INTELLIGENCE_ON_LEVEL_UP = gainedIntelligenceOnLevelUp;
    }

    public int getEffectiveHealth() {
        return this.health + this.healthFromArmor;
    }

    public int getEffectiveStrength() {
        return this.strength + this.strengthFromArmor;
    }

    public int getEffectiveDexterity() {
        return this.dexterity + this.dexterityFromArmor;
    }

    public int getEffectiveIntelligence() {
        return this.intelligence + this.intelligenceFromArmor;
    }

    public int getLevel() {
        return this.level;
    }

    public int getLevelUpRequirement() {
        return this.levelUpRequirement;
    }

    public void displayStats() {
        OutputHandler.printHeroStats(this);
    }

    public void gainXP(int xp) {
        // gaining XP takes the character closer to reaching the next level
        this.levelUpRequirement -= xp;

        // check if the character has reached a new level after gaining XP
        checkLevelUp();
    }

    public void equipWithArmor(Armor armor) {
        if (armor.getLevel() <= this.level) {
            this.slotsEquippedWithArmor.putIfAbsent(armor.getSlot(), null);
            slotsEquippedWithArmor.put(armor.getSlot(), armor);

            initializeStatsFromArmor();

            for (Slot slot : slotsEquippedWithArmor.keySet()) {
                Armor armorInSlot = slotsEquippedWithArmor.get(slot);

                this.healthFromArmor += armorInSlot.getBonusHP();
                this.strengthFromArmor += armorInSlot.getBonusStrength();
                this.dexterityFromArmor += armorInSlot.getBonusDexterity();
                this.intelligenceFromArmor += armorInSlot.getBonusIntelligence();
            }
        }
    }

    private void checkLevelUp() {
        /*
        When a character gains XP, this XP is deducted from the amount of XP required
        to reach the next level. If this amount becomes 0 or negative after the deduction,
        the character has reached a new level. A loop is used here in case of situations where
        the character gains enough XP to rise multiple levels at once.
         */
        while (this.levelUpRequirement <= 0) {
            levelUp();
        }
    }

    private void levelUp() {
        this.level += 1;

        this.health += GAINED_HEALTH_ON_LEVEL_UP;
        this.strength += GAINED_STRENGTH_ON_LEVEL_UP;
        this.dexterity += GAINED_DEXTERITY_ON_LEVEL_UP;
        this.intelligence += GAINED_INTELLIGENCE_ON_LEVEL_UP;

        // adjust the amount of XP required to reach the next level after a level-up
        this.levelUpRequirement += CharacterLevelManager.getLevelUpRequirement(this.level);
    }

    private void initializeStatsFromArmor() {
        this.healthFromArmor = 0;
        this.strengthFromArmor = 0;
        this.dexterityFromArmor = 0;
        this.intelligenceFromArmor = 0;
    }
}
