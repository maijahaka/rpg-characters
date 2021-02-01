package level;

public class CharacterLevelManager {
    // the XP required to reach level 2
    private static int INITIAL_LEVEL_UP_REQUIREMENT = 100;

    // the factor by which the XP required to reach the following level increases for each level
    private static double LEVEL_UP_REQUIREMENT_INCREASE_FACTOR = 1.1;

    public static int getInitialLevelUpRequirement() {
        return INITIAL_LEVEL_UP_REQUIREMENT;
    }

    public static int getLevelUpRequirement(int level) {
        double initialLevelUpRequirementDouble = Double.valueOf(INITIAL_LEVEL_UP_REQUIREMENT);

        /*
        The properties of geometric sequences are used to return the required XP to reach
        the following level from a specific level. The resulting value is rounded down
        to the nearest integer.
         */
        return (int) (initialLevelUpRequirementDouble *
                Math.pow(LEVEL_UP_REQUIREMENT_INCREASE_FACTOR, level - 1));
    }
}
