package hero.herotypes;

import hero.Hero;

public class Mage extends Hero {
    // initializing the starting stats for this character type
    private static final int INITIAL_HEALTH = 100;
    private static final int INITIAL_STRENGTH = 2;
    private static final int INITIAL_DEXTERITY = 3;
    private static final int INITIAL_INTELLIGENCE = 10;

    // initializing the increments by which the character attribute values increase on each level-up
    private static final int GAINED_HEALTH_ON_LEVEL_UP = 15;
    private static final int GAINED_STRENGTH_ON_LEVEL_UP = 1;
    private static final int GAINED_DEXTERITY_ON_LEVEL_UP = 2;
    private static final int GAINED_INTELLIGENCE_ON_LEVEL_UP = 5;

    public Mage() {
        super(
                INITIAL_HEALTH, INITIAL_STRENGTH, INITIAL_DEXTERITY, INITIAL_INTELLIGENCE,
                GAINED_HEALTH_ON_LEVEL_UP, GAINED_STRENGTH_ON_LEVEL_UP, GAINED_DEXTERITY_ON_LEVEL_UP,
                GAINED_INTELLIGENCE_ON_LEVEL_UP
        );
    }
}
