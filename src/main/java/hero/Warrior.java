package hero;

public class Warrior extends Hero {
    private static final int INITIAL_HEALTH = 150;
    private static final int INITIAL_STRENGTH = 10;
    private static final int INITIAL_DEXTERITY = 3;
    private static final int INITIAL_INTELLIGENCE = 1;

    public Warrior() {
        super(INITIAL_HEALTH, INITIAL_STRENGTH, INITIAL_DEXTERITY, INITIAL_INTELLIGENCE);
    }
}
