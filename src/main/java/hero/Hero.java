package hero;

public abstract class Hero {
    private int level;
    private int health;
    private int strength;
    private int dexterity;
    private int intelligence;

    public Hero(int health, int strength, int dexterity, int intelligence) {
        this.level = 1;
        this.health = health;
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }

    public void displayStats() {
        System.out.println(this.getClass().getSimpleName() + " details:");
        System.out.println("HP: " + this.health);
        System.out.println("Str: " + this.strength);
        System.out.println("Dex: " + this.dexterity);
        System.out.println("Int: " + this.intelligence);
        System.out.println("Lvl: " + this.level);
    }
}
