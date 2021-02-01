package hero;

import level.LevelManager;

// all character classes should inherit this abstract class
public abstract class Hero {
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;

    private int level;

    // the XP required to reach the next level
    private int levelUpRequirement;

    // the increments added to each attribute value on level-up
    private final int GAINED_HEALTH_ON_LEVEL_UP;
    private final int GAINED_STRENGTH_ON_LEVEL_UP;
    private final int GAINED_DEXTERITY_ON_LEVEL_UP;
    private final int GAINED_INTELLIGENCE_ON_LEVEL_UP;

    public Hero(int initialHealth, int initialStrength, int initialDexterity,
                int initialIntelligence, int gainedHealthOnLevelUp, int gainedStrengthOnLevelUp,
                int gainedDexterityOnLevelUp, int gainedIntelligenceOnLevelUp) {

        // initial attribute values are given as parameters for each character type
        this.health = initialHealth;
        this.strength = initialStrength;
        this.dexterity = initialDexterity;
        this.intelligence = initialIntelligence;

        // all characters start at level 1
        this.level = 1;

        // the XP required to reach level 2
        this.levelUpRequirement = LevelManager.getInitialLevelUpRequirement();

        // values for the attribute increments on level-up are given as constructor parameters
        GAINED_HEALTH_ON_LEVEL_UP = gainedHealthOnLevelUp;
        GAINED_STRENGTH_ON_LEVEL_UP = gainedStrengthOnLevelUp;
        GAINED_DEXTERITY_ON_LEVEL_UP = gainedDexterityOnLevelUp;
        GAINED_INTELLIGENCE_ON_LEVEL_UP = gainedIntelligenceOnLevelUp;
    }

    public void displayStats() {
        // displays the name of the instantiated subclass, i.e. the specific character type
        System.out.println(this.getClass().getSimpleName() + " details:");

        System.out.println("HP: " + this.health);
        System.out.println("Str: " + this.strength);
        System.out.println("Dex: " + this.dexterity);
        System.out.println("Int: " + this.intelligence);
        System.out.println("Lvl: " + this.level);
        System.out.println("XP to next: " + this.levelUpRequirement);
    }

    public void gainXP(int xp) {
        // gaining XP takes the character closer to reaching the next level
        this.levelUpRequirement -= xp;

        // check if the character has reached a new level after gaining XP
        checkLevelUp();
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
        this.levelUpRequirement += LevelManager.getLevelUpRequirement(this.level);
    }
}
