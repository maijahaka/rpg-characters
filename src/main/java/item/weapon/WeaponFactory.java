package item.weapon;

import item.weapon.weapontypes.MagicWeapon;
import item.weapon.weapontypes.MeleeWeapon;
import item.weapon.weapontypes.RangedWeapon;

public class WeaponFactory {
    public static Weapon getWeapon(WeaponType weaponType, String name, int level) {
        // if a new weapon class is added, a corresponding statement should be added here
        return switch (weaponType) {
            case MELEE -> new MeleeWeapon(name, level);
            case RANGED -> new RangedWeapon(name, level);
            case MAGIC -> new MagicWeapon(name, level);
        };
    }
}
