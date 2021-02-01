package item.armor;

import org.jetbrains.annotations.NotNull;

public enum Slot {
    BODY(1.0),
    HEAD(0.8),
    LEGS(0.6);

    public final double scalingFactor;

    Slot(double scalingFactor) {
        // the factor by which the slot affects the bonus stats of an armor item
        this.scalingFactor = scalingFactor;
    }

    @NotNull
    @Override
    public String toString() {
        return this.name().substring(0, 1) + this.name().substring(1).toLowerCase();
    }
}
