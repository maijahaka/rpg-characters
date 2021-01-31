package hero;

public class Mage extends Hero {
    private static final int INITIAL_HEALTH = 100;
    private static final int INITIAL_STRENGTH = 2;
    private static final int INITIAL_DEXTERITY = 3;
    private static final int INITIAL_INTELLIGENCE = 10;

    public Mage() {
        super(INITIAL_HEALTH, INITIAL_STRENGTH, INITIAL_DEXTERITY, INITIAL_INTELLIGENCE);
    }
}
