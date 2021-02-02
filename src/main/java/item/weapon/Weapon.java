package item.weapon;

public interface Weapon {

    String getName();
    int getLevel();
    int getDamage();

    double getStrengthBoostingFactor();
    double getDexterityBoostingFactor();
    double getIntelligenceBoostingFactor();

    void displayStats();
}
