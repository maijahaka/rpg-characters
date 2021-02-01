package hero;

import hero.herotypes.Mage;
import hero.herotypes.Ranger;
import hero.herotypes.Warrior;

public class HeroFactory {

    public static Hero getHero(HeroType heroType) {
        // if a new character class is added, a corresponding statement should be added here
        return switch (heroType) {
            case WARRIOR -> new Warrior();
            case RANGER -> new Ranger();
            case MAGE -> new Mage();
        };
    }
}
