package item.armor;

public interface Armor {
    String getName();
    Slot getSlot();
    int getLevel();
    int getBonusHP();
    int getBonusStrength();
    int getBonusDexterity();
    int getBonusIntelligence();

    void displayStats();
}
