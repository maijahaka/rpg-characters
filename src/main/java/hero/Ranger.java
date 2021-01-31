package hero;

public class Ranger extends Hero {
    private static final int INITIAL_HEALTH = 120;
    private static final int INITIAL_STRENGTH = 5;
    private static final int INITIAL_DEXTERITY = 10;
    private static final int INITIAL_INTELLIGENCE = 2;

    public Ranger() {
        super(INITIAL_HEALTH, INITIAL_STRENGTH, INITIAL_DEXTERITY, INITIAL_INTELLIGENCE);
    }
}
