package hero;

// all character classes should inherit this abstract class
public abstract class Hero {
    private int level;
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;

    public Hero(int health, int strength, int dexterity, int intelligence) {
        // all characters start at level 1
        this.level = 1;

        // initial attribute values are given as parameters for each character type
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void displayStats() {
        // displays the name of the instantiated subclass, i.e. the specific character type
        System.out.println(this.getClass().getSimpleName() + " details:");

        System.out.println("HP: " + this.health);
        System.out.println("Str: " + this.strength);
        System.out.println("Dex: " + this.dexterity);
        System.out.println("Int: " + this.intelligence);
        System.out.println("Lvl: " + this.level);
    }
}
