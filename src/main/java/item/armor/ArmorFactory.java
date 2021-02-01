package item.armor;

import item.armor.armortypes.ClothArmor;
import item.armor.armortypes.LeatherArmor;
import item.armor.armortypes.PlateArmor;

public class ArmorFactory {

    public static Armor getArmor(ArmorType armorType, String name, int level, Slot slot) {
        return switch (armorType) {
            // if a new armor class is added, a corresponding statement should be added here
            case CLOTH -> new ClothArmor(name, level, slot);
            case LEATHER -> new LeatherArmor(name, level, slot);
            case PLATE -> new PlateArmor(name, level, slot);
        };
    }
}
